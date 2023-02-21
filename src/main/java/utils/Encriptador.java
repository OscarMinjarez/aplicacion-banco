package utils;

public class Encriptador {
    public Encriptador() {
    }
    
    public static String encriptar(String texto) {
        char[] arr = texto.toCharArray();
        String cadena = "";
        int num;
        
        for (int i = 0; i < arr.length; i++) {
            num = (int) arr[i];
            num += 1;
            
            cadena += (char) num;
        }
        
        return cadena;
    }
    
    public static String desencriptar(String contrasenia) {
        char[] arr = contrasenia.toCharArray();
        String cadena = "";
        int num;
        
        for (int i = 0; i < arr.length; i++) {
            num = (int) arr[i];
            num -= 1;
            cadena += (char) num;
        }
        
        return cadena;
    }
}
