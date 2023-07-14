
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Pasajero;
import Modelo.Reserva;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
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
            // Realiza una consulta SQL para obtener las reservas asociadas al ID del vuelo
            String sql = "SELECT * FROM reserva_vuelo WHERE id_vuelo = ?";
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, idVuelo);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Obtener los datos de cada reserva y crear objetos Reserva
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
                   // Obtener los datos de cada pasajero y crear objetos Pasajero
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

            // Variables para almacenar el destino más popular
            String destinoPopular = "";
            int ventasMaximas = 0;

            try {
                // Crear una declaración SQL con parámetros de fecha
                String query = "SELECT v.destino, COUNT(*) AS total " +
                        "FROM reserva_vuelo rv " +
                        "JOIN vuelo v ON rv.id_vuelo = v.id_vuelo " +
                        "WHERE DATE(rv.fecha_reserva) BETWEEN ? AND ? " +
                        "GROUP BY v.destino " +
                        "ORDER BY total DESC";

                // Preparar la consulta SQL
                PreparedStatement statement = cn.prepareStatement(query);

                // Establecer los parámetros de fecha
                statement.setString(1, fecha1);
                statement.setString(2, fecha2);

                // Ejecutar la consulta SQL
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

}