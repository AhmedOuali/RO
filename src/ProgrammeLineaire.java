

	import java.util.ArrayList;

	public class ProgrammeLineaire {
		private int nombreVariables;
		private int nombreContraintes;
		private ArrayList<Float> coefficientsFonctionObjective;
		private ArrayList<ArrayList<Float>> coefficientsContraintes;
		private ArrayList<String> signeInegalites;
		private ArrayList<String> signesVariables;
		Accueil graph;
		
		//-------------------Constructeur-1-"comme demandé-dans le TP"--------------
		ProgrammeLineaire(int nombreVariables,int nombreContraintes){
			this.nombreVariables=nombreVariables;
			this.nombreContraintes=nombreContraintes;
			signeInegalites=new ArrayList<String>();
			coefficientsFonctionObjective = new ArrayList<Float>();
			coefficientsContraintes=new ArrayList<ArrayList<Float>>();
			
		}
		/////////////////////////////////////////////////////////////////////////
		
		ArrayList<ArrayList<Float>> getcoefficientsContraintes(){
			return coefficientsContraintes;
		}
		
		ArrayList<Float> getcoefficientsFonctionObjective(){
			return coefficientsFonctionObjective;
		}

		
		
		//------------------manipulerVariableDecision()--------------------
		void manipulerVariablesDescision(){
			for(int i=0;i<signeInegalites.size();i++){
				if(signeInegalites.get(i)=="R"){
					ajouterVariable(i);
				}
				if(signeInegalites.get(i)=="R-"){
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
			
		}
		//////////////////////////////////////////////////////////////////
		
		//---------------inverserVariable()-------------------------------
		void inverserVariable(int i){
			
		}
		
		
	}

