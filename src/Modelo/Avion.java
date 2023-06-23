
package Modelo;

public class Avion {
    private String idAvion;
    private String modelo;
    private int capacidadPasajeros;
    private String idAerolinea;

    public Avion(String idAvion, String modelo, int capacidadPasajeros, String idAerolinea) {
        this.idAvion = idAvion;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.idAerolinea = idAerolinea;
    }

    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
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

    public String getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(String idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
    
}
