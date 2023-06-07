package Clases;

public class Gestion {
    private ListaSimple interna = new ListaSimple();

    public Gestion() {
        for (int i = 65; i < 91; i++) {
            Arraylist arreglo = new Arraylist((char) i);
            interna.insertarAlFinal(arreglo);
        }

    }

    public boolean agregarContacto(Contacto contacto) {
        char letra = contacto.getNombre1().charAt(0);
        letra = Character.toUpperCase(letra);

        if ((int) letra < 65 || (int) letra > 90) {
            return false;
        }
        Nodo tmp = getInterna().getPrimerNodo();
        while (tmp.getSiguienteNodo() != null && tmp.getDato().getLetra() != letra) {
            tmp = tmp.getSiguienteNodo();
        }
        tmp.getDato().add(contacto);


        return true;
    }

    public Contacto removerContacto(Contacto contacto) {
        char letra = contacto.getNombre1().charAt(0);
        letra = Character.toUpperCase(letra);

        if ((int) letra < 65 && (int) letra > 90) {
            return null;
        }
        Nodo tmp = getInterna().getPrimerNodo();
        while (tmp.getSiguienteNodo() != null && tmp.getDato().getLetra() != letra) {
            tmp = tmp.getSiguienteNodo();
        }

        return tmp.getDato().remove(contacto);
    }

    public Arraylist Buscar(String Id){
        char letra =  Id.charAt(0);
        Arraylist contactos =  new Arraylist(letra);
        letra = Character.toUpperCase(letra);
        if ((int)letra > 64 && (int)letra < 91 ){
            Nodo tmp = getInterna().getPrimerNodo();
            while (tmp.getSiguienteNodo() != null && tmp.getDato().getLetra() != letra) {
                tmp = tmp.getSiguienteNodo();
            }
            char[] nombre1;
            char[] nombre2 = Id.toCharArray();
            int verificador = 0;
            for (int i = 0; i < tmp.getDato().getSize(); i++){
                Contacto contacto = tmp.getDato().getArreglo()[i];
                nombre1 = contacto.getNombre1().toCharArray();
                for (int j = 0; j < nombre2.length; j++){
                    if ( Character.toUpperCase(nombre1 [j]) == Character.toUpperCase(nombre2[j])){
                        verificador++;
                    }
                }
                if (verificador == nombre2.length){
                    contactos.add(contacto);
                }
                verificador = 0;
            }
        }
        if ((int)letra > 47 && (int)letra < 58 ){
            Nodo tmp = getInterna().getPrimerNodo();
            while (tmp.getSiguienteNodo() != null) {
                char[] nombre3;
                char[] nombre4 = Id.toCharArray();
                int verificador = 0;
                for (int i = 0; i < tmp.getDato().getSize(); i++){
                    Contacto contacto = tmp.getDato().getArreglo()[i];
                    nombre3 = contacto.getTelefono1().toCharArray();
                    for (int j = 0; j < nombre4.length; j++){
                        if ( (nombre3 [j]) == (nombre4[j])){
                            verificador++;
                        }
                    }
                    if (verificador == nombre4.length){
                        contactos.add(contacto);
                    }
                    verificador = 0;
                }
                tmp = tmp.getSiguienteNodo();
            }
        }
        return contactos;
    }
    public ListaSimple getInterna() {
        return interna;
    }

    public void setInterna(ListaSimple interna) {
        this.interna = interna;
    }

}
