
package Modelo;

public class Pasajero {
    private int dniPasajero;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String nacionalidad;

    public Pasajero(int dniPasajero, String nombre, String apellido, int edad, String genero, String nacionalidad) {
        this.dniPasajero = dniPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }

    public int getDniPasajero() {
        return dniPasajero;
    }

    public void setDniPasajero(int dniPasajero) {
        this.dniPasajero = dniPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
}
