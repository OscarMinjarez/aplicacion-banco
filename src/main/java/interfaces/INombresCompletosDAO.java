package interfaces;

import dominio.NombreCompleto;

public interface INombresCompletosDAO {
    public NombreCompleto consultar(Integer id);
    public NombreCompleto insertar();
    public NombreCompleto eliminar();
}
