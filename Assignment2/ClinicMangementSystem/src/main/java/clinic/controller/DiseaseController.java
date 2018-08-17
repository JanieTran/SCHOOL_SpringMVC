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
    // CREAE
    // ====================================================================

    @RequestMapping(path = "add-diseases", method = RequestMethod.POST)
    public String addDisease(@RequestBody Disease disease) {
        diseaseService.saveDisease(disease);
        return log(disease.getId(), "post");
    }

    // ====================================================================
    // READ
    // ====================================================================

    @RequestMapping(path = "diseases", method = RequestMethod.GET)
    public List<Disease> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }

    @RequestMapping(path = "diseases/id/{id}", method = RequestMethod.GET)
    public Disease getDiseaseById(@PathVariable int id) {
        return diseaseService.getDiseaseById(id);
    }

    @RequestMapping(path = "diseases-icd/{icd}", method = RequestMethod.GET)
    public List<Disease> getDiseaseByIcd(@PathVariable String icd) {
        return diseaseService.getDiseaseByIcd(icd);
    }

    @RequestMapping(path = "find-disease/{name}", method = RequestMethod.GET)
    public List<Disease> getDiseaseByName(@PathVariable String name) {
        return diseaseService.findDiseaseByName(name);
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    @RequestMapping(path = "update-disease", method = RequestMethod.PUT)
    public String updateDisease(@RequestBody Disease disease) {
        diseaseService.updateDisease(disease);
        return log(disease.getId(), "update");
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    @RequestMapping(path = "del-disease/{id}", method = RequestMethod.DELETE)
    public String deleteDisease(@PathVariable int id) {
        diseaseService.deleteDisease(id);
        return log(id, "delete");
    }

    // ====================================================================
    // HELPER FUNCTION
    // ====================================================================

    private String log(int id, String method) {
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
        return "Disease " + id + " has been " + method;
    }
}
