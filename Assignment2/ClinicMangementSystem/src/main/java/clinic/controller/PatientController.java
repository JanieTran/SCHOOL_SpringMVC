package clinic.controller;

import clinic.model.Patient;
import clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    // ====================================================================
    // CRUD
    // ====================================================================

    @RequestMapping(path = "patients", method = RequestMethod.GET)
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @RequestMapping(path = "patients/{id}", method = RequestMethod.GET)
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @RequestMapping(path = "find-patient/{name}", method = RequestMethod.GET)
    public List<Patient> getPatientByName(@PathVariable String name) {
        return patientService.findPatientByName(name);
    }

    @RequestMapping(path = "add-patient", method = RequestMethod.POST)
    public String addPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return log(patient.getId(), "post");
    }

    @RequestMapping(path = "update-patient", method = RequestMethod.PUT)
    public String updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
        return log(patient.getId(), "update");
    }

    @RequestMapping(path = "del-patient/{id}", method = RequestMethod.DELETE)
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
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
        return "Patient " + id + " has been " + method;
    }
}
