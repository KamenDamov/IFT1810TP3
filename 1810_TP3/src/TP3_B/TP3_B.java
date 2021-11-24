package TP3_B;

public class TP3_B {
	// 1: d`extraire de sous-chaines et d`afficher
	static void afficher(String tel, String nom) {
		
		System.out.printf("Le telephone de %s", nom);
		System.out.printf("  (%s) %s-%s\n", 
				tel.substring(0,3),
				tel.substring(3,6),
				tel.substring(6));
	}
	
	// 2: de compter et d`afficher
	static int nombre(String tel, char chiffre) {
		int n = 0;
		for(int i =0 ; i < tel.length(); i++) {
			if(tel.charAt(i)== chiffre) {
				n++;
			}
		}
		return n;
	}
	
	// 3: de compter et d`afficher --paire || impaire
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
	
	// 4: de determiner et d`afficher les chiffres impaires communs de ces 2 numeros
	static void afficherImpairsCommuns(String telA, String telB) {
	
	      System.out.printf("Les chiffres impairs communs des deux téléphones : ");
	      for(char c = '1' ; c <= '9'; c+=2)// examiner les chiffres
	                                        // impairs '1', '3', '5', '7', '9'
	      	if (telA.indexOf(c) >= 0 && telB.indexOf(c) >= 0  ) // s'il fait partie de 2 téléphones
	      	   System.out.printf("%c ", c); // on l'affiche
	      System.out.printf("\n");
	}
			

	public static void main(String[]args) {
		
		String telUDM = "5143436111",
			   telJean = "4501897654";
		
		// 1: call the fn afficher()
		afficher(telUDM, "UDM");
		afficher(telJean, "Jean");
		
		// 2: call the fn nombre
		System.out.printf("il y a %d fois chiffre ‘3’ dans le numero de telephone d'UDM\n", nombre(telUDM, '3'));
		System.out.printf("il y a %d fois chiffre ‘1’ dans le numero de telephone d'UDM\n", nombre(telUDM, '1'));
		System.out.printf("il y a %d fois chiffre ‘2’ dans le numero de telephone de Jean\n", nombre(telJean, '2'));
		
		
		// 4: call the fn paireoupas()
		System.out.printf("Il y a %d fois les chiffres impairs dans le numéro de téléphone d'UDM\n", paireImpaire(telUDM, "impaire"));
		System.out.printf("Il y a %d fois les chiffres pairs dans le numéro de téléphone de Jean\n", paireImpaire(telJean, "paire"));
	
		// 5: call the fn afficherImpairesCommuns()
		afficherImpairsCommuns(telUDM, telJean);
	
	}
}
