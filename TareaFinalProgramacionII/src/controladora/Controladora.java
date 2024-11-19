package controladora;
import modelo.Vehiculo;
import modelo.VehiculoDAO;
import Vista.Vista;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.Vehiculo;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import org.w3c.dom.events.MouseEvent;

public class Controladora implements ActionListener, MouseListener {

    private Vista vista;
	private VehiculoDAO vehiculoDAO;
	private Vehiculo vehiculo;

	public Controladora(Vista vista, VehiculoDAO vehiculoDAO) {
		this.vista= vista;
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
	public void actionPerformed(ActionEvent e) {
		String objeto= e.getActionCommand();
		vista.borrar();
		switch(objeto) {
			case "Ingresar":
			    if (!(vista.getMat().equals(""))) {
			    	if (vehiculoDAO.Consulta(vista.getMat())) {
			    		JOptionPane.showMessageDialog(null, "Matrícula existente.");
                   }else{
                       vehiculoDAO.agregarVehiculo(vista.getVehiculo());
                       vista.borrar();
                		vista.cargarTabla(vehiculoDAO.getVehiculos());
		    	    }
		    	}
				break;
			case "Modificar":
                if (!(vista.getMat().equals(""))) {
                   if (vehiculoDAO.Consulta(vista.getMat())) {
                    vehiculoDAO.modVehiculo(vista.getVehiculo());
                    vista.borrar();
                    vista.cargarTabla(vehiculoDAO.getVehiculos());
                    }
                }
				break;
			case "Eliminar":
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
			break;
			case "Borrar":
			    vista.borrar();
				break;

			case "Salir":
				vista.salir();
				break;

			default:
				JOptionPane.showMessageDialog(null,  "Evento no identificado.");
		}

	}

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
