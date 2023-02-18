/*
PersistenciaException.java
*/
package excepciones;

/**
 * Clase que se encarga de manejar las excepciones de tipo persistencia
 * en nuestro sistema.
 * @author Oscar Minjarez Zavala
 * @author Guimel Naely Rubio Morillon
 */
public class PersistenciaException extends Exception {
    
    /**
     * Método constructor por omisión.
     */
    public PersistenciaException() {
        super();
    }
    
    /**
     * Método constructor que recibe un mensaje como parámetro.
     * @param msg mensaje especificado.
     */
    public PersistenciaException(String msg) {
        super(msg);
    }
    
    /**
     * Método constructor que recibe un mensaje y una causa como parámetro.
     * @param message mensaje especificado.
     * @param cause causa especificada.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Método constructor que recibe una causa como parámetro.
     * @param cause causa especificada.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Método constructor que recibe un mensaje, una causa, una supresión
     * y un StackTrace como parámetro.
     * @param message mensaje especificado.
     * @param cause causa especificada.
     * @param enableSuppression supresión especificada.
     * @param writableStackTrace StackTrace especificado.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
