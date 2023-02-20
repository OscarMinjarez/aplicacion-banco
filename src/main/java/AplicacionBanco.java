
/**
 *
 * @author naely
 */
import dominio.Cliente;
import dominio.Direccion;
import dominio.NombreCompleto;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.DireccionesDAO;
import implementaciones.NombresCompletosDAO;
import interfaces.IConexionBD;
import presentacion.PantallaInicio;
import utils.ValidacionDatos;

public class AplicacionBanco {

    public static void main(String[] args) throws PersistenciaException {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "1234"
        );
        
        PantallaInicio inicio = new PantallaInicio(manejadorConexiones);
        inicio.setVisible(true);
    }
}
