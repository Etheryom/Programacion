package TemaDBClases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.awt.AWTUtilities;

public class Vista extends JFrame {

	private VistaImagenOracle oracle;
	private JPanel userPassword;
	private JPanel conectadoDesconectado;
	private JPanel panelAceptar;
	private JPanel marco;
	private JTextField campoNombre;
	private JPasswordField campoPassword;
	private JLabel nombre;
	private JLabel password;
	private JLabel estado;
	private JButton aceptar;
	
	
	
	public Vista(){
		
		oracle = new VistaImagenOracle();
		
		userPassword = new JPanel(new GridLayout(2,2));
		userPassword.setOpaque(false);
		
		conectadoDesconectado = new JPanel(new FlowLayout(1));
		conectadoDesconectado.setBackground(Color.black);
	
		
		marco = new JPanel(new GridLayout(3,1));
		panelAceptar = new JPanel(new BorderLayout());
		panelAceptar.setOpaque(false);
		
		marco.setBorder(new LineBorder(Color.gray));
		
		campoNombre = new JTextField(1);
		campoPassword = new JPasswordField(1);
		
		nombre = new JLabel("Nombre");
		password = new JLabel("Password");
		estado = new JLabel("Estado: Desconectado");
		estado.setForeground(Color.RED);
		
		aceptar = new JButton("Aceptar");
		
		panelAceptar.add(aceptar);
		conectadoDesconectado.add(estado);
		userPassword.add(nombre);
		userPassword.add(campoNombre);
		userPassword.add(password);
		userPassword.add(campoPassword);
		
		marco.add(conectadoDesconectado);
		marco.add(userPassword);
		marco.add(panelAceptar);
		
		
		add(oracle,BorderLayout.CENTER);
		add(marco,BorderLayout.SOUTH);
	}
	
	public void arrancar(){

		setSize(400,400);
		setTitle("Carta");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setUndecorated(true);
	    setVisible(true);
	    AWTUtilities.setWindowOpaque(this, false);
	}
	
	//<<------GETTERS AND SETTERS--------->>
	public VistaImagenOracle getOracle() {
		return oracle;
	}

	public void setOracle(VistaImagenOracle oracle) {
		this.oracle = oracle;
	}

	public JPanel getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(JPanel userPassword) {
		this.userPassword = userPassword;
	}

	public JPanel getConectadoDesconectado() {
		return conectadoDesconectado;
	}

	public void setConectadoDesconectado(JPanel conectadoDesconectado) {
		this.conectadoDesconectado = conectadoDesconectado;
	}

	public JPanel getPanelAceptar() {
		return panelAceptar;
	}

	public void setPanelAceptar(JPanel panelAceptar) {
		this.panelAceptar = panelAceptar;
	}

	public JPanel getMarco() {
		return marco;
	}

	public void setMarco(JPanel marco) {
		this.marco = marco;
	}

	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	public JPasswordField getCampoPassword() {
		return campoPassword;
	}

	public void setCampoPassword(JPasswordField campoPassword) {
		this.campoPassword = campoPassword;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JLabel getEstado() {
		return estado;
	}

	public void setEstado(JLabel estado) {
		this.estado = estado;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}
}
