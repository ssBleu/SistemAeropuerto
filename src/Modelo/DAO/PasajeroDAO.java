
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
            statement.setString(1, pasajero.getDniPasajero());
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
                ep=new Pasajero("","","",0,"","");
                ep.setDniPasajero(rs.getString(1));
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
        statement.setString(6, pasajero.getDniPasajero());

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
                Pasajero ep=new Pasajero("","","",0,"","");
                ep.setDniPasajero(rs.getString(1));
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
    
  
     /*public Pasajero obtenerPasajeroPorDni(String dni) throws SQLException {
        String sql = "SELECT dni_pasajero, nombre, apellido, edad, genero, nacionalidad FROM pasajero WHERE dni_pasajero = ?";
        Connection cn=Conexion.getConexion();
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, dni);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String dniPasajero = resultSet.getString("dni_pasajero");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    int edad = resultSet.getInt("edad");
                    String genero = resultSet.getString("genero");
                    String nacionalidad = resultSet.getString("nacionalidad");

                    return new Pasajero(dniPasajero, nombre, apellido, edad, genero, nacionalidad);
                }
            }
        }

        return null;
    }*/
}