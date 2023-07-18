
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Pasajero;
import Modelo.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;

public class ReservaDAO {

    public void crearReserva(Reserva reserva) throws SQLException {
        Connection cn = Conexion.getConexion();
        String sql = "INSERT INTO reserva_vuelo (dni_pasajero, id_vuelo, fecha_reserva) VALUES (?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, reserva.getDniPasajero());
            statement.setInt(2, reserva.getIdVuelo());
            statement.setDate(3, new java.sql.Date(reserva.getFechaReserva().getTime()));

            statement.executeUpdate();

            // Obtener el id generado automáticamente por la base de datos
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idReserva = generatedKeys.getInt(1);
                reserva.setIdReserva(idReserva);
            }
        }
    }


    public Reserva obtenerReservaVueloPorId(String idReserva) throws SQLException {
        Connection cn = Conexion.getConexion();
        String sql = "SELECT id_reserva, dni_pasajero, id_vuelo, fecha_reserva FROM reserva_vuelo WHERE id_reserva = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, idReserva);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_reserva");
                    int dniPasajero = resultSet.getInt("dni_pasajero");
                    int  idVuelo = resultSet.getInt("id_vuelo");
                    Date fechaReserva = resultSet.getDate("fecha_reserva");

                    return new Reserva(id, dniPasajero, idVuelo, fechaReserva);
                }
            }
        }

        return null;
    }
    
        public List<Reserva> obtenerReservasPorVuelo(int idVuelo) {
 
        List<Reserva> reservas = new ArrayList<>();
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT * FROM reserva_vuelo WHERE id_vuelo = ?";
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, idVuelo);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idReserva = resultSet.getInt("id_reserva");
                int dniPasajero = resultSet.getInt("dni_pasajero");
                Date fechaReserva = resultSet.getDate("fecha_reserva");

                Reserva reserva = new Reserva(idReserva, dniPasajero, idVuelo, fechaReserva);
                reservas.add(reserva);
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

        return reservas;
    }
        
        
                public List<Pasajero> obtenerPasajerosPorVuelo(int idVuelo) {
          List<Pasajero> pasajeros = new ArrayList<>();
          Connection cn = Conexion.getConexion();

          try {
              String sql = "SELECT p.* " +
                           "FROM pasajero p " +
                           "JOIN reserva_vuelo r ON p.dni_pasajero = r.dni_pasajero " +
                           "WHERE r.id_vuelo = ?";
              PreparedStatement statement = cn.prepareStatement(sql);
              statement.setInt(1, idVuelo);
              ResultSet resultSet = statement.executeQuery();

              while (resultSet.next()) {
                   int dni = resultSet.getInt("dni_pasajero");
                   String nombre = resultSet.getString("nombre");
                   String apellido = resultSet.getString("apellido");
                   int edad = resultSet.getInt("edad");
                   String genero = resultSet.getString("genero");
                   String nacionalidad = resultSet.getString("nacionalidad");

                   Pasajero pasajero = new Pasajero(dni, nombre, apellido, edad, genero, nacionalidad);
                   pasajeros.add(pasajero);
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

          return pasajeros;
      }
                
        // Falta eliminar y metodos extras
                
        public static DefaultCategoryDataset obtenerDatos3(String fecha1, String fecha2) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            Connection cn = Conexion.getConexion();

            String destinoPopular = "";
            int ventasMaximas = 0;

            try {
                String query = "SELECT v.destino, COUNT(*) AS total " +
                        "FROM reserva_vuelo rv " +
                        "JOIN vuelo v ON rv.id_vuelo = v.id_vuelo " +
                        "WHERE DATE(rv.fecha_reserva) BETWEEN ? AND ? " +
                        "GROUP BY v.destino " +
                        "ORDER BY total DESC";

                PreparedStatement statement = cn.prepareStatement(query);

                statement.setString(1, fecha1);
                statement.setString(2, fecha2);

                ResultSet resultSet = statement.executeQuery();

                // Obtener los destinos y sus ventas y almacenarlos en el dataset
                while (resultSet.next()) {
                    String destination = resultSet.getString("destino");
                    int ventas = resultSet.getInt("total");
                    dataset.addValue(ventas, "Destinos", destination);

                    // Verificar si es el destino más popular
                    if (ventas > ventasMaximas) {
                        ventasMaximas = ventas;
                        destinoPopular = destination;
                    }
                }

                // Mostrar el mensaje con el destino más popular
                System.out.println("El destino más popular del rango de fechas es: " + destinoPopular);
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return dataset;
        }
        
        
        public boolean existeReserva(int dniPasajero, int idVuelo) {
            Connection cn = Conexion.getConexion();
            boolean existeReserva = false;

            try {
                String sql = "SELECT COUNT(*) AS count FROM Reserva_vuelo WHERE dni_pasajero = ? AND id_vuelo = ?";
                PreparedStatement statement = cn.prepareStatement(sql);
                statement.setInt(1, dniPasajero);
                statement.setInt(2, idVuelo);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    existeReserva = (count > 0);
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

            return existeReserva;
        }
        
        
        public int obtenerCapacidadAsientos(int idVuelo) {
            Connection cn = Conexion.getConexion();
            int capacidad = 0;

            try {
                String sql = "SELECT capacidad_pasajeros FROM avion INNER JOIN vuelo ON avion.id_avion = vuelo.id_avion WHERE id_vuelo = ?";
                PreparedStatement statement = cn.prepareStatement(sql);
                statement.setInt(1, idVuelo);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    capacidad = resultSet.getInt("capacidad_pasajeros");
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

            return capacidad;
        }
        
        public int obtenerCantidadReservas(int idVuelo) {
    int cantidadReservas = 0;
    Connection cn = Conexion.getConexion();

    try {
        String sql = "SELECT COUNT(*) AS cantidad FROM Reserva_vuelo WHERE id_vuelo = ?";
        PreparedStatement statement = cn.prepareStatement(sql);
        statement.setInt(1, idVuelo);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            cantidadReservas = resultSet.getInt("cantidad");
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

    return cantidadReservas;
}

}