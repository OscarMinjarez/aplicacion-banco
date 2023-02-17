
/**
 *
 * @author naely
 */
import dominio.Cliente;
import dominio.NombreCompleto;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
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
        
        ClientesDAO cliente = new ClientesDAO(manejadorConexiones);
        // cliente.insertar(new Cliente(2, 1, "2001/05/14", "6444071684", "NaelyRubio", "1234"));
        System.out.println(cliente.consultar(1));
        
        NombresCompletosDAO nombre = new NombresCompletosDAO(manejadorConexiones);
        System.out.println(nombre.consultar(2));
        
        cliente.eliminar(1);
        System.out.println(cliente.consultar(1));
    }
}
