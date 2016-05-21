package Universidad.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Universidad.Modelo.Asignaturas;
import javafx.scene.layout.Border;
import tema12Clases.FlowLayout;

public class Programacion extends JFrame{
	
	private JPanel informacion_Universitario;
	private JPanel asignaturas;
	
	private JPanel universidad;
	private JPanel datos;
	private JPanel nombreColumnas;
	private JPanel ColumnasYAsignatura;
	private JPanel botones;
	private JPanel MateriasYBotones;
	
	private final JLabel JL_UNIVERSIDAD = new JLabel("UNIVERSIDAD 1ºDAW",SwingConstants.CENTER);
	private final JLabel JL_SERVICIOS = new JLabel("Servicio de Matriculacion",SwingConstants.CENTER);
	
	private JLabel jl_cuci;
	private JLabel jl_NombreCompleto;
	private JLabel jl_Fecha;
	private JLabel jl_NumeroMatricula;
	
	private JLabel vacio;
	private JLabel sigla;
	private JLabel nombreMateria;
	private JLabel curso;
	private JLabel tipo;
	private JLabel grupo;
	
	private JButton programar;
	private JButton cancelar;
	
	private ArrayList<Asignaturas> asigna;
	
	public Programacion(ArrayList<Asignaturas> asigna){
		this.asigna = asigna;
		
		informacion_Universitario = new JPanel(new BorderLayout());
		universidad = new JPanel(new GridLayout(2,1,0,5));
		datos = new JPanel(new GridLayout(1,4));
		nombreColumnas = new JPanel(new GridLayout(1,6));
		ColumnasYAsignatura = new JPanel(new BorderLayout());
		MateriasYBotones = new JPanel(new BorderLayout());
		botones = new JPanel(new java.awt.FlowLayout(0, 15, 0));
		
		asignaturas = implementarAsignaturas(asigna);
		
		jl_cuci = new JLabel("C.U.:                 C.I.: ",SwingConstants.LEFT);
		jl_NombreCompleto = new JLabel("Nombre: ",SwingConstants.CENTER);
		jl_Fecha = new JLabel("Fecha: ",SwingConstants.CENTER);
		jl_NumeroMatricula  = new JLabel("IDº Matricula:",SwingConstants.CENTER);
		
		vacio = new JLabel("");
		sigla = new JLabel("SIGLA");
		nombreMateria = new JLabel("NOMBRE DE MATERIA");
		curso = new JLabel("CURSO",SwingConstants.CENTER);
		tipo = new JLabel("TIPO");
		grupo = new JLabel("GRUPO");
		

		
		//Editamos panel universidad
		universidad.setBackground(new Color(0,153,76));
		JL_UNIVERSIDAD.setFont(new Font("SansSerif", Font.BOLD, 20));
		JL_UNIVERSIDAD.setForeground(Color.white);
		JL_SERVICIOS.setForeground(Color.WHITE);
		
		
		//editamos botones
		botones.setBackground(Color.black);
		programar = new JButton("Programar");
		cancelar = new JButton("Cancelar");
		botones.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		//Editamos panel datos con bordes

		datos.setBorder(BorderFactory.createMatteBorder(5, 50, 5,50, new Color(224,224,224)));

		nombreColumnas.setBorder(new LineBorder(Color.black));
		
		//Cambiamos fuentes
		
		cambiarFuenteYTamanio(jl_cuci);
		cambiarFuenteYTamanio(jl_NombreCompleto);
		cambiarFuenteYTamanio(jl_Fecha);
		cambiarFuenteYTamanio(jl_NumeroMatricula);
		
		cambiarEstiloColumnas();
		
		
		//Adicciones
		
		nombreColumnas.add(vacio);
		nombreColumnas.add(sigla);
		nombreColumnas.add(nombreMateria);
		nombreColumnas.add(curso);
		nombreColumnas.add(tipo);
		nombreColumnas.add(grupo);
		universidad.add(JL_UNIVERSIDAD);
		universidad.add(JL_SERVICIOS);
	
		datos.add(jl_cuci);
		datos.add(jl_NombreCompleto);
		datos.add(jl_Fecha);
		datos.add(jl_NumeroMatricula);
		
		botones.add(programar);
		botones.add(cancelar);
		
		informacion_Universitario.add(universidad,BorderLayout.NORTH);
		informacion_Universitario.add(datos,BorderLayout.CENTER);
		
		ColumnasYAsignatura.add(nombreColumnas,BorderLayout.NORTH);
		ColumnasYAsignatura.add(asignaturas,BorderLayout.CENTER);
		
		MateriasYBotones.add(ColumnasYAsignatura,BorderLayout.CENTER);
		MateriasYBotones.add(botones,BorderLayout.SOUTH);
		
		add(informacion_Universitario,BorderLayout.NORTH);
		add(MateriasYBotones,BorderLayout.CENTER);
		
		distintoColorPorFilas();
	}
	
	public void arrancar(){
		pack();
		setTitle("Matricula");
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setVisible(true);
	}
	
	public JPanel implementarAsignaturas(ArrayList<Asignaturas> asign){
		JPanel asignaturas = new JPanel(new GridLayout(asign.size(),1));
		
		for(int i = 0;i<asign.size();i++){	
			asignaturas.add(new VistaAsignaturas(asign.get(i)).getPanel());
		}
		return asignaturas;
	}
	
	public JLabel cambiarFuenteYTamanio(JLabel label){
		label.setFont(new Font("SansSerif",Font.PLAIN,17));
		return label;
	}
	
	public void cambiarEstiloColumnas(){
		
		nombreColumnas.setBackground(Color.gray);
		sigla.setFont(new Font("SansSerif",Font.BOLD,15));nombreMateria.setFont(new Font("SansSerif",Font.BOLD,15));tipo.setFont(new Font("SansSerif",Font.BOLD,15));
		curso.setFont(new Font("SansSerif",Font.BOLD,15));grupo.setFont(new Font("SansSerif",Font.BOLD,15));
		
	}
	
	public void distintoColorPorFilas(){
		
		for(int i = 0;i<asignaturas.getComponentCount();i++){
			if(i%2==0)
				asignaturas.getComponent(i).setBackground(Color.lightGray);
		}
		
	}
	
//<<<---GETTERS AND SETTERS--->>>
	public JPanel getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(JPanel nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public JPanel getColumnasYAsignatura() {
		return ColumnasYAsignatura;
	}

	public void setColumnasYAsignatura(JPanel columnasYAsignatura) {
		ColumnasYAsignatura = columnasYAsignatura;
	}

	public JPanel getBotones() {
		return botones;
	}

	public void setBotones(JPanel botones) {
		this.botones = botones;
	}

	public JPanel getMateriasYBotones() {
		return MateriasYBotones;
	}

	public void setMateriasYBotones(JPanel materiasYBotones) {
		MateriasYBotones = materiasYBotones;
	}

	public JLabel getVacio() {
		return vacio;
	}

	public void setVacio(JLabel vacio) {
		this.vacio = vacio;
	}

	public JLabel getSigla() {
		return sigla;
	}

	public void setSigla(JLabel sigla) {
		this.sigla = sigla;
	}

	public JLabel getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(JLabel nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public JLabel getCurso() {
		return curso;
	}

	public void setCurso(JLabel curso) {
		this.curso = curso;
	}

	public JLabel getTipo() {
		return tipo;
	}

	public void setTipo(JLabel tipo) {
		this.tipo = tipo;
	}

	public JLabel getGrupo() {
		return grupo;
	}

	public void setGrupo(JLabel grupo) {
		this.grupo = grupo;
	}

	public JButton getProgramar() {
		return programar;
	}

	public void setProgramar(JButton programar) {
		this.programar = programar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JLabel getJL_UNIVERSIDAD() {
		return JL_UNIVERSIDAD;
	}

	public JLabel getJL_SERVICIOS() {
		return JL_SERVICIOS;
	}
	public JPanel getInformacion_Universitario() {
		return informacion_Universitario;
	}

	public void setInformacion_Universitario(JPanel informacion_Universitario) {
		this.informacion_Universitario = informacion_Universitario;
	}

	public JPanel getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(JPanel asignaturas) {
		this.asignaturas = asignaturas;
	}

	public JPanel getUniversidad() {
		return universidad;
	}

	public void setUniversidad(JPanel universidad) {
		this.universidad = universidad;
	}

	public JPanel getDatos() {
		return datos;
	}

	public void setDatos(JPanel datos) {
		this.datos = datos;
	}

	public JLabel getJl_cuci() {
		return jl_cuci;
	}

	public void setJl_cuci(JLabel jl_cuci) {
		this.jl_cuci = jl_cuci;
	}

	public JLabel getJl_NombreCompleto() {
		return jl_NombreCompleto;
	}

	public void setJl_NombreCompleto(JLabel jl_NombreCompleto) {
		this.jl_NombreCompleto = jl_NombreCompleto;
	}

	public JLabel getJl_Fecha() {
		return jl_Fecha;
	}

	public void setJl_Fecha(JLabel jl_Fecha) {
		this.jl_Fecha = jl_Fecha;
	}

	public JLabel getJl_NumeroMatricula() {
		return jl_NumeroMatricula;
	}

	public void setJl_NumeroMatricula(JLabel jl_NumeroMatricula) {
		this.jl_NumeroMatricula = jl_NumeroMatricula;
	}

	public ArrayList<Asignaturas> getAsigna() {
		return asigna;
	}

	public void setAsigna(ArrayList<Asignaturas> asigna) {
		this.asigna = asigna;
	}

	
}
