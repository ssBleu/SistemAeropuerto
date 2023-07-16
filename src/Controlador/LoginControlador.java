package Controlador;

import Modelo.Trabajador;
import static Vista.Controladores.objTR;
import java.sql.SQLException;

public class LoginControlador {
    private static boolean sesionActiva = false;
    private static Trabajador trabajadorSesionado;
    
    public static boolean validarTrabajador(String usuario, String contrasena) throws SQLException {
        if (objTR.validarCredenciales(usuario, contrasena)) {
            int IDsesionado = objTR.obtenerIdTrabajador(usuario, contrasena);
            trabajadorSesionado = objTR.buscarTrabajador(IDsesionado);
            sesionActiva = true;
            return true;
        } else {
            return false;
        }
    }
    
    public static void cerrarSesion() {
        sesionActiva = false;
        trabajadorSesionado = null;
    }
    
    public static boolean isSesionActiva() {
        return sesionActiva;
    }
    
    public static Trabajador getTrabajadorSesionado() {
        return trabajadorSesionado;
    }
}
