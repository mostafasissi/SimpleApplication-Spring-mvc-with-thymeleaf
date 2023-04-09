package ehtp.mostafa.hospital.web;

import ehtp.mostafa.hospital.entities.Patient;
import ehtp.mostafa.hospital.entities.RendezVous;
import ehtp.mostafa.hospital.repositories.PatientRepository;
import ehtp.mostafa.hospital.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class RendezVousController {
    private RendezVousRepository rendezVousRepository;

    @GetMapping(path = "/rendezVous")
    public String patientList(Model model){
        List<RendezVous> rendezVous = rendezVousRepository.findAll();
        model.addAttribute("listeRendezVous" , rendezVous);
        return "listRendezVous";
    }
}
