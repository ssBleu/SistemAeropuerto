
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Vuelo;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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

    public Vuelo buscarVuelo(int id) {
        Vuelo ep=null;
        Connection cn=Conexion.getConexion();
        try {
            String sql="SELECT id_vuelo, origen, destino, fecha_salida, fecha_llegada, duracion, id_avion, precio, tipo_vuelo FROM vuelo where id_vuelo=?" ;
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                ep=new Vuelo("","","",null,null,"","",0,"",null);
                ep.setIdVuelo(rs.getString(1));
                ep.setOrigen(rs.getString(2));
                ep.setDestino(rs.getString(3));
                ep.setFechaSalida(rs.getDate(4));
                ep.setFechaLlegada(rs.getDate(5));
                ep.setDuracion(rs.getString(6));
                ep.setIdAvion(rs.getString(7));
                ep.setPrecio(rs.getDouble(8));
                ep.setTipo(rs.getString(9));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return ep;
    }
    public void modificarVuelo(Vuelo vuelo) throws SQLException {
    Connection cn = Conexion.getConexion();
    String sql = "UPDATE vuelo SET origen = ?, destino = ?, fecha_salida = ?, fecha_llegada = ?, duracion = ?, id_avion = ?, precio = ?, tipo_vuelo = ? WHERE id_vuelo = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
        statement.setString(1, vuelo.getOrigen());
        statement.setString(2, vuelo.getDestino());
        statement.setDate(3, new java.sql.Date(vuelo.getFechaSalida().getTime()));
        statement.setDate(4, new java.sql.Date(vuelo.getFechaLlegada().getTime()));
        statement.setString(5, vuelo.getDuracion());
        statement.setString(6, vuelo.getIdAvion());
        statement.setDouble(7, vuelo.getPrecio());
        statement.setString(8, vuelo.getTipo());
        statement.setString(9, vuelo.getIdVuelo());

        statement.executeUpdate();
    }
}
    public void eliminarVuelo(String idVuelo) throws SQLException {
    Connection cn = Conexion.getConexion();
    String sql = "DELETE FROM vuelo WHERE id_vuelo = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
        statement.setString(1, idVuelo);
        statement.executeUpdate();
    }
}
 
        public List<Vuelo> obtenerListaVuelosActivos() {
            List<Vuelo> listaVuelos = new ArrayList<>();
            Connection cn = Conexion.getConexion();

            try {
                String sql = "SELECT v.id_vuelo, v.origen, v.destino, v.fecha_salida, v.fecha_llegada, "
                        + "v.duracion, v.id_avion, v.precio, v.tipo_vuelo, v.estado_vuelo, av.modelo, "
                        + "ae.nombre FROM vuelo v "
                        + "JOIN avion av ON v.id_avion = av.id_avion "
                        + "JOIN aerolinea ae ON av.id_aerolinea = ae.id_aerolinea "
                        + "WHERE v.estado_vuelo = 'ACTIVO';";
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
                    String estado_vuelo = resultSet.getString("estado_vuelo");


                    String nombreAvion = resultSet.getString("modelo");                
                    String nombreAerolinea = resultSet.getString("nombre");

                    Vuelo vuelo = new Vuelo(idVuelo, origen, destino, fechaSalida, fechaLlegada, duracion, idAvion, precio, tipo, estado_vuelo);
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
        
        
        
                public List<Vuelo> obtenerListaVuelos() {
            List<Vuelo> listaVuelos = new ArrayList<>();
            Connection cn = Conexion.getConexion();

            try {
                String sql = "SELECT v.id_vuelo, v.origen, v.destino, v.fecha_salida, v.fecha_llegada, "
                        + "v.duracion, v.id_avion, v.precio, v.tipo_vuelo, v.estado_vuelo, av.modelo, ae.nombre " +
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
                    String estado_vuelo = resultSet.getString("estado_vuelo");


                    String nombreAvion = resultSet.getString("modelo");                
                    String nombreAerolinea = resultSet.getString("nombre");

                    Vuelo vuelo = new Vuelo(idVuelo, origen, destino, fechaSalida, fechaLlegada, duracion, idAvion, precio, tipo, estado_vuelo);
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

                Vuelo vuelo = new Vuelo(null, origen, destino, null, null, duracion, null, precio, tipoVuelo, null);
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
                        Vuelo vuelo = new Vuelo(idVuelo, origen, destino, fechaSalida, fechaLlegada, duracion, idAvion, precio, tipo, null);
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
        
        
        
    public String obtenerDestinoMasPopular() {
        String destinoMasPopular = null;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT destino, COUNT(*) AS cantidad FROM vuelo v INNER JOIN reserva_vuelo rv ON v.id_vuelo = rv.id_vuelo GROUP BY destino ORDER BY COUNT(*) DESC LIMIT 1";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                destinoMasPopular = resultSet.getString("destino");
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

        return destinoMasPopular;
    }
        
    public double calcularTendenciaPromedioPrecios() {
        double tendenciaPromedioPrecios = 0;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT AVG(precio) AS promedio FROM vuelo";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tendenciaPromedioPrecios = resultSet.getDouble("promedio");
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

        return tendenciaPromedioPrecios;
    }

    public String obtenerTipoVueloMasRegistrado() {
        String tipoVueloMasRegistrado = null;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT tipo_vuelo, COUNT(*) AS cantidad FROM vuelo GROUP BY tipo_vuelo ORDER BY COUNT(*) DESC LIMIT 1";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tipoVueloMasRegistrado = resultSet.getString("tipo_vuelo");
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

        return tipoVueloMasRegistrado;
    }
        
        
        public static DefaultCategoryDataset obtenerDatos2(String fechaInicial, String fechaFinal) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      Connection cn = Conexion.getConexion();

      try {
          Statement statement = cn.createStatement();

          String query = "SELECT v.origen, COUNT(*) AS total " +
                  "FROM reserva_vuelo rv " +
                  "JOIN vuelo v ON rv.id_vuelo = v.id_vuelo " +
                  "WHERE rv.fecha_reserva BETWEEN '" + fechaInicial + "' AND '" + fechaFinal + "' " +
                  "GROUP BY v.origen " +
                  "ORDER BY total DESC";

          ResultSet resultSet = statement.executeQuery(query);

          while (resultSet.next()) {
              String origen = resultSet.getString("origen");
              int total = resultSet.getInt("total");
              dataset.setValue(total, "Vuelos más Vendidos", origen);
          }

          resultSet.close();
          statement.close();
          cn.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return dataset;
  }
        
        
    public void cambiarEstadoVuelo(String idVuelo, String estadoActual) {
        Connection cn = Conexion.getConexion();

        String nuevoEstado = estadoActual.equalsIgnoreCase("ACTIVO") ? "CANCELADO" : "ACTIVO";
        String fechaCancelacion = (nuevoEstado.equals("CANCELADO")) ? "CURDATE()" : "NULL";

        try {
            String sql = "UPDATE vuelo SET estado_vuelo = ?, fecha_cancelacion = " + fechaCancelacion + " WHERE id_vuelo = ?";
            PreparedStatement statement = cn.prepareStatement(sql);

            statement.setString(1, nuevoEstado);
            statement.setString(2, idVuelo);

            statement.executeUpdate();

            if ("CANCELADO".equals(nuevoEstado)) {
                // Cancelar la reserva asociada al vuelo cancelado
                String sqlCancelarReserva = "UPDATE reserva_vuelo SET estado_reserva = 'CANCELADO', fecha_cancelacion = " + fechaCancelacion + " WHERE id_vuelo = ?";
                PreparedStatement statementCancelarReserva = cn.prepareStatement(sqlCancelarReserva);
                System.out.println("HOLA NO FUNCION:");
                statementCancelarReserva.setString(1, idVuelo);
                statementCancelarReserva.executeUpdate();
            } 
            
            if ("ACTIVO".equals(nuevoEstado)) {
                // Descancelar la reserva asociada al vuelo descancelado
                System.out.println("HOLA FUNCIONO?");
                String sqlDescancelarReserva = "UPDATE reserva_vuelo SET estado_reserva = 'ACTIVO', fecha_cancelacion = NULL WHERE id_vuelo = ?";
                PreparedStatement statementDescancelarReserva = cn.prepareStatement(sqlDescancelarReserva);

                statementDescancelarReserva.setString(1, idVuelo);
                statementDescancelarReserva.executeUpdate();
            
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
    }
    
    
    public static DefaultPieDataset obtenerDatosVuelosCanceladosActivos() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    Connection cn = Conexion.getConexion();

    try {
        // Crear una declaración SQL
        Statement statement = cn.createStatement();

        // Consulta SQL para obtener la cantidad de vuelos cancelados y activos
        String query = "SELECT estado_vuelo, COUNT(*) AS total " +
                       "FROM vuelo " +
                       "GROUP BY estado_vuelo";

        // Ejecutar la consulta SQL
        ResultSet resultSet = statement.executeQuery(query);

        // Calcular el total de vuelos para obtener el porcentaje
        int totalVuelos = 0;
        while (resultSet.next()) {
            int total = resultSet.getInt("total");
            totalVuelos += total;
        }

        // Volver a ejecutar la consulta para obtener los datos reales
        resultSet.beforeFirst();
        while (resultSet.next()) {
            String estadoVuelo = resultSet.getString("estado_vuelo");
            int total = resultSet.getInt("total");
            double porcentaje = (double) total / totalVuelos * 100;
            dataset.setValue(estadoVuelo + " (" + total + ", " + String.format("%.2f", porcentaje) + "%)", total);
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        statement.close();
        cn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return dataset;
}
    
    
    public void actualizarEstadosVuelosRealizados() {
    Connection cn = Conexion.getConexion();
    LocalDate fechaActual = LocalDate.now();

    try {
        // Obtener los vuelos con fecha de salida menor o igual a la fecha actual
        String query = "SELECT id_vuelo FROM vuelo WHERE fecha_salida <= ?";
        PreparedStatement statement = cn.prepareStatement(query);
        statement.setDate(1, java.sql.Date.valueOf(fechaActual));
        ResultSet resultSet = statement.executeQuery();

        // Actualizar el estado de los vuelos a "REALIZADO"
        while (resultSet.next()) {
            String idVuelo = resultSet.getString("id_vuelo");

            String queryActualizar = "UPDATE vuelo SET estado_vuelo = 'REALIZADO' WHERE id_vuelo = ?";
            PreparedStatement statementActualizar = cn.prepareStatement(queryActualizar);
            statementActualizar.setString(1, idVuelo);
            statementActualizar.executeUpdate();
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        statement.close();
        cn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


}