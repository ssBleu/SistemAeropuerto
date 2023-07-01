package Modelo.DAO;

import Modelo.Avion;
import Modelo.Conexion.Conexion;
import Modelo.Pasajero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO {

    //public AvionDAO(Connection connection) {
     //   this.connection = connection;
    //}

    public void crearAvion(Avion avion) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "INSERT INTO avion (id_avion, modelo, capacidad_pasajeros, id_aerolinea) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, avion.getIdAvion());
            statement.setString(2, avion.getModelo());
            statement.setInt(3, avion.getCapacidadPasajeros());
            statement.setInt(4, avion.getIdAerolinea());

            statement.executeUpdate();
        }
    }

    public Avion obtenerAvionPorId(String idAvion) throws SQLException {
        Connection cn=Conexion.getConexion();
        String sql = "SELECT id_avion, modelo, capacidad_pasajeros, id_aerolinea FROM avion WHERE id_avion = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, idAvion);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_avion");
                    String modelo = resultSet.getString("modelo");
                    int capacidadPasajeros = resultSet.getInt("capacidad_pasajeros");
                    int idAerolinea = resultSet.getInt("id_aerolinea");

                    return new Avion(id, modelo, capacidadPasajeros, idAerolinea);
                }
            }
        }

        return null;
    }
    
        public List<Avion> Listado() {
        List<Avion> lis=new ArrayList();
        Connection cn=Conexion.getConexion();
        try {
            String sql="select id_avion, modelo, capacidad_pasajeros, id_aerolinea from avion" ;
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Avion ep=new Avion(0,"",0,0);
                ep.setIdAvion(rs.getInt(1));
                ep.setModelo(rs.getString(2));
                ep.setCapacidadPasajeros(rs.getInt(3));
                ep.setIdAerolinea(rs.getInt(4));
                lis.add(ep);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return lis;
    }
        
        
      public void eliminarAvion(int id) throws SQLException {
        Connection cn = Conexion.getConexion();
        try {
            String sql = "delete from avion "
                    + "where id_avion=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        public Avion buscarAvion(int id) {
        Avion ep=null;
        Connection cn=Conexion.getConexion();
        try {
            String sql="select id_avion, modelo, capacidad_pasajeros, id_aerolinea from avion where id_avion=?" ;
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){//Si lee significa que existe
                ep=new Avion(0,"",0,0);
                 ep.setIdAvion(rs.getInt(1));
                ep.setModelo(rs.getString(2));
                ep.setCapacidadPasajeros(rs.getInt(3));
                ep.setIdAerolinea(rs.getInt(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { cn.close();} catch(Exception e2) {};
        }
        return ep;
    }
        // Falta eliminar y metodos extras
}
