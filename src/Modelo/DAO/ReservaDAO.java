
package Modelo.DAO;
import Modelo.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearReserva(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO reserva_vuelo (id_reserva, dni_pasajero, id_vuelo, fecha_reserva) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, reserva.getIdReserva());
            statement.setString(2, reserva.getDniPasajero());
            statement.setString(3, reserva.getIdVuelo());
            statement.setDate(4, new java.sql.Date(reserva.getFechaReserva().getTime()));

            statement.executeUpdate();
        }
    }

    public Reserva obtenerReservaVueloPorId(String idReserva) throws SQLException {
        String sql = "SELECT id_reserva, dni_pasajero, id_vuelo, fecha_reserva FROM reserva_vuelo WHERE id_reserva = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idReserva);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id_reserva");
                    String dniPasajero = resultSet.getString("dni_pasajero");
                    String idVuelo = resultSet.getString("id_vuelo");
                    Date fechaReserva = resultSet.getDate("fecha_reserva");

                    return new Reserva(id, dniPasajero, idVuelo, fechaReserva);
                }
            }
        }

        return null;
    }

        // Falta eliminar y metodos extras
}