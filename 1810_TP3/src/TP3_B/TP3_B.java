/* Fichier : TP3_B
   Auteurs : Kamen Damov
   			 Jie Wu 
   Cours   : IFT 1810 section A
   Trimestre : Automne 2021
   But : Ce programme inclus plusieurs exercices d'exatractions
		et d'affichage en Java.
   Derniere mise a jour : 05/12/2021               
*/

package TP3_B;

public class TP3_B {
	/*
	--------------------------------------------------
     D'extraire de sous-chaines et d'afficher
     Auteur: Kamen Damov
     But : Une fonction pour afficher le numero de telephone
	       avec cette forme (123) 456-7890.                              
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	static void afficher(String tel, String nom) {
		
		System.out.printf("Le telephone de %s :", nom);
		System.out.printf("  (%s) %s-%s\n", 
				tel.substring(0,3),
				tel.substring(3,6),
				tel.substring(6));
	}

	/*
	--------------------------------------------------
     De compter et d'afficher le numero voulu
     Auteur: Kamen Damov
     But : Une fonction pour afficher le compte d'un numero
	       voulu.                              
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	static int nombre(String tel, char chiffre) {
		int n = 0;
		for(int i =0 ; i < tel.length(); i++) {
			if(tel.charAt(i)== chiffre) {
				n++;
			}
		}
		return n;
	}

	/*
	--------------------------------------------------
     De compter et d'afficher un chiffre paire ou impaire
     Auteur: Jie Wu
     But : Afficher les chiffres paires du numero de telephone
	 		de Jean, et afficherles chiffres impaires du numero
			 de telephone de UDM.                              
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	static int paireImpaire(String tel, String flag) {
		int n = 0; 
		if (flag == "paire") {
			for(int i =0 ; i < tel.length(); i++) {
				int intNum = tel.charAt(i);
				if(intNum % 2 == 0 ) {
					n++;
				}
			}
		}
		else if(flag == "impaire") {
			for(int i =0 ; i < tel.length(); i++) {
				int intNum = tel.charAt(i);
				if(intNum % 2 != 0 ) {
					n++;
				}
			}
		}
		return n;
	}

	/*
	--------------------------------------------------
     De determiner et d`afficher les chiffres impaires communs 
	 de ces 2 numeros
     Auteur: Jie Wu
     But : Fonction qui nous permet de trouver les les nombre impaires
	 		communs dans le numero de Jean et de UDM                              
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	static void afficherImpairsCommuns(String telA, String telB) {
	
	      System.out.printf("Les chiffres impairs communs des deux téléphones : ");
	      for(char c = '1' ; c <= '9'; c+=2)// examiner les chiffres
	                                        // impairs '1', '3', '5', '7', '9'
	      	if (telA.indexOf(c) >= 0 && telB.indexOf(c) >= 0  ) // s'il fait partie de 2 téléphones
	      	   System.out.printf("%c ", c); // on l'affiche
	      System.out.printf("\n");
	}
		
	/*
	--------------------------------------------------
     Pour appeler les fonctions ci-haut
	 de ces 2 numeros
     Auteur: Jie Wu
     But : Fonction qui nous permet de retourner les resultats
	 		voulus, en evoquant les fonctions construites ci-haut                              
     Mise a jour : 05 12 2021
	 --------------------------------------------------
   */
	public static void main(String[]args) {
		
		String telUDM = "5143436111",
			   telJean = "4501897654";
		
		// 1: Appeler la fn afficher()
		afficher(telUDM, "UDM");
		afficher(telJean, "Jean");
		
		// 2: Appeler la fn nombre
		System.out.printf("il y a %d fois chiffre '3' dans le numero de telephone d'UDM\n", nombre(telUDM, '3'));
		System.out.printf("il y a %d fois chiffre '1' dans le numero de telephone d'UDM\n", nombre(telUDM, '1'));
		System.out.printf("il y a %d fois chiffre '2' dans le numero de telephone de Jean\n", nombre(telJean, '2'));
		
		
		// 4: Appeler la fn paireoupas()
		System.out.printf("Il y a %d fois les chiffres impairs dans le numéro de téléphone d'UDM\n", paireImpaire(telUDM, "impaire"));
		System.out.printf("Il y a %d fois les chiffres pairs dans le numéro de téléphone de Jean\n", paireImpaire(telJean, "paire"));
	
		// 5: Appeller la fn afficherImpairesCommuns()
		afficherImpairsCommuns(telUDM, telJean);
	
	}
}

/* 
Exécution: 
Le telephone de UDM  (514) 343-6111
Le telephone de Jean  (450) 189-7654
il y a 2 fois chiffre '3' dans le numero de telephone d'UDM
il y a 4 fois chiffre '1' dans le numero de telephone d'UDM
il y a 0 fois chiffre '2' dans le numero de telephone de Jean
Il y a 7 fois les chiffres impairs dans le numéro de téléphone d'UDM
Il y a 5 fois les chiffres pairs dans le numéro de téléphone de Jean
Les chiffres impairs communs des deux téléphones : 1 5 
*é
