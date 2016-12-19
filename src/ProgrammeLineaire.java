

	import java.util.ArrayList;

	public class ProgrammeLineaire {
		private int nombreVariables;
		private int nombreContraintes;
		private ArrayList<Float> coefficientsFonctionObjective;
		private ArrayList<ArrayList<Float>> coefficientsContraintes;
		private ArrayList<String> Signe;
		Graph graph;
		
		//-------------------Constructeur-1-"comme demandé-dans le TP"--------------
		ProgrammeLineaire(int nombreVariables,int nombreContraintes){
			this.nombreVariables=nombreVariables;
			this.nombreContraintes=nombreContraintes;
			Signe=new ArrayList<String>();
			coefficientsFonctionObjective = new ArrayList<Float>();
			coefficientsContraintes=new ArrayList<ArrayList<Float>>();
			
		}
		/////////////////////////////////////////////////////////////////////////
		
		
		//-----------------Constructeur-2-"Celui qu'on va utiliser dans la suite----
		ProgrammeLineaire(Graph graph){
			this.graph=graph;
		}
		
		//------------------manipulerVariableDecision()--------------------
		void manipulerVariablesDescision(){
			for(int i=0;i<Signe.size();i++){
				if(Signe.get(i)=="R"){
					ajouterVariable(i);
				}
				if(Signe.get(i)=="R-"){
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

