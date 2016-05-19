package AhorcadoConTimer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Interface extends JFrame {
	private static ControladorAhorcado controlador = null;
	private static Ahorcado ahorcado = null;
	private static Diccionario diccionario =null;
	private String mask;
	private String letrasIntroducidas;
	private int fallos;
	private static Interface pantalla;
	
	private JLabel fallos_label;
	private JLabel letras_label;
	private JLabel mascara_mascara;
	
	private JButton comprobar;
	private JButton reiniciar;
	private JTextField cajon;
	
	private JPanel teclado;
	private JPanel intentar;
	private JPanel ahr;
	
	private Timer timer;
	private Timer timer2;
	GanarPerder gp;
	
	public Interface(){
		
		//Defino Propiedades
		this.mask= ahorcado.getMaskWord().toUpperCase();
		this.fallos = controlador.getErrores();
		this.letrasIntroducidas = controlador.getLetterIntroduced();
		
		fallos_label = new JLabel("Fallos: "+fallos+"/7",SwingConstants.CENTER);
		letras_label = new JLabel("  Introducidas: "+letrasIntroducidas);
		mascara_mascara = new JLabel(mask);
		
		
		//Defino el frame como un BorderLayout
		setLayout(new BorderLayout());
		
		//Crecion de Paneles -- NOTA: Consultas contiene a errores y mascara
		JPanel informacion = new JPanel(new GridLayout(2, 1));
		JPanel errores = new JPanel(new GridLayout(2, 1));
		JPanel mascara = new JPanel(new FlowLayout(1));
		intentar = new JPanel(new GridLayout(1, 2));
		ahr = new JPanel(new BorderLayout());
		teclado=crearLetras();
		
		//Defino los elementos que comprobaran la palabra insertado por el usuario
		cajon=new JTextField(1);
		comprobar = new JButton("Comprobar");
		
		//instancio boton de reiniciar, pero no lo añado
		reiniciar = new JButton("REINICIAR");
		
		
		//Creacion de Labels y adiccion a los paneles correspondiente
		errores.add(fallos_label);
		errores.add(letras_label);
		mascara.add(mascara_mascara);
		informacion.add(errores);
		informacion.add(mascara);
		intentar.add(cajon);
		intentar.add(comprobar);
		
		//Cambio de fuentes y colores
		fallos_label.setFont(new Font("SansSerif ", Font.BOLD, 16));
		letras_label.setFont(new Font("SansSerif ", Font.BOLD, 12));
		mascara_mascara.setFont(new Font("SansSerif ", Font.BOLD, 30));
		fallos_label.setForeground(Color.RED);
		letras_label.setForeground(Color.WHITE);
		reiniciar.setFont(new Font("SansSerif ", Font.BOLD, 24));
		reiniciar.setForeground(Color.RED);
		
		//cambio de color de fondos
		errores.setBackground(Color.BLACK);
		mascara.setBackground(new Color(40,183,183));
		getContentPane().setBackground(new Color(192,192,192));
		
		//Adiccion al Frame
		add(informacion,BorderLayout.NORTH);
		ahr.add(new AhorcadoGrafico(fallos),BorderLayout.CENTER);
		ahr.add(intentar,BorderLayout.SOUTH);
		add(ahr);
		add(teclado,BorderLayout.SOUTH);
		
		//Adiccion eventos del teclado grafico a todas las teclas
		for(int i =0;i<27;i++){
		TecladoListener tecladoGrafico = new TecladoListener();
		JButton ok1 = (JButton) teclado.getComponent(i);
		ok1.addActionListener(tecladoGrafico);
		}
		
		//Timer. El boton comprobar esta asociado con este mismo.
		timer = new Timer(1000, new GanarPerder());
		gp = new GanarPerder();
		comprobar.addActionListener(gp);
		
		//Configuracion del eventos del boton reiniciar
		Reiniciar reload = new Reiniciar(pantalla,diccionario);
		reiniciar.addActionListener(reload);
		
		//Timer.todo click en el frame.
		Check check = new Check();
		timer2 = new Timer(1000,check);
		addMouseListener(check);
		
		//Mensaje de buena suerte
		JOptionPane.showMessageDialog(null, "Buena suerte!!");
		}

	
	
	//Creo el teclado graficos
	public JPanel crearLetras(){
		JPanel teclado = new JPanel(new GridLayout(3,10,0,0));

		for(char i='A';i<='Z';i++){
			teclado.add(new JButton(new ImageIcon("images/teclado/"+i+".jpg")));
				
		}
		teclado.add(new JButton(new ImageIcon("images/teclado/NN.jpg")));
		
		return teclado;
	}
	
	public void bloquearTeclado(boolean bloquear){
		
		if(bloquear){
			
			for(int i = 0;i<teclado.getComponentCount();i++){
				teclado.getComponent(i).setEnabled(false);
			}
			
		}
		else{
			
			for(int i = 0;i<teclado.getComponentCount();i++){
				teclado.getComponent(i).setEnabled(true);
			}
			
		}
	}
	
	public static void arrancar(){
		pantalla = new Interface();
	    pantalla.setTitle("Juego del Ahorcado");
	    pantalla.setSize(400, 700);
	    pantalla.setLocationRelativeTo(null); // Center the frame   
	    pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pantalla.setVisible(true);	
	}
	

	
	//<<<<<<<<<<<<<<<<<<----CLASES INTERNAS ----->>>>>>>>>>>>>>>>>>>>>
	
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
						 letter = Character.toString('�');
					else
						 letter = Character.toString(letra);
					
					
					
					if(controlador.checkLetter(letter)){
						//cambio color a verde por acertar y bloqueo la tecla
						teclado.getComponent(i).setBackground(Color.GREEN);
						teclado.getComponent(i).setEnabled(false);
						
						//Actualizo mascara, cargo la mascara y modifico el JLabel
						controlador.actualizarMascara(letter);
						mask=ahorcado.getMaskWord();
						mascara_mascara.setText(mask);
						
						//--COMPRUEBO SI HE GANADO CON CADA LETRA INTRODUCIDA VALIDA--
						if(controlador.ganar()){
							//BLOQUEO TECLADO
							bloquearTeclado(true);
							
						}
					}
					else{
						//cambio color a rojo por fallar y bloqueo la tecla
						teclado.getComponent(i).setBackground(Color.RED);
						teclado.getComponent(i).setEnabled(false);
						
						//Actualizo fallos y modifico el JLabel de fallos
						fallos=controlador.getErrores();
						fallos_label.setText("Fallos: "+fallos+"/7");
						
						//Actualizamos el muñeco del ahorcado, removiendo el anterior y poniendo el nuevo
						ahr.removeAll();
						ahr.add(new AhorcadoGrafico(fallos),BorderLayout.CENTER);
						ahr.add(intentar,BorderLayout.SOUTH);
						
						
						//--COMPRUEBO SI HE PERDIDO AL INSERTAR UNA LETRA INCORRECTA--
						if(fallos==7){
							
							//BLOQUEO TECLADO
							bloquearTeclado(true);
												
							//Desbloqueo la mascara
							mask=ahorcado.getWord();
							mascara_mascara.setText(mask);
							
						}
						
					}
					
					letra = 'A';
				}
			}
			//Añado la letra al conjunto de letras usadas
			letrasIntroducidas = controlador.getLetterIntroduced();
			letras_label.setText("  Introducidas: "+letrasIntroducidas);
		}
	}
	
	private class Reiniciar implements ActionListener{
		
		public Reiniciar(Interface pantalla,Diccionario diccionario){
			
		}

		public void actionPerformed(ActionEvent e) {
			
			
			//vuelvo a pintar el ahorcado con 0 erroes
			controlador.setErrores(0);
			fallos=controlador.getErrores();
			fallos_label.setText("Fallos: "+fallos+"/7");
			
			//Letras usadas borradas
			controlador.setLetterIntroduced("");
			letrasIntroducidas = controlador.getLetterIntroduced();
			letras_label.setText("  Introducidas: "+letrasIntroducidas);
			
			try {
				ahorcado.setWord(diccionario.generarPalabra());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			ahorcado.setMaskWord(ahorcado.createMaskWord());
			mask=ahorcado.getMaskWord().toUpperCase();
			
			
			//Elimino la pantalla anterior
			pantalla.dispose();
			
			//Arranco la nueva
			pantalla.arrancar();
			
			//paro el timer
			timer.stop();
			timer2.stop();
			
		}
		
	}
	
	public class GanarPerder implements ActionListener{
		boolean incremento= true;
		int i = 1;
		
		
		public void actionPerformed(ActionEvent e) {
		
			String introducido = cajon.getText();
			
			if(!controlador.equals(introducido)){
				timer.start();
				if(incremento){
					if(i==1){
						ahr.removeAll();
						ahr.add(new AhorcadoGrafico(8),BorderLayout.CENTER);
						ahr.add(reiniciar,BorderLayout.SOUTH);
					}
					if(i==2){
						ahr.removeAll();
						ahr.add(new AhorcadoGrafico(6),BorderLayout.CENTER);
						ahr.add(reiniciar,BorderLayout.SOUTH);
						
					}
					if(i==3){
						ahr.removeAll();
						ahr.add(new AhorcadoGrafico(7),BorderLayout.CENTER);
						ahr.add(reiniciar,BorderLayout.SOUTH);
						incremento = false;
					}
					i++;
					
					if(!incremento){
						i=3;
					}
				}
				
				if(!incremento){
					if(i==1){
						ahr.removeAll();
						ahr.add(new AhorcadoGrafico(8),BorderLayout.CENTER);
						ahr.add(reiniciar,BorderLayout.SOUTH);
						incremento = true;
					}
					if(i==2){
						ahr.removeAll();
						ahr.add(new AhorcadoGrafico(6),BorderLayout.CENTER);
						ahr.add(reiniciar,BorderLayout.SOUTH);
						
					}
					if(i==3){
						ahr.removeAll();
						ahr.add(new AhorcadoGrafico(7),BorderLayout.CENTER);
						ahr.add(reiniciar,BorderLayout.SOUTH);
						incremento = false;
					}
					i--;
					if(incremento){
						i=2;
					}
				}
			}
			
			else{
				timer.start();
				
				if(i%2==0){
					ahr.removeAll();
					ahr.add(new AhorcadoGrafico(9),BorderLayout.CENTER);
					ahr.add(reiniciar,BorderLayout.SOUTH);
					
				}
				if(i%2==1){
					ahr.removeAll();
					ahr.add(new AhorcadoGrafico(10),BorderLayout.CENTER);
					ahr.add(reiniciar,BorderLayout.SOUTH);
				}
				i++;
			}
			pantalla.paintAll(pantalla.getGraphics());
			
			//Bloqueo todas las teclas
			bloquearTeclado(true);
			
			//Desbloqueo la mascara tanto si gana como si pierde
			mask=ahorcado.getWord();
			mascara_mascara.setText(mask);
		}

	}
	private class Check extends MouseAdapter implements ActionListener{
		boolean incremento= true;
		int i = 1;

		public void mouseEntered(MouseEvent e) {
			timer2.start();		
		}

		public void actionPerformed(ActionEvent e) {

			if(controlador.getErrores()==7){
					if(incremento){
						if(i==1){
							ahr.removeAll();
							ahr.add(new AhorcadoGrafico(8),BorderLayout.CENTER);
							ahr.add(reiniciar,BorderLayout.SOUTH);
						}
						if(i==2){
							ahr.removeAll();
							ahr.add(new AhorcadoGrafico(6),BorderLayout.CENTER);
							ahr.add(reiniciar,BorderLayout.SOUTH);
							
						}
						if(i==3){
							ahr.removeAll();
							ahr.add(new AhorcadoGrafico(7),BorderLayout.CENTER);
							ahr.add(reiniciar,BorderLayout.SOUTH);
							incremento = false;
						}
						i++;
						
						if(!incremento){
							i=3;
						}
					}
					
					if(!incremento){
						if(i==1){
							ahr.removeAll();
							ahr.add(new AhorcadoGrafico(8),BorderLayout.CENTER);
							ahr.add(reiniciar,BorderLayout.SOUTH);
							incremento = true;
						}
						if(i==2){
							ahr.removeAll();
							ahr.add(new AhorcadoGrafico(6),BorderLayout.CENTER);
							ahr.add(reiniciar,BorderLayout.SOUTH);
							
						}
						if(i==3){
							ahr.removeAll();
							ahr.add(new AhorcadoGrafico(7),BorderLayout.CENTER);
							ahr.add(reiniciar,BorderLayout.SOUTH);
							incremento = false;
						}
						i--;
						if(incremento){
							i=2;
						}
					}
					pantalla.paintAll(pantalla.getGraphics());
					
					//Bloqueo todas las teclas
					bloquearTeclado(true);
					
					//Desbloqueo la mascara tanto si gana como si pierde
					mask=ahorcado.getWord();
					mascara_mascara.setText(mask+" ");
				}
			
			if(controlador.ganar()){
				if(i%2==0){
					ahr.removeAll();
					ahr.add(new AhorcadoGrafico(9),BorderLayout.CENTER);
					ahr.add(reiniciar,BorderLayout.SOUTH);
					
				}
				if(i%2==1){
					ahr.removeAll();
					ahr.add(new AhorcadoGrafico(10),BorderLayout.CENTER);
					ahr.add(reiniciar,BorderLayout.SOUTH);
				}
				pantalla.paintAll(pantalla.getGraphics());
				
				//Bloqueo todas las teclas
				bloquearTeclado(true);
				
				//Desbloqueo la mascara tanto si gana como si pierde
				mask=ahorcado.getWord();
				mascara_mascara.setText(mask);
				i++;
			}
		}
		
	}
	
	//<<<<<<<<<<<<<<<<<<----AQUI COMIENZA EL MAIN ----->>>>>>>>>>>>>>>>>>>>>
	
	public static void main(String[] args) throws IOException{
		
		String ruta="";
		String nombreDiccionario;
		String categoria="";
		boolean acceso = false;
		
		ahorcado = new Ahorcado();
		
		Configuracion c = new Configuracion();
	    c.setTitle("Configuracion Ahorcado");
	    c.pack();
	    c.setLocationRelativeTo(null); // Center the frame   
	    c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    c.setVisible(true);
	    

	    
	    while(!acceso){
	    ruta= c.getRuta();
		nombreDiccionario = c.getnombreDiccionario();
		categoria = c.getCategory();
		acceso= c.getAcceso();
		System.out.print("");
	    }
	    
	 
	    c.dispose();
	   
	    
	    diccionario = new Diccionario(ruta,categoria);
	    ahorcado = new Ahorcado(diccionario);
	    controlador = new ControladorAhorcado(ahorcado);
		
	    
	    pantalla.arrancar();
	   
	}


}
