package clinic.controller;

import clinic.model.Visit;
import clinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {
    @Autowired
    private VisitService visitService;

    // ====================================================================
    // CREATE
    // ====================================================================

    @RequestMapping(path = "add-visit", method = RequestMethod.POST)
    public String addVisit(@RequestBody Visit visit) {
        visitService.saveVisit(visit);
        return log(visit.getId(), "post");
    }

    // ====================================================================
    // READ
    // ====================================================================

    @RequestMapping(path = "visits", method = RequestMethod.GET)
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @RequestMapping(path = "visits/{id}", method = RequestMethod.GET)
    public Visit getVisitById(@PathVariable int id) {
        return visitService.getVisitById(id);
    }

    @RequestMapping(path = "visits-patient/{id}", method = RequestMethod.GET)
    public List<Visit> getVisitsByPatient(@PathVariable int patientId) {
        return visitService.findVisitByPatient(patientId);
    }

    @RequestMapping(path = "visits-on-date/{date}", method = RequestMethod.GET)
    public List<Visit> findVisitOnDate(@PathVariable String date) {
        return visitService.findVisitOnDate(date);
    }

    @RequestMapping(path = "visits-before-date/{date}", method = RequestMethod.GET)
    public List<Visit> findVisitBeforeDate(@PathVariable String date) {
        return visitService.findVisitBeforeDate(date);
    }

    @RequestMapping(path = "visits-after-date/{date}", method = RequestMethod.GET)
    public List<Visit> findVisitAfterDate(@PathVariable String date) {
        return visitService.findVisitAfterDate(date);
    }

    @RequestMapping(path = "visits-per-day", method = RequestMethod.GET)
    public List getVisitsPerDay() {
        return visitService.getVisitsPerDay();
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    @RequestMapping(path = "update-visit", method = RequestMethod.PUT)
    public String updateVisit(@RequestBody Visit visit) {
        visitService.updateVisit(visit);
        return log(visit.getId(), "update");
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    @RequestMapping(path = "del-visit/{id}", method = RequestMethod.DELETE)
    public String deleteVisit(@PathVariable int id) {
        visitService.deleteVisit(id);
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
        return "Visit " + id + " has been " + method;
    }
}
