
/**
 *
 * @author naely
 */
import dominio.NombreCompleto;
import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import implementaciones.NombresCompletosDAO;
import interfaces.IConexionBD;

public class AplicacionBanco {

    public static void main(String[] args) throws PersistenciaException {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "130920"
        );
        
        NombresCompletosDAO nombresCompletos = new NombresCompletosDAO(manejadorConexiones);
        
        //nombresCompletos.insertar(new NombreCompleto("Naely", "Rubio", "Morillon"));
        nombresCompletos.insertar(new NombreCompleto("Oscar", "Minjarez", "Zavala"));
        
        System.out.println(nombresCompletos.consultar(0));
        System.out.println(nombresCompletos.consultar(2));
    }
}
