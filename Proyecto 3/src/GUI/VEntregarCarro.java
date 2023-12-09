package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Logica.AdminGeneral;
import Logica.Aplicacion;
import Logica.Empleado;

public class VEntregarCarro extends JFrame {
	private JButton entregarCarro;
	private JButton regresar;
	private JComboBox<String> comboBox;
	private VPagar vPagar;
	public VEntregarCarro(VEmpleado vEmpleado, Empleado emp, Aplicacion app) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		JLabel IDLabel = new JLabel("Ingrese la ID del carro a entregar: ");
		JPanel arriba = new JPanel();
        arriba.setBackground(new Color(65, 105, 225));
        IDLabel.setForeground(Color.WHITE);
        arriba.add(IDLabel); 
        JPanel abajo = new JPanel();
        abajo.setBackground(new Color(65, 105, 225));
        abajo.add(Box.createRigidArea(new Dimension(0,15)));
        
        JPanel izq = new JPanel();
        izq.add(Box.createRigidArea(new Dimension(25,0)));
        JPanel der = new JPanel();
        der.add(Box.createRigidArea(new Dimension(15,0)));
        
       
        
        this.add(arriba, BorderLayout.NORTH);
        this.add(abajo, BorderLayout.SOUTH);
        this.add(der, BorderLayout.EAST);
        this.add(izq, BorderLayout.WEST);
		
        comboBox = new JComboBox<>(app.getReservas().keySet().toArray(new String[0]));
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 10, 10));
	    //panel.add(idEliminarCarro);
		entregarCarro = new JButton("Pasar a Pago");
		entregarCarro.setBackground(new Color(65, 105, 225));
		entregarCarro.setForeground(Color.WHITE);
		String idELim = (String)comboBox.getSelectedItem();
        			//System.out.println(idELim);
        			//emp.entregarVehiculo(app, idELim);
        			
						this.vPagar = new VPagar(this, emp, app, idELim);			
						// TODO Auto-generated catch block
				
		entregarCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			vPagar.setVisible(true);
        			setVisible(false);
        			//JOptionPane.showMessageDialog(null, "EL VEHICULO DE LA RESERVA "+idELim+" HA SIDO ENTREGADO", "ENTREGADO",JOptionPane.INFORMATION_MESSAGE);
        			comboBox.removeItem(idELim);
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR, REVISE EL ID", "ERROR",JOptionPane.ERROR_MESSAGE);
        		}
            }

        });
	    regresar = new JButton("Regresar");
	    regresar.setBackground(new Color(65, 105, 225));
	    regresar.setForeground(Color.WHITE);
	    regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vEmpleado.setVisible(true);
        		dispose();
        		
            }

        });
	    
	    panel.add(comboBox);
	    panel.add(entregarCarro);
	    panel.add(regresar);
	    add(panel);
	    
       
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}

}
