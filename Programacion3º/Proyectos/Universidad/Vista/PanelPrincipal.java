package Universidad.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.sun.xml.internal.ws.addressing.v200408.ProblemAction;
import sun.tools.jar.resources.jar;

public class PanelPrincipal extends JFrame {
	
	private JPanel botones;
	private JPanel centro;
	
	private JButton ingresar;
	private JButton salir;
	private JButton programar;
	private JButton visualizar;
	
	public PanelPrincipal(){
		
		botones = new JPanel(new GridLayout(4,1));
		centro= new JPanel(new BorderLayout());
		
		//BOTONES CON ESTILO
		ingresar = crearBoton("CONECTAR","conectar");
		salir = crearBoton("DESCONECTAR","salir");
		programar = crearBoton("PROGRAMAR","programar");
		visualizar = crearBoton("VISUALIZAR","lupa");
		
		
		botones.add(ingresar);
		botones.add(salir);
		botones.add(programar);
		botones.add(visualizar);
		
		add(botones,BorderLayout.WEST);
		add(new DibujarImagenes(DibujarImagenes.IMAGEN_UNIVERSIDAD),BorderLayout.CENTER);
		
		//BOTONES BLOQUEADOS HASTA INICIAR SESION
		salir.setEnabled(false);
		programar.setEnabled(false);
		visualizar.setEnabled(false);
		
	}
	
	public void arrancar(){
		setSize(1200,700);
		setTitle("Universidad de 1ºDAW");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    setVisible(true);
	}
	
	public JButton crearBoton(String texto,String nombreImagen){
		JButton boton = new JButton(texto,new ImageIcon("universidad/"+nombreImagen+".png"));
		boton.setVerticalTextPosition(AbstractButton.BOTTOM);
		boton.setHorizontalTextPosition(AbstractButton.CENTER);
		boton.setBackground(Color.black);
		boton.setForeground(Color.white);
		boton.setFocusable(false);//Elimina focus del elemento
		return boton;
	}
	
	//<<<---GETTERS AND SETTERS--->>>
	public JPanel getBotones() {
		return botones;
	}

	public void setBotones(JPanel botones) {
		this.botones = botones;
	}

	public JPanel getCentro() {
		return centro;
	}

	public void setCentro(JPanel centro) {
		this.centro = centro;
	}

	public JButton getIngresar() {
		return ingresar;
	}

	public void setIngresar(JButton ingresar) {
		this.ingresar = ingresar;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JButton getProgramar() {
		return programar;
	}

	public void setProgramar(JButton programar) {
		this.programar = programar;
	}

	public JButton getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(JButton visualizar) {
		this.visualizar = visualizar;
	}

}
