
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Vuelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    public void crearVuelo(Vuelo vuelo) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "INSERT INTO vuelo (id_vuelo, origen, destino, fecha_salida, fecha_llegada, duracion, id_avion, precio, tipo_vuelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, vuelo.getIdVuelo());
            statement.setString(2, vuelo.getOrigen());
            statement.setString(3, vuelo.getDestino());
            statement.setDate(4, new java.sql.Date(vuelo.getFechaSalida().getTime()));
            statement.setDate(5, new java.sql.Date(vuelo.getFechaLlegada().getTime()));
            statement.setString(6, vuelo.getDuracion());
            statement.setString(7, vuelo.getIdAvion());
            statement.setDouble(8,vuelo.getPrecio());
            statement.setString(9, vuelo.getTipo());

            statement.executeUpdate();
        }
    }

    
        public List<Vuelo> obtenerListaVuelos() {
            List<Vuelo> listaVuelos = new ArrayList<>();
            Connection cn = Conexion.getConexion();

            try {
                String sql = "SELECT v.id_vuelo, v.origen, v.destino, v.fecha_salida, v.fecha_llegada, "
                        + "v.duracion, v.id_avion, v.precio, v.tipo_vuelo, av.modelo, ae.nombre " +
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
                    String tipo = resultSet.getString("tipo_vuelo");

                    String nombreAvion = resultSet.getString("modelo");                
                    String nombreAerolinea = resultSet.getString("nombre");

                    Vuelo vuelo = new Vuelo(idVuelo, origen, destino, fechaSalida, fechaLlegada, duracion, idAvion, precio, tipo);
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
        
        
        
        public List<String> obtenerOrigenes() {
            List<String> vuelo = new ArrayList<>();
            Connection cn = Conexion.getConexion();
            try {
                String sql = "SELECT origen FROM vuelo";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    vuelo.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    cn.close();
                } catch (Exception e2) {
                }
            }
            return vuelo;
        }
        
        public List<String> obtenerDestino() {
            List<String> vuelo = new ArrayList<>();
            Connection cn = Conexion.getConexion();
            try {
                String sql = "SELECT destino FROM vuelo";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    vuelo.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    cn.close();
                } catch (Exception e2) {
                }
            }
            return vuelo;
        }
        
        public List<String> obtenerDuraciones() {
            List<String> vuelo = new ArrayList<>();
            Connection cn = Conexion.getConexion();
            try {
                String sql = "SELECT duracion FROM vuelo";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    vuelo.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    cn.close();
                } catch (Exception e2) {
                }
            }
            return vuelo;
        }



        // PARA LOS FILTROS DE LOS COMBOBOX
        
            public List<Vuelo> obtenerVuelosPorOrigen(String origenSeleccionado) {
        List<Vuelo> vuelosFiltrados = new ArrayList<>();
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT v.origen, v.destino, v.duracion, v.tipo_vuelo, ae.nombre AS aerolinea, v.precio " +
                         "FROM vuelo v " +
                         "JOIN avion av ON v.id_avion = av.id_avion " +
                         "JOIN aerolinea ae ON av.id_aerolinea = ae.id_aerolinea " +
                         "WHERE v.origen = ?";
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, origenSeleccionado);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String origen = resultSet.getString("origen");
                String destino = resultSet.getString("destino");
                String duracion = resultSet.getString("duracion");
                String tipoVuelo = resultSet.getString("tipo_vuelo");
                String nombreAerolinea = resultSet.getString("aerolinea");
                double precio = resultSet.getDouble("precio");

                Vuelo vuelo = new Vuelo(null, origen, destino, null, null, duracion, null, precio, tipoVuelo);
                vuelo.setNombreAerolinea(nombreAerolinea);
                vuelosFiltrados.add(vuelo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }

        return vuelosFiltrados;
    }
            
            
            
        public List<Vuelo> obtenerVuelosFiltrados(String origenSeleccionado, String destinoSeleccionado, String duracionSeleccionada, int precioElegido) {
            List<Vuelo> vuelosFiltrados = new ArrayList<>();
            Connection cn = Conexion.getConexion();

            try {
                String sql = "SELECT v.*, av.id_aerolinea FROM vuelo v JOIN avion av ON v.id_avion = av.id_avion WHERE 1=1";

                if (!origenSeleccionado.isEmpty()) {
                    sql += " AND origen = ?";
                }

                if (!destinoSeleccionado.isEmpty()) {
                    sql += " AND destino = ?";
                }

                if (!duracionSeleccionada.isEmpty()) {
                    sql += " AND duracion = ?";
                }
                
                if (precioElegido > 0 | precioElegido < 1000) {
                    sql += " AND precio <= ?";
                }



                PreparedStatement statement = cn.prepareStatement(sql);

                int parameterIndex = 1;

                if (!origenSeleccionado.isEmpty()) {
                    statement.setString(parameterIndex, origenSeleccionado);
                    parameterIndex++;
                }

                if (!destinoSeleccionado.isEmpty()) {
                    statement.setString(parameterIndex, destinoSeleccionado);
                    parameterIndex++;
                }

                if (!duracionSeleccionada.isEmpty()) {
                    statement.setString(parameterIndex, duracionSeleccionada);
                }
                
                if (precioElegido > 0 | precioElegido < 1000) {
                    statement.setDouble(parameterIndex, precioElegido);
                    parameterIndex++;
                }

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    // Obtener los datos de cada vuelo y crear objetos Vuelo
                    String idVuelo = resultSet.getString("id_vuelo");
                    String origen = resultSet.getString("origen");
                    String destino = resultSet.getString("destino");
                    Date fechaSalida = resultSet.getDate("fecha_salida");
                    Date fechaLlegada = resultSet.getDate("fecha_llegada");
                    String duracion = resultSet.getString("duracion");
                    String idAvion = resultSet.getString("id_avion");
                    double precio = resultSet.getDouble("precio");
                    String tipo = resultSet.getString("tipo_vuelo");
                    String idAerolinea = resultSet.getString("id_aerolinea");

                    // Realiza una consulta para obtener el nombre de la aerolínea
                    String sqlAerolinea = "SELECT nombre FROM aerolinea WHERE id_aerolinea = ?";
                    PreparedStatement statementAerolinea = cn.prepareStatement(sqlAerolinea);
                    statementAerolinea.setString(1, idAerolinea);
                    ResultSet resultSetAerolinea = statementAerolinea.executeQuery();

                    // Si se encuentra un resultado, obtén el nombre de la aerolínea
                    if (resultSetAerolinea.next()) {
                        String nombreAerolinea = resultSetAerolinea.getString("nombre");

                        // Crea el objeto Vuelo y asigna el nombre de la aerolínea
                        Vuelo vuelo = new Vuelo(idVuelo, origen, destino, fechaSalida, fechaLlegada, duracion, idAvion, precio, tipo);
                        vuelo.setNombreAerolinea(nombreAerolinea);

                        vuelosFiltrados.add(vuelo);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    cn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            return vuelosFiltrados;
        }

}