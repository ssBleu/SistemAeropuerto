
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private Connection connection;

    public Usuario(Connection connection) {
        this.connection = connection;
    }

     public Trabajador obtenerTrabajadorPorId(String idTrabajador) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "SELECT id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, cargo, salario, fecha_contratacion, id_aerolinea FROM trabajador WHERE id_trabajador = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, idTrabajador);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_trabajador");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
                    String usuario = resultSet.getString("usuario");
                    String contrasena = resultSet.getString("contrasena");
                    String cargo = resultSet.getString("cargo");
                    double salario = resultSet.getDouble("salario");
                    Date fechaContratacion = resultSet.getDate("fecha_contratacion");
                    int idAerolinea = resultSet.getInt("id_aerolinea");

                    return new Trabajador(id, nombre, apellido, fechaNacimiento, usuario, contrasena, cargo, salario, fechaContratacion, idAerolinea);
                
                }
            }
        }

        return null;
    }
     public boolean validarCredenciales(String usuario, String contrasena) throws SQLException {
        Connection cn=Conexion.getConexion();
    String sql = "SELECT COUNT(*) FROM trabajador WHERE usuario = ? AND contrasena = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
        statement.setString(1, usuario);
        statement.setString(2, contrasena);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }

    return false;
    }

}
