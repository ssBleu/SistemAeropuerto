
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Trabajador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {

    public void crearTrabajador(Trabajador trabajador) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "INSERT INTO trabajador (id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, cargo, salario, fecha_contratacion, id_aerolinea) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, trabajador.getCodigoTra());
            statement.setString(2, trabajador.getNombre());
            statement.setString(3, trabajador.getApellido());
            statement.setDate(4, new java.sql.Date(trabajador.getFechaNacimiento().getTime()));
            statement.setString(5, trabajador.getUsuario());
            statement.setString(6, trabajador.getContrasena());
            statement.setString(7, trabajador.getCargo());
            statement.setDouble(8, trabajador.getSalario());
            statement.setDate(9, new java.sql.Date(trabajador.getFechaContratacion().getTime()));
            statement.setInt(10, trabajador.getIdAerolinea());

            statement.executeUpdate();
        }
    }
     public void eliminarTrabajdor(int id) throws SQLException {
        Connection cn = Conexion.getConexion();
        try {
            String sql = "delete from trabajador "
                    + "where id_trabajador=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void modificarTrabajador(Trabajador trabajador) throws SQLException {
    Connection cn = Conexion.getConexion();
    String sql = "UPDATE trabajador SET nombre = ?, apellido = ?, fecha_nacimiento = ?, usuario = ?, contrasena = ?, cargo = ?, salario = ?, fecha_contratacion = ?, id_aerolinea = ?     WHERE id_trabajador = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
        
        statement.setString(1, trabajador.getNombre());
        statement.setString(2, trabajador.getApellido());
        statement.setDate(3, new java.sql.Date(trabajador.getFechaNacimiento().getTime()));
        statement.setString(4,trabajador.getUsuario());
        statement.setString(5,trabajador.getContrasena());
        statement.setString(6,trabajador.getCargo());
        statement.setDouble(7,trabajador.getSalario());
        statement.setDate(8, new java.sql.Date(trabajador.getFechaContratacion().getTime()));
        statement.setInt(9, trabajador.getIdAerolinea());
        statement.setInt(10, trabajador.getCodigoTra());
        statement.executeUpdate();
    }
}
    
      public List<Trabajador> Listado() {
        List<Trabajador> lis=new ArrayList();
    
        
        Connection cn=Conexion.getConexion();
        try {
            String sql="select id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, cargo, salario, fecha_contratacion, id_aerolinea from trabajador" ;
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Trabajador ep=new Trabajador(0,"","",null,"","","",0,null,0);
                ep.setCodigoTra(rs.getInt(1));
                ep.setNombre(rs.getString(2));
                ep.setApellido(rs.getString(3));
                ep.setFechaNacimiento(rs.getDate(4));
                ep.setUsuario(rs.getString(5));
                ep.setContrasena(rs.getString(6));
                ep.setCargo(rs.getString(7));
                ep.setSalario(rs.getDouble(8));
                ep.setFechaContratacion(rs.getDate(9));
                ep.setIdAerolinea(rs.getInt(10));
                lis.add(ep);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return lis;
    }
      public Trabajador buscarTrabajador(int id) {
        Trabajador ep=null;
        Connection cn=Conexion.getConexion();
        try {
            String sql="select id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, cargo, salario, fecha_contratacion, id_aerolinea from trabajador where id_trabajador=?" ;
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){//Si lee significa que existe
                ep=new Trabajador(0,"","",null,"","","",0,null,0);
                 ep.setCodigoTra(rs.getInt(1));
                ep.setNombre(rs.getString(2));
                ep.setApellido(rs.getString(3));
                ep.setFechaNacimiento(rs.getDate(4));
                ep.setUsuario(rs.getString(5));
                ep.setContrasena(rs.getString(6));
                ep.setCargo(rs.getString(7));
                ep.setSalario(rs.getDouble(8));
                ep.setFechaContratacion(rs.getDate(9));
                ep.setIdAerolinea(rs.getInt(10));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return ep;
    }
   /* public Trabajador obtenerTrabajadorPorId(String idTrabajador) throws SQLException {
        String sql = "SELECT id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, cargo, salario, fecha_contratacion, id_aerolinea FROM trabajador WHERE id_trabajador = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idTrabajador);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id_trabajador");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
                    String usuario = resultSet.getString("usuario");
                    String contrasena = resultSet.getString("contrasena");
                    String cargo = resultSet.getString("cargo");
                    double salario = resultSet.getDouble("salario");
                    Date fechaContratacion = resultSet.getDate("fecha_contratacion");
                    String idAerolinea = resultSet.getString("id_aerolinea");

                    return new Trabajador(id, nombre, apellido, fechaNacimiento, usuario, contrasena, cargo, salario, fechaContratacion, idAerolinea);
                
                }
            }
        }

        return null;
    }

    public boolean validarCredenciales(String usuario, String contrasena) throws SQLException {
    String sql = "SELECT COUNT(*) FROM trabajador WHERE usuario = ? AND contrasena = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, usuario);
        statement.setString(2, contrasena);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }

    return false;
    }*/
}