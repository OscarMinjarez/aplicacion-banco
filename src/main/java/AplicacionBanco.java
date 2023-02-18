
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

public class AplicacionBanco {

    public static void main(String[] args) throws PersistenciaException {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "1234"
        );
        
        // PantallaInicio inicio = new PantallaInicio();
        // inicio.setVisible(true);
        
        DireccionesDAO direccion = new DireccionesDAO(manejadorConexiones);
        
        direccion.insertar(new Direccion("Jesus Garcia", "3808", null, 85203, "Urbi Villa"));
        System.out.println(direccion.consultar(3));
        direccion.eliminar(3);
        System.out.println(direccion.consultar(3));
    }
}
