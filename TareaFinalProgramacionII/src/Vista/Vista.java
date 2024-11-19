package Vista;
import modelo.Vehiculo;
import modelo.VehiculoDAO;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladora.Controladora;

import javax.swing.JScrollPane;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmat;
	private JTextField txtmarca;
	private JTextField txtmod;
	private JTextField txtmalet;
	private JTextField txtpuer;
	private JTextField txtplaz;
	private JTextField txtyear;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnagregar, btndel, btnbuscar, btnmodificar, btnmostrar, btnborrar, btnsalir;
	private JScrollPane scrollpane;
	private JPanel contentpane;
	private Vehiculo vehiculo;
	private Controladora controladora;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("Alquileres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmat = new JLabel("Matricula");
		lblmat.setBounds(10, 11, 70, 20);
		contentPane.add(lblmat);
		
		JLabel lblmarca = new JLabel("Marca");
		lblmarca.setBounds(10, 36, 70, 20);
		contentPane.add(lblmarca);
		
		JLabel lblmod = new JLabel("Modelo");
		lblmod.setBounds(10, 61, 70, 20);
		contentPane.add(lblmod);
		
		JLabel lblmalet = new JLabel("Maletero");
		lblmalet.setBounds(10, 86, 70, 20);
		contentPane.add(lblmalet);
		
		JLabel lblpuer = new JLabel("Puertas");
		lblpuer.setBounds(10, 111, 70, 20);
		contentPane.add(lblpuer);
		
		JLabel lblplaz = new JLabel("Plazas");
		lblplaz.setBounds(10, 136, 70, 20);
		contentPane.add(lblplaz);
		
		JLabel lblyear = new JLabel("Año");
		lblyear.setBounds(10, 160, 70, 20);
		contentPane.add(lblyear);
		
		txtmat = new JTextField();
		txtmat.setBounds(100, 10, 180, 20);
		contentPane.add(txtmat);
		txtmat.setColumns(10);
		
		txtmarca = new JTextField();
		txtmarca.setColumns(10);
		txtmarca.setBounds(100, 35, 180, 20);
		contentPane.add(txtmarca);
		
		txtmod = new JTextField();
		txtmod.setColumns(10);
		txtmod.setBounds(100, 60, 180, 20);
		contentPane.add(txtmod);
		
		txtmalet = new JTextField();
		txtmalet.setColumns(10);
		txtmalet.setBounds(100, 85, 180, 20);
		contentPane.add(txtmalet);
		
		txtpuer = new JTextField();
		txtpuer.setColumns(10);
		txtpuer.setBounds(100, 110, 180, 20);
		contentPane.add(txtpuer);
		
		txtplaz = new JTextField();
		txtplaz.setColumns(10);
		txtplaz.setBounds(100, 135, 180, 20);
		contentPane.add(txtplaz);
		
		txtyear = new JTextField();
		txtyear.setColumns(10);
		txtyear.setBounds(100, 160, 180, 20);
		contentPane.add(txtyear);
		
		btnagregar = new JButton("Agregar");
		btnagregar.setBounds(296, 10, 120, 35);
		contentPane.add(btnagregar);
		
		btndel = new JButton("Eliminar");
		btndel.setBounds(296, 55, 120, 35);
		contentPane.add(btndel);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.setBounds(296, 100, 120, 35);
		contentPane.add(btnbuscar);
		
		btnmodificar = new JButton("Modificar");
		btnmodificar.setBounds(296, 145, 120, 35);
		contentPane.add(btnmodificar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 414, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		model.addColumn("Matricula");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Maletero");
		model.addColumn("Puertas");
		model.addColumn("Plazas");
		model.addColumn("Año");

		JButton btnmostrar = new JButton("Mostrar");
		btnmostrar.setBounds(10, 430, 120, 35);
		contentPane.add(btnmostrar);
		
		btndel = new JButton("Borrar");
		btndel.setBounds(160, 430, 120, 35);
		contentPane.add(btndel);
		
		btnsalir = new JButton("Salir");
		btnsalir.addActionListener(controladora);
		btnsalir.setBounds(300, 430, 120, 35);
		contentPane.add(btnsalir);
	}

	public Vehiculo getVehiculo(){
		Vehiculo vehiculo= new Vehiculo();
		if(!(txtmat.equals("")&&txtmarca.equals("")&&txtmod.equals("")&&txtmalet.equals("")&&txtpuer.equals("")&&txtyear.equals("")&&txtplaz.equals(""))){
				vehiculo.setMat(txtmat.getText());
				vehiculo.setMarca(txtmarca.getText());
				vehiculo.setMod(txtmod.getText());
				vehiculo.setMalet(txtmalet.getText());
				vehiculo.setPuer(Integer.parseInt(txtpuer.getText()));
				vehiculo.setPlaz(Integer.parseInt(txtplaz.getText()));
				vehiculo.setYear(Integer.parseInt(txtyear.getText()));
				return vehiculo;
		}else{
			JOptionPane.showMessageDialog(null,"Hay datos sin completar");
            txtmat.requestFocus();
		}
		return vehiculo;
	}
    public String getMat(){
        String mat;
        if (txtmat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una matrícula");
            mat="";
        }else{
        mat = txtmat.getText();
		}
		return mat;
	}
	public void cargar(Vehiculo vehiculo){
		txtmat.setText(vehiculo.getMat());
		txtmarca.setText(vehiculo.getMarca());
		txtmod.setText(vehiculo.getMod());
		txtmalet.setText(vehiculo.getMalet());
		txtplaz.setText(String.valueOf(vehiculo.getPlaz()));
		txtpuer.setText(String.valueOf(vehiculo.getPuer()));
		txtyear.setText(String.valueOf(vehiculo.getYear()));
	}

		public void cargarTabla(ArrayList vehiculos){
			if(vehiculos.size() == 0){
				btnmodificar.setEnabled(false);
			}
			model.setRowCount(0);
			for(int i = 0; i < vehiculos.size(); i++){
					Object[] fila = {
					vehiculos.get(i).getMat(),
					vehiculos.get(i).getMarca(),
					vehiculos.get(i).getMod(),
					vehiculos.get(i).getMalet(),
					vehiculos.get(i).getPlaz(),
					vehiculos.get(i).getPuer(),
					vehiculos.get(i).getYear()
				};
			model.addRow(fila);
			}
		}

	public void borrar(){
		txtmat.setText("");
		txtmod.setText("");
		txtpuer.setText("");
		txtplaz.setText("");
		txtmalet.setText("");
		txtyear.setText("");
	}

		public void salir(){
			System.exit(0);
		}
		
		public void inicio(){
			btnagregar.setEnabled(true);
			btnmodificar.setEnabled(false);
			btndel.setEnabled(true);
			btnmostrar.setEnabled(true);
			btnbuscar.setEnabled(true);
			btnborrar.setEnabled(true);
			btnsalir.setEnabled(true);
		}
		public void Buscar(){
			btnagregar.setEnabled(false);
			btnmodificar.setEnabled(true);
			btndel.setEnabled(true);
			btnmostrar.setEnabled(true);
			btnbuscar.setEnabled(true);
			btnborrar.setEnabled(true);
			btnsalir.setEnabled(true);
		}
		public void modificarEliminar(){
			btnagregar.setEnabled(false);
			btnmodificar.setEnabled(true);
			btndel.setEnabled(true);
			btnmostrar.setEnabled(true);
			btnbuscar.setEnabled(false);
			btnborrar.setEnabled(true);
			btnsalir.setEnabled(true);
		}
		public void Mostrar(){
			btnagregar.setEnabled(true);
			btnmodificar.setEnabled(false);
			btndel.setEnabled(false);
			btnmostrar.setEnabled(true);
			btnbuscar.setEnabled(false);
			btnborrar.setEnabled(true);
			btnsalir.setEnabled(true);
		}

}
