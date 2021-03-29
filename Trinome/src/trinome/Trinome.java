/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class Trinome {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Plateau plato = new Plateau("a","b");//on genere un plateau vide
		System.out.println("Charger la derniere partie? (O/N)");
		if (sc.next().equals("O")) {
			plato.reload();
		} else {
			System.out.println("Quelle partie créer? Normale(N) ou spéciale(S)?");
			plato.newGame(sc.next().equals("S")); //on choisit pions speciaux ou non et on remplit le plateau en fonction
		}
		boolean play = true;


		Integer[] newpos = new Integer[2];   //nouvelle postion a chaque p.tour
		do {
			plato.blitMatrix(); //on affiche le plateau
			Piece p = plato.selectPawn(plato.tour, sc); //le joueur choisit le pion qu'il veut deplacer
			
			ArrayList<Integer[]> possib = p.radar(plato.pionsr, plato.pionsv);//on affiche les cases de destination disponibles
			if (possib.isEmpty()) {  //si aucune case disponible
				System.out.println("pion non bougeable");
				continue; //on recommence le p.tour
			}
			int i = 1;
			for (Integer[] ui : possib) { //si il y a des cases on affiche leur coordonnées
				System.out.println(Arrays.toString(ui) + i);
				i++;
			}
			System.out.println("taper les coordonnées de destination");
			try {
				newpos = possib.get(sc.nextInt() - 1); //on selectionne les coordonnées souhaitées

			} catch (Exception e) { //si l'indice entré est incorrecte
				System.out.println("Position non valide!");
				continue;
			}
			try {
				if (p.getType().equals("Pyramide S ")) {
					Integer[] a = {(p.position[0] + newpos[0]) / 2, (p.position[1] + newpos[1]) / 2};
					plato.movePawn(p, a, plato.tour); //deplacement intermediaire pour les pyramides speciales
				}
			} catch (Exception e) {
			}
			plato.movePawn(p, newpos, plato.tour); //on bouge le pion
			for (Piece pjok : plato.pionsr) { //seuls les cubes speciaux verifient vraiment quelque chose ici
				pjok.joker(plato.pionsr);
			}
			for (Piece pjok : plato.pionsv) {//pour les cubes speciaux verts
				pjok.joker(plato.pionsv);
			}
			if (plato.endGame()) {
				System.out.println("Le gagnant est : " + p.getColor());
				break;
			}
			System.out.println("Continuer? (oui = O, non = N)");//c'est ici qu'on peut quitter en laissant une sauvegarde
			play = sc.next().equals("O");
			if (plato.tour == 1)//changement de valeur de p.tour pour changer le joueur dans l'iteration de boucle suivante
			{
				plato.tour = 0;
			} else if (plato.tour == 0) {
				plato.tour = 1;
			}
		} while (play);
		plato.save();
		sc.close();
	}

}
