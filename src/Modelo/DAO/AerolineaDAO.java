
package Modelo.DAO;

import Modelo.Aerolinea;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AerolineaDAO {
    private Connection connection;

    public AerolineaDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearAerolinea(Aerolinea aerolinea) throws SQLException {
        String sql = "INSERT INTO aerolinea (id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, aerolinea.getIdAerolinea());
            statement.setString(2, aerolinea.getNombre());
            statement.setString(3, aerolinea.getPaisOrigen());
            statement.setString(4, aerolinea.getTelefono());
            statement.setString(5, aerolinea.getPaginaWeb());
            statement.setDate(6, new java.sql.Date(aerolinea.getFechaFundacion().getTime()));

            statement.executeUpdate();
        }
    }

    public Aerolinea obtenerAerolineaPorId(String idAerolinea) throws SQLException {
        String sql = "SELECT id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion FROM aerolinea WHERE id_aerolinea = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idAerolinea);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id_aerolinea");
                    String nombre = resultSet.getString("nombre");
                    String paisOrigen = resultSet.getString("pais_origen");
                    String telefono = resultSet.getString("telefono");
                    String paginaWeb = resultSet.getString("pagina_web");
                    Date fechaFundacion = resultSet.getDate("fecha_fundacion");

                    return new Aerolinea(id, nombre, paisOrigen, telefono, paginaWeb, fechaFundacion);
                }
            }
        }

        return null;
    }

    // Falta eliminar y metodos extras
}