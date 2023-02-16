
/**
 *
 * @author naely
 */
import implementaciones.ConexionBD;
import interfaces.IConexionBD;

public class AplicacionBanco {

    public static void main(String[] args) {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "130920"
        );
    }
}
