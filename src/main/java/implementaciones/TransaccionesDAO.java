/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.Transaccion;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITransaccionesDAO;
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
public class TransaccionesDAO implements ITransaccionesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public TransaccionesDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }

    @Override
    public Transaccion consultar(Integer id) throws PersistenciaException {
        String codigoSQL = "SELECT idCuentaOrigen, idCuentaDestino"
                + "FROM Transaccion WHERE idTransaccion = ?";

        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Transaccion transaccion = null;

            if (resultado.next()) {
                Integer idCuentaOrigen = resultado.getInt("idCuentaOrigen");
                Integer idCuentaDestino = resultado.getInt("idCuentaDestino");

                transaccion = new Transaccion(idCuentaOrigen, idCuentaDestino);
            }

            return transaccion;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe el cliente a consultar" + ex.getMessage());
        }
    }

    @Override
    public Transaccion Insertar(Transaccion transaccion) throws PersistenciaException {
        String codigoSQL = "INSERT INTO Transaccion (idCuentaOrigen, idCuentaDestino)"
                + "VALUES (?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);) {

            comando.setInt(1, transaccion.getIdCuentaOrigen());
            comando.setInt(2, transaccion.getIdCuentaDestino());

            comando.executeLargeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                transaccion.setIdCuentaDestino(id);
                return transaccion;

            }

            LOG.log(Level.WARNING, "");
            throw new PersistenciaException("");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "");
            throw new PersistenciaException(ex.getMessage());
        }

    }

    @Override
    public Transaccion eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM Transacciones WHERE idTransaccion  = ?";

        try {
            Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            Transaccion transaccionBusca = this.consultar(id);
            comando.setInt(1, id);
            comando.execute();

            return transaccionBusca;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe el nombre completo a eliminar: " + ex.getMessage());

        }
    }

}
