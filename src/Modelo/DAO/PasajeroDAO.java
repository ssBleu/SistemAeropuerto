
package Modelo.DAO;

import Modelo.Pasajero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {
        private Connection connection;

    public PasajeroDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearPasajero(Pasajero pasajero) throws SQLException {
        String sql = "INSERT INTO pasajero (dni_pasajero, nombre, apellido, edad, genero, nacionalidad) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pasajero.getDniPasajero());
            statement.setString(2, pasajero.getNombre());
            statement.setString(3, pasajero.getApellido());
            statement.setInt(4, pasajero.getEdad());
            statement.setString(5, pasajero.getGenero());
            statement.setString(6, pasajero.getNacionalidad());

            statement.executeUpdate();
        }
    }

    public Pasajero obtenerPasajeroPorDni(String dni) throws SQLException {
        String sql = "SELECT dni_pasajero, nombre, apellido, edad, genero, nacionalidad FROM pasajero WHERE dni_pasajero = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String dniPasajero = resultSet.getString("dni_pasajero");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    int edad = resultSet.getInt("edad");
                    String genero = resultSet.getString("genero");
                    String nacionalidad = resultSet.getString("nacionalidad");

                    return new Pasajero(dniPasajero, nombre, apellido, edad, genero, nacionalidad);
                }
            }
        }

        return null;
    }
        // Falta eliminar y metodos extras
}
