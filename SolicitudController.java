package cl.duoc.felixsantillan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.felixsantillan.model.Solicitud;
import cl.duoc.felixsantillan.service.SolicitudService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private SolicitudService service = new SolicitudService();

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Solicitud s) {
        return ResponseEntity.status(201).body(service.crear(s));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Solicitud s) {
        return ResponseEntity.ok(service.actualizar(id, s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ordenadas/prioridad")
    public ResponseEntity<?> ordenar() {
        return ResponseEntity.ok(service.ordenarPorPrioridad());
    }
}