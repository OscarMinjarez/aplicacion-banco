package dominio;

import java.util.Objects;

public class NombreCompleto {

    private Integer idNombre;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public NombreCompleto() {
    }

    public NombreCompleto(String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public NombreCompleto(Integer idNombre, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.idNombre = idNombre;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public Integer getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(Integer idNombre) {
        this.idNombre = idNombre;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idNombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NombreCompleto other = (NombreCompleto) obj;
        if (!Objects.equals(this.idNombre, other.idNombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NombreCompleto{" + "idNombre=" + idNombre + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + '}';
    }
}