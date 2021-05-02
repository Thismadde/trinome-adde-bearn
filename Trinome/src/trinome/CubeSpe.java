/*
 * Création : 17/03/2021
 * Dernière modification : 28/04/2021
 */
package trinome;

import java.util.ArrayList;

/**
 *
 * @author Clarisse, Mathis
 */
public class CubeSpe extends Cube {

	public CubeSpe(boolean fix, Integer[] pos, String team, boolean j) {
		super(fix, pos, team, j);
		if (team == "vert") {      //si la couleur du pion est vert, on lui donne la version verte de l'image
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/cubeVs.png"));
		} else if (team == "rouge") { //sinon si c'est rouge, la version rouge        
			sprite =new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/cubeRs.png"));
		}
	}

	@Override
	public String getType() {
		return "Cube S ";
	}

	@Override
	public void joker(ArrayList<Piece> pions) {
		//pour activer le activeJoker des cubes speciaux 

		if (!frozen) {               //si le pion est déjà verouillé on ne fait rien
			int n = 0;              //compteur de pions sur la meme diagonale
			for (Piece p : pions) {  //on parcourt toutes les pieces de la meme couleur
				if (p.position[0] - position[0] == p.position[1] - position[1]) //si le pion est  sur la meme diagonale \ 
				{
					n++;
				}
			}
			if (n < 2) { //s'il n'y avait pas assez de pions sur la diagonale \, on verifie ceux sur la diagonale /
				n = 0; //on remet le compteur a 0
				for (Piece p : pions) { //on reparcourt tous les pions de la meme couleur
					if (p.position[0] - position[0] == position[1] - p.position[1]) {
						n++;
					}
				}
			}
			if (n > 1)//s'il y a eu assez de pions sur l'une ou l'autre des diagonales
			{
				activeJoker = true;
			}
		}
	}
}
