package ehtp.mostafa.hospital.repositories;

import ehtp.mostafa.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin , Long> {
    Medecin findByNom(String name);
}
