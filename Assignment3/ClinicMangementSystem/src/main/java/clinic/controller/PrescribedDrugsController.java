package clinic.controller;

import clinic.model.PrescribedDrugs;
import clinic.service.PrescribedDrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrescribedDrugsController {
    @Autowired
    private PrescribedDrugsService prescribedDrugsService;

    @RequestMapping(path = "prescribed-drugs", method = RequestMethod.GET)
    public List<PrescribedDrugs> getAllPrescribedDrugs() {
        return prescribedDrugsService.getAllPrescribedDrugs();
    }

    @RequestMapping(path = "count-prescribed-drugs", method = RequestMethod.GET)
    public int countPrescribedDrugss() {
        return prescribedDrugsService.countPrescribedDrugs();
    }
}
