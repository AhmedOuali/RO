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
	//private ProgrammeLineaire programmeLineaire;
	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulaire frame = new Formulaire();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Formulaire(Accueil accueil) {
		//programmeLineaire=new ProgrammeLineaire(accueil.getNombreContraintes(),accueil.getNombreVariables());
		matriceDuProbleme=new ArrayList<ArrayList<JTextField>>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(12, 91, 424, 162);
		getContentPane().add(panel);
		panel.setLayout(new java.awt.GridLayout(accueil.getNombreContraintes(),accueil.getNombreVariables()));
		for(int i=0;i<accueil.getNombreContraintes();i++){
			for(int j=0;j<accueil.getNombreVariables();j++){
				
				JTextField Text;
				panel.add(Text=new JTextField());
				//matriceDuProbleme.get(i).add(Text);
				panel.add( new JLabel(" X"+(j+1)));
				
			}
			
			panel.add(new JComboBox(new String[] { "", "<=", ">=", "=" }));
			panel.add(new JTextField());
			
				
		}
		
		
		
		
		
		
	}
	
	

	
}
