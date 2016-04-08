package tema12Clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CheckAndRadius extends JFrame {
	
	public CheckAndRadius(){
		
		//<<<CHECK CON ICONOS>>>>
		
		JPanel checkConIconos = new JPanel(new GridLayout(1,4,0,1));
		
		//Aplicamos borde y titulo
		checkConIconos.setBorder(new LineBorder(Color.gray,2));
		checkConIconos.setBorder(new TitledBorder("What countries do you like?"));
		
		//creamos los checks con iconos
		JCheckBox españa = new JCheckBox("España",new ImageIcon("images/icoespaña.png"),false);
		JCheckBox francia = new JCheckBox("Francia",new ImageIcon("images/icofrancia.gif"),false);
		JCheckBox canada = new JCheckBox("Canada",new ImageIcon("images/icocanada.png"),false);
		JCheckBox eeuu = new JCheckBox("EEUU",new ImageIcon("images/icoeeuu.gif"),false);
		
		
		//añadimos los checks
		checkConIconos.add(españa);
		checkConIconos.add(francia);
		checkConIconos.add(canada);
		checkConIconos.add(eeuu);
		
		
		
		//<<<CHECK SIN ICONOS>>>>
		
		JPanel checkSinIconos = new JPanel(new GridLayout(1,4,0,1));
		
		//Aplicamos borde y titulo
		checkSinIconos.setBorder(new LineBorder(Color.gray,2));
		checkSinIconos.setBorder(new TitledBorder("What countries do you like?"));
		
		//creamos los checks con iconos
		JCheckBox España = new JCheckBox("España",false);
		JCheckBox Francia = new JCheckBox("Francia",false);
		JCheckBox Canada = new JCheckBox("Canada",false);
		JCheckBox EEUU = new JCheckBox("EEUU",false);
		
		//añadimos los checks
		checkSinIconos.add(España);
		checkSinIconos.add(Francia);
		checkSinIconos.add(Canada);
		checkSinIconos.add(EEUU);
		
		
		
		//<<<RADIUS BUTTON CON ICONO>>>>
		JPanel radius = new JPanel(new GridLayout(1,4,0,1));
		
		//Aplicamos borde y titulo
		radius.setBorder(new LineBorder(Color.gray,2));
		radius.setBorder(new TitledBorder("Select a Country"));
		
		//Creamos los radio button
		JRadioButton esp = new JRadioButton("España",new ImageIcon("images/icoespaña.png"),false);
		JRadioButton fr = new JRadioButton("Francia",new ImageIcon("images/icofrancia.gif"),false);
		JRadioButton ca = new JRadioButton("Canada",new ImageIcon("images/icocanada.png"),false);
		JRadioButton eu = new JRadioButton("EEUU",new ImageIcon("images/icoeeuu.gif"),false);
		
		//Añadimos los buttons al group
		ButtonGroup grupoConIcono = new ButtonGroup();
		grupoConIcono.add(esp);
		grupoConIcono.add(fr);
		grupoConIcono.add(ca);
		grupoConIcono.add(eu);
		
		//añadimos los radio buttons
		radius.add(esp);
		radius.add(fr);
		radius.add(ca);
		radius.add(eu);
		
		
		
		//<<<RADIUS BUTTON SIN  ICONO>>>>
		JPanel radiusSinIcono = new JPanel(new GridLayout(1,4,0,1));
		
		//Aplicamos borde y titulo
		radiusSinIcono.setBorder(new LineBorder(Color.gray,2));
		radiusSinIcono.setBorder(new TitledBorder("Select a Country"));
		
		//Creamos los radio button
		JRadioButton ESP = new JRadioButton("España",false);
		JRadioButton FR = new JRadioButton("Francia",false);
		JRadioButton CA = new JRadioButton("Canada",false);
		JRadioButton EU = new JRadioButton("EEUU",false);
		
		//añadimos los radio buttons
		radiusSinIcono.add(ESP);
		radiusSinIcono.add(FR);
		radiusSinIcono.add(CA);
		radiusSinIcono.add(EU);
		
		//Añadimos los buttons al group
		ButtonGroup grupoSinIcono = new ButtonGroup();
		grupoSinIcono.add(ESP);
		grupoSinIcono.add(FR);
		grupoSinIcono.add(CA);
		grupoSinIcono.add(EU);
		
		
	
		
		//<<<AÑADIMOS LOS JPANELS AL JFRAME>>>>
		setLayout(new GridLayout(4,1,0,1));
		add(checkConIconos);
		add(checkSinIconos);
		add(radius);
		add(radiusSinIcono);
		
	}
	

}
