
package Modelo.DAO;

import Modelo.Aerolinea;
import Modelo.Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AerolineaDAO {


  public void crearAerolinea(Aerolinea aerolinea) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "INSERT INTO aerolinea (id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, aerolinea.getIdAerolinea());
            statement.setString(2, aerolinea.getNombre());
            statement.setString(3, aerolinea.getPaisOrigen());
            statement.setString(4, aerolinea.getTelefono());
            statement.setString(5, aerolinea.getPaginaWeb());
           // statement.setDate(6, new java.sql.Date(aerolinea.getFechaFundacion().getTime()));
           
            statement.executeUpdate();
        }
    }

    public Aerolinea obtenerAerolineaPorId(String idAerolinea) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "SELECT id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion FROM aerolinea WHERE id_aerolinea = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, idAerolinea);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_aerolinea");
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