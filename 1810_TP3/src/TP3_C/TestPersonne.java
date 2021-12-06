/* Fichier : TestPersonne
   Auteurs : Kamen Damov
   			 Jie Wu 
   Cours   : IFT 1810 section A
   Trimestre : Automne 2021
   But : Ce programme inclus la réponse de plusieurs exercices 
   		d'affichage, extraction, compte, et autre avec la POO
		en Java.
   Derniere mise a jour : 05/12/2021               
*/

package TP3_C;

import java.util.ArrayList;

class Personne {
	//Declaration des 2 parametres
	private String naissance;
	
	private int nbCafe;

	/*--------------------------------------------------
     Constructeur avec nbCafe auto defini
     Auteur: Kamen Damov
     But : Defini les valeurs pour les parametres                             
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	public Personne(String date, int cafe) {
		naissance = date;
		nbCafe = cafe;
	}

	/*--------------------------------------------------
     Constructeur avec nbCafe
     Auteur: Kamen Damov
     But : Defini la valeur par defaut pour le nbCafe                             
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	public Personne(String date) {
		naissance = date;
		nbCafe = 1;
	}

	/*--------------------------------------------------
     Pour avoir et initialiser naissance
     Auteur: Kamen Damov
     But : Pour avoir et initialiser naissance                           
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	/*--------------------------------------------------
     Pour avoir et initialiser nbCafe
     Auteur: Kamen Damov
     But : Pour avoir et initialiser nbCafe                           
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	public int getNbCafe() {
		return nbCafe;
	}

	public void setNbCafe(int nbCafe) {
		this.nbCafe = nbCafe;
	}
	
	/*
	--------------------------------------------------
     Pour avoir le nom du mois
     Auteur: Jie Wu
     But : On doit en premier extraire la chaine de caracteres
	 		qui represente le chiffre du mois, et ensuite lui 
			 assigner la chaine de caracteres qui represente de 
			 nom du mois.                          
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	public int rangMois()
    {
    	return Integer.parseInt(naissance.substring(3,5)) ;
    }

    public String getMois()
    {
    	String[] nomMois = { "janvier", "février", "mars", "avril", "mai",
    	                   "juin", "juillet", "août", "septembre",
    	                   "octobre", "novembre", "décembre"};

        // si rangMois() vaut 4, nomMois[4-1] vaut nomMois[3] vaut "Avril"
    	return nomMois[rangMois()-1];
    }
	
	/*
	--------------------------------------------------
     Pour avoir le jour
     Auteur: Kamen Damov
     But : On choisit la partie de la chaine de carateres
	 		qui represente le jour de naissance                          
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
    public int getJour()
	{
		return Integer.parseInt(naissance.substring(0,2));
	}
   
	/*
	--------------------------------------------------
     Pour avoir l'annee
     Auteur: Kamen Damov
     But : On choisit la partie de la chaine de carateres
	 		qui represente l'annee de naissance                          
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
    public int getAnnee()
	{
		return  Integer.parseInt(naissance.substring(6));
	}
	
	/*
	--------------------------------------------------
    La fonction pour afficher le resulat en bonne et due
	a partir des constructeurs ci-haut. 
     Auteur: Kamen Damov
     But : Les constructeurs sont placés dans les strings                          
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	public void afficher(String titre) {
		System.out.printf(titre);
		System.out.printf("naissance : "+ getJour()+" "+getMois()+" "+getAnnee());
		System.out.printf("Cafe : "+ nbCafe + " tasse(s) par jour");
	}
		
}// fin Personne

public class TestPersonne {
	
	/*
	--------------------------------------------------
     Fonction pour afficher le tableau
     Auteur: Jie Wu
     But : Afficher le tableau                          
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
   static  void afficher(Personne[] pers, int nbPers, String message)
    {
    	System.out.printf("\nIndice       Tableaux pers:     " + message);
    	System.out.printf("---------------------------------------------------");
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
	
	/*
	--------------------------------------------------
     Pour avoir l'annee
     Auteur: Kamen Damov
     But : Avoir l'information de la personne qui a bu le plus
	 		de cafe                          
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
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
	   
	   System.out.printf("la personne qui consomme le plus cafe est ne "+pers[maxIndex].getNaissance()
			   +" , elle consomme " + maxCafe + " tasses par jour");
	   
   }
   
   	/*
	--------------------------------------------------
     Pour avoir le tableau avec les cafés réduit
     Auteur: Jie Wu
     But : On itère, et on réduit le nombre de café bu de 1                          
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
   static void reduire(Personne[] pers, int nbPers) {   
	   for(int i = 0; i < nbPers; i++)
	   {
		   if(pers[i].getNbCafe()>0)
		   {
			   pers[i].setNbCafe(pers[i].getNbCafe()-1);
		   }
	   }
   }
   
   	/*
	--------------------------------------------------
     Pour avoir la ou les personnes née en Mai
     Auteur: Kamen Damov
     But : On compte et retourne les gens avec mai 
   			comme mois de naissance.
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
   static int persMai(Personne[] pers, int nbPers) {
	   int nombre = 0;
	   for(int i = 0; i < nbPers; i++)
	   {
		   if(pers[i].getMois()=="mai")
		   {
			   nombre++;
		   }
	   }
	   return nombre;
   }
   
   	/*
	--------------------------------------------------
     La fonction principale
     Auteur: Kamen Damov et Jie Wu
     But :Afficher et presenter les informations voulues à
   			partir des fonctions et constructeurs ci-haut
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
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
		System.out.printf("le nombre de personne qui sont nees au mois de mai est "+ TestPersonne.persMai(pers, nbPers));		
	}
}
/*Exécution:
A AJOUTER!
*/