package Modelo.DAO;

import Modelo.Avion;
import Modelo.Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO {

    //public AvionDAO(Connection connection) {
     //   this.connection = connection;
    //}

    public void crearAvion(Avion avion) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "INSERT INTO avion (id_avion, modelo, capacidad_pasajeros, id_aerolinea) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, avion.getIdAvion());
            statement.setString(2, avion.getModelo());
            statement.setInt(3, avion.getCapacidadPasajeros());
            statement.setInt(4, avion.getIdAerolinea());

            statement.executeUpdate();
        }
    }

    public Avion obtenerAvionPorId(String idAvion) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "SELECT id_avion, modelo, capacidad_pasajeros, id_aerolinea FROM avion WHERE id_avion = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, idAvion);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_avion");
                    String modelo = resultSet.getString("modelo");
                    int capacidadPasajeros = resultSet.getInt("capacidad_pasajeros");
                    int idAerolinea = resultSet.getInt("id_aerolinea");

                    return new Avion(id, modelo, capacidadPasajeros, idAerolinea);
                }
            }
        }

        return null;
    }

        // Falta eliminar y metodos extras
}
