package cl.duoc.felixsantillan.model;

public class Solicitud {

    private Long id;
    private String pacienteNombre;
    private String especialidad;
    private String prioridad;
    private String estado;


    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }


    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setId(Long long1) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public Object getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
