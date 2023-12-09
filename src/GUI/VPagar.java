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
import javax.swing.JTextField;

import com.itextpdf.io.IOException;

import Logica.Aplicacion;
import Logica.Empleado;
import Logica.PasarelaPago;
import Logica.PayU;
import Logica.Paypal;



public class VPagar extends JFrame{
	private JButton pagar;
	private JButton regresar;
	private JComboBox<String> comboBox;
	private PasarelaPago pasarela;
	public VPagar(VEntregarCarro vEntregarCarro, Empleado emp, Aplicacion app,String reserva)  {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		JLabel IDLabel = new JLabel("Ingrese la Pasarela de pago");
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
        
        JLabel label1 = new JLabel ("Ingrese el nuemero de la tarjeta registrada del cliente");
        JTextField num = new JTextField();
        JLabel label2 = new JLabel ("Ingrese el cvv de la tarjeta registrada del cliente ");
        JTextField cvv = new JTextField();
        
        this.add(arriba, BorderLayout.NORTH);
        this.add(abajo, BorderLayout.SOUTH);
        this.add(der, BorderLayout.EAST);
        this.add(izq, BorderLayout.WEST);
        String[] comboBoxOptiones = {"PayU", "Paypal"};
        comboBox = new JComboBox<>(comboBoxOptiones);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 1, 10, 10));
	    //panel.add(idEliminarCarro);
		pagar = new JButton("Pagar con Tarjeta");
		pagar.setBackground(new Color(65, 105, 225));
		pagar.setForeground(Color.WHITE);
		String pasarelaTex = (String)comboBox.getSelectedItem();
		System.out.println(pasarela);
		String id = app.getReservas().get(reserva).getCliente();
		String numTar = num.getText();
		String cvvTar = cvv.getText();
				
		try
		{
		
		Class clase = Class.forName(pasarelaTex);
		
		pasarela = (PasarelaPago) clase.getDeclaredConstructor(Aplicacion.class).newInstance(app);
		
		
		}
		
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e)
		{
		System.out.println("No existe la clase :( o no funciona dinamcamente " + pasarelaTex);
		System.out.println("Se crea la clase no dinamicamente :/" + pasarelaTex);
		if (pasarelaTex == "PayU"){
		this.pasarela = new PayU(app);}
		else {
			this.pasarela = new Paypal(app);
		}
		e.printStackTrace();
		}
		
		
		int pag = pasarela.pagar(id, numTar, cvvTar);
		pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			
        			if (pag==2) {
        				JOptionPane.showMessageDialog(null, "PAGO CON TARJETA SATISFACTORIOS", "PAGO",JOptionPane.INFORMATION_MESSAGE);}
        			else if (pag==1) {
        				JOptionPane.showMessageDialog(null, "INFORMACION ERRONEA", "PAGO",JOptionPane.INFORMATION_MESSAGE);}
        			else if (pag==0) {
        				JOptionPane.showMessageDialog(null, "TARJETA BLOQUEDA, PAGUE EN EFECTIVO", "PAGO",JOptionPane.INFORMATION_MESSAGE);}
        			
        			emp.entregarVehiculo(app, reserva);
        			JOptionPane.showMessageDialog(null, "EL VEHICULO DE LA RESERVA "+reserva+" HA SIDO ENTREGADO", "ENTREGADO",JOptionPane.INFORMATION_MESSAGE);
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR INESPERADO", "ERROR",JOptionPane.ERROR_MESSAGE);
        		}
            }

        });
	    regresar = new JButton("Regresar");
	    regresar.setBackground(new Color(65, 105, 225));
	    regresar.setForeground(Color.WHITE);
	    regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vEntregarCarro.setVisible(true);
        		dispose();
        		
            }

        });
	    
	    panel.add(comboBox);
	    panel.add(label1);
	    panel.add(num);
	    panel.add(label2);
	    panel.add(cvv);
	    panel.add(pagar);
	    panel.add(regresar);
	    add(panel);
	    
       
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}

}
