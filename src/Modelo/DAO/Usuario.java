
package Modelo.DAO;

import Modelo.Conexion.Conexion;
import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private Connection connection;

    public Usuario(Connection connection) {
        this.connection = connection;
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

}
