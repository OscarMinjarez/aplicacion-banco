package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD implements IConexionBD {

    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;

    public ConexionBD(String CADENA_CONEXION, String USUARIO, String PASSWORD) {
        this.CADENA_CONEXION = CADENA_CONEXION;
        this.USUARIO = USUARIO;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(
                this.CADENA_CONEXION,
                this.USUARIO,
                this.PASSWORD
        );
    }
}
