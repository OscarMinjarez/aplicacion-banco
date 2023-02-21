package dominio;

public class Transaccion extends Operacion {

    private Integer idCuentaOrigen;
    private Integer idCuentaDestino;

    public Transaccion() {
        super();
    }

    public Transaccion(Integer idCuentaOrigen, Integer idCuentaDestino) {
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    
    public Transaccion(Integer idCuentaOrigen, Integer idCuentaDestino, String fechaHora, double monto) {
        super(fechaHora, monto);
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    public Transaccion(Integer idCuentaOrigen, Integer idCuentaDestino, Integer folio, String fechaHora, double monto) {
        super(folio, fechaHora, monto);
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    public Integer getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(Integer idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    public Integer getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(Integer idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    @Override
    public String toString() {
        return super.toString() + "Transacciones{" + "idCuentaOrigen=" + idCuentaOrigen + ", idCuentaDestino=" + idCuentaDestino + '}';
    }
}
