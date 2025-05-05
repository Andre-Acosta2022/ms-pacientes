package upeu.edu.pe.ms_paciente.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.ms_paciente.domain.historialmedico;

public interface historialmedRepository extends JpaRepository<historialmedico, Long>{
    historialmedico readById(Long id);
}
