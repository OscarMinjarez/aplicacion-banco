/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

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
public class TransaccionDAO implements ITransaccionesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public TransaccionDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }

    @Override
    
    public Transaccion consultar(Integer id) throws PersistenciaException {
        String codigoSQL = "SELECT folio, monto, fechaHora, idCuentaOrigen, idCuentaDestino "
                + "FROM Transferencias WHERE folio = ?";

        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);
        ) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Transaccion transaccion = null;

            if (resultado.next()) {
                Integer folio = resultado.getInt("folio");
                Double monto = resultado.getDouble("monto");
                String fechaHora = resultado.getString("fechaHora");
                Integer idCuentaOrigen = resultado.getInt("idCuentaOrigen");
                Integer idCuentaDestino = resultado.getInt("idCuentaDestino");

                transaccion = new Transaccion(idCuentaOrigen, idCuentaDestino, folio, fechaHora, monto);
            }

            return transaccion;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe la transferencia a consultar" + ex.getMessage());
        }
    }

  @Override
    public Transaccion Insertar(Transaccion transaccion) throws PersistenciaException {
        String codigoSQL = "INSERT INTO Transferencias (idCuentaOrigen, idCuentaDestino, monto, fechaHora) "
                + "VALUES (?,?,?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS);) {

            comando.setInt(1, transaccion.getIdCuentaOrigen());
            comando.setInt(2, transaccion.getIdCuentaDestino());
            comando.setDouble(3, transaccion.getMonto());
            comando.setString(4, transaccion.getFechaHora());

            comando.executeLargeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                transaccion.setIdCuentaDestino(id);
                return transaccion;

            }

            LOG.log(Level.WARNING, "Se creo la transaccion pero no se genero el folio");
            throw new PersistenciaException("Se creo la transaccion pero no se genero el folio");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar la transaccion.");
            throw new PersistenciaException(ex.getMessage());
        }

    }
        
    @Override
    public Transaccion eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM Transferencias WHERE folio  = ?";

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

    @Override
    public Transaccion actualizar(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
   

}
