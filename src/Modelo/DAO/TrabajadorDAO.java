
package Modelo.DAO;

import Modelo.Trabajador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {
    private Connection connection;

    public TrabajadorDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearTrabajador(Trabajador trabajador) throws SQLException {
        String sql = "INSERT INTO trabajador (id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, cargo, salario, fecha_contratacion, id_aerolinea) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, trabajador.getIdTrabajador());
            statement.setString(2, trabajador.getNombre());
            statement.setString(3, trabajador.getApellido());
            statement.setDate(4, new java.sql.Date(trabajador.getFechaNacimiento().getTime()));
            statement.setString(5, trabajador.getUsuario());
            statement.setString(6, trabajador.getContrasena());
            statement.setString(7, trabajador.getCargo());
            statement.setDouble(8, trabajador.getSalario());
            statement.setDate(9, new java.sql.Date(trabajador.getFechaContratacion().getTime()));
            statement.setString(10, trabajador.getIdAerolinea());

            statement.executeUpdate();
        }
    }

    public Trabajador obtenerTrabajadorPorId(String idTrabajador) throws SQLException {
        String sql = "SELECT id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, cargo, salario, fecha_contratacion, id_aerolinea FROM trabajador WHERE id_trabajador = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idTrabajador);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id_trabajador");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
                    String usuario = resultSet.getString("usuario");
                    String contrasena = resultSet.getString("contrasena");
                    String cargo = resultSet.getString("cargo");
                    double salario = resultSet.getDouble("salario");
                    Date fechaContratacion = resultSet.getDate("fecha_contratacion");
                    String idAerolinea = resultSet.getString("id_aerolinea");

                    return new Trabajador(id, nombre, apellido, fechaNacimiento, usuario, contrasena, cargo, salario, fechaContratacion, idAerolinea);
                
                }
            }
        }

        return null;
    }

    public boolean validarCredenciales(String usuario, String contrasena) throws SQLException {
    String sql = "SELECT COUNT(*) FROM trabajador WHERE usuario = ? AND contrasena = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
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