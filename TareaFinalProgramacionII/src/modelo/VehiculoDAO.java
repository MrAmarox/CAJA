package modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class VehiculoDAO {
    private Statement stmt= null;
	private PreparedStatement pstmt= null;
	private ResultSet rs= null;
	private Connection con= null;
	private ConexionBD conbd= null;
    private Vehiculo vehiculo;

    public VehiculoDAO(ConexionBD conbd){
        this.conbd=conbd;    
    }
    public VehiculoDAO(){

    }

    public void modVehiculo(Vehiculo vehiculo){
        String sql="UPDATE Vehiculo SET marca=?, modelo=?, puertas=?, plazas=?, maletero=?, año=? where matricula=?";
        try{
            con=conbd.getconnection();
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, vehiculo.getMarca());
            pstmt.setString(2, vehiculo.getMod());
            pstmt.setInt(3, vehiculo.getPuer());
            pstmt.setInt(4, vehiculo.getPlaz());
            pstmt.setString(5, vehiculo.getMalet());
            pstmt.setInt(6, vehiculo.getYear());
            pstmt.setString(7, vehiculo.getMat());
            int res= pstmt.executeUpdate();
            if(res!=0 ){
                JOptionPane.showMessageDialog(null, "Modificación exitosa.");
            }
            pstmt.close();
            con.close();
        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null, "Error al cargar Drivers");
			cnfe.printStackTrace();
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
			sqle.printStackTrace();
        }
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        String sql="INSERT INTO vehiculo VALVES(?,?,?,?,?,?,?)";
        try {
			con=conbd.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vehiculo.getMat());
			pstmt.setString(2, vehiculo.getMarca());
			pstmt.setString(3, vehiculo.getMod());
			pstmt.setString(4, vehiculo.getPuer());
            pstmt.setString(5, vehiculo.getPlaz());
            pstmt.setString(6, vehiculo.getMalet());
            pstmt.setInt(7, vehiculo.getYear());
			int res=pstmt.executeUpdate();
			if(res!=0) {
				JOptionPane.showMessageDialog(null, "Vehiculo agregado exitosamente.");
			}
			pstmt.close();
			con.close();
		}catch(ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Error al cargar Drivers");
			cnfe.printStackTrace();
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
			sqle.printStackTrace();
		}
    }
    public boolean Consulta(String matr){
        boolean existe=false;
        String sql="Select * FROM vehiculo where matricula="+matr;
        try{
            con=conbd.getConnection();
            stmt=con.createStatement();
            rs= stmt.executeQuery(sql);
            if(rs.next()){
                int matCheck= rs.getString("matricula");
                if(matCheck==mat){
                    existe=true;
                }
            }
        }catch(ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Error al cargar Drivers");
			cnfe.printStackTrace();
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
			sqle.printStackTrace();
		}
		return existe;
    }
    public void delVehiculo(String mat){
        String sql="DELETE FROM vehiculos WHERE matricula="+mat;
        try{
            con= conbd.getConnection();
			stmt= con.createStatement();
			int res= stmt.executeUpdate(sql);
			if(res !=0) {
				JOptionPane.showMessageDialog(null, "Vehículo removido con éxito.");
			}
			stmt.close();
			con.close();
		}catch(ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Error al cargar Drivers");
			cnfe.printStackTrace();
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
			sqle.printStackTrace();
        }
    }
    public void getVehiculo(String mat){
        String sql="SELECT * FROM vehiculo WHERE matricula="+mat;
        try{
            conexion= conexionbd.getConnection();
			stmt= conexion.createStatement();
			rs.stmt.executeQuery(sql);
            if(rs.next()){
                vehiculo= new Vehiculo(
                    rs.getString(1);
                    rs.getString(2);
                    rs.getString(3);
                    rs.getString(6);
                    rs.getString(4);
                    rs.getString(5);
                    rs.getInt(7);
                )
            }
			stmt.close();
			conexion.close();
		}catch(ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Error al cargar Drivers");
			cnfe.printStackTrace();
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
			sqle.printStackTrace();
        }
    }
}
