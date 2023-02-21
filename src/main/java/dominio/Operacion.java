package dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Operacion {

    private Integer folio;
    private String fechaHora;
    private double monto;

    public Operacion() {
    }

    public Operacion(String fechaHora, double monto) {
        this.fechaHora = fechaHora;
        this.monto = monto;
    }

    public Operacion(Integer folio, String fechaHora, double monto) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.monto = monto;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.folio);
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
        final Operacion other = (Operacion) obj;
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Operaciones{" + "folio=" + folio + ", fechaHora=" + fechaHora + ", monto=" + monto + '}';
    }
}
