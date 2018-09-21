package clinic.controller;

import clinic.model.Drug;
import clinic.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrugController {
    @Autowired
    private DrugService drugService;

    // ====================================================================
    // CREAE
    // ====================================================================

    @RequestMapping(path = "add-drugs", method = RequestMethod.POST)
    public String addDrug(@RequestBody Drug drug) {
        drugService.saveDrug(drug);
        return log(drug.getId(), "post");
    }

    // ====================================================================
    // READ
    // ====================================================================

    @RequestMapping(path = "drugs", method = RequestMethod.GET)
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @RequestMapping(path = "drugs/id/{id}", method = RequestMethod.GET)
    public Drug getDrugById(@PathVariable int id) {
        return drugService.getDrugById(id);
    }

    @RequestMapping(path = "find-drug/{name}", method = RequestMethod.GET)
    public List<Drug> getDrugByName(@PathVariable String name) {
        return drugService.findDrugByName(name);
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    @RequestMapping(path = "update-drug", method = RequestMethod.PUT)
    public String updateDrug(@RequestBody Drug drug) {
        drugService.updateDrug(drug);
        return log(drug.getId(), "update");
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    @RequestMapping(path = "del-drug/{id}", method = RequestMethod.DELETE)
    public String deleteDrug(@PathVariable int id) {
        drugService.deleteDrug(id);
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
        return "Drug " + id + " has been " + method;
    }
}
