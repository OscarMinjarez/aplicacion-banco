
/**
 *
 * @author naely
 */
import dominio.NombreCompleto;
import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import implementaciones.NombresCompletosDAO;
import interfaces.IConexionBD;
import presentacion.PantallaInicio;

public class AplicacionBanco {

    public static void main(String[] args) throws PersistenciaException {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "130920"
        );
        
        PantallaInicio inicio = new PantallaInicio();
        inicio.setVisible(true);
    }
}
