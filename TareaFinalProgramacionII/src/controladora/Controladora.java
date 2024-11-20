package controladora;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Vehiculo;
import modelo.VehiculoDAO;

public class Controladora implements ActionListener, MouseListener {

    private static Vista vista;
	private static VehiculoDAO vehiculoDAO;
	@SuppressWarnings("unused")
	private Vehiculo vehiculo;

	public Controladora(Vista vista, VehiculoDAO vehiculoDAO) {
		Controladora.vista= vista;
		Controladora.vehiculoDAO= vehiculoDAO;
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		String objeto= e.getActionCommand();
		switch(objeto) {
			case "Agregar":
			    if (!(vista.getMat().equals(""))) {
			    	if (vehiculoDAO.Consulta(vista.getMat())) {
			    		JOptionPane.showMessageDialog(null, "Matrícula existente.");
                   }else{
						vehiculo = vista.getVehiculo();
                       vehiculoDAO.agregarVehiculo(vista.getVehiculo());
                       vista.borrar();
                		vista.cargarTabla(vehiculoDAO.getVehiculos());
		    	    }
		    	}else{
					JOptionPane.showMessageDialog(null, "No hay matrícula ingresada");
				}
				break;
			case "Modificar":
                if (!(vista.getmatTabla().equals(""))) {
                   if (vehiculoDAO.Consulta(vista.getmatTabla())) {
                    vehiculoDAO.modVehiculo(vista.getVehiculo(), vista.getmatTabla());
                    vista.borrar();
                    vista.cargarTabla(vehiculoDAO.getVehiculos());
                    }
                }
				break;
			case "Eliminar":
				if(!(vista.getmatTabla().equals(""))){
					vehiculoDAO.delVehiculo(vista.getmatTabla());
					vista.cargarTabla(vehiculoDAO.getVehiculos());
					vista.borrar();
				}
				break;
			case "Buscar":
			    if (vehiculoDAO.Consulta(vista.getMat())){
			    	vista.cargar(vehiculoDAO.getVehiculo(vista.getMat()));
                    vista.Buscar();
		    	}else{
		    		JOptionPane.showMessageDialog(null, "Ingrese una matrícula existente.");
	    		}
			break;
			case "Mostrar":
 				vista.cargarTabla(vehiculoDAO.getVehiculos());
				vista.Mostrar();
			break;
			case "Borrar":
			    vista.borrar();
				break;
			case "Salir":
				vista.salir();
				break;

			default:
				JOptionPane.showMessageDialog(null,  "Evento no identificado.");
				break;
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {


	}

	@Override
	public void mouseReleased(MouseEvent e) {


	}

	@Override
	public void mouseEntered(MouseEvent e) {


	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
