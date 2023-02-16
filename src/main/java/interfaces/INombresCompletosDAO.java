package interfaces;

import dominio.NombreCompleto;
import excepciones.PersistenciaException;

public interface INombresCompletosDAO {
    public NombreCompleto consultar(Integer id);
    public NombreCompleto insertar(NombreCompleto nombreCompleto) throws PersistenciaException;
    public NombreCompleto eliminar(Integer id);
}
