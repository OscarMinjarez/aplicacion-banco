package dominio;

import java.time.LocalDate;
import java.util.Objects;

/*
 * Clase que guarda las operaciones.
 * @author Oscar Mijarez 231506
 * @author Naely Morillon 229324
 */
public class Operacion {

    //Declaración de atributos.
    private Integer folio;
    private String fechaHora;
    private double monto;

    /**
     * Método constructor por omisión.
     */
    public Operacion() {
    }

    /**
     * Método constructor que recibe los parámetros de Operación, excepto el
     * folio.
     *
     * @param fechaHora  que se generó la operación.
     * @param monto cantidad que se movió.
     */
    public Operacion(String fechaHora, double monto) {
        this.fechaHora = fechaHora;
        this.monto = monto;
    }

    /**
     * Método constructor que recibe todos los parámetros de Operación.
     *
     * @param folio que se genera por la operación
     * @param fechaHora fecha y hora que se generó la operación
     * @param monto cantidad que entró en la transacción.
     */
    public Operacion(Integer folio, String fechaHora, double monto) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.monto = monto;
    }

    /**
     * Método que obtiene el folio de la transacción.
     *
     * @return folio de la transacción.
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * Método que establece el folio de la transacción.
     *
     * @param folio folio de la transacción a establecer.
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * Método que obtiene la fecha y hora de la transacción.
     *
     * @return fecha y hora de la transacción.
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Método que establece la fecha y hora de la transacción.
     *
     * @param fechaHora fecha y hora de la transacción a establecer.
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Método que obtiene el monto de la transacción .
     *
     * @return el monto de la transacción.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Método que establece el monto de la transacción.
     *
     * @param monto el monto de la transacción a establecer.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Método que genera el HashCode del objeto.
     *
     * @return hash.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.folio);
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
        final Operacion other = (Operacion) obj;
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        return true;
    }

    /**
     * Método toString de la clase Operaciónes
     *
     * @return cadena de los datos de Operaciónes
     */
    @Override
    public String toString() {
        return "Operaciones{" + "folio=" + folio + ", fechaHora=" + fechaHora + ", monto=" + monto + '}';
    }
}
