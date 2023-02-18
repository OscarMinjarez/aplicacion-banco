package dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Operacion {

    private String folio;
    private LocalDate fechaHora;
    private double monto;

    public Operacion() {
    }

    public Operacion(LocalDate fechaHora, double monto) {
        this.fechaHora = fechaHora;
        this.monto = monto;
    }

    public Operacion(String folio, LocalDate fechaHora, double monto) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.monto = monto;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
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
