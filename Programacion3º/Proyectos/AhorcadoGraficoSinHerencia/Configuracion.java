package AhorcadoGraficoSinHerencia;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Configuracion  extends JFrame{

	private String ruta;
	private String nombreDiccionario;
	private String category;
	private boolean acceso;
	
	private JPanel informacion;
	private JPanel enviar_informacion;
	private JTextField directorio;
	private JTextField archivo;
	private JLabel info_categoria;
	private JLabel info_directorio;
	private JLabel info_archivo;
	private JButton enviar;
	
	private JComboBox categoria;
	
	public Configuracion(){
		this.acceso = false;
		this.ruta = ruta;
		this.nombreDiccionario = nombreDiccionario;
		this.category = category;
		
		
		setLayout(new BorderLayout(0,20));
		informacion = new JPanel(new GridLayout(3,2,10,10));
		enviar_informacion = new JPanel( new FlowLayout(1));
	
		directorio = new JTextField(1);
		archivo = new JTextField(1);
		info_categoria = new JLabel("Seleccione la catergoria");
		info_directorio = new JLabel("Ruta de instalacion");
		info_archivo = new JLabel("Nombre del archivo");
		categoria = new JComboBox();
		enviar = new JButton("Enviar");
		
		categoria.addItem("Perifericos");
		categoria.addItem("Programacion");
		categoria.addItem("Hardware");
		
	
		informacion.add(info_categoria);
		informacion.add(categoria);
		informacion.add(info_directorio);
		informacion.add(directorio);
		informacion.add(info_archivo);
		informacion.add(archivo);
		
		enviar_informacion.add(enviar);
		
		add(informacion,BorderLayout.NORTH);
		add(enviar_informacion,BorderLayout.CENTER);
		
		EnviarInformacion send = new EnviarInformacion();
		enviar.addActionListener(send);
		
	}
	
	public String getRuta(){
		return ruta;
	}
	
	public String getnombreDiccionario(){
	
		return nombreDiccionario;
	}
	
	public String getCategory(){
		return category;
	}
	
	public boolean getFalse(){
		return acceso;
	}
	
	
	
	private class EnviarInformacion implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			nombreDiccionario = archivo.getText();
			ruta= directorio.getText()+nombreDiccionario+".txt";
			category = (String)categoria.getSelectedItem();
			acceso = true;
			
		}
		
	}
}
