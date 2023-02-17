package interfaces;

import dominio.NombreCompleto;
import excepciones.PersistenciaException;

public interface INombresCompletosDAO {
    public NombreCompleto consultar(Integer id) throws PersistenciaException;
    public NombreCompleto insertar(NombreCompleto nombreCompleto) throws PersistenciaException;
    public NombreCompleto eliminar(Integer id) throws PersistenciaException;
}
