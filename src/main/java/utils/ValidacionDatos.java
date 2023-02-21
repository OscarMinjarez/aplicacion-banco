package utils;

public class ValidacionDatos {

    public static boolean validarSoloLetrasYLongitud(String cadena, int longitud) {
        if (cadena.length() <= longitud) {
            return cadena.matches("[A-Za-z\\s]*");
        }

        return false;
    }

    public static boolean validarSoloLetrasYNumerosYLongitud(String cadena, int longitud) {
        if (cadena.length() <= longitud) {
            return cadena.matches("[0-9A-Za-z\\s]*");
        }

        return false;
    }

    public static boolean validarSoloNumerosYLongitud(String cadena, int longitud) {
        if (cadena.length() <= longitud) {
            return cadena.matches("[0-9]*");
        }
        
        return false;
    }

    public static boolean validarCadenaConEspacios(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                return true;
            }
        }
        
        return false;
    }
}
