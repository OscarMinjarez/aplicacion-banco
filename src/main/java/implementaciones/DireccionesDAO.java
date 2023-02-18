package implementaciones;

import dominio.Direccion;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDireccionesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DireccionesDAO implements IDireccionesDAO {

    private static final Logger LOG = Logger.getLogger(NombresCompletosDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;
    
    public DireccionesDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }
    
    @Override
    public Direccion consultar(Integer id) throws PersistenciaException {
        String codigoSQL = "SELECT idDireccion, calle, numeroExterior, numeroInterior, codigoPostal, colonia  "
                + "FROM Direcciones WHERE idDireccion = ?";

        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL)
        ) {
                comando.setInt(1, id);
                ResultSet resultado = comando.executeQuery();

                Direccion direccion = null;

            if (resultado.next()) {
                Integer idDireccion = resultado.getInt("idDireccion");
                String calle = resultado.getString("calle");
                String numeroExterior = resultado.getString("numeroExterior");
                String numeroInterior = resultado.getString("numeroInterior");
                Integer codigoPostal = resultado.getInt("codigoPostal");
                String colonia = resultado.getString("colonia");
                
                direccion = new Direccion(idDireccion, calle, numeroExterior, numeroInterior, codigoPostal, colonia);
            }

            return direccion;
        } catch (SQLException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new PersistenciaException("No existe la dirección consultado: " + e.getMessage());
        }
    }

    @Override
    public Direccion insertar(Direccion direccion) throws PersistenciaException {
        String codigoSQL = "INSERT INTO Direcciones (calle, numeroExterior, numeroInterior, codigoPostal, colonia) "
                + "VALUES(?,?,?,?,?)";
        try ( 
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(
                        codigoSQL,
                        Statement.RETURN_GENERATED_KEYS
                );
        ) {
            comando.setString(1,  direccion.getCalle());
            comando.setString(2,  direccion.getNumeroExterior());
            comando.setString(3,  direccion.getNumeroInterior());
            comando.setInt(4,  direccion.getCodigoPostal());
            comando.setString(5,  direccion.getColonia());
            
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            
            if (resultado.next()) {
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                direccion.setIdDireccion(id);
                return direccion;
            }
            
            LOG.log(Level.WARNING, "Se inserto la direccion pero no se genero id.");
            throw new PersistenciaException("Se inserto la direccion pero no se genero id.");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No se pudo insertar el nombre completo: " + e.getMessage());
        }
    }

    @Override
    public Direccion eliminar(Integer id) throws PersistenciaException {
        String codigoSQL = "DELETE FROM Direcciones WHERE idDireccion = ?";
        
        try {
            Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            Direccion direccion = this.consultar(id);
            comando.setInt(1, id);
            comando.execute();
            
            return direccion;
        } catch (SQLException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new PersistenciaException("No existe la dirección a eliminar: " + e.getMessage());
        }
    }
}
