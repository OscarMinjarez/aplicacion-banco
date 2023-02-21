/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
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
 *
 * @author naely
 */
public class CuentasDAO implements ICuentasDAO {

    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public CuentasDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }

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

    @Override
    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "INSERT INTO Cuentas (numeroCuenta, fechaApertura, saldo, idCliente) "
                + "VALUES (?,?,?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuenta.getNumeroCuenta());
            comando.setString(2, cuenta.getFechaApertura());
            comando.setDouble(3, cuenta.getSaldo());
            comando.setInt(4, cuenta.getIdCliente());

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
