package ma.enset.hospital.Repositories;

import ma.enset.hospital.Entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsulationRepository extends JpaRepository<Consultation,Long> {
}
