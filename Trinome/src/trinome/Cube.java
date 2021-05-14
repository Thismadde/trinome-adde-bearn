/*
 * Création : 30/01/2021
 * Dernière modification : 28/04/2021
 */
package trinome;

/**
 *
 * @author clarisse, mathis
 */
import java.util.ArrayList;

public class Cube extends Piece {

	private ArrayList<Piece> sameCol;

	public Cube(boolean fix, Integer[] pos, String team, boolean j) {
		super(fix, pos, team, j);
		if ("vert".equals(team)) {		//si la couleur du pion est vert, on lui donne la version verte de l'image
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/cubeV.png"));
		} else if ("rouge".equals(team)) { //sinon si c'est rouge, la version rouge                                                     
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/cubeR.png"));
		}
	}

	@Override
	public String getType() {
		return "Cube ";
	}

	@Override
	public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv) {

		// renvoie les cases ou le pion peut aller
		
		
		if (color.equals("rouge")) {
			sameCol = (ArrayList<Piece>) pionsr.clone(); //liste avec laquelle on veut verifier les collisons, ici ici les pions de la meme couleur, car on peut de toute maniere manger les autres
		}
		else if (color.equals("vert")) {
			sameCol = (ArrayList<Piece>) pionsv.clone();
		}

		ArrayList<Integer[]> zbleh = new ArrayList<>();   //liste des cases atteignables disponibles

		//-1 0    <= deplacement testé sur la case de coordonnées [x-1,y]
		if (!conflict(position[0] - 1, position[1], sameCol) && (0 < position[0] - 1)) {
			Integer[] npos = {position[0] - 1, position[1]};
			zbleh.add(npos);
		}
		//0 +1
		if (!conflict(position[0], position[1] + 1, sameCol) && (position[1] + 1 < 12)) {
			Integer[] npos = {position[0], position[1] + 1};
			zbleh.add(npos);
		}
		//+1 0
		if (!conflict(position[0] + 1, position[1], sameCol) && (position[0] + 1 < 12)) {
			Integer[] npos = {position[0] + 1, position[1]};
			zbleh.add(npos);
		}
		//0 -1
		if (!conflict(position[0], position[1] - 1, sameCol) && (0 < position[1] - 1)) {
			Integer[] npos = {position[0], position[1] - 1};
			zbleh.add(npos);
		}
		return zbleh;
	}

}
