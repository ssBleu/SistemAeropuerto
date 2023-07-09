
package Modelo;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private int dniPasajero;
    private int idVuelo;
    private Date fechaReserva;

    public Reserva(int idReserva, int dniPasajero, int idVuelo, Date fechaReserva) {
        this.idReserva = idReserva;
        this.dniPasajero = dniPasajero;
        this.idVuelo = idVuelo;
        this.fechaReserva = fechaReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getDniPasajero() {
        return dniPasajero;
    }

    public void setDniPasajero(int dniPasajero) {
        this.dniPasajero = dniPasajero;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

}
