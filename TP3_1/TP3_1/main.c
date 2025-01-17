/* Fichier : main
   Auteurs : Kamen Damov
   			 Jie Wu 
   Cours   : IFT 1810 section A
   Trimestre : Automne 2021
   But : Ce programme inclus la réponse de plusieurs exercices 
   		d'affichage, compte, et autre en utilisant des fonctions
        du langage C.
   Derniere mise a jour : 05/12/2021               
*/

#include <stdio.h>
/*--------------------------------------------------
Afficher les 3 tableaux
Auteur: Kamen Damov
But : d'afficher le contenu de ces trois tableaux 
    avant le tri                            
Mise a jour : 05 12 2021
--------------------------------------------------
*/
void afficher(int age[], int nbCafe[], char poste[], int nbEmp, char quand[])
{
   printf("Contenu de 3 tableaux %s selon les ages:\n", quand);
   printf("Rang     poste     nbCafe      age\n");
   for (int i = 0; i < nbEmp; i++)
     printf("%2d) %8c %9d %11d  \n", i, poste[i], nbCafe[i], age[i]);
   printf("\n")  ;
}

/*--------------------------------------------------
Compter et afficher
Auteur: Jie Wu
But : compter par une function avec return et ses 
    appels pour afficher le nombre de P, A, O                         
Mise a jour : 05 12 2021
--------------------------------------------------
*/
int nombre(char carValeur, char tableau[], int nbEmp)
{
   int n = 0;
    for(int i=0; i<nbEmp; i++)
        if(tableau[i]==carValeur)
            n++;
    return n;
}

/*--------------------------------------------------
Compter et afficher selon les restrictions
Auteur: Kamen Damov
But :  compter par une fonction avec return et ses 
        appels pour afficher le nombre demployer 
        age plus grand ou égal a 30 ans et nbCafe
        supérieur ou égal a 3                     
Mise a jour : 05 12 2021
--------------------------------------------------
*/
int nombreAvecSueil(int seuil, int tableau[], int nbEmp)
{
   int n = 0;
    for(int i=0; i<nbEmp; i++)
        if(tableau[i]>=seuil)
            n++;
    return n;
}

/*--------------------------------------------------
Fonction pour afficher la valeur maximale
Auteur: Jie Wu
But : determiner par une fonction et d`afficher 
    la valeur maximale                    
Mise a jour : 05 12 2021
--------------------------------------------------
*/
int maxi(int tableau[], int nbElem)
{
      int plusGrand = tableau[0] ;
      for (int i = 1; i < nbElem; i++)
        if ( tableau[i] > plusGrand)
              plusGrand = tableau[i];
      return plusGrand;
}

/*--------------------------------------------------
Trier selon les ages et reafficher
Auteur: Kamen Damov
But : trier selon les ages et reafficher les 3 tableaux 
        apres le tri                    
Mise a jour : 05 12 2021
--------------------------------------------------
*/
void trier(int age[], int nbCafe[], char poste[], int nbEmp)
{
    for (int i = 0; i < nbEmp-1; i++)
    {
        int indMin = i ;
        for (int j = i+1; j < nbEmp; j++)
             if (age[j] < age[indMin])
                 indMin = j ;
         if (indMin != i)
         {
            int tempo = age[i];
              age[i] = age[indMin];
              age[indMin] = tempo;

              int tempoNbCafe = nbCafe[i];
              nbCafe[i] = nbCafe[indMin];
              nbCafe[indMin] = tempoNbCafe;
             
              char tempoPoste = poste[i];
              poste[i] = poste[indMin];
              poste[indMin] = tempoPoste;
         }
   }
}

/*--------------------------------------------------
Fonction principale pour utiliser les fonctions créées
ci-haut
Auteur: Kamen Damov
But : Pour appeler les fonctions ci-haut              
Mise a jour : 05 12 2021
--------------------------------------------------
*/

int main() {
    int age[] = {25, 19, 27, 30, 65, 24, 56, 29},
        nbCafe[] = {3, 1, 5, 0, 3, 4, 0, 3};
    char poste[] = {'P', 'P', 'O', 'A', 'P', 'A', 'P', 'P'};
    int nbEmp = sizeof(age) / sizeof(int);
    
    // 1: call the fn affchier（）
    afficher(age, nbCafe, poste, nbEmp, "avant le tri");
    
    // 2: call the fn nombre()
    printf("le nobmre de Employees: \n");
    printf("le nombre de Programmeurs  : %d\n", nombre('P', poste, nbEmp));
    printf("le nombre de Analystes : %d\n", nombre('A', poste, nbEmp));
    printf("le nombre de Operateurs : %d\n", nombre('O', poste, nbEmp));
    
    // 3: call the fn nombreAvecSueil()
    printf("le nombre d`employees ayant 30 ans ou plus : %d\n", nombreAvecSueil(30,age,nbEmp));
    printf("le nombre d`employees consommant 3 tasses ou plus : %d\n", nombreAvecSueil(3,nbCafe,nbEmp));
    
    // 4: call the fn maxi()
    printf("la consommation maximale de cafe de tous les employees est %d\n", maxi(nbCafe, nbEmp));
    printf("l`age maximal de toudes employes est %d\n", maxi(age, nbEmp));
    
    // 5: call the fns trier() + afficher()
    trier(age, nbCafe, poste, nbEmp);
    afficher(age, nbCafe, poste, nbEmp, "apres le trie");
    
    return 0;
       
}


/*
    OUTPUT:
     Contenu de 3 tableaux avant le tri selon les ages:
     Rang     poste     nbCafe      age
      0)        P         3          25
      1)        P         1          19
      2)        O         5          27
      3)        A         0          30
      4)        P         3          65
      5)        A         4          24
      6)        P         0          56
      7)        P         3          29

     le nobmre de Employees:
     le nombre de Programmeurs  : 5
     le nombre de Analystes : 2
     le nombre de Operateurs : 1
     le nombre d`employees ayant 30 ans ou plus : 3
     le nombre d`employees consommant 3 tasses ou plus : 5
     la consommation maximale de cafe de tous les employees est 5
     l`age maximal de toudes employes est 65
     Contenu de 3 tableaux apres le trie selon les ages:
     Rang     poste     nbCafe      age
      0)        P         1          19
      1)        A         4          24
      2)        P         3          25
      3)        O         5          27
      4)        P         3          29
      5)        A         0          30
      6)        P         0          56
      7)        P         3          65

     Program ended with exit code: 0
 */
