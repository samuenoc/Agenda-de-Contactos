package Clases;

public class ExceptionListaVacia extends Throwable {

    /* Constructor de la excepcion
     */
    public ExceptionListaVacia() {
        super("No hay sufientes elementos en la lista  para realizar la accion");
    }
}
