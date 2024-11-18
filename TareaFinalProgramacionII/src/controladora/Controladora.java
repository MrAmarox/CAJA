package controladora;
import modelo.Vehiculo;
import modelo.VehiculoDAO;
import Vista.Vista;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.Vehiculo;

import org.w3c.dom.events.MouseEvent;

public class Controladora implements ActionListener, MouseListener {

    private Vista Vista;
	private VehiculoDAO vehiculoDAO;
	private Vehiculo vehiculo;

	public Controladora(Vista Vista, VehiculoDAO vehiculoDAO) {
		this.Vista= Vista;
		this.vehiculoDAO= vehiculoDAO;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String objeto= e.getActionCommand();
		switch(objeto) {
			case "Ingresar":
			if (Vista.getMat()!="") {
				if (vehiculoDAO.Consulta(Vista.getMat())) {
					JOptionPane.showMessageDialog(null, "Matrícula existente.");
                }else{
					
				}
			}
				break;
			case "Modificar":
				break;
			case "Eliminar":
				break;
			case "Buscar":
				break;
			case "Mostrar":
				break;
			case "Borrar":
				break;
			case "Salir":
				Vista.salir();
				break;
			default:
				JOptionPane.showMessageDialog(null,  "Evento no identificado.");
		}

	}
}
