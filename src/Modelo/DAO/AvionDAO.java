package Modelo.DAO;

import Modelo.Avion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO {
    private Connection connection;

    public AvionDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearAvion(Avion avion) throws SQLException {
        String sql = "INSERT INTO avion (id_avion, modelo, capacidad_pasajeros, id_aerolinea) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, avion.getIdAvion());
            statement.setString(2, avion.getModelo());
            statement.setInt(3, avion.getCapacidadPasajeros());
            statement.setString(4, avion.getIdAerolinea());

            statement.executeUpdate();
        }
    }

    public Avion obtenerAvionPorId(String idAvion) throws SQLException {
        String sql = "SELECT id_avion, modelo, capacidad_pasajeros, id_aerolinea FROM avion WHERE id_avion = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idAvion);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id_avion");
                    String modelo = resultSet.getString("modelo");
                    int capacidadPasajeros = resultSet.getInt("capacidad_pasajeros");
                    String idAerolinea = resultSet.getString("id_aerolinea");

                    return new Avion(id, modelo, capacidadPasajeros, idAerolinea);
                }
            }
        }

        return null;
    }

        // Falta eliminar y metodos extras
}
