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
        String codigoSQL = "SELECT folio, contrasenia, monto, fechaHora, estado, idCuenta "
                + "FROM RetirosSinCuentas WHERE folio = ?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            RetiroSinCuenta retiroSinCuenta = null;

            if (resultado.next()) {
                Integer folio = resultado.getInt("folio");
                String contrasenia = resultado.getString("contrasenia");
                Double monto = resultado.getDouble("monto");
                String fechaHora = resultado.getString("fechaHora");
                String estado = resultado.getString("estado");
                Integer idCuenta = resultado.getInt("idCuenta");

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
        String codigoSQL = "INSERT INTO RetirosSinCuentas (contrasenia, monto, fechaHora, estado, idCuenta) "
                + "VALUES (?,?,?,?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);
        ) {
            comando.setString(1, retiroSinCuenta.getContrasenia());
            comando.setDouble(2, retiroSinCuenta.getMonto());
            comando.setString(3, retiroSinCuenta.getFechaHora());
            comando.setString(4, retiroSinCuenta.getEstado());
            comando.setInt(5, retiroSinCuenta.getIdCuenta());

            comando.executeLargeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                retiroSinCuenta.setFolio(id);
                return retiroSinCuenta;
            }
            
            LOG.log(Level.WARNING, "Se creo el retiro sin cuenta pero no se genero el folio.");
            throw new PersistenciaException("Se creo el retiro sin cuenta pero no se genero el folio.");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se inserto el retiro sin cuenta.");
            throw new PersistenciaException(ex.getMessage());
        }
    }

    @Override
    public RetiroSinCuenta eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM RetirosSinCuentas WHERE folio =?";

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

    @Override
    public RetiroSinCuenta actualizar(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
