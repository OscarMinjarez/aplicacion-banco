package implementaciones;

import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que se encarga de se encarga de todas las consultas a la tabla Cuentas.
 * 
 * @author Oscar
 * @author naely
 */
public class CuentasDAO implements ICuentasDAO {

    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    /**
     * Método constructor que recibe el manejador de conexiones de la base de datos.
     * 
     * @param MANEJADOR_CONEXIONES driver de sql.
     */
    public CuentasDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }

    /**
     * Método que te permite consultar una cuenta con un Id.
     * @param id id a consultar.
     * @return cuenta consultada si esta existe.
     * @throws PersistenciaException si no existe la cuenta consultada.
     */
    @Override
    public Cuenta consultar(Integer id) throws PersistenciaException {
        String codigoSQL = "SELECT idCuenta, idCliente, numeroCuenta, fechaApertura, saldo "
                + "FROM Cuentas WHERE idCuenta = ?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Cuenta cuenta = null;

            if (resultado.next()) {
                Integer idCuenta = resultado.getInt("idCuenta");
                Integer idCliente = resultado.getInt("idCliente");
                String numeroCuenta = resultado.getString("numeroCuenta");
                String fechaApertura = resultado.getString("fechaApertura");
                double saldo = resultado.getDouble("saldo");

                cuenta = new Cuenta(idCuenta, idCliente, numeroCuenta, fechaApertura, saldo);
            }

            return cuenta;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe la direccion a consultar" + ex.getMessage());
        }

    }
    
    /**
     * Método que se encarga de insertar una cuenta a la base de datos.
     * @param cuenta cuenta a isnertar.
     * @return cuenta insertada.
     * @throws PersistenciaException si no se puede insertar.
     */
    @Override
    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "INSERT INTO Cuentas (numeroCuenta, saldo, idCliente) "
                + "VALUES (?,?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuenta.getNumeroCuenta());
            comando.setDouble(2, cuenta.getSaldo());
            comando.setInt(3, cuenta.getIdCliente());

            comando.executeLargeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                cuenta.setIdCuenta(id);
                return cuenta;
            }

            LOG.log(Level.WARNING, "Se creo la cuenta pero no se genero el Id.");
            throw new PersistenciaException("Se creo la cuenta pero no se genero el Id.");
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar al cuenta.");
        }
    }

    /**
     * Método que se encarga de eliminar una cuenta desde un id.
     * @param id id de la cuenta.
     * @return cuenta eliminada.
     * @throws PersistenciaException error si no existe la cuenta.
     */
    @Override
    public Cuenta eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM Cuentas WHERE idCuenta = ?";

        try {
            Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            Cuenta cuentaBusca = this.consultar(id);
            comando.setInt(1, id);
            comando.execute();

            return cuentaBusca;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe la cuenta a eliminar: " + ex.getMessage());
        }
    }

    @Override
    public Cuenta actualizar(Integer id, Cuenta actualizacionCuenta) throws PersistenciaException {
        String codigoSQL = "UPDATE Cuenta SET idCuenta = ?, idCliente, numeroCuenta, fechaApertura, saldo"
                + "WHERE idCuenta = ?";

        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);) {

            comando.setInt(1, actualizacionCuenta.getIdCliente());
            comando.setInt(2, actualizacionCuenta.getIdCliente());
            comando.setString(3, actualizacionCuenta.getNumeroCuenta());
            comando.setString(4, actualizacionCuenta.getFechaApertura());
            comando.setDouble(5, actualizacionCuenta.getSaldo());

            comando.executeLargeUpdate();

            actualizacionCuenta.setIdCuenta(id);
            return actualizacionCuenta;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar el nombre completo: " + ex.getMessage());
        }
    }
}
