
/**
 *
 * @author naely
 */
import implementaciones.ConexionBD;
import implementaciones.NombresCompletosDAO;
import interfaces.IConexionBD;

public class AplicacionBanco {

    public static void main(String[] args) {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "1234"
        );
        
        NombresCompletosDAO nombresCompletos = new NombresCompletosDAO(manejadorConexiones);
        
        System.out.println(nombresCompletos.consultar(0));
        System.out.println(nombresCompletos.consultar(1));
    }
}
