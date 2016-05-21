package Universidad.Vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Universidad.Modelo.Asignaturas;

public class VistaAsignaturas extends JFrame {
	
	private JPanel panel;
	private JCheckBox check;
	private JLabel sigla;
	private JLabel nombre;
	private JLabel curso;
	private JLabel tipo;
	private JComboBox combo;
	
	public VistaAsignaturas(Asignaturas asignatura){
		panel = new JPanel(new GridLayout(1,6));
		
		check = new JCheckBox();
		check.setOpaque(false);
		sigla = new JLabel(asignatura.getSigla());
		nombre = new JLabel(asignatura.getNombre());
		curso = new JLabel(Integer.toString(asignatura.getCurso()),SwingConstants.CENTER);
		tipo = new JLabel(asignatura.getTipo());
		combo = rellenarCombo();
		
		panel.add(check);
		panel.add(sigla);
		panel.add(nombre);
		panel.add(curso);
		panel.add(tipo);
		panel.add(combo);
		
		add(panel);
	}

	public JComboBox rellenarCombo() {
		JComboBox combo = new JComboBox();
		for(int i = 1;i<=6;i++){
			combo.addItem((String)Integer.toString(i));
		}
		return combo;
	}
//<<<---GETTERS AND SETTERS--->>>
	public VistaAsignaturas getVistaAsignaturas(){
		return this;
	}
	
	public JCheckBox getCheck() {
		return check;
	}

	public void setCheck(JCheckBox check) {
		this.check = check;
	}

	public JLabel getSigla() {
		return sigla;
	}

	public void setSigla(JLabel sigla) {
		this.sigla = sigla;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
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

	public JComboBox getCombo() {
		return combo;
	}

	public void setCombo(JComboBox combo) {
		this.combo = combo;
	}
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
