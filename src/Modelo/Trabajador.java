
package Modelo;

import java.util.Date;

public class Trabajador {
    private String idTrabajador;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String cargo;
    private double salario;
    private Date fechaContratacion;
    private String idAerolinea;

    public Trabajador(String idTrabajador, String nombre, String apellido, Date fechaNacimiento, String cargo, double salario, Date fechaContratacion, String idAerolinea) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.idAerolinea = idAerolinea;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(String idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
}
