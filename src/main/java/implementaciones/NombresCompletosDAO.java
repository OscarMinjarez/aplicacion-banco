package implementaciones;

import dominio.NombreCompleto;
import interfaces.IConexionBD;
import interfaces.INombresCompletosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class NombresCompletosDAO implements INombresCompletosDAO {

    private static final Logger LOG = Logger.getLogger(NombresCompletosDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;
    
    public NombresCompletosDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
    }
    
    @Override
    public NombreCompleto consultar(Integer id) {
        String codigoSQL = "SELECT idNombreCompleto, nombres, apellidoPaterno, apellidoMaterno "
                + "FROM NombresCompletos WHERE idNombreCompleto = ?";
        
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL)
        ) {
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
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public NombreCompleto insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NombreCompleto eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
