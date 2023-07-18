
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Pasajero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {
 
    public void crearPasajero(Pasajero pasajero) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "INSERT INTO pasajero (dni_pasajero, nombre, apellido, edad, genero, nacionalidad) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, pasajero.getDniPasajero());
            statement.setString(2, pasajero.getNombre());
            statement.setString(3, pasajero.getApellido());
            statement.setInt(4, pasajero.getEdad());
            statement.setString(5, pasajero.getGenero());
            statement.setString(6, pasajero.getNacionalidad());

            statement.executeUpdate();
        }
    }
    
      public void eliminarPasajero(int id) throws SQLException {
        Connection cn=Conexion.getConexion();
    try {
            String sql="delete from pasajero "
                    + "where dni_pasajero=?" ;
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     public Pasajero buscarPasajero(int id) {
        Pasajero ep=null;
        Connection cn=Conexion.getConexion();
        try {
            String sql="select dni_pasajero, nombre, apellido, edad, genero, nacionalidad from pasajero where dni_pasajero=?" ;
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){//Si lee significa que existe
                ep=new Pasajero(0,"","",0,"","");
                ep.setDniPasajero(rs.getInt(1));
                ep.setNombre(rs.getString(2));
                ep.setApellido(rs.getString(3));
                ep.setEdad(rs.getInt(4));
                ep.setGenero(rs.getString(5));
                ep.setNacionalidad(rs.getString(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return ep;
    }
     
     public void modificarPasajero(Pasajero pasajero) throws SQLException {
    Connection cn = Conexion.getConexion();
    String sql = "UPDATE pasajero SET nombre = ?, apellido = ?, edad = ?, genero = ?, nacionalidad = ? WHERE dni_pasajero = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
        statement.setString(1, pasajero.getNombre());
        statement.setString(2, pasajero.getApellido());
        statement.setInt(3, pasajero.getEdad());
        statement.setString(4, pasajero.getGenero());
        statement.setString(5, pasajero.getNacionalidad());
        statement.setInt(6, pasajero.getDniPasajero());

        statement.executeUpdate();
    }
}

    public List<Pasajero> Listado() {
        List<Pasajero> lis=new ArrayList();
        Connection cn=Conexion.getConexion();
        try {
            String sql="select dni_pasajero, nombre, apellido, edad, genero, nacionalidad from pasajero" ;
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Pasajero ep=new Pasajero(0,"","",0,"","");
                ep.setDniPasajero(rs.getInt(1));
                ep.setNombre(rs.getString(2));
                ep.setApellido(rs.getString(3));
                ep.setEdad(rs.getInt(4));
                ep.setGenero(rs.getString(5));
                ep.setNacionalidad(rs.getString(6));
                lis.add(ep);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return lis;
    }
    
    //para el otro frm

    public List<Object[]> listarPasajerosVuelo() {
        List<Object[]> clientes = new ArrayList<>();
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT r.id_reserva, p.dni_pasajero, p.nombre, p.apellido, v.origen, v.destino, aero.nombre AS aerolinea, r.fecha_reserva " +
                         "FROM reserva_vuelo r " +
                         "JOIN pasajero p ON r.dni_pasajero = p.dni_pasajero " +
                         "JOIN vuelo v ON r.id_vuelo = v.id_vuelo " +
                         "JOIN avion av ON v.id_avion = av.id_avion " +
                         "JOIN aerolinea aero ON av.id_aerolinea = aero.id_aerolinea";

            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int dniPasajero = resultSet.getInt("dni_pasajero");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String origen = resultSet.getString("origen");
                String destino = resultSet.getString("destino");
                String aerolinea = resultSet.getString("aerolinea");
                String fechaReserva = resultSet.getString("fecha_reserva");

                Object[] cliente = {dniPasajero, nombre, apellido, origen, destino, aerolinea, fechaReserva};
                clientes.add(cliente);
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

        return clientes;
    }
    
    
public List<Object[]> obtenerPasajerosReservadosFiltrados(String dni, String nombre, String apellido, String origen, String destino, String fechaInicial, String fechaFinal) {
    List<Object[]> pasajerosReservadosFiltrados = new ArrayList<>();
    Connection cn = Conexion.getConexion();

    try {
        String sql = "SELECT p.dni_pasajero, p.nombre, p.apellido, v.origen, v.destino, a.nombre AS aerolinea, r.fecha_reserva" +
                     " FROM Reserva_vuelo r" +
                     " INNER JOIN Pasajero p ON r.dni_pasajero = p.dni_pasajero" +
                     " INNER JOIN Vuelo v ON r.id_vuelo = v.id_vuelo" +
                     " INNER JOIN avion av ON v.id_avion = av.id_avion" +
                     " INNER JOIN aerolinea a ON av.id_aerolinea = a.id_aerolinea" +
                     " WHERE 1=1";

        if (dni != null && !dni.isEmpty()) {
            sql += " AND p.dni_pasajero = ?";
        }

        if (nombre != null && !nombre.isEmpty()) {
            sql += " AND p.nombre LIKE ?";
        }

        if (apellido != null && !apellido.isEmpty()) {
            sql += " AND p.apellido LIKE ?";
        }

        if (origen != null && !origen.isEmpty()) {
            sql += " AND v.origen = ?";
        }

        if (destino != null && !destino.isEmpty()) {
            sql += " AND v.destino = ?";
        }

        if (fechaInicial != null && fechaFinal != null) {
            sql += " AND r.fecha_reserva BETWEEN ? AND ?";
        }

        PreparedStatement statement = cn.prepareStatement(sql);

        int parameterIndex = 1;

        if (dni != null && !dni.isEmpty()) {
            statement.setString(parameterIndex, dni);
            parameterIndex++;
        }

        if (nombre != null && !nombre.isEmpty()) {
            statement.setString(parameterIndex, nombre + "%");
            parameterIndex++;
        }

        if (apellido != null && !apellido.isEmpty()) {
            statement.setString(parameterIndex, apellido + "%");
            parameterIndex++;
        }

        if (origen != null && !origen.isEmpty()) {
            statement.setString(parameterIndex, origen);
            parameterIndex++;
        }

        if (destino != null && !destino.isEmpty()) {
            statement.setString(parameterIndex, destino);
            parameterIndex++;
        }

        if (fechaInicial != null && fechaFinal != null) {
            statement.setString(parameterIndex, fechaInicial);
            parameterIndex++;
            statement.setString(parameterIndex, fechaFinal);
        }

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[7];
            fila[0] = resultSet.getInt("dni_pasajero");
            fila[1] = resultSet.getString("nombre");
            fila[2] = resultSet.getString("apellido");
            fila[3] = resultSet.getString("origen");
            fila[4] = resultSet.getString("destino");
            fila[5] = resultSet.getString("aerolinea");
            fila[6] = resultSet.getDate("fecha_reserva");

            pasajerosReservadosFiltrados.add(fila);
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

    return pasajerosReservadosFiltrados;
}

        public int contarPasajeros() {
        int cantidadPasajeros = 0;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT COUNT(*) AS cantidad FROM Pasajero";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cantidadPasajeros = resultSet.getInt("cantidad");
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

        return cantidadPasajeros;
    }
    
    public int contarPasajerosConReservas() {
        int cantidadPasajerosConReservas = 0;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT COUNT(DISTINCT dni_pasajero) AS cantidad FROM Reserva_vuelo";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cantidadPasajerosConReservas = resultSet.getInt("cantidad");
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

        return cantidadPasajerosConReservas;
    }
    
    
    public String obtenerNacionalidadMasRegistrada() {
        String nacionalidadMasRegistrada = null;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT nacionalidad, COUNT(*) AS cantidad FROM pasajero GROUP BY nacionalidad ORDER BY COUNT(*) DESC LIMIT 1";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nacionalidadMasRegistrada = resultSet.getString("nacionalidad");
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

        return nacionalidadMasRegistrada;
    }

}