/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
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
public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public ClientesDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;

    }

    @Override
    public Cliente consultar(Integer id) throws PersistenciaException {
        String codigoSQL = "SELECT idCliente, idNombre, idDireccion, fechaNacimiento, telefono, usuario, contrasenia"
                + "FROM Clientes WHERE idCliente = ?";

        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;

            if (resultado.next()) {
                Integer idCliente = resultado.getInt("idCliente");
                Integer idNombre = resultado.getInt("idNombre");
                Integer idDireccion = resultado.getInt("idDireccion");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                String telefono = resultado.getString("telefono");
                String usuario = resultado.getString("usuario");
                String contrasenia = resultado.getString("contrasenia");

                cliente = new Cliente(idCliente, idNombre, idDireccion, fechaNacimiento, telefono, usuario, contrasenia);
            }
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No existe el cliente a consultar" + ex.getMessage());
        }

    }

    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "INSER INTO Cliente (idCliente, idNombre, idDireccion, fechaNacimiento, telefono, usuario, contrasenia)"
                + "VALUES(?,?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL,
                Statement.RETURN_GENERATED_KEYS
        );) {

            comando.setInt(1, cliente.getIdCliente());
            comando.setInt(2, cliente.getIdNombre());
            comando.setInt(3, cliente.getIdDireccion());
            comando.setString(4, cliente.getFechaNacimiento());
            comando.setString(5, cliente.getTelefono());
            //usuario - contrasenia
            comando.setString(6, cliente.getUsuario());
            comando.setString(6, cliente.getContrasenia());

            comando.executeLargeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                cliente.setIdCliente(id);
                return cliente;

            }

            LOG.log(Level.WARNING, "");
            throw new PersistenciaException("");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("" + ex.getMessage());
        }
    }

    @Override
    public Cliente eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM Cliente WHERE IdCliente =?";

        try {
            Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            Cliente clienteBusca = this.consultar(id);
            comando.setInt(1, id);
            comando.execute();

            return clienteBusca;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            throw new PersistenciaException("No existe el nombre completo a eliminar: " + ex.getMessage());

        }
    }
}
