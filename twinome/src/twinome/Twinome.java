import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;   

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

//package twinome;
/**
 *
 * @author Utilisateur
 */
public class Twinome {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Plateau plato = new Plateau();//on genere un plateau vide
        int tour;
        System.out.println("Charger la derniere partie? (O/N)");
        if (sc.next().equals("O"))
            tour = plato.reload(); 
        else{
            System.out.println("Quelle partie créer? Normale(N) ou spéciale(S)?");
            plato.newGame(sc.next().equals("S")); //on choisit pions speciaux ou non et on remplit le plateau en fonction
            tour = 1; //1 pour rouge, 0 pour vert, rouge commence
        }   
        boolean play =true;
        Integer[] newpos = new Integer[2];   //nouvelle postion a chaque tour
        do{
            plato.blitMatrix(); //on affiche le plateau
            Piece p = plato.selectPawn(tour,sc); //le joueur choisit le pion qu'il veut deplacer
            ArrayList<Integer[]> possib = p.radar(plato.pionsr, plato.pionsv); //on affiche les cases de destination disponibles
            //possib.forEach(System.out::println);
            if (possib.isEmpty()){  //si aucune case disponible
                System.out.println("pion non bougeable");
                continue; //on recommence le tour
            }
            for (Integer[] ui: possib){ //si il y a des cases on affiche leur coordonnées
                System.out.println(Arrays.toString(ui));
            }
            System.out.println("taper les coordonnées de destination");    
            newpos[0] = sc.nextInt(); //on saisit les coordonnees souhaitées une a une
            newpos[1] = sc.nextInt();
            boolean z = true; //tant que le pion n'est pas deplacer
            for (Integer[] possibI: possib){
                if (possibI[0] == newpos[0] && possibI[1]==newpos[1]){ //on parcourt toutes les possibilités presentées pour valider que les données saisies sont autorisées
                    //si on a une pyramide speciale, il arrive qu'elles saute au dessus d'un point. pour le supprimer, il faut passer par sa case, donc on fait:
                    try {
                        if (p.getType().equals("Pyramide S ")){
                            Integer[] a = {(p.position[0]+newpos[0])/2,(p.position[1]+newpos[1])/2}; 
                            plato.movePawn(p,a, tour); //deplacement intermediaire
                        }
                    } catch (Exception e) {
                    }
                    plato.movePawn(p, newpos, tour); //on bouge le pion
                    z = false;
                }
            }
            for (Piece pjok: plato.pionsr){ //seuls les cubes speciaux verifient vraiment quelque chose ici
                pjok.joker(plato.pionsr);
            }
            for (Piece pjok: plato.pionsv){//pour les cubes speciaux verts
                pjok.joker(plato.pionsv);
            }
            if(z){//si les positions données sont invalides
                System.out.println("Position non valide!");
                continue;//on recommence sans changer le tour
            }
            if(plato.endGame()){
                System.out.println("Le gagnant est : "+p.getColor());
                break;
            }
            System.out.println("Continuer? (oui = O, non = N)");//c'est ici qu'on peut quitter en laissant une sauvegarde
            play = sc.next().equals("O");
            if(tour==1)//changement de valeur de tour pour changer le joueur dans l'iteration de boucle suivante
                tour=0;
            else if(tour==0)
                tour=1;
        }while (play);
        plato.save(tour);
        sc.close();




    }

}
