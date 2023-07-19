package Modelo.DAO;

import Modelo.Avion;
import Modelo.Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO {

    public void crearAvion(Avion avion) throws SQLException {
        Connection cn = Conexion.getConexion();
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
        Connection cn = Conexion.getConexion();
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
        List<Avion> lis = new ArrayList();
        Connection cn = Conexion.getConexion();
        try {
            String sql = "select id_avion, modelo, capacidad_pasajeros, id_aerolinea from avion";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Avion ep = new Avion(0, "", 0, 0);
                ep.setIdAvion(rs.getInt(1));
                ep.setModelo(rs.getString(2));
                ep.setCapacidadPasajeros(rs.getInt(3));
                ep.setIdAerolinea(rs.getInt(4));
                lis.add(ep);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            };
        }
        return lis;
    }

    public List<Avion> obtenerListaAviones() {
        List<Avion> listaAviones = new ArrayList<>();
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT av.id_avion, av.modelo, av.capacidad_pasajeros, ae.id_aerolinea, ae.nombre "
                    + "FROM avion av "
                    + "JOIN aerolinea ae ON av.id_aerolinea = ae.id_aerolinea";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idAvion = resultSet.getInt("id_avion");
                String modelo = resultSet.getString("modelo");
                int capacidadPasajeros = resultSet.getInt("capacidad_pasajeros");
                int idAerolinea = resultSet.getInt("id_aerolinea");
                String nombreAerolinea = resultSet.getString("nombre");

                Avion avion = new Avion(idAvion, modelo, capacidadPasajeros, idAerolinea);
                avion.setNombreAerolinea(nombreAerolinea);
                listaAviones.add(avion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }

        return listaAviones;
    }

    public void eliminarAvion(int id) throws SQLException {
        Connection cn = Conexion.getConexion();
        try {
            String sql = "delete from avion where id_avion=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Avion buscarAvion(int id) {
        Avion ep = null;
        Connection cn = Conexion.getConexion();
        try {
            String sql = "select id_avion, modelo, capacidad_pasajeros, id_aerolinea from avion where id_avion=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ep = new Avion(0, "", 0, 0);
                ep.setIdAvion(rs.getInt(1));
                ep.setModelo(rs.getString(2));
                ep.setCapacidadPasajeros(rs.getInt(3));
                ep.setIdAerolinea(rs.getInt(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            };
        }
        return ep;
    }

    public List<String> obtenerAvion() {
        List<String> avion = new ArrayList<>();
        Connection cn = Conexion.getConexion();
        try {
            String sql = "SELECT modelo FROM avion";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                avion.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return avion;
    }

    public int obtenerIdAvionPorModelo(String modeloAvion) throws SQLException {
        Connection cn = Conexion.getConexion();
        String sql = "SELECT id_avion FROM avion WHERE modelo = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, modeloAvion);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_avion");
                }
            }
        }

        return -1;
    }

    public String obtenerAvionPreferido() {
        String avionPreferido = null;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT av.modelo, COUNT(*) AS cantidad FROM avion av INNER JOIN Vuelo v ON av.id_avion = v.id_avion INNER JOIN Reserva_vuelo rv ON v.id_vuelo = rv.id_vuelo GROUP BY av.modelo ORDER BY COUNT(*) DESC LIMIT 1";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                avionPreferido = resultSet.getString("modelo");
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

        return avionPreferido;
    }

    public int obtenerCapacidadPromedioAvion() {
        int capacidadPromedio = 0;
        Connection cn = Conexion.getConexion();

        try {
            String sql = "SELECT AVG(capacidad_pasajeros) AS capacidad_promedio FROM avion";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                capacidadPromedio = resultSet.getInt("capacidad_promedio");
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

        return capacidadPromedio;
    }

}
