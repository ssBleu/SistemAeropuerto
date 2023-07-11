
package Modelo;

import java.util.Date;

public class Trabajador {
    private int codigoTra;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String usuario;
    private String contrasena;
    private byte[] foto;
    private double salario;
    private Date fechaContratacion;


    public Trabajador(int codigoTra, String nombre, String apellido, Date fechaNacimiento, String usuario, String contrasena, byte[] foto, double salario, Date fechaContratacion) {
        this.codigoTra = codigoTra;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.foto = foto;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getCodigoTra() {
        return codigoTra;
    }

    public void setCodigoTra(int codigoTra) {
        this.codigoTra = codigoTra;
    }

}