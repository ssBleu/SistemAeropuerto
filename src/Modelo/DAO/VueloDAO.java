
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Vuelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    public void crearVuelo(Vuelo vuelo) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "INSERT INTO vuelo (id_vuelo, origen, destino, fecha_salida, fecha_llegada, duracion, id_avion, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, vuelo.getIdVuelo());
            statement.setString(2, vuelo.getOrigen());
            statement.setString(3, vuelo.getDestino());
            statement.setDate(4, new java.sql.Date(vuelo.getFechaSalida().getTime()));
            statement.setDate(5, new java.sql.Date(vuelo.getFechaLlegada().getTime()));
            statement.setString(6, vuelo.getDuracion());
            statement.setString(7, vuelo.getIdAvion());
            statement.setDouble(8,vuelo.getPrecio());

            statement.executeUpdate();
        }
    }

    
        public List<Vuelo> obtenerListaVuelos() {
            List<Vuelo> listaVuelos = new ArrayList<>();
            Connection cn = Conexion.getConexion();

            try {
                String sql = "SELECT v.id_vuelo, v.origen, v.destino, v.fecha_salida, v.fecha_llegada, v.duracion, v.id_avion, v.precio, av.modelo, ae.nombre " +
                             "FROM vuelo v " +
                             "JOIN avion av ON v.id_avion = av.id_avion " +
                             "JOIN aerolinea ae ON av.id_aerolinea = ae.id_aerolinea";
                PreparedStatement statement = cn.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String idVuelo = resultSet.getString("id_vuelo");
                    String origen = resultSet.getString("origen");
                    String destino = resultSet.getString("destino");
                    Date fechaSalida = resultSet.getDate("fecha_salida");
                    Date fechaLlegada = resultSet.getDate("fecha_llegada");
                    String duracion = resultSet.getString("duracion");
                    String idAvion = resultSet.getString("id_avion");
                    double precio = resultSet.getDouble("precio");

                    String nombreAvion = resultSet.getString("modelo");                
                    String nombreAerolinea = resultSet.getString("nombre");

                    Vuelo vuelo = new Vuelo(idVuelo, origen, destino, fechaSalida, fechaLlegada, duracion, idAvion, precio);
                    vuelo.setNombreAvion(nombreAvion);
                    vuelo.setNombreAerolinea(nombreAerolinea);
                    listaVuelos.add(vuelo);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    cn.close();
                } catch (Exception e2) {
                }
            }

            return listaVuelos;
        }


        // Falta eliminar y metodos extras
}