package TP3_C;

import java.util.ArrayList;

class Personne {
	
	private String naissance;
	
	private int nbCafe;
	
	// constructeur with self-defined nbCafe
	public Personne(String date, int cafe) {
		naissance = date;
		nbCafe = cafe;
	}
	
	
	// constructeur with default nbCafe
	public Personne(String date) {
		naissance = date;
		nbCafe = 1;
	}
	
	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public int getNbCafe() {
		return nbCafe;
	}

	public void setNbCafe(int nbCafe) {
		this.nbCafe = nbCafe;
	}
	
	public int rangMois()
    {
    	return Integer.parseInt( naissance.substring(3,5)) ;
    }

    public String getMois()
    {
    	String[] nomMois = { "Janvier", "Février", "Mars", "Avril", "Mai",
    	                   "Juin", "Juillet", "Août", "Septembre",
    	                   "Octobre", "Novembre", "Décembre"};

        // si rangMois() vaut 4, nomMois[4-1] vaut nomMois[3] vaut "Avril"
    	return nomMois[rangMois()-1];

    }

  
    public int getJour()
	{
		return Integer.parseInt(naissance.substring(0,2));
	}

    
    public int getAnnee()
	{
		return  Integer.parseInt(naissance.substring(6));
	}
	
	public void afficher(String titre) {
		System.out.println(titre);
		System.out.println("naissance : "+ getJour()+" "+getMois()+" "+getAnnee());
		System.out.println("Cafe : "+ nbCafe + " tasse(s) par jour");
	}
		
}// fin Personne

public class TestPersonne {
	
   static  void afficher(Personne[] pers, int nbPers, String message)
    {
    	System.out.println("\nIndice       Tableaux pers:     " + message);
    	System.out.println("---------------------------------------------------");
    	for(int i = 0; i < nbPers; i++)
    		if(pers[i].getNbCafe()<=0) 
    		{
        		System.out.printf("%3d %15s %3d tasse \n", i,
        		        pers[i].getNaissance(),
        		        pers[i].getNbCafe());
    		}
    		else if(pers[i].getNbCafe()==1) 
    		{
    			System.out.printf("%3d %15s %3d tasse (par defaut) \n", i,
        		        pers[i].getNaissance(),
        		        pers[i].getNbCafe());
    		}
    		else
    		{
    			System.out.printf("%3d %15s %3d tasses \n", i,
        		        pers[i].getNaissance(),
        		        pers[i].getNbCafe());
    		}

        System.out.printf("\n");
    }
	
   static void maxCafe(Personne[] pers, int nbPers) {
	   int maxCafe = 0;
	   int maxIndex=0;
	   for(int i = 0; i < nbPers; i++)
	   {
		   if(pers[i].getNbCafe()>maxCafe)
		   {
			   maxCafe = pers[i].getNbCafe();
			   maxIndex = i;
		   }
	   }
	   
	   System.out.println("la personne qui consomme le plus cafe est ne "+pers[maxIndex].getNaissance()
			   +" , elle consomme " + maxCafe + " tasses par jour");
	   
   }
 
   static void reduire(Personne[] pers, int nbPers) {   
	   for(int i = 0; i < nbPers; i++)
	   {
		   if(pers[i].getNbCafe()>0)
		   {
			   pers[i].setNbCafe(pers[i].getNbCafe()-1);
		   }
	   }
   }
   
   static int persMai(Personne[] pers, int nbPers) {
	   int nombre = 0;
	   for(int i = 0; i < nbPers; i++)
	   {
		   if(pers[i].getMois()=="Mai")
		   {
			   nombre++;
		   }
	   }
	   return nombre;
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Personne pers1 = new Personne("19/05/1997", 4),
				 pers2 = new Personne("31/12/1990"),
				 pers3 = new Personne("08/05/1994",2);
		pers2.afficher("informations de la deuxieme personne:");
		
		// afficher le tableau au debut
		Personne[] pers = { new Personne("16/05/1992", 2),
							new Personne("02/11/1990"),
							new Personne("23/05/1996", 5),
							new Personne("19/02/1985", 0),
							new Personne("30/05/1991", 2)
						  };
		int nbPers = pers.length;
		TestPersonne.afficher(pers, nbPers, "au debut");
		
		// chercher la personne qui consomme le plus de cafe
		TestPersonne.maxCafe(pers, nbPers);
		
		// reduire de 1 tasse de moins pour les personnes qui consomment de cafe
				TestPersonne.reduire(pers, nbPers);
				
		// reafficher le tableau
		TestPersonne.afficher(pers, nbPers, "apres la reduction");
		
		// compter le nombre de personne aui sont nees au mois de mai
		System.out.println("le nombre de personne qui sont nees au mois de mai est "+ TestPersonne.persMai(pers, nbPers));
		
		
		
		
	}

}
