package ehtp.mostafa.hospital;

import ehtp.mostafa.hospital.entities.*;
import ehtp.mostafa.hospital.repositories.ConsultationRepository;
import ehtp.mostafa.hospital.repositories.MedecinRepository;
import ehtp.mostafa.hospital.repositories.PatientRepository;
import ehtp.mostafa.hospital.repositories.RendezVousRepository;
import ehtp.mostafa.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(
			IHospitalService iHospitalService ,
			PatientRepository patientRepository ,
			MedecinRepository medecinRepository ,
			RendezVousRepository rendezVousRepository

	){
		return args -> {
			Stream.of("Ahmed" , "Ali" , "Najat").forEach(
					name -> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setMalade(true);
						patient.setDateNaissance(new Date());
						iHospitalService.savePatient(patient);
					}
			);
			//Ajouter des medecin
			Stream.of("Ayman" , "Hanane" , "Yassmine").forEach(
					name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setSpecialite(Math.random()>0.5?"Cardio" : "Dentiste");
						medecin.setEmail(name+"@gmail.com");
						iHospitalService.saveMedecin(medecin);
					}
			);
			// Ajouter un rendezVous
			Patient patient1 = patientRepository.findByNom("Ahmed");
			Patient patient2 = patientRepository.findAll().get(0);// si il ne trouve pas de patient il retourne null

			Medecin medecin = medecinRepository.findByNom("Hanane");
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient1);
			iHospitalService.saveRendezVous(rendezVous);

			// Ajouter une consultation ;
			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ....");
			iHospitalService.saveConsultation(consultation);




		};
	}

}
