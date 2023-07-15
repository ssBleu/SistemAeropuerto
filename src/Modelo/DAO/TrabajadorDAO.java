
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Trabajador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {

    public void crearTrabajador(Trabajador trabajador) throws SQLException {
        Connection cn = Conexion.getConexion();
        String sql = "INSERT INTO trabajador (id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, foto, salario, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, trabajador.getCodigoTra());
            statement.setString(2, trabajador.getNombre());
            statement.setString(3, trabajador.getApellido());
            statement.setDate(4, new java.sql.Date(trabajador.getFechaNacimiento().getTime()));
            statement.setString(5, trabajador.getUsuario());
            statement.setString(6, trabajador.getContrasena());
            statement.setBytes(7, trabajador.getFoto());
            statement.setDouble(8, trabajador.getSalario());
            statement.setDate(9, new java.sql.Date(trabajador.getFechaContratacion().getTime()));

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
    String sql = "UPDATE trabajador SET nombre = ?, apellido = ?, fecha_nacimiento = ?, usuario = ?, contrasena = ?, foto = ?, salario = ?, fecha_contratacion = ? WHERE id_trabajador = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
        statement.setString(1, trabajador.getNombre());
        statement.setString(2, trabajador.getApellido());
        statement.setDate(3, new java.sql.Date(trabajador.getFechaNacimiento().getTime()));
        statement.setString(4, trabajador.getUsuario());
        statement.setString(5, trabajador.getContrasena());
        statement.setBytes(6, trabajador.getFoto());
        statement.setDouble(7, trabajador.getSalario());
        statement.setDate(8, new java.sql.Date(trabajador.getFechaContratacion().getTime()));
        statement.setInt(9, trabajador.getCodigoTra());

        statement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    
        public List<Trabajador> Listado() {
            List<Trabajador> lis = new ArrayList();
            Connection cn = Conexion.getConexion();

            try {
                String sql = "SELECT id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, foto, salario, fecha_contratacion FROM trabajador";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    int codigoTra = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String apellido = rs.getString(3);
                    Date fechaNacimiento = rs.getDate(4);
                    String usuario = rs.getString(5);
                    String contrasena = rs.getString(6);
                    byte[] fotoBytes = rs.getBytes(7);
                    double salario = rs.getDouble(8);
                    Date fechaContratacion = rs.getDate(9);

                    Trabajador trabajador = new Trabajador(codigoTra, nombre, apellido, fechaNacimiento, usuario, contrasena, fotoBytes, salario, fechaContratacion);

                    lis.add(trabajador);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try { cn.close(); } catch (Exception e2) {}
            }

            return lis;
        }
    
    
    public Trabajador buscarTrabajador(int id) {
        Trabajador trabajador = null;
        Connection cn = Conexion.getConexion();
        try {
            String sql = "SELECT id_trabajador, nombre, apellido, fecha_nacimiento, usuario, contrasena, foto, salario, fecha_contratacion FROM trabajador WHERE id_trabajador=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int codigoTra = rs.getInt("id_trabajador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");
                byte[] foto = rs.getBytes("foto");
                double salario = rs.getDouble("salario");
                Date fechaContratacion = rs.getDate("fecha_contratacion");

                trabajador = new Trabajador(codigoTra, nombre, apellido, fechaNacimiento, usuario, contrasena, foto, salario, fechaContratacion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return trabajador;
    }
    

         public boolean validarCredenciales(String usuario, String contrasena) throws SQLException {
        Connection cn=Conexion.getConexion();
    String sql = "SELECT COUNT(*) FROM trabajador WHERE usuario = ? AND contrasena = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
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
    }
         
         public int obtenerIdTrabajador(String usuario, String contrasena) throws SQLException {
        Connection cn = Conexion.getConexion();
        String sql = "SELECT id_trabajador FROM trabajador WHERE usuario = ? AND contrasena = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, usuario);
            statement.setString(2, contrasena);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_trabajador");
                }
            }
        }

        return -1;
    }
}