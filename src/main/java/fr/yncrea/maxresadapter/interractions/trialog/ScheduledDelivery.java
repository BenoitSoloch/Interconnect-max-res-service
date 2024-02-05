//package fr.yncrea.maxresadapter.interractions.trialog;
//
//import fr.yncrea.maxresadapter.graphpattern.BindingSetMapper;
//import fr.yncrea.maxresadapter.models.trialog.DynamicTarifModel;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openapitools.client.model.AskResult;
//import org.openapitools.client.model.PostResult;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import world.inetum.dr.knowledge_engine.adapter.interactions.ProactiveClient;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class ScheduledDelivery {
//    private final Logger log = LogManager.getLogger();
//    private final BindingSetMapper bindingSetMapper;
//    private final ProactiveClient proactiveClient;
//    private final PostDynamicTarif dynamicTarifInteraction;
//
//    public ScheduledDelivery(BindingSetMapper bindingSetMapper, ProactiveClient proactiveClient, PostDynamicTarif dynamicTarifInteraction) {
//        this.bindingSetMapper = bindingSetMapper;
//        this.proactiveClient = proactiveClient;
//        this.dynamicTarifInteraction = dynamicTarifInteraction;
//    }
//
////    @Scheduled(cron="0 0 18 * * *")
//    @Scheduled(fixedRate = 20000)
//    public void reportCurrentTime() {
//        //TODO Send Dynamic Tarif to Trialog
//        double rdm = Math.random();
//        String pdl = "Linc-4";
//
////        Date date = new Date();
////        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////        String formattedDateNow= dateFormat.format(date).replace(" ", "T")+"Z";
////        date = Date.from(date.toInstant().plus(Duration.ofHours(1)));
////        String formattedDateLater= dateFormat.format(date).replace(" ", "T")+"Z";
////        DateFormat hourFormat = new SimpleDateFormat("hh");
////        String hour = hourFormat.format(date);
//
//
//        LocalDate localDate = LocalDate.now();
//        localDate = localDate.plusDays(1);
//        LocalDateTime startOfDay = localDate.atStartOfDay();
//        String dateNow = startOfDay+":00Z";
//        LocalDateTime startOfDayPlusOne = startOfDay.plusHours(1);
//        String dateLater = startOfDayPlusOne+":00Z";
//
//        List<DynamicTarifModel> dynamicTarifModels = new ArrayList<>();
//
//        for(int i=0; i<24; i++){
//            DynamicTarifModel model = new DynamicTarifModel(
//                    rdm+"",
//                    dateNow,
//                    dateLater,
//                    "http://interconnectproject.eu/pilots/france/building/"+pdl,
//                    "http://interconnectproject.eu/pilots/france/dataPoint/"+pdl+"/"+(i+1),
//                    "http://interconnectproject.eu/pilots/france/timeInstant/"+pdl+"/"+(i+1)+"/1",
//                    "http://interconnectproject.eu/pilots/france/timeInstant/"+pdl+"/"+(i+1)+"/2",
//                    "http://interconnectproject.eu/pilots/france/forecast/"+pdl,
//                    "http://interconnectproject.eu/pilots/france/quantity/"+pdl+"/"+(i+1),
//                    "http://interconnectproject.eu/pilots/france/timeInterval/"+pdl+"/"+(i+1),
//                    "http://interconnectproject.eu/pilots/france/timeSeries/"+pdl,
//                    "http://interconnectproject.eu/pilots/france/measure/"+pdl+"/"+(i+1)
//            );
//            dynamicTarifModels.add(model);
//
//            startOfDay = startOfDay.plusHours(1);
//            dateNow = startOfDay+":00Z";
//            startOfDayPlusOne = startOfDay.plusHours(1);
//            dateLater = startOfDayPlusOne+":00Z";
//        }
//
//        List<Map<String, String>> models = bindingSetMapper.mapActuationsToBindingDynamicTarif(dynamicTarifModels);
//        log.info("Models: " + models);
//
//        AskResult postResult = this.proactiveClient.ask(dynamicTarifInteraction, models);
//        log.info("Scheduled Dynamic Tarif Result: " + postResult);
//    }
//}
