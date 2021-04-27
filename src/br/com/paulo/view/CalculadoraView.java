package br.com.paulo.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.paulo.controller.ExceptionController;
import br.com.paulo.controller.TelaController;

public class CalculadoraView extends JFrame {

	private Container cPrincipal;
	private GridBagLayout layout;
	private GridBagConstraints restricoes;
	private TelaController tc;
	
	private JTextField tfCalc;
	private JButton bt7;
	private JButton bt8;
	private JButton bt9;
	private JButton btDivisao;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton btMulti;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton btSub;
	private JButton bt0;
	private JButton btPonto;
	private JButton btSoma;
	private JButton btIgual;
	
	JButton btBack;
	JButton btCe;

	public CalculadoraView() {
		super("Calculadora");

		
		cPrincipal = getContentPane();
		layout = new GridBagLayout();
		cPrincipal.setLayout(layout);

		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\calc.png"));

		restricoes = new GridBagConstraints();

		tfCalc = new JTextField(30);
		tc = new TelaController(tfCalc);
		tfCalc.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent event){
				try{
					tc.validar(event);
				}catch(ExceptionController ex){
					JOptionPane.showMessageDialog(null,ex.getMessage() , "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					tfCalc.setText("");
				}
			}
		});
		tfCalc.setFont(new Font("Time New Roman", 0, 25)); 
		
		bt7 = new JButton("7");
		bt8 = new JButton("8");
		bt9 = new JButton("9");
		btDivisao = new JButton("/");
		
		bt4 = new JButton("4");
		bt5 = new JButton("5");
		bt6 = new JButton("6");
		btMulti = new JButton("*");
		
		bt1 = new JButton("1");
		bt2 = new JButton("2");
		bt3 = new JButton("3");
		btSub = new JButton("-");
		
		bt0 = new JButton("0");
		btPonto = new JButton(".");
		btSoma = new JButton("+");
		btIgual = new JButton("=");
		
		btBack = new JButton("BackSpace");
		btCe = new JButton("Ce");
		
		bt7.addActionListener(new TelaController(bt7, tfCalc));
		bt8.addActionListener(new TelaController(bt8, tfCalc));
		bt9.addActionListener(new TelaController(bt9, tfCalc));
		btDivisao.addActionListener(new TelaController(btDivisao, tfCalc));
		
		bt4.addActionListener(new TelaController(bt4, tfCalc));
		bt5.addActionListener(new TelaController(bt5, tfCalc));
		bt6.addActionListener(new TelaController(bt6, tfCalc));
		btMulti.addActionListener(new TelaController(btMulti, tfCalc));
		
		bt1.addActionListener(new TelaController(bt1, tfCalc));
		bt2.addActionListener(new TelaController(bt2, tfCalc));
		bt3.addActionListener(new TelaController(bt3, tfCalc));
		btSub.addActionListener(new TelaController(btSub, tfCalc));
		
		bt0.addActionListener(new TelaController(bt0, tfCalc));
		btPonto.addActionListener(new TelaController(btPonto, tfCalc));
		btSoma.addActionListener(new TelaController(btSoma, tfCalc));
		btIgual.addActionListener(new TelaController(btIgual, tfCalc));
		
		btBack.addActionListener(new TelaController(btBack, tfCalc));
		btCe.addActionListener(new TelaController(btCe, tfCalc));

		restricoes.weightx = 1000;
		restricoes.weighty = 1;

		restricoes.fill = GridBagConstraints.BOTH;
		adicionarComponente(tfCalc, 0, 1, 4, 1);
		adicionarComponente(btBack, 1, 1, 2, 1);
		adicionarComponente(btCe, 1, 3, 2, 1);
		
		adicionarComponente(bt7, 2, 1, 1, 1);
		adicionarComponente(bt8, 2, 2, 1, 1);
		adicionarComponente(bt9, 2, 3, 1, 1);
		adicionarComponente(btDivisao, 2, 4, 1, 1);

		adicionarComponente(bt4, 3, 1, 1, 1);
		adicionarComponente(bt5, 3, 2, 1, 1);
		adicionarComponente(bt6, 3, 3, 1, 1);
		adicionarComponente(btMulti, 3, 4, 1, 1);

		adicionarComponente(bt1, 4, 1, 1, 1);
		adicionarComponente(bt2, 4, 2, 1, 1);
		adicionarComponente(bt3, 4, 3, 1, 1);
		adicionarComponente(btSub, 4, 4, 1, 1);

		adicionarComponente(bt0, 5, 1, 1, 1);
		adicionarComponente(btPonto, 5, 2, 1, 1);
		adicionarComponente(btSoma, 5, 3, 1, 1);
		adicionarComponente(btIgual, 5, 4, 1, 1);

		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void adicionarComponente(Component componente, int linha,
			int coluna, int largura, int altura) {
		
		restricoes.gridx = coluna;
		restricoes.gridy = linha;

		
		restricoes.gridwidth = largura;
		restricoes.gridheight = altura;

		layout.setConstraints(componente, restricoes);
		cPrincipal.add(componente);
	}
}
