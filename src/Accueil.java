import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Accueil {

	private JFrame frame;
	private JTextField textField_Nbre_Variables;
	private JTextField textField_NbreContraintes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
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
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 448, 265);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVotreProblemeLineaire = new JLabel("Votre Probleme Lineaire a");
		lblVotreProblemeLineaire.setBounds(43, 83, 199, 15);
		panel.add(lblVotreProblemeLineaire);
		
		textField_Nbre_Variables = new JTextField();
		textField_Nbre_Variables.setBounds(236, 81, 24, 19);
		panel.add(textField_Nbre_Variables);
		textField_Nbre_Variables.setColumns(10);
		
		JLabel lblV = new JLabel("Variables");
		lblV.setBounds(271, 83, 70, 15);
		panel.add(lblV);
		
		textField_NbreContraintes = new JTextField();
		textField_NbreContraintes.setColumns(10);
		textField_NbreContraintes.setBounds(236, 110, 24, 19);
		panel.add(textField_NbreContraintes);
		
		JLabel lblContraine = new JLabel("Contraintes");
		lblContraine.setBounds(271, 110, 84, 15);
		panel.add(lblContraine);
		
		JButton btnNewButton = new JButton("Suivant (Former)");
		btnNewButton.setBounds(43, 142, 312, 25);
		panel.add(btnNewButton);
	}
}
