package AhorcadoGraficoSinHerencia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends JFrame {
	
	private String mask;
	private String letrasIntroducidas;
	private int fallos;
	
	private JLabel fallos_Letras;
	private JLabel mascara_mascara;
	
	
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
		JPanel teclado=crearLetras();
		
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

	}
	public JPanel crearLetras(){
		JPanel teclado = new JPanel(new GridLayout(3,10,0,0));

		for(char i='A';i<='Z';i++){
			teclado.add(new JButton(new ImageIcon("images/teclado/"+i+".jpg")));
			if(i=='N'){
			teclado.add(new JButton(new ImageIcon("images/teclado/Ñ.jpg")));
			}
				
		}

		return teclado;
	}

}