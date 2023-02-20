/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetirosSinCuentasDAO;
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
public class RetirosSinCuentasDAO implements IRetirosSinCuentasDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public RetirosSinCuentasDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }

    @Override
    public RetiroSinCuenta consultar(Integer id) throws PersistenciaException {
        String codigoSQL = "SELECT idCuenta, contrasenia"
                + "FROM RetirosSinCuentas = ?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            RetiroSinCuenta retiroSinCuenta = null;

            if (resultado.next()) {
                Integer idCuenta = resultado.getInt("idCuenta");
                String contrasenia = resultado.getString("contrasenia");

                retiroSinCuenta = new RetiroSinCuenta(idCuenta, contrasenia);
            }
            return retiroSinCuenta;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe el cliente a consultar" + ex.getMessage());
        }
    }

    @Override
    public RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException {
        String codigoSQL = "SELECT INTO RetiroSinCuenta (idCuenta, contrasenia)"
                + "VALUES (?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, retiroSinCuenta.getIdCuenta());
            comando.setString(2, retiroSinCuenta.getContrasenia());

            comando.executeLargeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                retiroSinCuenta.setIdCuenta(id);
                return retiroSinCuenta;
            }
            LOG.log(Level.WARNING, "");
            throw new PersistenciaException("");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "");
            throw new PersistenciaException(ex.getMessage());
        }
    }

    @Override
    public RetiroSinCuenta eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM RetiroSinCuenta WHERE IdCuenta =?";

        try {
            Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            RetiroSinCuenta retiroSinCuentaBusca = this.consultar(id);

            comando.setInt(1, id);
            comando.execute();

            return retiroSinCuentaBusca;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe retiro sin cuenta a eliminar: " + ex.getMessage());
        }

    }

}
