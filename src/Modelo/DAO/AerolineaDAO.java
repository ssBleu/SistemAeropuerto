package Modelo.DAO;

import Modelo.Aerolinea;
import Modelo.Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AerolineaDAO {


  public void crearAerolinea(Aerolinea aerolinea) throws SQLException {
        Connection cn=Conexion.getConexion(); //INSERT INTO aerolinea (id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion) VALUES (?, ?, ?, ?, ?, ?)
        String sql = "INSERT INTO aerolinea (id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion) VALUES (?, ?, ?, ?, ?, ?)";
//
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, aerolinea.getIdAerolinea());
            statement.setString(2, aerolinea.getNombre());
            statement.setString(3, aerolinea.getPaisOrigen());
            statement.setString(4, aerolinea.getTelefono());
            statement.setString(5, aerolinea.getPaginaWeb());
            statement.setDate(6, new java.sql.Date(aerolinea.getFechaFundacion().getTime())); //new java.sql.Date(aerolinea.getFechaFundacion().getTime())

            statement.executeUpdate();
        }
    }
     public void modificarAerolinea(Aerolinea aerolinea) throws SQLException {
    Connection cn = Conexion.getConexion();
    String sql = "UPDATE aerolinea SET nombre = ?, pais_origen = ?, telefono = ?, pagina_web = ?, fecha_fundacion = ? WHERE id_aerolinea = ?";

    try (PreparedStatement statement = cn.prepareStatement(sql)) {
        statement.setString(1, aerolinea.getNombre());
        statement.setString(2, aerolinea.getPaisOrigen());
        statement.setString(3, aerolinea.getTelefono());
        statement.setString(4, aerolinea.getPaginaWeb());
        statement.setDate(5, new java.sql.Date(aerolinea.getFechaFundacion().getTime()));
        statement.setInt(6, aerolinea.getIdAerolinea());

        statement.executeUpdate();
    }
}
    public void eliminarAerolinea(int idAerolinea) throws SQLException {
      Connection cn = Conexion.getConexion();
      String sql = "DELETE FROM aerolinea WHERE id_aerolinea = ?";
      try (PreparedStatement statement = cn.prepareStatement(sql)) {
          statement.setInt(1, idAerolinea);
          statement.executeUpdate();
      }
  }
 

        public List<Aerolinea> Listado() {
        List<Aerolinea> lis=new ArrayList();
        Connection cn=Conexion.getConexion();
        try {
            String sql="SELECT id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion FROM aerolinea" ;
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Aerolinea ep=new Aerolinea(0,"","","","",null);
                ep.setIdAerolinea(rs.getInt(1));
                ep.setNombre(rs.getString(2));
                ep.setPaisOrigen(rs.getString(3));
                ep.setTelefono(rs.getString(4));
                ep.setPaginaWeb(rs.getString(5));
                ep.setFechaFundacion(rs.getDate(6));
                lis.add(ep);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return lis;
    }
    public Aerolinea buscarAerolinea(int id) {
        Aerolinea ep=null;
        Connection cn=Conexion.getConexion();
        try {
            String sql="SELECT id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion FROM aerolinea where id_aerolinea=?" ;
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){//Si lee significa que existe
                ep=new Aerolinea(0,"","","","",null);
                ep.setIdAerolinea(rs.getInt(1));
                ep.setNombre(rs.getString(2));
                ep.setPaisOrigen(rs.getString(3));
                ep.setTelefono(rs.getString(4));
                ep.setPaginaWeb(rs.getString(5));
                ep.setFechaFundacion(rs.getDate(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return ep;
    }
    public Aerolinea obtenerAerolineaPorId(int idAerolinea) throws SQLException {
        Connection cn = Conexion.getConexion();
        String sql = "SELECT id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion FROM aerolinea WHERE id_aerolinea = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, idAerolinea);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_aerolinea");
                    String nombre = resultSet.getString("nombre");
                    String paisOrigen = resultSet.getString("pais_origen");
                    String telefono = resultSet.getString("telefono");
                    String paginaWeb = resultSet.getString("pagina_web");
                    Date fechaFundacion = resultSet.getDate("fecha_fundacion");

                    return new Aerolinea(id, nombre, paisOrigen, telefono, paginaWeb, fechaFundacion);
                }
            }
        }

        return null;
    }
    
        public Aerolinea obtenerAerolineaPorNombre(String nombreAerolinea) throws SQLException {
        Connection cn = Conexion.getConexion();
        String sql = "SELECT id_aerolinea, nombre, pais_origen, telefono, pagina_web, fecha_fundacion FROM aerolinea WHERE nombre = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, nombreAerolinea);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_aerolinea");
                    String nombre = resultSet.getString("nombre");
                    String paisOrigen = resultSet.getString("pais_origen");
                    String telefono = resultSet.getString("telefono");
                    String paginaWeb = resultSet.getString("pagina_web");
                    Date fechaFundacion = resultSet.getDate("fecha_fundacion");

                    return new Aerolinea(id, nombre, paisOrigen, telefono, paginaWeb, fechaFundacion);
                }
            }
        }

        return null;
    }
    
    
    public List<Integer> obtenerAerolineas() {
        List<Integer> aeropuertos = new ArrayList<>();
        Connection cn = Conexion.getConexion();
        try {
            String sql = "SELECT id_aerolinea FROM aerolinea";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                aeropuertos.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return aeropuertos;
    }
    
    
        
    public List<String> obtenerNombreporIdAerolineas(int ID) {
        List<String> aeropuertos = new ArrayList<>();
        Connection cn = Conexion.getConexion();
        try {
            String sql = "SELECT nombre FROM aerolinea WHERE id_aerolinea=?";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                aeropuertos.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return aeropuertos;
    }


    // Falta eliminar y metodos extras
}