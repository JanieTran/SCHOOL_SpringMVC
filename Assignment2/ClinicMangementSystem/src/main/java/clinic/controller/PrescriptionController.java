package clinic.controller;

import clinic.model.Prescription;
import clinic.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    // ====================================================================
    // CREAE
    // ====================================================================

    @RequestMapping(path = "add-prescriptions", method = RequestMethod.POST)
    public String addPrescription(@RequestBody Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return log(prescription.getId(), "post");
    }

    // ====================================================================
    // READ
    // ====================================================================

    @RequestMapping(path = "prescriptions", method = RequestMethod.GET)
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @RequestMapping(path = "prescriptions/id/{id}", method = RequestMethod.GET)
    public Prescription getPrescriptionById(@PathVariable int id) {
        return prescriptionService.getPrescriptionById(id);
    }

    @RequestMapping(path = "prescription-drug/{drugName}", method = RequestMethod.GET)
    public List<Prescription> findPrescriptionByDrug(@PathVariable String drugName) {
        return prescriptionService.findPrescriptionByDrug(drugName);
    }

    @RequestMapping(path = "drugs-prescribed", method = RequestMethod.GET)
    public List getNumberOfDrugsPrescribed() {
        return prescriptionService.getNumberOfDrugsPrescribed();
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    @RequestMapping(path = "update-prescription", method = RequestMethod.PUT)
    public String updatePrescription(@RequestBody Prescription prescription) {
        prescriptionService.updatePrescription(prescription);
        return log(prescription.getId(), "update");
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    @RequestMapping(path = "del-prescription/{id}", method = RequestMethod.DELETE)
    public String deletePrescription(@PathVariable int id) {
        prescriptionService.deletePrescription(id);
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
        return "Prescription " + id + " has been " + method;
    }
}
