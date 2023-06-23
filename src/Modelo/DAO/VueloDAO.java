
package Modelo.DAO;

import Modelo.Vuelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {
    private Connection connection;

    public VueloDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearVuelo(Vuelo vuelo) throws SQLException {
        String sql = "INSERT INTO vuelo (id_vuelo, origen, destino, fecha_salida, fecha_llegada, duracion, id_avion) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vuelo.getIdVuelo());
            statement.setString(2, vuelo.getOrigen());
            statement.setString(3, vuelo.getDestino());
            statement.setDate(4, new java.sql.Date(vuelo.getFechaSalida().getTime()));
            statement.setDate(5, new java.sql.Date(vuelo.getFechaLlegada().getTime()));
            statement.setInt(6, vuelo.getDuracion());
            statement.setString(7, vuelo.getIdAvion());

            statement.executeUpdate();
        }
    }

    public Vuelo obtenerVueloPorId(String idVuelo) throws SQLException {
        String sql = "SELECT id_vuelo, origen, destino, fecha_salida, fecha_llegada, duracion, id_avion FROM vuelo WHERE id_vuelo = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idVuelo);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id_vuelo");
                    String origen = resultSet.getString("origen");
                    String destino = resultSet.getString("destino");
                    Date fechaSalida = resultSet.getDate("fecha_salida");
                    Date fechaLlegada = resultSet.getDate("fecha_llegada");
                    int duracion = resultSet.getInt("duracion");
                    String idAvion = resultSet.getString("id_avion");

                    return new Vuelo(id, origen, destino, fechaSalida, fechaLlegada, duracion, idAvion);
                }
            }
        }

        return null;
    }

        // Falta eliminar y metodos extras
}