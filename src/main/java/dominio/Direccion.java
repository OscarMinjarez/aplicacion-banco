package dominio;

import java.util.Objects;

public class Direccion {
    
    private Integer idDireccion;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private Integer codigoPostal;
    private String colonia;

    public Direccion() {
    }

    public Direccion(String calle, String numeroExterior, String numeroInterior, Integer codigoPostal, String colonia) {
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
    }

    public Direccion(Integer idDireccion, String calle, String numeroExterior, String numeroInterior, Integer codigoPostal, String colonia) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idDireccion);
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
        final Direccion other = (Direccion) obj;
        if (!Objects.equals(this.idDireccion, other.idDireccion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", numeroExterior=" + numeroExterior + ", numeroInterior=" + numeroInterior + ", codigoPostal=" + codigoPostal + ", colonia=" + colonia + '}';
    }
}
