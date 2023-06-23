
package Modelo;

import java.util.Date;

public class Reserva {
    private String idReserva;
    private String dniPasajero;
    private String idVuelo;
    private Date fechaReserva;

    public Reserva(String idReserva, String dniPasajero, String idVuelo, Date fechaReserva) {
        this.idReserva = idReserva;
        this.dniPasajero = dniPasajero;
        this.idVuelo = idVuelo;
        this.fechaReserva = fechaReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getDniPasajero() {
        return dniPasajero;
    }

    public void setDniPasajero(String dniPasajero) {
        this.dniPasajero = dniPasajero;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

}
