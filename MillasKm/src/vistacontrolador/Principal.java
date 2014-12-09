package vistacontrolador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.JButton;

import Modelo.Conversor2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class Principal {

	private JFrame frame;
	private JComboBox<String> operacion;
	private JTextField txtNumero;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		operacion = new JComboBox();
		operacion.setModel(new DefaultComboBoxModel(new String[] {"Millas-Km", "Km-Millas"}));
		
		JLabel lblNumero = new JLabel("Numero:");
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		
		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conversor2 conversor=new Conversor2();
				double millas;
				double km;
				String op=(String)operacion.getSelectedItem();
				if(op.equals("Millas-Km")){
				    km=Double.parseDouble(txtNumero.getText());
				    millas=conversor.kmmillas(km);
				    DecimalFormat miFormato = new DecimalFormat("###0.00");
				    String resultado=miFormato.format(millas);
				    txtResultado.setText(resultado);
				}
				if(op.equals("Km-Millas")){
				    millas=Double.parseDouble(txtNumero.getText());
				    km=conversor.millaskm(millas);
				    DecimalFormat miFormato = new DecimalFormat("###0.00");
				    String resultado=miFormato.format(km);
				    txtResultado.setText(resultado);
				}    
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(131)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblResultado)
							.addGap(18)
							.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(151))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumero, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNumero)
							.addGap(148))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(163)
					.addComponent(btnCalcular)
					.addContainerGap(200, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(154)
					.addComponent(operacion, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(operacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResultado)
						.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCalcular)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {operacion, txtNumero});
		frame.getContentPane().setLayout(groupLayout);
	}
}
