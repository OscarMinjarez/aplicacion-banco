package dominio;

import java.util.Objects;

/**
 * Clase que guarda la direccion del cliente en la base de datos.
 * 
 * @author Oscar Mijarez 231506
 * @author Naely Morillon 229324
 */
public class Direccion {
    
    //Declaración de atributos.
    private Integer idDireccion;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String codigoPostal;
    private String colonia;

    /**
     * Método constructor por omisión.
     */
    public Direccion() {
    }

    /**
     * Método constructor que recibe los parámetros de dirección, excepto idDireccion.
     * @param calle número de calle o nombre de calle.
     * @param numeroExterior número exterior de la vivienda.
     * @param numeroInterior número interior de la vivienda.
     * @param codigoPostal código postal de la vivienda.
     * @param colonia colonia de la vivienda.
     */
    public Direccion(String calle, String numeroExterior, String numeroInterior, String codigoPostal, String colonia) {
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
    }

    /**
     * Método que recibe todos los parámetros de Dirección. 
     * @param idDireccion id que se genera para la dirección. 
     * @param calle número de calle o nombre de calle.
     * @param numeroExterior número exterior de la vivienda.
     * @param numeroInterior número interior de la vivienda.
     * @param codigoPostal código postal de la vivienda.
     * @param colonia colonia de la vivienda.
     */
    public Direccion(Integer idDireccion, String calle, String numeroExterior, String numeroInterior, String codigoPostal, String colonia) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
    }

    /**
     * Método que obtiene el id de la dirección.
     * @return id de la dirección.
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * Método que establece el id de la dirección.
     * @param idDireccion  id a establecer.
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Método que obtiene la calle de la dirección.
     * @return la calle de la dirección
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método que establece la calle de la dirección
     * @param calle la calle a establecer.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    
    /**
     * Método que obtiene el númeroExterior de la dirección.
     * @return el número exterior de la dirección.
     */
    public String getNumeroExterior() {
        return numeroExterior;
    }

    /**
     * Método que establece el númeroExterior de la dirección 
     * @param numeroExterior el número exterior de la dirección a establecer
     */
    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    /**
     * Método que obtiene el númeroInterior de la dirección.
     * @return el numero interior de la dirección.
     */
    public String getNumeroInterior() {
        return numeroInterior;
    }
    /**
     * Método que establece el númeroInterior de la dirección-
     * @param numeroInterior el numero interioro de la dirección a establcer.
     */
    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    /**
     * Método que obtiene el códigoPostal de la dirección.
     * @return el codigo postal de la dirección.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método que establece el códigoPostal de la dirección.
     * @param codigoPostal el código postal de la dirección a establecer.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método que obtiene el nombre la colonia de la dirección.
     * @return el nombre de la colonia de la dirección. 
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Método que establece el nomnre de la colonia de la dirección.
     * @param colonia la colonia de la dirección a establecer.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Método que genera el hashCode del objeto.
     * @return hash.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idDireccion);
        return hash;
    }

    /**
     * Método que verifica que el objeto sea idéntico a otro.
     * @param obj objeto a comparar. 
     * @return true si son iguales.
     */
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

    /**
     * Método toString de la clase Dirección. 
     * @return cadena con los datos de la dirección.
     */
    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", numeroExterior=" + numeroExterior + ", numeroInterior=" + numeroInterior + ", codigoPostal=" + codigoPostal + ", colonia=" + colonia + '}';
    }
}
