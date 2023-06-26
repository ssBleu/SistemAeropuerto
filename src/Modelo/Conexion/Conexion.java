package Modelo.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection getConexion(){ 
		Connection con = null;
		try { Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10628899"; //"jdbc:mysql://localhost/bd_vuelos" (opcion local)
		String usr = "sql10628899"; //root (opcion local)
		String psw = "YqmCP18gTM"; //nada (opcion local)
		con = DriverManager.getConnection(url,usr,psw); 
		System.out.println("conexion ok");
		} catch (ClassNotFoundException ex)
		{ System.out.println("No hay Driver!!"); } 
		catch (SQLException ex) { System.out.println("Error con la BD "); }
		return con; 
		}
}  

