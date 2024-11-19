package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VehiculoDAO {
    private Statement stmt= null;
	private PreparedStatement pstmt= null;
	private ResultSet rs= null;
	private Connection con= null;
	private ConexionBD conbd;
    private Vehiculo vehiculo;

    public VehiculoDAO(ConexionBD conbd){
        this.conbd=conbd;
    }
    public VehiculoDAO(){
        conbd= new ConexionBD();
    }
    public ArrayList<Vehiculo> getVehiculos(){
        ArrayList<Vehiculo> vehiculos= new ArrayList<>();
        String sql="SELECT matricula, marca, modelo, puertas, plazas, maletero, año FROM vehiculo;";
        try {
            con= conbd.getConnection();
            stmt= con.createStatement();
            rs= stmt.executeQuery(sql);
            while(rs.next()){
                vehiculo=new Vehiculo(
                    rs.getString("matricula"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("maletero"),
                    rs.getInt("puertas"),
                    rs.getInt("plazas"),
                    rs.getInt("año")
                );
                vehiculos.add(vehiculo);
            }

            rs.close();
            stmt.close();
            con.close();

        }catch(ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers.");
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos");
        }
        return vehiculos;
    }

    public void modVehiculo(Vehiculo vehiculo){
        String sql="UPDATE Vehiculo SET marca=?, modelo=?, puertas=?, plazas=?, maletero=?, año=? where matricula=?;";
        try{
            con=conbd.getConnection();
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
			JOptionPane.showMessageDialog(null, "Error al modificar los datos");
            sqle.printStackTrace();
        }
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        String sql="INSERT INTO vehiculo (matricula, marca, modelo, puertas, plazas, maletero, año) VALUES(?,?,?,?,?,?,?);";
        try {
			con=conbd.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vehiculo.getMat());
			pstmt.setString(2, vehiculo.getMarca());
			pstmt.setString(3, vehiculo.getMod());
			pstmt.setInt(4, vehiculo.getPuer());
            pstmt.setInt(5, vehiculo.getPlaz());
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
			JOptionPane.showMessageDialog(null, "Error al insertar datos");
            sqle.printStackTrace();
		}
    }
    public boolean Consulta(String matr){
        boolean existe=false;
        String sql="Select * FROM vehiculo WHERE matricula="+matr+";";
        try{
            con=conbd.getConnection();
            stmt=con.createStatement();
            rs= stmt.executeQuery(sql);
            if(rs.next()){
                String matCheck= rs.getString("matricula");
                if(matCheck.equals(matr)){
                    existe=true;
                }
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la matrícula");
            System.err.println(e.getMessage());
            e.printStackTrace();
		}
		return existe;
    }
    public boolean delVehiculo(String matr){
        boolean done = false;
        try{
            con= conbd.getConnection();
            stmt= con.createStatement();
            stmt.execute("DELETE FROM vehiculo WHERE matricula="+matr+";");
			JOptionPane.showMessageDialog(null, "Vehículo removido con éxito.");
			stmt.close();
			con.close();
        }catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el vehiculo");
            System.err.println(sqle.getMessage());
            sqle.printStackTrace();
		}catch(ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Error al cargar Drivers");
            System.err.println(cnfe.getMessage());
            cnfe.printStackTrace();
        }
        return done;
    }
    public Vehiculo getVehiculo(String mat){
        try{
            con= conbd.getConnection();
			stmt= con.createStatement();
			rs= stmt.executeQuery("SELECT * FROM vehiculo where matricula="+mat+";");
            if(rs.next()){
                vehiculo= new Vehiculo(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(6),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(7)
                );
            }
            stmt.close();
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener los datos");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return vehiculo;
    }
}
