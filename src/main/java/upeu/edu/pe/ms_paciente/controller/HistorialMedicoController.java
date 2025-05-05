package upeu.edu.pe.ms_paciente.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.ms_paciente.domain.historialmedico;
import upeu.edu.pe.ms_paciente.repository.historialmedRepository;
import upeu.edu.pe.ms_paciente.service.HistorialMedService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historiales")
public class HistorialMedicoController {
    @Autowired
    private historialmedRepository service;

    @GetMapping
    public ResponseEntity<List<historialmedico>> readAll() {
        try {
            List<historialmedico> historiales = service.findAll();
            if (historiales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(historiales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<historialmedico> guardarHistorial(@Valid @RequestBody historialmedico historial) {
        try {
            historialmedico h = service.save(historial);
            return new ResponseEntity<>(h, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<historialmedico> getHistorialById(@PathVariable("id") Long id) {
        try {
            historialmedico h = service.readById(id);
            return new ResponseEntity<>(h, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateHistorial(@PathVariable("id") Long id, @Valid @RequestBody historialmedico historial) {
        historialmedico h = service.readById(id);
        if (h.getId()>0) {
            return new ResponseEntity<>(service.save(historial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
