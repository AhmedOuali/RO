

	import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

	public class ProgrammeLineaire implements Cloneable { //implements Cloneable (pour pouvoir le cloner en plusieurs objets)
		private int nombreVariables;
		private int nombreContraintes;
		private ArrayList<Float> coefficientsFonctionObjective;
		private ArrayList<ArrayList<Float>> coefficientsContraintes;
		private ArrayList<String> signeInegalites;
		private ArrayList<String> signesVariables;
		private String but;
		
		
		//-----------------------Implementation du methode de clonage- pour avoir par la suite deux objet cloner de programmeLineaire
		public Object clone() {
			Object o = null;
			try {
				// On récupère l'instance à renvoyer par l'appel de la 
				// méthode super.clone()
				o = super.clone();
			} catch(CloneNotSupportedException cnse) {
				// Ne devrait jamais arriver car nous implémentons 
				// l'interface Cloneable
				cnse.printStackTrace(System.err);
			}
			// on renvoie le clone
			return o;
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//-------------------Constructeur-1-"comme demandé-dans le TP"--------------
		ProgrammeLineaire(int nombreVariables,int nombreContraintes){
			this.nombreVariables=nombreVariables;
			this.nombreContraintes=nombreContraintes;
			signeInegalites=new ArrayList<String>();
			signesVariables=new ArrayList<String>();
			coefficientsFonctionObjective = new ArrayList<Float>();
			coefficientsContraintes=new ArrayList<ArrayList<Float>>();
			
		}
		/////////////////////////////////////////////////////////////////////////
		
		
		//-------------Les Getters et Setters----------------------------------
		ArrayList<ArrayList<Float>> getcoefficientsContraintes(){
			return coefficientsContraintes;
		}
		
		ArrayList<Float> getcoefficientsFonctionObjective(){
			return coefficientsFonctionObjective;
		}
		ArrayList<String> getsigneInegalites(){
			return signeInegalites;
		}
		ArrayList<String> getsignesVariables(){
			return signesVariables;
		}
		String getbut(){
			return but;
		}
		void setbut(String but){
			this.but=but;
		}
		int getnombreVariables(){
			return nombreVariables;
		}
		int getnombreContraintes(){
			return nombreContraintes;
		}
		void setnombreContraintes(int nbre){
			nombreContraintes= nbre;
		}
		void setcoefficientsContraintes(ArrayList<ArrayList<Float>> coefficientsContraintes){
			this.coefficientsContraintes=coefficientsContraintes;
		}
		void setcoefficientsFonctionObjective(ArrayList<Float> coefficientsFonctionObjective){
			this.coefficientsFonctionObjective=coefficientsFonctionObjective;
		}
		void setsigneInegalites(ArrayList<String> signeInegalites){
			this.signeInegalites=signeInegalites;
		}
		void setsignesVariables(ArrayList<String> signesVariables){
			this.signesVariables=signesVariables;
		}
		/////////////////////////////////////////////////////////////////////////////////////
		
		//------------------manipulerVariableDecision()--------------------
		void manipulerVariablesDescision(){
			for(int i=0;i<signesVariables.size();i++){
				if(signesVariables.get(i)=="R"){
					ajouterVariable(i);
				}
				if(signesVariables.get(i)=="R-"){
					inverserVariable(i);
				}
			}
		}
		//////////////////////////////////////////////////////////////////////////
		
		//----------------ajouterVariable()--------------------------------
		void ajouterVariable(int pos){
			for(int i=0;i<coefficientsContraintes.size();i++){
				coefficientsContraintes.get(i).add(pos, -coefficientsContraintes.get(i).get(pos));
			}
			coefficientsFonctionObjective.add(-coefficientsFonctionObjective.get(pos));
			nombreVariables++;	
			
		}
		//////////////////////////////////////////////////////////////////
		
		//---------------inverserVariable()-------------------------------
		void inverserVariable(int indexVariable){
			for(int i=0;i<coefficientsContraintes.size();i++){
				
					coefficientsContraintes.get(i).set(indexVariable,-coefficientsContraintes.get(i).get(indexVariable));
					
			}
			for(int i=0;i<coefficientsFonctionObjective.size();i++){
				coefficientsFonctionObjective.set(indexVariable, coefficientsFonctionObjective.get(indexVariable));
			}
			
		}
		
		//---------------manipulerVariablesDécision()-------------------------------
		void manipulerVariablesDécision(){
			for(int i=0;i<signesVariables.size();i++){
				switch (signesVariables.get(i)) {
				case "R-":
					inverserVariable(i);
					break;
				case "R":
					ajouterVariable(i);
					break;
				}
			}
		}
		////////////////////////////////////////////////////////////////////////////////
		
		//---------------------Transformer l'objet ProgrammeLineaire en forme canonique-------------------
		void convertirALaFormeCanonique(){
			switch (but){
			case "Max":
				for(int i=0;i<signeInegalites.size();i++){
					if(signeInegalites.get(i)==">="){
						inverserLigne(i);
						signeInegalites.set(i, "<=");
					}
					if(signeInegalites.get(i)=="="){
						signeInegalites.set(i, "<=");
						coefficientsContraintes.add(new ArrayList<Float>());
						nombreContraintes++;
						
						for(int j=0;j<coefficientsContraintes.get(i).size();j++){
							//JOptionPane.showMessageDialog(null,coefficientsContraintes.size() );
							coefficientsContraintes.get(coefficientsContraintes.size()-1).add(coefficientsContraintes.get(i).get(j));
						}
						signeInegalites.add("<=");
						inverserLigne(coefficientsContraintes.size()-1);	
					}	
				}
				break;
				
			case "Min":
				for(int i=0;i<signeInegalites.size();i++){
					if(signeInegalites.get(i)=="<="){
						inverserLigne(i);
						signeInegalites.set(i, ">=");
					}
					if(signeInegalites.get(i)=="="){
						signeInegalites.set(i, ">=");
						coefficientsContraintes.add(new ArrayList<Float>());
						nombreContraintes++;		
						for(int j=0;j<coefficientsContraintes.get(i).size();j++){
							coefficientsContraintes.get(coefficientsContraintes.size()-1).add(coefficientsContraintes.get(i).get(j));
						}
						signeInegalites.add(">=");
						inverserLigne(coefficientsContraintes.size()-1);
					}
				}
				break;
			}
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//---------------------Transformer l'objet ProgrammeLineaire en forme canonique-------------------
		void convertirALaFormeStandard(){
			for(int i=0;i<signeInegalites.size();i++){
				switch (signeInegalites.get(i)){
				case "<=":
					ajouterVariable(coefficientsContraintes.get(i).size()-2);
					coefficientsContraintes.get(i).set(nombreVariables-1, (float) 1);
					coefficientsFonctionObjective.set(nombreVariables-1, (float) 1);
					signeInegalites.set(i, "=");
					break;
				case ">=":
					ajouterVariable(coefficientsContraintes.get(i).size()-2);
					coefficientsContraintes.get(i).set(nombreVariables-1, (float) -1);
					coefficientsFonctionObjective.set(nombreVariables-1, (float) -1);
					signeInegalites.set(i, "=");
					break;
				}
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		void inverserLigne(int pos){
			for(int i=0;i<coefficientsContraintes.get(pos).size();i++)
				coefficientsContraintes.get(pos).set(i, -coefficientsContraintes.get(pos).get(i));
			
		}
		
		
		//
		
		
	}

