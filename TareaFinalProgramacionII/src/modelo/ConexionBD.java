package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexionBD{
	private Connection conexion;
	private String bd="Clases";
	private String user="root";
	private String pswrd="root";
	private String url="jdbc:mariadb://localhost/"+ bd;
	private ConexionBD instance=null;
	
	private ConexionBD() {
	}
	public ConexionBD getInstance() {
		if(instance==null) {
			instance=new ConexionBD();
		}
		return instance;
	}
	public Connection getConnection()throws ClassNotFoundException,SQLException{
		Class.forName("org.mariadb.jdbc.Driver");
		conexion=DriverManager.getConnection(url,user,pswrd);
		return conexion;
	} 
	
}