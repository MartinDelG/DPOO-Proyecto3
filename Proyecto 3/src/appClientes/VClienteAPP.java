package appClientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import GUI.VCliente;
import GUI.VNuevoCliente;
import Logica.Aplicacion;
import Logica.Cliente;
import Logica.principales;
import Logica.regresable;

public class VClienteAPP extends JFrame implements principales, regresable{

	private Aplicacion app = new Aplicacion(); 
    private JTextField usernameField;
    private JPasswordField passwordField;
    private VCliente vCliente;
    private VNuevoCliente vNuevoCliente;
	public VClienteAPP() {
		// TODO Auto-generated constructor stub
		 setTitle("APP CLIENTES");

	        usernameField = new JTextField(20);
	        // usernameField.setPreferredSize(new Dimension(15,this.getWidth()));
	        //usernameField.setBorder(new EmptyBorder(0, 0, 0, 20));
	        passwordField = new JPasswordField(20);
	        //passwordField.setBorder(new EmptyBorder(0, 0, 0, 20));
	        this.setLayout(new BorderLayout());
	        JLabel usernameLabel = new JLabel("USUARIO:");
	        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        JLabel passwordLabel = new JLabel("CONTRASENIA:");
	        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        JButton loginButton = new JButton("LogIn");
	        
	        JButton NewUserButton = new JButton("Nuevo Cliente");
	        NewUserButton.setBackground(new Color(65, 105, 225));
	        NewUserButton.setForeground(Color.WHITE);
	        loginButton.setBackground(new Color(65, 105, 225));
	        loginButton.setForeground(Color.WHITE);
	        VClienteAPP temp = this;
	        loginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                char[] passwordChars = passwordField.getPassword();
	                String password = new String(passwordChars);

	                 if (verificarUser(username, password)==4) {
	                	Cliente admin = app.getCliente(username);
	                	setVisible(false);
	                	vCliente = new VCliente(temp, admin, app);
	                	vCliente.setVisible(true);
	                }
	                
	                else {
	                	 //JOptionPane d =new JOptionPane();
	                	 JOptionPane.showMessageDialog(null, "CONTRASENIA O USUARIO INCORRECTOS", "Error",JOptionPane.WARNING_MESSAGE);
	                	 /*
	                	d.setModal(true);
	                	d.add(lab);
	                	d.setSize(300, 150);
	                    d.setLocationRelativeTo(null); 
	                	d.setVisible(true);*/
	                }
	            }
	        });
	        
	        VClienteAPP this_temp = this;
	        NewUserButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	vNuevoCliente = new VNuevoCliente(this_temp, app);
	                setVisible(false);
	                vNuevoCliente.setVisible(true);
	            }
	        });
	        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 20));
	        //panel.add(Box.createRigidArea(new Dimension(0,15)));
	        //panel.add(Box.createRigidArea(new Dimension(0,15)));
	        //panel.add(Box.createRigidArea(new Dimension(0,15)));
	        //panel.add(Box.createRigidArea(new Dimension(0,15)));
	        //panel.add(Box.createRigidArea(new Dimension(0,15)));
	        
	        panel.add(Box.createRigidArea(new Dimension(0,15)));
	        panel.add(Box.createRigidArea(new Dimension(0,15)));
	        
	        panel.add(usernameLabel);
	        panel.add(usernameField);
	        
	        
	        
	        panel.add(passwordLabel);
	        panel.add(passwordField);
	        
	        panel.add(Box.createRigidArea(new Dimension(0,15)));
	        panel.add(loginButton);
	        
	        //panel.add(new JLabel()); 
	        panel.add(Box.createRigidArea(new Dimension(0,15)));
	        panel.add(NewUserButton);
	        
	        panel.add(Box.createRigidArea(new Dimension(0,15)));
	        panel.add(Box.createRigidArea(new Dimension(0,15)));
	        //panel.add(Box.createRigidArea(new Dimension(0,15)));
	       // panel.add(Box.createRigidArea(new Dimension(0,15)));
	        //setLayout(new FlowLayout());
	        
	        JPanel arriba = new JPanel();
	        arriba.setBackground(new Color(65, 105, 225));
	        arriba.add(Box.createRigidArea(new Dimension(0,15)));
	        JPanel abajo = new JPanel();
	        abajo.setBackground(new Color(65, 105, 225));
	        abajo.add(Box.createRigidArea(new Dimension(0,15)));
	        
	        JPanel izq = new JPanel();
	        izq.add(Box.createRigidArea(new Dimension(25,0)));
	        JPanel der = new JPanel();
	        der.add(Box.createRigidArea(new Dimension(15,0)));
	        
	        this.add(arriba, BorderLayout.NORTH);
	        this.add(abajo, BorderLayout.SOUTH);
	        this.add(panel,BorderLayout.CENTER);
	        this.add(der, BorderLayout.EAST);
	        this.add(izq, BorderLayout.WEST);
	        //panel.setBackground();
	       
	        setSize(600, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null); 
	        setVisible(true);
	}

	@Override
	public Integer verificarUser(String username, String password) {
		// TODO Auto-generated method stub
		return this.app.verificarUsuario(username, password);
		
	}
	public static void main(String[] args) {
		VClienteAPP vClienteAPP = new VClienteAPP();
		vClienteAPP.app.cargarAdminGeneral("Datattt/adminGeneral.txt");
		vClienteAPP.app.cargarAdminsLocales("Datattt/AdminLocal.txt");
		vClienteAPP.app.cargarCategorias("Datattt/Categorias.txt");
		vClienteAPP.app.cargarClientes("Datattt/Clientes.txt");
		vClienteAPP.app.cargarEmpleados("Datattt/Empleados.txt");
		vClienteAPP.app.cargarSedes("Datattt/Sedes.txt");
		vClienteAPP.app.cargarSeguro("Datattt/Seguros.txt");
		vClienteAPP.app.cargarVehiculos("Datattt/Vehiculos.txt");
		vClienteAPP.app.cargarTemporada("Datattt/temp.txt");
		vClienteAPP.app.cargarReservas("Datattt/reservas.txt");
		//vLogIn.ejecutarAplicacion();	 
	}
}

