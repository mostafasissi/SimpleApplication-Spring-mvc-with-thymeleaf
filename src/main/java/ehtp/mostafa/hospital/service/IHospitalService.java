package ehtp.mostafa.hospital.service;

import ehtp.mostafa.hospital.entities.Consultation;
import ehtp.mostafa.hospital.entities.Medecin;
import ehtp.mostafa.hospital.entities.Patient;
import ehtp.mostafa.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
