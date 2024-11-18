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
    private Vehiculo vehiculo:

    public VehiculoDAO(ConexionBD conexionbd){
        this.conexionbd=conexionbd;    
    }
    public VehiculoDAO(){

    }

    public void modVehiculo(Vehiculo vehiculo){
        String sql="UPDATE Vehiculo SET marca=?, modelo=?, puertas=?, plazas=?, maletero=?, año=? where matricula=?";
        try{
            conexion=conexionbd.getconnection();
            pstmt=conexion.prepareStatement(sql);
            pstmt.setString(1, vehiculo.getMarca()));
            pstmt.setString(2, vehiculo.getModelo());
            pstmt.setString(3, vehiculo.getPuertas());
            pstmt.setString(4, vehiculo.getPlazas());
            pstmt.setString(5, vehiculo.getMaletero());
            pstmt.setString(6, vehiculo.getYear());
            pstmt.setString(7, vehiculo.getMatricula());
        }
    }
}
