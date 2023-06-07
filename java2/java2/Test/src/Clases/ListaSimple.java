package Clases;
public class ListaSimple {
    private Nodo primerNodo;
    private int tamaño;

    /* Constructor de la lista enlazada
     *
             */
    public ListaSimple() {
        this.primerNodo = null;

    }


    /* @return Nodo
     */
    public Nodo getPrimerNodo() {
        return primerNodo;
    }


    /* @param primerNodo
     */
    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }





    /* Insertar un elemento al inicio de la lista.
            *
            * @param dato: El dato que contendrá el nodo a insertar
     */
    public void insertarAlFrente(Arraylist dato) {
        if (estaVacia()) {
            this.primerNodo = new Nodo(dato);
        } else {
            Nodo nvoNodo = new Nodo(dato, this.primerNodo);
            this.primerNodo = nvoNodo;
        }
    }

    /* Insertar un elemento al final de la lista.
     *
             * @param dato El dato que contendrá el nodo a insertar
     */
    public void insertarAlFinal(Arraylist dato) {
        if (estaVacia()) {
            this.primerNodo = new Nodo(dato);
        } else {
            Nodo contador=primerNodo;
            while(contador.getSiguienteNodo()!=null){
                contador=contador.getSiguienteNodo();
            }
            contador.setSiguienteNodo(new Nodo(dato));
        }
    }

    /* Inserta un elemento en una posicion específica.
     *
             * @param dato     El dato que contendrá el nodo a insertar
     * @param posicion numero de posición en que se insertará el objeto
     */
    public void insertarEnPosicion(Arraylist dato, int posicion) throws ExceptionListaVacia {
        if (estaVacia()) {
            if (posicion == 1) {
                this.primerNodo= new Nodo(dato);
            } else
                throw new ExceptionListaVacia();
        } else {
            Nodo tmp = this.primerNodo;
            int contador = 0;
            while (tmp.getSiguienteNodo() != null) {
                contador++;
                if (contador == posicion - 1) {
                    Nodo nvoNodo = new Nodo(dato, tmp.getSiguienteNodo());
                    tmp.setSiguienteNodo(nvoNodo);
                } else if ((posicion > cantidadElementos()) || posicion < 1) {
                    throw new ExceptionListaVacia();
                }

                else
                    tmp = tmp.getSiguienteNodo();
            }
        }
    }

    /* Elimina el nodo al frente de la lista.
            *
            * @return El dato que contenía el nodo.
            * @throws ExceptionListaVacia Cuando la lista está vacía
     */
    public Arraylist eliminarAlFrente() throws ExceptionListaVacia {
        if (estaVacia())
            throw new ExceptionListaVacia();

        Arraylist dato = this.primerNodo.getDato();
        if (this.primerNodo.getSiguienteNodo() == null)
            this.primerNodo = null;
        else
            this.primerNodo = this.primerNodo.getSiguienteNodo();

        return dato;
    }

    /* Elimina el último elemento de la lista.
     *
             * @return El dato que contenía el nodo.
            * @throws ExceptionListaVacia Cuando la lista está vacia.
            */
    public Arraylist eliminarDelFinal() throws ExceptionListaVacia {
        if (estaVacia())
            throw new ExceptionListaVacia();

        Arraylist dato = primerNodo.getDato();
        if (this.primerNodo.getSiguienteNodo() == null)
            this.primerNodo = null;
        else {
            Nodo tmp = this.primerNodo;
            while (tmp.getSiguienteNodo().getSiguienteNodo() != null)
                tmp = tmp.getSiguienteNodo();
            dato = tmp.getSiguienteNodo().getDato();

            tmp.setSiguienteNodo(null);
        }

        return dato;
    }


    /* Elimina un elemento en la posición especificada.
     *
    * @param posicion posicion del elemento que se desea eliminar
     * @return El dato que contenía el nodo
     */
    public Arraylist eliminarEnPosicion(int posicion) throws ExceptionListaVacia {
        if (estaVacia()) {
            throw new ExceptionListaVacia();
        }
        if (posicion <= cantidadElementos()) {
            Nodo tmp = this.primerNodo;
            Arraylist dato = tmp.getDato();
            int contador = 0;
            while (tmp.getSiguienteNodo() != null) {
                contador++;
                if (contador == posicion - 1) {
                    Nodo eliminado = tmp.getSiguienteNodo();
                    tmp.setSiguienteNodo(null);
                    tmp.setSiguienteNodo(eliminado.getSiguienteNodo());
                    dato = eliminado.getDato();
                }

                else
                    tmp = tmp.getSiguienteNodo();
            }
            return dato;
        } else {
            throw new ExceptionListaVacia();
        }
    }

    /* Calcula la cantidad de elementos de la lista.
            *
            * @return la cantidad de elementos que hay en la lista
     */
    public int cantidadElementos() {
        if (estaVacia()) {
            return 0;
        } else {
            Nodo tmp = this.primerNodo;
            int contador = 1;
            while (tmp.getSiguienteNodo() != null) {
                contador++;
                tmp = tmp.getSiguienteNodo();
            }
            return contador;
        }
    }


    /* Operación para imprimir los elementos de la lista
     */
    public void imprimirLista() {
        if (estaVacia())
            System.out.println("La lista está vacía");
        else {
            System.out.println("Contenido de la lista: ");

            Nodo tmp = this.primerNodo;
            while (tmp.getSiguienteNodo() != null) {
                System.out.println(tmp.getDato());
                tmp = tmp.getSiguienteNodo();
            }

            System.out.println(tmp.getDato());
        }

    }

    /* Valida si la lista está vacía.
            *
            * @return Verdadero si la lista está vacía, falso en caso contrario
     */
    public boolean estaVacia() {
        return (null == this.primerNodo);
    }
}

