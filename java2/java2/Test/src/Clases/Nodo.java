package Clases;

public class Nodo {
    private Arraylist dato;
    private Nodo siguienteNodo;

    /* Constructor de Nodo que no tiene referencia a ningun otro nodo
     * @param dato dato que contendrá el nodo
     */
    public Nodo(Arraylist dato){
        this(dato, null);
    }
    /* Constructor del Nodo que referencia a otro nodo.
            * @param dato dato que contendrá el nodo
     * @param siguienteNodo referencia del siguiente nodo en la lista
     */
    public Nodo(Arraylist dato, Nodo siguienteNodo){
        this.dato = dato;
        this.siguienteNodo = siguienteNodo;
    }
    /* @return Object*/
    public Arraylist getDato() {
        return dato;
    }
    /* @param dato*/
    public void setDato(Arraylist dato) {
        this.dato = dato;
    }
    /* @return Nodo*/
    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }
    /* @param siguienteNodo*/
    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

}
