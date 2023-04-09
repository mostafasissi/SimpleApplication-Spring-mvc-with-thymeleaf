package ehtp.mostafa.hospital.repositories;

import ehtp.mostafa.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient , String> {
    Patient findByNom(String name);
}
