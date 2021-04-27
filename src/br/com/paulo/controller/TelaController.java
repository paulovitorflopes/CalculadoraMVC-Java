package br.com.paulo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaController implements ActionListener {

	private JTextField tfCalc;
	private JButton btPress;
	public static char op;
	
	public TelaController(JTextField obj){
		this.tfCalc = obj;
	}

	public TelaController(JButton b, JTextField obj) {
		this.tfCalc = obj;
		this.btPress = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btPress && btPress.getText().equals("Ce")) {
			String a = tfCalc.getText();
			tfCalc.setText(a.substring(0, tfCalc.getText().length() - 1));
		} else if (e.getSource() == btPress
				&& btPress.getText().equals("BackSpace")) {
			tfCalc.setText("");
		} else if (e.getSource() == btPress && btPress.getText().equals("=")) {
			try {
				calcula();
			} catch (ExceptionController e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage() , "Informamos", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == btPress && btPress.getText().equals("+")) {
			tfCalc.setText(tfCalc.getText() + "+");
			op = '+';
		} else if (e.getSource() == btPress && btPress.getText().equals("-")) {
			tfCalc.setText(tfCalc.getText() + "-");
			op = '-';
		} else if (e.getSource() == btPress && btPress.getText().equals("/")) {
			tfCalc.setText(tfCalc.getText() + "/");
			op = '/';
		} else if (e.getSource() == btPress && btPress.getText().equals("*")) {
			tfCalc.setText(tfCalc.getText() + "*");
			op = '*';
		} else if (e.getSource() == btPress) {
			tfCalc.setText(tfCalc.getText() + btPress.getActionCommand());
		}

	}

	public void calcula() throws ExceptionController {
		if(op == '-'){
			String[] valores = tfCalc.getText().split("\\-");
			tfCalc.setText(String.valueOf(Double.parseDouble(valores[0])
					- Double.parseDouble(valores[1])));
			
		}
		if(op == '+'){
			String[] valores = tfCalc.getText().split("\\+");
			tfCalc.setText(String.valueOf(Double.parseDouble(valores[0])
					+ Double.parseDouble(valores[1])));
			
		}
		if(op == '/'){
			String[] valores = tfCalc.getText().split("\\/");
			if(valores[1].equals("0")){
				throw new ExceptionController("Não é possível divisão por 0");
			}else
			tfCalc.setText(String.valueOf(Double.parseDouble(valores[0])
					/ Double.parseDouble(valores[1])));
			
			
		}
		if(op == '*'){
			String[] valores = tfCalc.getText().split("\\*");
			tfCalc.setText(String.valueOf(Double.parseDouble(valores[0])
					* Double.parseDouble(valores[1])));
			
		}

	}
	
	public void validar(KeyEvent e) throws ExceptionController {
		if (!Character.isDigit(e.getKeyChar()) && e.getKeyCode() != KeyEvent.VK_BACK_SPACE){
			tfCalc.setText("");
			throw new ExceptionController("Apenas digitos");
			
		}	
	}

}
