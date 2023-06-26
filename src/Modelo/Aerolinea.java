package Modelo;

import java.util.Date;

public class Aerolinea {
   private int idAerolinea;
    private String nombre;
    private String paisOrigen;
    private String telefono;
    private String paginaWeb;
    private Date fechaFundacion;

    public Aerolinea(int idAerolinea, String nombre, String paisOrigen, String telefono, String paginaWeb, Date fechaFundacion) {
        this.idAerolinea = idAerolinea;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.fechaFundacion = fechaFundacion;
    }

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(java.sql.Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }
    
}