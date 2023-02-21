package dominio;

import java.util.Objects;

/**
 * Clase que guarda las cuentas que entran a la base de datos.
 * 
 * @author Oscar Mijarez 231506
 * @author Naely Morillon 229324
 */

public class Cuenta {

    //Declración de atributos
    private Integer idCuenta;
    private Integer idCliente;
    private String numeroCuenta;
    private String fechaApertura;
    private double saldo;

    /**
     * Método constructor por omisión.
     */
    public Cuenta() {
    }
    
    /**
     * 
     * Metodo contstructor que recibe los parámetros de cuenta, excepto idCuenta.
     * @param idCliente  id de la cuenta.
     * @param numeroCuenta 
     * @param fechaApertura fecha en que se creó la cuenta.
     * @param saldo cantidad que tiene la cuenta.
     */
    public Cuenta(Integer idCliente, String numeroCuenta, String fechaApertura, double saldo) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    /**
     * 
     * Método constructor que recibe todos los parámetros de cuenta.
     * 
     * @param idCuenta número de identificación de la cuenta.
     * @param idCliente número de identificación del cliente.
     * @param numeroCuenta número de 16 dígitos de la cuenta.
     * @param fechaApertura fecha en que se creó la cuenta.
     * @param saldo cantidad que tiene la cuenta.
     */
    public Cuenta(Integer idCuenta, Integer idCliente, String numeroCuenta, String fechaApertura, double saldo) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    /**
     * Método que obtiene el id de cuenta.
     * @return id de la cuenta.
     */
    public Integer getIdCuenta() {
        return idCuenta;
    }

    /**
     * Método que establece el id de la cuenta.
     * @param idCuenta id a establecer.
     */
    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
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
     * Método que obtiene el número de la cuenta
     * @return número de la cuenta.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método que establece el número de la cuenta.
     * @param numeroCuenta número de cuenta a establcer.
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Método que obtiene la fecha de apertura de la cuenta.
     * @return fecha de apertura. 
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método que establece la fecha de apertura de la cuenta.
     * @param fechaApertura fecha de la cuenta a establcer.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

   /**
    * Método que obtiene el saldo de la cuenta.
    * @return el saldo de la cuenta.
    */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método que establece el saldo de la cuenta.
     * @param saldo saldo de la cuenta a establecer.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Método que general el HashCode del objeto.
     * @return  hash.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idCuenta);
        return hash;
    }

    /**
     * Método que verifica que el objeto sea idéntico a otro. 
     * @param obj objeto a comparar.
     * @return  true si son iguales.
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
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.idCuenta, other.idCuenta)) {
            return false;
        }
        return true;
    }

    /**
     * Método toString de la clase Cuenta.
     * @return cadena de los datos de la cuenta.
     */
    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", idCliente=" + idCliente + ", numeroCuenta=" + numeroCuenta + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + '}';
    }
}
