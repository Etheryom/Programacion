package AhorcadoGraficoSinHerencia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface extends JFrame {
	private static ControladorAhorcado controlador = null;
	private static Ahorcado ahorcado = null;
	private String mask;
	private String letrasIntroducidas;
	private int fallos;
	
	private JLabel fallos_Letras;
	private JLabel mascara_mascara;
	
	private JPanel teclado;
	
	
	public Interface(String mask,int fallos,String letrasIntroducidas){
		
		//Defino Propiedades
		this.mask= mask;
		this.fallos = fallos;
		this.letrasIntroducidas = letrasIntroducidas;
		
		fallos_Letras = new JLabel("Letras Introducidas: "+letrasIntroducidas+"   Fallos "+fallos+"/7");
		mascara_mascara = new JLabel(mask);
		
		
		//Defino el frame como un BorderLayout
		setLayout(new BorderLayout());
		
		//Crecion de Paneles -- NOTA: Informacion contiene a errores y mascara
		JPanel informacion = new JPanel(new GridLayout(2, 1));
		JPanel errores = new JPanel(new FlowLayout(1));
		JPanel mascara = new JPanel(new FlowLayout(1));
		JPanel ahr = new JPanel(new BorderLayout());
		teclado=crearLetras();
		
		//Creacion de Labels y adiccion a los paneles correspondiente
		errores.add(fallos_Letras);
		mascara.add(mascara_mascara);
		informacion.add(errores);
		informacion.add(mascara);
		
		//Cambio de fuentes y colores
		fallos_Letras.setFont(new Font("SansSerif ", Font.BOLD, 16));
		mascara_mascara.setFont(new Font("SansSerif ", Font.BOLD, 30));
		fallos_Letras.setForeground(Color.WHITE);
		
		//cambio de color de fondos
		errores.setBackground(Color.BLACK);
		mascara.setBackground(new Color(40,183,183));
		getContentPane().setBackground(new Color(192,192,192));
		
		//Adiccion al Frame
		add(informacion,BorderLayout.NORTH);
		ahr.add(new AhorcadoGrafico(7),BorderLayout.CENTER);
		add(ahr);
		add(teclado,BorderLayout.SOUTH);
		
		//Adiccion eventos
		for(int i =0;i<27;i++){
		TecladoListener ok = new TecladoListener();
		JButton ok1 = (JButton) teclado.getComponent(i);
		ok1.addActionListener(ok);
		}

	}
	public JPanel crearLetras(){
		JPanel teclado = new JPanel(new GridLayout(3,10,0,0));

		for(char i='A';i<='Z';i++){
			teclado.add(new JButton(new ImageIcon("images/teclado/"+i+".jpg")));
				
		}
		teclado.add(new JButton(new ImageIcon("images/teclado/Ñ.jpg")));
		//teclado.add(teclado.getComponent(0)).setBackground(new Color(74,74,74));;

		return teclado;
	}
	
	private class TecladoListener implements ActionListener{
		
		public TecladoListener(){
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//Obtengo el objeto que ha provocado el evento
			Object myObject = e.getSource();
			String letter;
			
			//Dependiendo del objeto que lo llamara realizara una opcion
		for(int i = 0;i<27;i++){
			
			if(myObject == teclado.getComponent(i)){
				char letra = 'A';
				letra+=i;
				
				if(i==26)
					 letter = Character.toString('Ñ');
				else
					 letter = Character.toString(letra);
				System.out.println(letter);
				
				if(controlador.checkLetter(letter)){
					teclado.getComponent(i).setBackground(Color.GREEN);
					teclado.getComponent(i).setEnabled(false);
				}
				else{
					teclado.getComponent(i).setBackground(Color.RED);
					teclado.getComponent(i).setEnabled(false);
				}
				
				letra = 'A';
			}
			
		}
			
			
		}
		
	}
public static void main(String[] args) throws FileNotFoundException{
		
		
		String ruta;
		String nombreDiccionario;
		String categoria;
		boolean acceso = true;

		
		do{
			acceso=true;
			ruta = JOptionPane.showInputDialog(null,"Seleccione la ruta donde quiere instalar el juego");
			nombreDiccionario = JOptionPane.showInputDialog(null,"Seleccione el nombre que quieres darle al archivo que se creará");
			nombreDiccionario+=".txt";
			ruta+=nombreDiccionario;
			categoria = JOptionPane.showInputDialog(null,"Seleccione la categoria que quieras:\n-Perifericos.\n-Hardware.\n-Programacion.");
			
			try {
			
			ahorcado = new Ahorcado(new Diccionario(ruta,categoria));
			controlador = new ControladorAhorcado(ahorcado);
				
		} catch (IOException ex) {
			acceso=false;
			System.out.println("Disculpe, pero la ruta de instalacion insertada no es correcta");
			
		}
		catch (IndexOutOfBoundsException ex) {
				acceso=false;
				System.out.println("La categoria seleccionada no existe.");
				
			}
			
		}while(!acceso);
		
		
		Interface pantalla = new Interface(controlador.getAhorcado().getWord().toUpperCase(),controlador.getErrores(),controlador.getLetterIntroduced());
	    pantalla.setTitle("TestPaintComponent");
	    pantalla.setSize(400, 800);
	    pantalla.setLocationRelativeTo(null); // Center the frame   
	    pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pantalla.setVisible(true);
	}

}