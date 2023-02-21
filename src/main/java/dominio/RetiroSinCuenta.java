package dominio;

public class RetiroSinCuenta extends Operacion {

    private Integer idCuenta;
    private String contrasenia;
    private String estado;

    public RetiroSinCuenta() {
        super();
    }

    public RetiroSinCuenta(Integer idCuenta, String contrasenia) {
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
    }
    
    public RetiroSinCuenta(Integer idCuenta, String contrasenia, String fechaHora, double monto, String estado) {
        super(fechaHora, monto);
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public RetiroSinCuenta(Integer idCuenta, String contrasenia, Integer folio, String fechaHora, double monto, String estado) {
        super(folio, fechaHora, monto);
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + "RetiroSinCuenta{" + "idCuenta=" + idCuenta + ", contrasenia=" + contrasenia + ", estado=" + estado + '}';
    }
}
