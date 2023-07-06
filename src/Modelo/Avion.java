package Modelo;

public class Avion {
    private int idAvion;
    private String modelo;
    private int capacidadPasajeros;
    private int idAerolinea;
    private String nombreAerolinea;

    public Avion(int idAvion, String modelo, int capacidadPasajeros, int idAerolinea) {
        this.idAvion = idAvion;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.idAerolinea = idAerolinea;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
    
    public String getNombreAerolinea() {
        return nombreAerolinea;
    }
    
    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }
}