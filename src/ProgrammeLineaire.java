

	import java.util.ArrayList;

	public class ProgrammeLineaire {
		private int nombreVariables;
		private int nombreContraintes;
		private ArrayList<Float> coefficientsFonctionObjective;
		private ArrayList<ArrayList<Float>> coefficientsContraintes;
		private ArrayList<String> Signe;
		
		//-------------------Constructeur------------------------------------------
		ProgrammeLineaire(int nombreVariables,int nombreContraites){
			this.nombreVariables=nombreVariables;
			this.nombreContraintes=nombreContraintes;
			Signe=new ArrayList<String>();
			coefficientsFonctionObjective = new ArrayList<Float>();
			coefficientsContraintes=new ArrayList<ArrayList<Float>>();
			
		}
		/////////////////////////////////////////////////////////////////////////
		
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
				coefficientsContraintes.get(i).get(pos).add(-coefficientsContraintes.get(i).get(pos));
			}
			
		}
		//////////////////////////////////////////////////////////////////
		
		//---------------inverserVariable()-------------------------------
		void inverserVariable(int i){
			
		}
		
		
	}

