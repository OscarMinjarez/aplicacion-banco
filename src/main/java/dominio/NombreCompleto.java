package dominio;

import java.util.Objects;

/*
 * Clase que guarda el nombre completo del cliente.
 * @author Oscar Mijarez 231506
 * @author Naely Morillon 229324
 */
public class NombreCompleto {

    //Declaración de atributos.
    private Integer idNombre;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    /**
     * Método constructor por omisión.
     */
    public NombreCompleto() {
    }

    /**
     * Método constructor que recibe los parámetros de NombreCompleto, excepto
     * iNomnre.
     *
     * @param nombres Los nombres del cliente.
     * @param apellidoPaterno el apellido paterno del cliente.
     * @param apellidoMaterno el apellido materno del cliente.
     */
    public NombreCompleto(String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método constructor que recibe todos los parámetros de NombreCompleto.
     *
     * @param idNombre el idNombre del cliente.
     * @param nombres Los nombres del cliente.
     * @param apellidoPaterno el apellido paterno del cliente.
     * @param apellidoMaterno e apellido materno del cliente.
     */
    public NombreCompleto(Integer idNombre, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.idNombre = idNombre;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que obtiene el id del nombre del cliente.
     *
     * @return idnombre del cliente
     */
    public Integer getIdNombre() {
        return idNombre;
    }

    /**
     * Método que establece el id del nombre del cliente.
     *
     * @param idNombre idnombre a establcer
     */
    public void setIdNombre(Integer idNombre) {
        this.idNombre = idNombre;
    }

    /**
     * Método que obtiene los nombres del cliente.
     *
     * @return nombres del cliente.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método que establece los nombres del cliente.
     *
     * @param nombres nombres a establecer.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método que obtiene el apellido paterno del cliente
     *
     * @return apellido paterno del cliente
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece el apellido paterno del cliente
     *
     * @param apellidoPaterno el apellido paterno a establecer.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que obtiene el apellido materno del cliente.
     *
     * @return apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo que establece el apellido materno del cliente.
     *
     * @param apellidoMaterno apellido materno a establecer.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que general el HashCode del objeto.
     *
     * @return hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idNombre);
        return hash;
    }

    /**
     * Método que verifica que el objeto sea idéntico a otro.
     *
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
        final NombreCompleto other = (NombreCompleto) obj;
        if (!Objects.equals(this.idNombre, other.idNombre)) {
            return false;
        }
        return true;
    }

    /**
     * Método toString de la clase NombreCompleto.
     *
     * @return cadena de los datos de NombreCompleto.
     */
    @Override
    public String toString() {
        return "NombreCompleto{" + "idNombre=" + idNombre + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + '}';
    }
}
