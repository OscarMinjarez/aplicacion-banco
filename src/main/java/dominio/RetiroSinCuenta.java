package dominio;

import java.time.LocalDate;

public class RetiroSinCuenta extends Operacion {

    private Integer idCuenta;
    private String contrasenia;

    public RetiroSinCuenta() {
        super();
    }

    public RetiroSinCuenta(Integer idCuenta, String contrasenia) {
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
    }
    
    public RetiroSinCuenta(Integer idCuenta, String contrasenia, LocalDate fechaHora, double monto) {
        super(fechaHora, monto);
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
    }

    public RetiroSinCuenta(Integer idCuenta, String contrasenia, String folio, LocalDate fechaHora, double monto) {
        super(folio, fechaHora, monto);
        this.idCuenta = idCuenta;
        this.contrasenia = contrasenia;
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

    @Override
    public String toString() {
        return super.toString() + "RetiroSinCuenta{" + "idCuenta=" + idCuenta + ", contrasenia=" + contrasenia + '}';
    }
}
