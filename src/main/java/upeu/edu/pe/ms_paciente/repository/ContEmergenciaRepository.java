package upeu.edu.pe.ms_paciente.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.ms_paciente.domain.ContactoEmergencia;

public interface ContEmergenciaRepository extends JpaRepository<ContactoEmergencia, Long>{
    ContactoEmergencia readById(Long id);
}
