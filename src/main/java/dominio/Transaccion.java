package dominio;

/*
 * Clase que guarda las transacciones.
 * @author Oscar Mijarez 231506
 * @author Naely Morillon 229324
 */
public class Transaccion extends Operacion {

    //Declaración de atributos
    private Integer idCuentaOrigen;
    private Integer idCuentaDestino;

    /**
     * Construcción por omisión.
     */
    public Transaccion() {
        super();
    }

    /**
     * Constructor que recibe todos los parámetros de Transacción.
     *
     * @param idCuentaOrigen de dónde se moverá el monto
     * @param idCuentaDestino dónde se ingresará el monto.
     */
    public Transaccion(Integer idCuentaOrigen, Integer idCuentaDestino) {
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * Constructor que recibe los parámetros de Transaccion y de operación, excepto el folio. 
     *
     * @param idCuentaOrigen de dónde se moverá el monto.
     * @param idCuentaDestino dónde se ingresará el monto.
     * @param fechaHora que se generó la operación.
     * @param monto cantidad que entro a la transacción.
     */
    public Transaccion(Integer idCuentaOrigen, Integer idCuentaDestino, String fechaHora, double monto) {
        super(fechaHora, monto);
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     *
     * Constructor que recibe todos los parámetros de Transaccion y todos los parámetros de Operación.
     * @param idCuentaOrigen de dónde se moverá el monto.
     * @param idCuentaDestino dónde se ingresará el monto.
     * @param folio que se genera por la operación
     * @param fechaHora fecha y hora que se generó la operación
     * @param montocantidad que entro a la transacción.
     */
    public Transaccion(Integer idCuentaOrigen, Integer idCuentaDestino, Integer folio, String fechaHora, double monto) {
        super(folio, fechaHora, monto);
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * Método que obtiene la cuenta de origen para la transacción.
     * @return cuenta de origen
     */
    public Integer getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    /**
     * Método que establece la cuenta de origen para la transacción.
     * @param idCuentaOrigen cuenta de origen a establecer.
     */
    public void setIdCuentaOrigen(Integer idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    /**
     * Método que obtiene la cuenta destino para la transacción.
     * @return cuenta destino
     */
    public Integer getIdCuentaDestino() {
        return idCuentaDestino;
    }

    /**
     * Método que establece la cuenta destino para la transacción.
     * @param idCuentaDestino  cuenta destino a establecer.
     */
    public void setIdCuentaDestino(Integer idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * Método toString de la clase Transaación
     * @return cadena de los datos de transacción
     */
    @Override
    public String toString() {
        return super.toString() + "Transacciones{" + "idCuentaOrigen=" + idCuentaOrigen + ", idCuentaDestino=" + idCuentaDestino + '}';
    }
}
