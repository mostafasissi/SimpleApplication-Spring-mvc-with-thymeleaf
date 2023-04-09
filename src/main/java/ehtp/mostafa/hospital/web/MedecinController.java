package ehtp.mostafa.hospital.web;

import ehtp.mostafa.hospital.entities.Medecin;
import ehtp.mostafa.hospital.entities.Patient;
import ehtp.mostafa.hospital.repositories.MedecinRepository;
import ehtp.mostafa.hospital.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MedecinController {
    private MedecinRepository medecinRepository;

    @GetMapping(path = "/medecins")
    public String medecinList(Model model){
        List<Medecin> medecins = medecinRepository.findAll();
        model.addAttribute("medecins" , medecins);
        return "listMedecin";
    }
}
