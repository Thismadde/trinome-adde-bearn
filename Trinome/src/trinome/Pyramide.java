/*
 * Création : 30/01/2021
 * Dernière modification : 22/04/2021
 */
package trinome;

/**
 *
 * @author clarisse, mathis
 */
import java.util.ArrayList;

public class Pyramide extends Piece {

	private ArrayList<Piece> samecol;

	public Pyramide(boolean fix, Integer[] pos, String team, boolean j) {
		super(fix, pos, team, j);
		if (team == "vert") {            //si la couleur du pion est vert, on lui donne la version verte de l'image
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/pyraV.png"));
		} else if (team == "rouge") { //sinon si c'est rouge, la version rouge        
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/pyraR.png"));
		}
	}

	@Override
	public String getType() {
		return "Pyramide ";
	}

	@Override
	public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv) {

		//renvoie la liste des cases ou le pion peut aller
		// meme principe que pour le cube, seul les cases testées changent
		if (color.equals("rouge")) {
			samecol = (ArrayList<Piece>) pionsr.clone();
		} else if (color.equals("vert")) {
			samecol = (ArrayList<Piece>) pionsv.clone();
		}

		ArrayList<Integer[]> zbleh = new ArrayList<>();

		//-1 -1
		if (!conflict(position[0] - 1, position[1] - 1, samecol) && (0 < position[0] - 1) && (0 < position[1] - 1)) {
			Integer[] npos = {position[0] - 1, position[1] - 1};
			zbleh.add(npos);
		}
		//-1 +1
		if (!conflict(position[0] - 1, position[1] + 1, samecol) && (0 < position[0] - 1) && (position[1] + 1 < 12)) {
			Integer[] npos = {position[0] - 1, position[1] + 1};
			zbleh.add(npos);
		}
		//+1 +1
		if (!conflict(position[0] + 1, position[1] + 1, samecol) && (position[0] + 1 < 12) && (position[1] + 1 < 12)) {
			Integer[] npos = {position[0] + 1, position[1] + 1};
			zbleh.add(npos);
		}
		//+1 -1
		if (!conflict(position[0] + 1, position[1] - 1, samecol) && (position[0] + 1 < 12) && (0 < position[1] - 1)) {
			Integer[] npos = {position[0] + 1, position[1] - 1};
			zbleh.add(npos);
		}

		return zbleh;
	}

}
