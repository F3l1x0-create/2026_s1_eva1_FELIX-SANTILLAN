package cl.duoc.felixsantillan.repository;
import java.util.*;

import cl.duoc.felixsantillan.model.Solicitud;

public class SolicitudRespository {
    private List<Solicitud> solicitudes = new ArrayList<>();
    private Long contador = 1L;

    public List<Solicitud> listar() {
        return solicitudes;
    }

    public Solicitud guardar(Solicitud s) {
        s.setId(contador++);
        solicitudes.add(s);
        return s;
    }

    public Optional<Solicitud> buscarPorId(Long id) {
        return solicitudes.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public void eliminar(Long id) {
        solicitudes.removeIf(s -> s.getId().equals(id));
    }
}