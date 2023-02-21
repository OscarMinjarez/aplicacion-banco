
/**
 *
 * @author naely
 */
import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import interfaces.IConexionBD;
import presentacion.PantallaInicio;

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
