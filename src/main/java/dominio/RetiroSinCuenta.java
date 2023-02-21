package dominio;

/*
 * Clase que guarda el retiro sin cuenta.
 * @author Oscar Mijarez 231506
 * @author Naely Morillon 229324
 */
public class RetiroSinCuenta extends Operacion {

    //Declaración de atributos
    private Integer idCuenta;
    private String contrasenia;
    private String estado;

    /**
     * Construccion por omisión.
     */
    public RetiroSinCuenta() {
        super();
    }

    /**
     * Constructor que recibe los parámetros de retiro sin cuenta, excepto
     * estado.
     *
     * @param idCuenta id de la cuenta.
     * @param contrasenia contrasenia de la cuenta.
     */
    public RetiroSinCuenta(Integer idCuenta, String contrasenia) {
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor que recibe los parámetros de Retiro sin cuenta, asi como la
     * fecha y el monto del retiro.
     *
     * @param idCuenta id de la cuenta.
     * @param contrasenia contrasenia de la cuenta.
     * @param fechaHora fecha y hora de la transaccion.
     * @param monto cantiad que entró a la transacción.
     * @param estado estatus de la transacción.
     */
    public RetiroSinCuenta(Integer idCuenta, String contrasenia, String fechaHora, double monto, String estado) {
        super(fechaHora, monto);
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    /**
     * Méodo que recibe todos los parémetros de Retiro sin cuenta asi como los
     * parámetros d operación.
     *
     * @param idCuenta
     * @param contrasenia
     * @param folio
     * @param fechaHora
     * @param monto
     * @param estado
     */
    public RetiroSinCuenta(Integer idCuenta, String contrasenia, Integer folio, String fechaHora, double monto, String estado) {
        super(folio, fechaHora, monto);
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    /**
     * Método que obtiene el id de cuenta.
     *
     * @return id de la cuenta.
     */
    public Integer getIdCuenta() {
        return idCuenta;
    }

    /**
     * Método que establece el id de la cuenta.
     *
     * @param idCuenta id a establecer.
     */
    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Método que obtiene la contrasenia de la cuenta.
     *
     * @return la contrasenia de la cuenta.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Método que establece la contrasenia de la cuenta.
     *
     * @param contrasenia la contrasenia de la cuenta a establcer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método que obtiene el estado de la transacción.
     * @return el estado de la transacción.
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Método que establece el estado de la transacción.
     * @param estado el estado de la transacción a establecer. 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString de la clase RetiroSinCuenta
     * @return cadena de los datos de retiro sin cuenta.
     */
    @Override
    public String toString() {
        return super.toString() + "RetiroSinCuenta{" + "idCuenta=" + idCuenta + ", contrasenia=" + contrasenia + ", estado=" + estado + '}';
    }
}
