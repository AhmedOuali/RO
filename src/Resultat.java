import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Label;


public class Resultat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ProgrammeLineaire FormeStandard;
	ProgrammeLineaire FormeCanonique;
	ProgrammeLineaire programmeLineaire;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Resultat(ProgrammeLineaire programmeLineaire) {
		this.programmeLineaire=programmeLineaire;
		FormeCanonique= (ProgrammeLineaire) programmeLineaire.clone();
		FormeStandard= (ProgrammeLineaire) programmeLineaire.clone();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image img=new ImageIcon(this.getClass().getResource("ASA-Firewall-icon (1).png")).getImage();
		
		JLabel lblNewLabel = new JLabel("Resolution d'un programme lineaire");
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 16));
		lblNewLabel.setBounds(177, 0, 345, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblFomreSaisie = new JLabel("Fomre saisie");
		lblFomreSaisie.setBounds(50, 51, 112, 15);
		contentPane.add(lblFomreSaisie);
		
		JLabel lblFormeCanonique = new JLabel("Forme canonique");
		lblFormeCanonique.setBounds(57, 268, 131, 15);
		contentPane.add(lblFormeCanonique);
		
		JLabel lblFormeStandrd = new JLabel("Forme standard");
		lblFormeStandrd.setBounds(516, 268, 123, 15);
		contentPane.add(lblFormeStandrd);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(216, 56, 400, 135);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(59, 295, 319, 130);
		contentPane.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(516, 295, 381, 130);
		contentPane.add(panel3);
		
		JLabel label = new JLabel("{");
		label.setBounds(154, 51, 57, 142);
		contentPane.add(label);
		label.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 99));
		
		JLabel label_1 = new JLabel("{");
		label_1.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 99));
		label_1.setBounds(0, 281, 70, 142);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("{");
		label_2.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 99));
		label_2.setBounds(452, 281, 70, 142);
		contentPane.add(label_2);
		
		panel1.setLayout(new java.awt.GridLayout(programmeLineaire.getnombreContraintes()+1,(programmeLineaire.getnombreVariables()*2+2)));
		panel1.add(new JLabel(programmeLineaire.getbut()));
		
		for(int i=0;i<programmeLineaire.getcoefficientsFonctionObjective().size();i++){
			panel1.add(new JLabel(programmeLineaire.getcoefficientsFonctionObjective().get(i).toString()));
			if(programmeLineaire.getcoefficientsFonctionObjective().size()-i!=i)
				
				panel1.add(new JLabel("X" +i+"+  "));
			
			else
				panel1.add(new JLabel("X"+i));
		}
		panel1.add(new JLabel(""));
		
		
		//---------remplissage de l'inteface de la forme normal
		for(int i=0;i<programmeLineaire.getcoefficientsContraintes().size();i++){
			for(int j=0;j<programmeLineaire.getcoefficientsContraintes().get(i).size();j++){
				if(programmeLineaire.getcoefficientsContraintes().get(i).size()-1==j){
					panel1.add(new JLabel(programmeLineaire.getsigneInegalites().get(i).toString()));
					panel1.add(new JLabel(programmeLineaire.getcoefficientsContraintes().get(i).get(j).toString()));
				}
				else if(programmeLineaire.getcoefficientsContraintes().get(i).size()-2==j){
					
						panel1.add(new JLabel(programmeLineaire.getcoefficientsContraintes().get(i).get(j).toString()));
						panel1.add(new JLabel("X"+j));
					}
						else{
						panel1.add(new JLabel(programmeLineaire.getcoefficientsContraintes().get(i).get(j).toString()));
						panel1.add(new JLabel("X"+j+"   +"));
						
						}		
			}	
		}
		
		
		clonerProgrammeLineaire(); //orperation de clonage de deux object ProgrammeLineaire (Construction de FormeCanonique et FormeStandard)
		
		FormeCanonique.convertirALaFormeCanonique();//Construire la forme canonique
		construirePanel(panel2,FormeCanonique);
		FormeStandard.convertirALaFormeStandard();//Construire la forme canonique
		construirePanel(panel3,FormeStandard);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(396, 329, 57, 60);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		
	}
	void clonerProgrammeLineaire(){
		FormeCanonique= (ProgrammeLineaire) programmeLineaire.clone();
		FormeStandard= (ProgrammeLineaire) programmeLineaire.clone();
		FormeStandard.setcoefficientsContraintes((ArrayList<ArrayList<Float>>) programmeLineaire.getcoefficientsContraintes().clone());
		FormeStandard.setcoefficientsFonctionObjective((ArrayList<Float>) programmeLineaire.getcoefficientsFonctionObjective().clone());
		FormeStandard.setsigneInegalites((ArrayList<String>)programmeLineaire.getsigneInegalites().clone());
		FormeStandard.setsignesVariables((ArrayList<String>)programmeLineaire.getsignesVariables().clone());
	}
	
	
	void construirePanel(JPanel panel1 ,ProgrammeLineaire programmeLineaire){
		panel1.setLayout(new java.awt.GridLayout((programmeLineaire.getnombreContraintes()+1),(programmeLineaire.getnombreVariables()*2+2)));
		panel1.add(new JLabel(programmeLineaire.getbut()));
		
		System.out.println((programmeLineaire.getnombreContraintes()+1));
		System.out.println((programmeLineaire.getnombreVariables()*2+2));
		System.out.println(programmeLineaire.getnombreContraintes()); ///////////////////
		System.out.println(programmeLineaire.getnombreVariables());
		for(int i=0;i<programmeLineaire.getcoefficientsFonctionObjective().size();i++){
			panel1.add(new JLabel(programmeLineaire.getcoefficientsFonctionObjective().get(i).toString()));
			if(programmeLineaire.getcoefficientsFonctionObjective().size()-i!=i)
				
				panel1.add(new JLabel("X" +i+"+  "));
			
			else
				panel1.add(new JLabel("X"+i));
		}
		panel1.add(new JLabel(""));
		for(int i=0;i<programmeLineaire.getcoefficientsContraintes().size();i++){
			for(int j=0;j<programmeLineaire.getcoefficientsContraintes().get(i).size();j++){
				if(programmeLineaire.getcoefficientsContraintes().get(i).size()-1==j){
					panel1.add(new JLabel(programmeLineaire.getsigneInegalites().get(i).toString()));
					panel1.add(new JLabel(programmeLineaire.getcoefficientsContraintes().get(i).get(j).toString()));
				}
				else if(programmeLineaire.getcoefficientsContraintes().get(i).size()-2==j){
					
						panel1.add(new JLabel(programmeLineaire.getcoefficientsContraintes().get(i).get(j).toString()));
						panel1.add(new JLabel("X"+j));
					}
						else{
						panel1.add(new JLabel(programmeLineaire.getcoefficientsContraintes().get(i).get(j).toString()));
						panel1.add(new JLabel("X"+j+"   +"));
						
						}		
			}	
		}
	}
}
