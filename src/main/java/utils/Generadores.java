package utils;

public class Generadores {
    public static String generarNumeroCuenta() {
        String cadena = "";
        
        for (int i = 0; i < 16; i++) {
            cadena += (int) (Math.random() * 9) + 1;
        }
        
        return cadena;
    }
    
    public static String generarContrasenia() {
        String cadena = "";
        
        for (int i = 0; i < 8; i++) {
            cadena += (int) (Math.random() * 8) + 1;
        }
        
        return cadena;
    }
}
