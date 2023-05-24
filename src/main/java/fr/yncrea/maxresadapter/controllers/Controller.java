package fr.yncrea.maxresadapter.controllers;

import fr.yncrea.maxresadapter.graphpattern.BindingSetMapper;
import fr.yncrea.maxresadapter.interractions.whirlpool.AskWhpKnowledgeInteraction;
import fr.yncrea.maxresadapter.models.whirlpool.AskWhirlpoolModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.inetum.dr.knowledge_engine.adapter.interactions.ProactiveClient;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class Controller {
    private final ProactiveClient knowledgeEngineClient;
    private final AskWhpKnowledgeInteraction whpKI;
    private final BindingSetMapper bindingSetMapper;
    private final Logger log = LogManager.getLogger();
    public Controller(ProactiveClient knowledgeEngineClient, AskWhpKnowledgeInteraction whpKI, BindingSetMapper bindingSetMapper) {
        this.knowledgeEngineClient = knowledgeEngineClient;
        this.whpKI = whpKI;
        this.bindingSetMapper = bindingSetMapper;
    }

    @GetMapping(path = "/whp-ask")
    public ResponseEntity<Object> getDevices() {
        log.info("Request received");

        AskWhirlpoolModel model = new AskWhirlpoolModel(
                "https://www.example.org/appliances",
                "FR-Kpq1z",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50SWQiOjIyNjU3NiwiUm9sZU5hbWUiOiJTVEFOREFSRF9VU0VSIiwiY29tcGFueUlkIjowLCJVc2VyTmFtZSI6IkJlbm_DrnRTb2xvY2giLCJ1c2VyX25hbWUiOiJCRU5PSVQuU09MT0NIQFlOQ1JFQS5GUiIsInNjb3BlIjpbInRydXN0IiwicmVhZCIsIndyaXRlIl0sImV4cCI6MTY4NDI0ODEyOCwiYXV0aG9yaXRpZXMiOlsiU1RBTkRBUkRfVVNFUiJdLCJqdGkiOiJmNGVjZGRmNC1iZjVjLTRhYzUtYTk0Yy1jZGNkMzc2OTc2YmMiLCJjbGllbnRfaWQiOiJzcnZzeXN3Y2VtZWEiLCJTQUlEIjpbIldQUjRXSzRLR0wzMzQiXX0.qje58mD0AjF8BWfkW7KISmiD9UWuIuohzBrFtoWb3rU"
        );

        List<AskWhirlpoolModel> list = new ArrayList<>();
        list.add(model);

        log.info("Model: " + model);

        this.knowledgeEngineClient.ask(this.whpKI, bindingSetMapper.mapActuationsToBindingAskWhirlpool(list));

        return ResponseEntity.ok(null);
    }
}
