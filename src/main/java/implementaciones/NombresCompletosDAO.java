package implementaciones;

import dominio.NombreCompleto;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.INombresCompletosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NombresCompletosDAO implements INombresCompletosDAO {

    private static final Logger LOG = Logger.getLogger(NombresCompletosDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public NombresCompletosDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }

    @Override
    public NombreCompleto consultar(Integer id) throws PersistenciaException {
        String codigoSQL = "SELECT idNombreCompleto, nombres, apellidoPaterno, apellidoMaterno "
                + "FROM NombresCompletos WHERE idNombreCompleto = ?";

        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            NombreCompleto nombreCompleto = null;

            if (resultado.next()) {
                Integer idNombreCompleto = resultado.getInt("idNombreCompleto");
                String nombres = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");

                nombreCompleto = new NombreCompleto(idNombreCompleto, nombres, apellidoPaterno, apellidoMaterno);
            }

            return nombreCompleto;
        } catch (SQLException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new PersistenciaException("No existe el nombre completo consultado: " + e.getMessage());
        }
    }

    @Override
    public NombreCompleto insertar(NombreCompleto nombreCompleto) throws PersistenciaException {
        String codigoSQL = "INSERT INTO NombresCompletos (nombres, apellidoPaterno, apellidoMaterno) "
                + "VALUES(?,?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS
        );) {
            comando.setString(1, nombreCompleto.getNombres());
            comando.setString(2, nombreCompleto.getApellidoPaterno());
            comando.setString(3, nombreCompleto.getApellidoMaterno());

            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                nombreCompleto.setIdNombre(id);
                return nombreCompleto;
            }

            LOG.log(Level.WARNING, "Se inserto el nombre completo pero no se genero id.");
            throw new PersistenciaException("Se inserto el nombre completo pero no se genero id.");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No se pudo insertar el nombre completo: " + e.getMessage());
        }
    }

    @Override
    public NombreCompleto eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM NombresCompletos WHERE idNombreCompleto = ?";

        try {
            Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            NombreCompleto nombreBusca = this.consultar(id);
            comando.setInt(1, id);
            comando.execute();

            return nombreBusca;
        } catch (SQLException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new PersistenciaException("No existe el nombre completo a eliminar: " + e.getMessage());
        }
    }

    @Override
    public NombreCompleto actualizar(Integer id, NombreCompleto nuevoNombreCompleto) throws PersistenciaException {
        String codigoSQL = "UPDATE NombresCompletos SET nombres=?, apellidoPaterno=?, apellidoMaterno=? "
                + "WHERE idNombreCompleto=?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, nuevoNombreCompleto.getNombres());
            comando.setString(2, nuevoNombreCompleto.getApellidoPaterno());
            comando.setString(3, nuevoNombreCompleto.getApellidoMaterno());
            comando.setInt(4, id);

            comando.executeLargeUpdate();

            nuevoNombreCompleto.setIdNombre(id);
            return nuevoNombreCompleto;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar el nombre completo: " + ex.getMessage());
        }
    }
}