import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;


public class Formulaire extends JFrame {
	private Accueil accueil;
	private ArrayList<ArrayList<JTextField>> matriceDuProbleme;
	private ArrayList<JComboBox> signeInegalites;
	private ProgrammeLineaire programmeLineaire;
	private ArrayList<JTextField> coefficientsFonctionObjective;
	private ArrayList<JComboBox> signesVariables;
	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	public Formulaire(Accueil accueil) {
		programmeLineaire=new ProgrammeLineaire(accueil.getNombreContraintes(),accueil.getNombreVariables());
		
		
		matriceDuProbleme=new ArrayList<ArrayList<JTextField>>();
		coefficientsFonctionObjective=new ArrayList<JTextField>();
		signeInegalites=new ArrayList<JComboBox>();
		signesVariables=new ArrayList<JComboBox>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 469);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(12, 183, 678, 239);
		getContentPane().add(panel);
		
		JLabel lblContrainte = new JLabel("Contraintes :");
		lblContrainte.setBounds(38, 156, 127, 15);
		getContentPane().add(lblContrainte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(347, 61, 343, 82);
		getContentPane().add(panel_1);
		
		JComboBox maxMin = new JComboBox(new String[] {"Max", "Min" });
		maxMin.setBounds(347, 25, 114, 24);
		getContentPane().add(maxMin);
		
		JLabel lblButDeLa = new JLabel("But de la Fonction Objective :");
		lblButDeLa.setBounds(38, 30, 227, 15);
		getContentPane().add(lblButDeLa);
		
		JLabel lblFonctionObjective = new JLabel("Fonction Objective :");
		lblFonctionObjective.setBounds(38, 71, 151, 15);
		getContentPane().add(lblFonctionObjective);
		
		//panel.setLayout(new java.awt.GridLayout(accueil.getNombreContraintes(),accueil.getNombreVariables()));
		//panel.setLayout(new java.awt.GridLayout(accueil.getNombreContraintes(),accueil.getNombreVariables()));
		
		
		// preparation du tableau contraintes
		panel.setLayout(new java.awt.GridLayout(accueil.getNombreContraintes(),accueil.getNombreVariables()));
			for(int i=0;i<accueil.getNombreContraintes();i++){
				for(int j=0;j<accueil.getNombreVariables();j++){
					
					JTextField Text;
					panel.add(Text=new JTextField());
					
					//remplissage Du tableau dynamique matriceDuProbleme
					matriceDuProbleme.add(new ArrayList<JTextField>());
					matriceDuProbleme.get(i).add(Text);
					/////////////////////////////////////////
					
					//condition d'affichage (ne pas afficher "+" aprés le derbier variable
					
					if(j==accueil.getNombreVariables()-1)
						panel.add( new JLabel(" X"+(j+1)));
					else
						panel.add( new JLabel(" X"+(j+1)+" +"));	
				}
				
				//remplissage Du tableau dynamique matriceDuProbleme
				JComboBox combo;
				panel.add(combo=new JComboBox(new String[] { "", "<=", ">=", "=" }));
				signeInegalites.add(combo);
				///////////////////////////////////////////////////////////
				
				
				
				JTextField Text;
				panel.add(Text=new JTextField());
				matriceDuProbleme.add(new ArrayList<JTextField>());
				matriceDuProbleme.get(i).add(Text);		
			}
		//
			
		//preparatin de la fonction objective
			panel_1.setLayout(new java.awt.GridLayout(2,accueil.getNombreVariables()*2));
			for(int i=0;i<accueil.getNombreVariables();i++){
				JTextField Text;
				panel_1.add(Text=new JTextField());
				coefficientsFonctionObjective.add(Text);
				//condition d'affichage (ne pas afficher "+" aprés le derbier variable
				
				if(i==accueil.getNombreVariables()-1)
					panel_1.add( new JLabel(" X"+(i+1)));
				else
					panel_1.add( new JLabel(" X"+(i+1)+" +"));	
			}
			for(int i=0;i<accueil.getNombreVariables();i++){
				JComboBox combo;
				panel_1.add(combo=new JComboBox(new String[] {"R", "R+", "R-" }));
				panel_1.add( new JLabel(""));
				signesVariables.add(combo);
			}
			
		//
				
			
	}
}
