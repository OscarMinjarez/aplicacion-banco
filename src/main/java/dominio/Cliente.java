package dominio;

/*
Cliente.java
*/

import java.util.Objects;

/**
 * Clase que guarda los clientes que entran en la base de datos.
 * 
 * @author Oscar Mijarez 231506
 * @author Naely Morillon 229324
 */
public class Cliente {
    
    // Declaración de atributos
    private Integer idCliente;
    private Integer idNombre;
    private Integer idDireccion;
    private String fechaNacimiento;
    private String telefono;
    private String usuario;
    private String contrasenia;

    /**
     * Método constructor por omisión.
     */
    public Cliente() {
    }

    /**
     * Método constructor que recibe todos los parámetros sin idCliente.
     * 
     * @param idNombre id del nombre completo que le pertenece.
     * @param idDireccion id de la dirección que le pertenece.
     * @param fechaNacimiento fecha de nacimiento el cliente.
     * @param telefono teléfono del cliente.
     * @param usuario usuario del cliente.
     * @param contrasenia contrasenia del cliente.
     */
    public Cliente(Integer idNombre, Integer idDireccion, String fechaNacimiento, String telefono, String usuario, String contrasenia) {
        this.idNombre = idNombre;
        this.idDireccion = idDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Método constructor del cliente que recibe todos los parámetro del cliente.
     * 
     * @param idCliente id del cliente.
     * @param idNombre id del nombre completo que le pertenece.
     * @param idDireccion id de la dirección que le pertenece.
     * @param fechaNacimiento fecha de nacimiento el cliente.
     * @param telefono teléfono del cliente.
     * @param usuario usuario del cliente.
     * @param contrasenia contrasenia del cliente.
     */
    public Cliente(Integer idCliente, Integer idNombre, Integer idDireccion, String fechaNacimiento, String telefono, String usuario, String contrasenia) {
        this.idCliente = idCliente;
        this.idNombre = idNombre;
        this.idDireccion = idDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Método que obtiene el id del cliente.
     * @return id del cliente.
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Método que establece el id del cliente.
     * @param idCliente id a establecer.
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método que establece el id del nombre del cliente.
     * @return id del nombre.
     */
    public Integer getIdNombre() {
        return idNombre;
    }

    /**
     * Método que establece el id del nombre del cliente.
     * @param idNombre 
     */
    public void setIdNombre(Integer idNombre) {
        this.idNombre = idNombre;
    }

    /**
     * Método que obtiene el id de la dirección.
     * @return 
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * Método que establece el id de la dirección del cliente.
     * @param idDireccion id de la dirección del cliente.
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Método que obtiene la fecha de nacimiento del cliente.
     * @return 
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que obtiene la fecha de nacimiento del cliente.
     * @param fechaNacimiento fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método que obtiene el teléfono del cliente.
     * @return teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que establece el teléfono del cliente.
     * @param telefono teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que obtiene el usuario del cliente.
     * @return usuario del cliente.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que establece el usuario del cliente.
     * @param usuario usuario del cliente.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que obtiene la contraseña del cliente.
     * @return contraseña del cliente.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Método que establece la contraseña del cliente.
     * @param contrasenia contraseña del cliente.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método que genera el hashCode del objeto.
     * @return hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return true;
    }

    /**
     * Método toString de la clase Cliente.
     * @return cadena con los datos del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", idNombr=" + idNombre + ", idDireccion=" + idDireccion + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }
}
