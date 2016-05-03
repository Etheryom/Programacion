package TemaDBClases.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.sun.awt.AWTUtilities;

public class VistaConsulta extends JFrame {
	
	private JPanel arriba;
	private JPanel nombres;
	private JPanel nombreYApellidos;
	private JPanel comboYLabel;
	private JComboBox departments;
	private JLabel info;
	private JLabel nombre;
	private JLabel apellidos;
	private ArrayList <String> departamentos;
	
	public VistaConsulta(ArrayList <String> departamentos){
		
		arriba = new JPanel(new GridLayout(2,1));
		nombres = new JPanel(new GridLayout(1,2));
		nombreYApellidos = new JPanel(new GridLayout(1,2));
		comboYLabel = new JPanel(new GridLayout(1,2));
		
		info = new JLabel("Departamento",SwingConstants.CENTER);
		departments = new JComboBox();
		
		this.departamentos = departamentos;
		departments = rellanarCombo();
		
		nombre = new JLabel("NOMBRE",SwingConstants.CENTER);
		apellidos = new JLabel("APELLIDOS",SwingConstants.CENTER);
		
		
		nombres.setBackground(new Color(255,255,153));
		nombres.setBorder(new LineBorder(Color.BLACK));
		nombreYApellidos.setBorder(new LineBorder(Color.BLACK));
		
		nombreYApellidos.setBackground(new Color(153,255,255));
		
		comboYLabel.add(info);
		comboYLabel.add(departments);
		nombreYApellidos.add(nombre);
		nombreYApellidos.add(apellidos);
		
		arriba.add(comboYLabel);
		arriba.add(nombreYApellidos);
		
		add(arriba,BorderLayout.NORTH);
		add(nombres,BorderLayout.CENTER);
			
	}
	
	public JComboBox rellanarCombo(){
		departments = new JComboBox();
		
		for(int i = 0;i<departamentos.size();i++){
			departments.addItem(departamentos.get(i));
		}
		return departments;
	}
	
	public void arrancar(){

		pack();
		setTitle("Departamentos");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
	
//<<------GETTERS AND SETTERS--------->>
	public JPanel getArriba() {
		return arriba;
	}

	public void setArriba(JPanel arriba) {
		this.arriba = arriba;
	}

	public JPanel getNombres() {
		return nombres;
	}

	public void setNombres(JPanel nombres) {
		this.nombres = nombres;
	}

	public JPanel getNombreYApellidos() {
		return nombreYApellidos;
	}

	public void setNombreYApellidos(JPanel nombreYApellidos) {
		this.nombreYApellidos = nombreYApellidos;
	}

	public JPanel getComboYLabel() {
		return comboYLabel;
	}

	public void setComboYLabel(JPanel comboYLabel) {
		this.comboYLabel = comboYLabel;
	}

	public JComboBox getDepartments() {
		return departments;
	}

	public void setDepartments(JComboBox departments) {
		this.departments = departments;
	}

	public JLabel getInfo() {
		return info;
	}

	public void setInfo(JLabel info) {
		this.info = info;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getApellidos() {
		return apellidos;
	}

	public void setApellidos(JLabel apellidos) {
		this.apellidos = apellidos;
	}

	public ArrayList<String> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList<String> departamentos) {
		this.departamentos = departamentos;
	}
	
	
}
