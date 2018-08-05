package clinic.controller;

import clinic.model.Disease;
import clinic.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    // ====================================================================
    // CRUD
    // ====================================================================

    @RequestMapping(path = "diseases", method = RequestMethod.GET)
    public List<Disease> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }

    @RequestMapping(path = "diseases/{icd}", method = RequestMethod.GET)
    public Disease getDiseaseByIcd(@PathVariable String icd) {
        return diseaseService.getDiseaseByIcd(icd);
    }

    @RequestMapping(path = "find-disease/{name}", method = RequestMethod.GET)
    public List<Disease> getDiseaseByName(@PathVariable String name) {
        return diseaseService.findDiseaseByName(name);
    }

    @RequestMapping(path = "add-diseases", method = RequestMethod.POST)
    public String addDisease(@RequestBody Disease disease) {
        diseaseService.saveDisease(disease);
        return log(disease.getIcd(), "post");
    }

    @RequestMapping(path = "update-disease", method = RequestMethod.PUT)
    public String updateDisease(@RequestBody Disease disease) {
        diseaseService.updateDisease(disease);
        return log(disease.getIcd(), "update");
    }

    @RequestMapping(path = "del-disease/{icd}", method = RequestMethod.DELETE)
    public String deleteDisease(@PathVariable String icd) {
        diseaseService.deleteDisease(icd);
        return log(icd, "delete");
    }

    // ====================================================================
    // HELPER FUNCTION
    // ====================================================================

    private String log(String icd, String method) {
        switch (method) {
            case "post":
                method = "added";
                break;

            case "update":
                method = "updated";
                break;

            case "delete":
                method = "deleted";
                break;

            default:
                break;
        }
        return "Disease " + icd + " has been " + method;
    }
}
