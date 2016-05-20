package Universidad.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Universidad.Modelo.Asignaturas;

public class Programacion extends JFrame{
	
	private JPanel informacion_Universitario;
	private JPanel asignaturas;
	
	private JPanel universidad;
	private JPanel datos;
	
	private final JLabel JL_UNIVERSIDAD = new JLabel("UNIVERSIDAD 1ºDAW",SwingConstants.CENTER);
	private final JLabel JL_SERVICIOS = new JLabel("Servicio de Matriculacion",SwingConstants.CENTER);
	
	private JLabel jl_cuci;
	private JLabel jl_NombreCompleto;
	private JLabel jl_Fecha;
	private JLabel jl_NumeroMatricula;
	
	private ArrayList<Asignaturas> asigna;
	
	public Programacion(ArrayList<Asignaturas> asigna){
		this.asigna = asigna;
		
		informacion_Universitario = new JPanel(new BorderLayout());
		universidad = new JPanel(new GridLayout(2,1,0,5));
		datos = new JPanel(new GridLayout(6,1,0,5));
		asignaturas = implementarAsignaturas(asigna);
		
		jl_cuci = new JLabel("C.U.:              C.I.: ");
		jl_NombreCompleto = new JLabel("Nombre: ");
		jl_Fecha = new JLabel("Fecha: ");
		jl_NumeroMatricula  = new JLabel("IDº Matricula:");
		

		
		//Editamos panel universidad
		universidad.setBackground(new Color(0,153,76));
		JL_UNIVERSIDAD.setFont(new Font("SansSerif", Font.BOLD, 20));
		JL_UNIVERSIDAD.setForeground(Color.white);
		JL_SERVICIOS.setForeground(Color.WHITE);
		
		//Editamos panel datos con bordes

		datos.setBorder(BorderFactory.createMatteBorder(5, 50, 5,50, new Color(224,224,224)));
		jl_cuci.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
		jl_NombreCompleto.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
		jl_Fecha.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
		jl_NumeroMatricula.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));

		
		//Adicciones
		universidad.add(JL_UNIVERSIDAD);
		universidad.add(JL_SERVICIOS);
		datos.add(new JLabel(""));
		datos.add(jl_cuci);
		datos.add(jl_NombreCompleto);
		datos.add(jl_Fecha);
		datos.add(jl_NumeroMatricula);
		datos.add(new JLabel(""));
		
		informacion_Universitario.add(universidad,BorderLayout.NORTH);
		informacion_Universitario.add(datos,BorderLayout.CENTER);
		
		add(informacion_Universitario,BorderLayout.NORTH);
		add(asignaturas,BorderLayout.CENTER);
	}
	
	public void arrancar(){
		setSize(550,520);
		setTitle("Login Universidad");
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
	
}
