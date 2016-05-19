package Universidad.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.sun.awt.AWTUtilities;

public class Login extends JFrame {
	
	private JPanel panel_Nombre_Universidad;
	private JPanel panel_Login;
	private JPanel panel_Login_Datos;
	private JPanel panel_Login_Botones;
	private JPanel panel_Login_Imagen;
	
	private JLabel jl_carnetUniversitario;
	private JLabel jl_password;
	
	private JButton ingresar;
	private JButton cancelar;
	
	private JTextField carnetUniversitario;
	private JPasswordField password;
	
	private JLabel nombre_Universidad;
	
	public Login(){
		
		panel_Nombre_Universidad = new JPanel();
		panel_Login = new JPanel(new BorderLayout());
		panel_Login_Datos = new JPanel(new GridLayout(5,1,0,4));
		panel_Login_Botones = new JPanel(new GridLayout(1,2));
		panel_Login_Imagen = new JPanel(new BorderLayout());
		
		
		nombre_Universidad = new JLabel("UNIVERSIDAD DE 1ºDAW",SwingConstants.CENTER);
		jl_carnetUniversitario = new JLabel("Carnet Universitario");
		jl_password = new JLabel("Password");
		
		carnetUniversitario = new JTextField(1);
		password= new JPasswordField(1);
		
		ingresar= new JButton("Ingresar");
		cancelar = new JButton("Cancelar");
		
		panel_Nombre_Universidad.setBackground(new Color(0,153,76));
		nombre_Universidad .setFont(new Font("SansSerif", Font.BOLD, 18));
		nombre_Universidad.setForeground(Color.WHITE);
		
		panel_Login_Datos.setBorder(new LineBorder(new Color(198,198,198),7));
		panel_Login.setBackground(new Color(198,198,198));
		
		panel_Login_Datos.setOpaque(false);
		
		panel_Login_Imagen.add(new DibujarImagenes(DibujarImagenes.IMAGEN_LOGIN));
		
		panel_Nombre_Universidad.add(nombre_Universidad);
		
		panel_Login_Botones.add(ingresar);
		panel_Login_Botones.add(cancelar);
		

		panel_Login_Datos.add(jl_carnetUniversitario);
		panel_Login_Datos.add(carnetUniversitario);
		panel_Login_Datos.add(jl_password);
		panel_Login_Datos.add(password);
		panel_Login_Datos.add(panel_Login_Botones);
		

		panel_Login.add(panel_Login_Datos,BorderLayout.CENTER);
		panel_Login.add(panel_Login_Imagen,BorderLayout.WEST);
		

		
		add(panel_Nombre_Universidad,BorderLayout.NORTH);
		add(panel_Login,BorderLayout.CENTER);
		
	}
	
	public void arrancar(){
		setSize(450,220);
		setTitle("Login Universidad");
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setVisible(true);
	}
	//<<<---GETTERS AND SETTERS--->>>
	public JPanel getPanel_Nombre_Universidad() {
		return panel_Nombre_Universidad;
	}

	public void setPanel_Nombre_Universidad(JPanel panel_Nombre_Universidad) {
		this.panel_Nombre_Universidad = panel_Nombre_Universidad;
	}

	public JPanel getPanel_Login() {
		return panel_Login;
	}

	public void setPanel_Login(JPanel panel_Login) {
		this.panel_Login = panel_Login;
	}

	public JPanel getPanel_Login_Datos() {
		return panel_Login_Datos;
	}

	public void setPanel_Login_Datos(JPanel panel_Login_Datos) {
		this.panel_Login_Datos = panel_Login_Datos;
	}

	public JPanel getPanel_Login_Botones() {
		return panel_Login_Botones;
	}

	public void setPanel_Login_Botones(JPanel panel_Login_Botones) {
		this.panel_Login_Botones = panel_Login_Botones;
	}

	public JPanel getPanel_Login_Imagen() {
		return panel_Login_Imagen;
	}

	public void setPanel_Login_Imagen(JPanel panel_Login_Imagen) {
		this.panel_Login_Imagen = panel_Login_Imagen;
	}

	public JLabel getJl_carnetUniversitario() {
		return jl_carnetUniversitario;
	}

	public void setJl_carnetUniversitario(JLabel jl_carnetUniversitario) {
		this.jl_carnetUniversitario = jl_carnetUniversitario;
	}

	public JButton getIngresar() {
		return ingresar;
	}

	public void setIngresar(JButton ingresar) {
		this.ingresar = ingresar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JTextField getCarnetUniversitario() {
		return carnetUniversitario;
	}

	public void setCarnetUniversitario(JTextField carnetUniversitario) {
		this.carnetUniversitario = carnetUniversitario;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JLabel getNombre_Universidad() {
		return nombre_Universidad;
	}

	public void setNombre_Universidad(JLabel nombre_Universidad) {
		this.nombre_Universidad = nombre_Universidad;
	}


}
