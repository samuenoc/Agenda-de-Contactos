package Clases;
public class Arraylist{

    private int size;
    private Contacto[] arreglo;
    private char letra;

    public Arraylist(char letra) {
        this.letra = letra;
        arreglo = new Contacto[10];
        size = 0;
    }

    public boolean add(Contacto contacto) {
        if (size == this.arreglo.length) {
            grow();
        }
        if(size ==0){arreglo[0]=contacto;}
        else {AgregarEnOrden(contacto);}
        size++;
        return true;
    }

    public void AgregarEnOrden(Contacto contacto) {
        // Buscamos la posición donde debería ir el nuevo nombre en orden alfabético
        int posicion = 0;
        while (posicion < size && contacto.getNombre1().compareTo(this.arreglo[posicion].getNombre1()) > 0) {
            posicion++;
        }

        // Insertamos el nuevo nombre en la posición correspondiente
        Contacto[] nuevoArreglo = new Contacto[size + 1];
        for (int i = 0; i < posicion; i++) {
            nuevoArreglo[i] = this.arreglo[i];
        }
        nuevoArreglo[posicion] = contacto;
        for (int i = posicion + 1; i < size+1; i++) {
            nuevoArreglo[i] = this.arreglo[i - 1];
        }

        // Actualizamos el arreglo original con el nuevo arreglo ordenado
        for (int i = 0; i < size+1; i++) {
            this.arreglo[i] = nuevoArreglo[i];
        }


    }

    public Contacto get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arreglo[index];
    }


    public int indexOf(Object target) {
        for (int i = 0; i < this.size; i++) {
            if (this.arreglo[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public Contacto remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return null;
        }

        return remove(index);

    }

    public Contacto remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size < this.arreglo.length / 4) {
            reduce();
        }

        Contacto contacto = this.arreglo[index];

        for (int i = index; i < size - 1; i++) {
            this.arreglo[i] = this.arreglo[i + 1];
        }
        this.size--;
        return contacto;
    }

    public Contacto set(int index, Contacto element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Contacto old = this.arreglo[index];
        this.arreglo[index] = element;
        return old;
    }

    private void reduce() {
        Contacto[] newArray = new Contacto [this.arreglo.length/2];
        System.arraycopy(this.arreglo, 0, newArray, 0, newArray.length);
        this.arreglo = newArray;
    }

    private void grow() {
        Contacto[] newArray = new Contacto [this.arreglo.length*2];
        System.arraycopy(this.arreglo, 0, newArray, 0, this.arreglo.length);
        this.arreglo = newArray;
    }
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Contacto[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Contacto[] arreglo) {
        this.arreglo = arreglo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}


