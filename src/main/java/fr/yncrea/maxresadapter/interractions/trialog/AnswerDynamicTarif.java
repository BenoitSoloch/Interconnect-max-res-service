package fr.yncrea.maxresadapter.interractions.trialog;

import fr.yncrea.maxresadapter.graphpattern.BindingSetMapper;
import fr.yncrea.maxresadapter.models.trialog.DynamicTarifModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.AnswerKnowledgeInteraction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AnswerDynamicTarif extends AnswerKnowledgeInteraction {

    private final Logger log = LogManager.getLogger();
    private final BindingSetMapper bindingSetMapper;
    private final double[] values = new double[24];

    public AnswerDynamicTarif(@Value("${graphpattern.dynamictarif}") String argumentPattern, BindingSetMapper bindingSetMapper) {

        super(argumentPattern);
        this.bindingSetMapper = bindingSetMapper;
        for(int i=0; i<24; i++){
            values[i] = Math.random();
        }
    }

    @Scheduled(cron="0 0 18 * * *")
//    @Scheduled(fixedRate = 20000)
    public void fillValues() {
        for(int i=0; i<24; i++){
            values[i] = Math.random();
        }
    }

    @Override
    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> request) {
        log.info("ASK RECEIVED FROM TRIALOG");

        String pdl = "Linc-4";

        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        String dateNow = startOfDay+":00Z";
        LocalDateTime startOfDayPlusOne = startOfDay.plusHours(1);
        String dateLater = startOfDayPlusOne+":00Z";

        List<DynamicTarifModel> dynamicTarifModels = new ArrayList<>();

        for(int i=0; i<24; i++){
            DynamicTarifModel model = new DynamicTarifModel(
                    values[i]+"",
                    dateNow,
                    dateLater,
                    "http://interconnectproject.eu/pilots/france/building/"+pdl,
                    "http://interconnectproject.eu/pilots/france/dataPoint/"+pdl+"/"+(i+1),
                    "http://interconnectproject.eu/pilots/france/timeInstant/"+pdl+"/"+(i+1)+"/1",
                    "http://interconnectproject.eu/pilots/france/timeInstant/"+pdl+"/"+(i+1)+"/2",
                    "http://interconnectproject.eu/pilots/france/forecast/"+pdl,
                    "http://interconnectproject.eu/pilots/france/quantity/"+pdl+"/"+(i+1),
                    "http://interconnectproject.eu/pilots/france/timeInterval/"+pdl+"/"+(i+1),
                    "http://interconnectproject.eu/pilots/france/timeSeries/"+pdl,
                    "http://interconnectproject.eu/pilots/france/measure/"+pdl+"/"+(i+1)
            );
            dynamicTarifModels.add(model);

            startOfDay = startOfDay.plusHours(1);
            dateNow = startOfDay+":00Z";
            startOfDayPlusOne = startOfDay.plusHours(1);
            dateLater = startOfDayPlusOne+":00Z";
        }

        List<Map<String, String>> models = bindingSetMapper.mapActuationsToBindingDynamicTarif(dynamicTarifModels);
        log.info("Models: " + models);

        return Optional.ofNullable(models);
//        return Optional.empty();
    }

}
