package modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VehiculoDAO {
    private Statement stmt= null;
	private PreparedStatement pstmt= null;
	private ResultSet rs= null;
	private Connection conexion= null;
	private ConexionBD conexionbd= null;

    public VehiculoDAO(ConecionBD conexionbd){
        this.conexionbd=conexionbd;    
    }
    public VehiculoDAO(){

    }

    public void modVehiculo(Vehiculo vehiculo){
        String sql="UPDATE ";
    }
}
