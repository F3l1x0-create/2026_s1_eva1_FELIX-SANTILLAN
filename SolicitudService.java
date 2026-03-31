package cl.duoc.felixsantillan.service;

import java.util.List;

import cl.duoc.felixsantillan.model.Solicitud;
import cl.duoc.felixsantillan.repository.SolicitudRespository;

public class SolicitudService {

    private SolicitudRespository repo = new SolicitudRespository();

    public Solicitud crear(Solicitud s) {
        validar(s);
        return repo.guardar(s);
    }

    public List<Solicitud> listar() {
        return repo.listar();
    }

    public Solicitud obtener(Long id) {
        return repo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    public Solicitud actualizar(Long id, Solicitud nueva) {
        Solicitud s = obtener(id);

        if (nueva.getEstado() != null) {
            s.setEstado(nueva.getEstado());
        }

        if (nueva.getPrioridad() != null) {
            s.setPrioridad(nueva.getPrioridad());
        }

        return s;
    }

    public void eliminar(Long id) {
        obtener(id);
        repo.eliminar(id);
    }

    public List<Solicitud> ordenarPorPrioridad() {
        return repo.listar().stream()
                .sorted((a, b) -> {
                    String pa = a.getPrioridad();
                    String pb = b.getPrioridad();

                    if (pa == null) return 1;
                    if (pb == null) return -1;

                    return pb.compareTo(pa); 
                })
                .toList();
    }

    private void validar(Solicitud s) {

        if (s.getPacienteNombre() == null || s.getPacienteNombre().trim().isEmpty()) {
            throw new RuntimeException("Nombre del paciente obligatorio");
        }

        if (s.getEspecialidad() == null || s.getEspecialidad().trim().isEmpty()) {
            throw new RuntimeException("Especialidad requerida");
        }

        if (s.getPrioridad() == null || s.getPrioridad().trim().isEmpty()) {
            throw new RuntimeException("Prioridad requerida");
        }

        if (s.getEstado() == null || s.getEstado().trim().isEmpty()) {
            s.setEstado("PENDIENTE"); 
        }
    }
}