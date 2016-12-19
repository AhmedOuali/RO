import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Graph {

	private JFrame frame;
	private JTextField textField_NbreVariables;
	private JTextField textField_NbreContraintes;
	private int nombreContrainte;
	private int nombreVariables;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graph window = new Graph();
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
	public Graph() {
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
		initAccueilPanel();
		initFormulaireProgrammePanel();
		initResultatPanel();
		
		
		
	}
	void initResultatPanel(){
		final JPanel Resultat = new JPanel();
		Resultat.setBounds(0, 0, 448, 265);
		frame.getContentPane().add(Resultat);
	}
	
	void initFormulaireProgrammePanel(){
		final JPanel FormulaireProgramme = new JPanel();
		FormulaireProgramme.setBounds(0, 0, 448, 265);
		frame.getContentPane().add(FormulaireProgramme);
		FormulaireProgramme.setLayout(null);
	}
	
	void initAccueilPanel(){
		final JPanel Accueil = new JPanel();
		Accueil.setBounds(0, 0, 448, 265);
		frame.getContentPane().add(Accueil);
		Accueil.setLayout(null);
		
		JLabel lblVotreProblemeLineaire = new JLabel("Votre Probleme Lineaire a");
		lblVotreProblemeLineaire.setBounds(43, 83, 199, 15);
		Accueil.add(lblVotreProblemeLineaire);
		
		textField_NbreVariables = new JTextField();
		textField_NbreVariables.setBounds(236, 81, 24, 19);
		Accueil.add(textField_NbreVariables);
		textField_NbreVariables.setColumns(10);
		
		JLabel lblV = new JLabel("Variables");
		lblV.setBounds(271, 83, 70, 15);
		Accueil.add(lblV);
		
		textField_NbreContraintes = new JTextField();
		textField_NbreContraintes.setColumns(10);
		textField_NbreContraintes.setBounds(236, 110, 24, 19);
		Accueil.add(textField_NbreContraintes);
		
		JLabel lblContraine = new JLabel("Contraintes");
		lblContraine.setBounds(271, 110, 84, 15);
		Accueil.add(lblContraine);
		
		JButton btnSuivant = new JButton("Suivant (Former)");
		
		//------ Bouton Suivant(Former) ---------------------------------------------
		////////////////////////////////////////////////////////////////////////////
		btnSuivant.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				nombreContrainte=Integer.parseInt(textField_NbreContraintes.getText());
				nombreVariables=Integer.parseInt(textField_NbreVariables.getText());
				Accueil.show(false);
			}
		});
		////////////////////////////////////////////////////////////////////////////////
		
		btnSuivant.setBounds(43, 142, 312, 25);
		Accueil.add(btnSuivant);
	}
}
