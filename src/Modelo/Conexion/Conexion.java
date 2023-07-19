package Modelo.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection getConexion(){ 
		Connection con = null;
		try { Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost/bd_vuelos"; //"jdbc:mysql://localhost/bd_vuelos" (opcion local)
		String usr = "root";
		String psw = "";
		con = DriverManager.getConnection(url,usr,psw); 
		} catch (ClassNotFoundException ex)
		{ System.out.println("No hay Driverxd"); } 
		catch (SQLException ex) { System.out.println("Error con la BD "); }
		return con; 
		}
}  

