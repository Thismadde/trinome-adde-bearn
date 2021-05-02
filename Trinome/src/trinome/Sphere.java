/*
 * Création : 30/01/2021
 * Dernière modification : 22/04/2021
 */
package trinome;

/**
 *
 * @author Utilisateur
 */
import java.util.ArrayList;

public class Sphere extends Piece {

	private ArrayList<Piece> sameCoL;
	private ArrayList<Piece> otherCol;

	public Sphere(boolean fix, Integer[] pos, String team, boolean j) {
		super(fix, pos, team, j);
		if (team == "vert") {            //si la couleur du pion est vert, on lui donne la version verte de l'image
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/demispV.png"));
		} else if (team == "rouge") { //sinon si c'est rouge, la version rouge        
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/demispR.png"));
		}
	}

	@Override
	public String getType() {
		return "Sphere ";
	}

	@Override
	public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv) {

		// renvoie les cases ou le pion peut aller
		if (color.equals("rouge")) {
			//selon la couleur du pion on attribue aux deux listes pionsr et pionsv des noms differents 
			//(on les clone sous des noms differents en fait)
			sameCoL = (ArrayList<Piece>) pionsr.clone();
			otherCol = (ArrayList<Piece>) pionsv.clone();
			//et apres relecture je me rend compte que ca ne sert a rien, genre vraiment on fait la meme chose aux deux...
			//mais bon, maintenant que c'est la...
		} else if (color.equals("vert")) {
			sameCoL = (ArrayList<Piece>) pionsv.clone();
			otherCol = (ArrayList<Piece>) pionsr.clone();
		}

		ArrayList<Integer[]> zbleh = new ArrayList<>();         //liste des cases atteignables disponibles

		//-2 -2
		if (!conflict(position[0] - 2, position[1] - 2, otherCol) && !conflict(position[0] - 2, position[1] - 2, sameCoL)
		&& (0 < position[0] - 2) && (0 < position[1] - 2)) {
			Integer[] npos = {position[0] - 2, position[1] - 2};
			zbleh.add(npos);
		}
		//-2 0
		if (!conflict(position[0] - 2, position[1], otherCol) && !conflict(position[0] - 2, position[1], sameCoL)
		&& (0 < position[0] - 2)) {
			Integer[] npos = {position[0] - 2, position[1]};
			zbleh.add(npos);
		}
		//-2 +2
		if (!conflict(position[0] - 2, position[1] + 2, otherCol) && !conflict(position[0] - 2, position[1] + 2, sameCoL)
		&& (0 < position[0] - 2) && (position[1] + 2) < 12) {
			Integer[] npos = {position[0] - 2, position[1] + 2};
			zbleh.add(npos);
		}
		//0 +2 
		if (!conflict(position[0], position[1] + 2, otherCol) && !conflict(position[0], position[1] + 2, sameCoL)
		&& (position[1] + 2 < 12)) {
			Integer[] npos = {position[0], position[1] + 2};
			zbleh.add(npos);
		}
		//+2 +2
		if (!conflict(position[0] + 2, position[1] + 2, otherCol) && !conflict(position[0] + 2, position[1] + 2, sameCoL)
		&& (position[0] + 2 < 12) && (position[1] + 2 < 12)) {
			Integer[] npos = {position[0] + 2, position[1] + 2};
			zbleh.add(npos);
		}
		//+2 0
		if (!conflict(position[0] + 2, position[1], otherCol) && !conflict(position[0] + 2, position[1], sameCoL)
		&& (position[0] + 2 < 12)) {
			Integer[] npos = {position[0] + 2, position[1]};
			zbleh.add(npos);
		}
		//+2 -2
		if (!conflict(position[0] + 2, position[1] - 2, otherCol) && !conflict(position[0] + 2, position[1] - 2, sameCoL)
		&& (position[0] + 2 < 12) && (0 < position[1] - 2)) {
			Integer[] npos = {position[0] + 2, position[1] - 2};
			zbleh.add(npos);
		}
		//0 -2
		if (!conflict(position[0], position[1] - 2, otherCol) && !conflict(position[0], position[1] - 2, sameCoL)
		&& (0 < position[1] - 2)) {
			Integer[] npos = {position[0], position[1] - 2};
			zbleh.add(npos);
		}

		return zbleh;
	}

}
