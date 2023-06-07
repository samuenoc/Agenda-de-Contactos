package Clases;

public class Contacto {
    private String nombre1;
    private String telefono1;
    private String email1;
    private String direccion1;
    private String tipo1;
    private String favorito1;

    public Contacto(String nombre1, String telefono1, String email1, String direccion1, String tipo1, String favorito1) {
        this.nombre1 = nombre1;
        this.telefono1 = telefono1;
        this.email1 = email1;
        this.direccion1 = direccion1;
        this.tipo1 = tipo1;
        this.favorito1 = favorito1;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public String getEmail1() {
        return email1;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getFavorito1() {
        return favorito1;
    }
}



