
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
            String sql = "SELECT r.id_reserva, p.dni_pasajero, p.nombre, p.apellido, v.origen, v.destino, aero.nombre AS aerolinea, v.precio " +
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
                double precio = resultSet.getDouble("precio");

                Object[] cliente = {dniPasajero, nombre, apellido, origen, destino, aerolinea, precio};
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
    
    
    
    
    
    
    

}