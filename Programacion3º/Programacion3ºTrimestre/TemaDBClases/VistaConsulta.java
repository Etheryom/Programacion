package TemaDBClases;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaConsulta extends JFrame {
	
	private JPanel botones;
	private JPanel nombres;
	private JComboBox departaments;
	private JButton consultar;
	private ArrayList <String> departamentos;
	
	public VistaConsulta(ArrayList <String> departamentos){
		
		botones = new JPanel(new GridLayout(1,2));
		nombres = new JPanel(new GridLayout(3,2));
		
		consultar = new JButton("Consultar");
		departaments = new JComboBox();
		
		this.departamentos = departamentos;

		departaments = rellanarCombo();
	}
	
	public JComboBox rellanarCombo(){
		departaments = new JComboBox();
		
		for(int i = 0;i<departamentos.size();i++){
			departaments.add(new JLabel(departamentos.get(i)));
		}
		return departaments;
	}
	
	
	

}
