package ehtp.mostafa.hospital.web;

import ehtp.mostafa.hospital.entities.Patient;
import ehtp.mostafa.hospital.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientRestController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/patients")
    public String patientList(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients" , patients);
        return "listPatient";
    }
}
