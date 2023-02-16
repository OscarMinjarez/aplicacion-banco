package dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
    
    private Integer idCliente;
    private Integer idNombreNombre;
    private Integer idDireccion;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String usuario;
    private String contrasenia;

    public Cliente() {
    }

    public Cliente(Integer idNombreNombre, Integer idDireccion, LocalDate fechaNacimiento, String telefono, String usuario, String contrasenia) {
        this.idNombreNombre = idNombreNombre;
        this.idDireccion = idDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Cliente(Integer idCliente, Integer idNombreNombre, Integer idDireccion, LocalDate fechaNacimiento, String telefono, String usuario, String contrasenia) {
        this.idCliente = idCliente;
        this.idNombreNombre = idNombreNombre;
        this.idDireccion = idDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdNombreNombre() {
        return idNombreNombre;
    }

    public void setIdNombreNombre(Integer idNombreNombre) {
        this.idNombreNombre = idNombreNombre;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", idNombreNombre=" + idNombreNombre + ", idDireccion=" + idDireccion + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }
}
