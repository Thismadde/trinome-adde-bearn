/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinome;

/**
 *
 * @author Utilisateur
 */
import java.util.ArrayList;

public class SphereSpe extends Sphere {

	private ArrayList<Piece> sameCoL;
	private ArrayList<Piece> otherCol;

	public SphereSpe(boolean fix, Integer[] pos, String team, boolean j) {
		super(fix, pos, team, j);
		if (team == "vert") {                //si la couleur du pion est vert, on lui donne la version verte de l'image
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/demispVs.png"));
		} else if (team == "rouge") { //sinon si c'est rouge, la version rouge        
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/demispRs.png"));
		}
	}

	@Override
	public String getType() {
		return "Sphere S ";
	}

	@Override
	public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv) {

		//meme fonction que pour les spheres, a un detail pres
		ArrayList<Integer[]> zbleh = new ArrayList<>();

		if (color.equals("rouge")) {		//séparation des cas ici car les couleurs ne vont pas dans le même sens, donc les verif pour l'une ne sont pas reutilisables pour l'autre (en partie)
			sameCoL = (ArrayList<Piece>) pionsr.clone();
			otherCol = (ArrayList<Piece>) pionsv.clone();
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
			if (!conflict(position[0] + 2, position[1], otherCol) && !conflict(position[0] + 2, position[1] + 0, sameCoL)
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
			if (zbleh.isEmpty()) {      //on n'envisage les deplacement en arriere que si les autres sont tous indisponibles
				//-2 0
				if (!conflict(position[0] - 2, position[1], otherCol) && !conflict(position[0] - 2, position[1] + 0, sameCoL)
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
				//-2 -2
				if (!conflict(position[0] - 2, position[1] - 2, otherCol) && !conflict(position[0] - 2, position[1] - 2, sameCoL)
				&& (0 < position[0] - 2) && (0 < position[1] - 2)) {
					Integer[] npos = {position[0] - 2, position[1] - 2};
					zbleh.add(npos);
				}
			}
		} else if (color.equals("vert")) {
			sameCoL = (ArrayList<Piece>) pionsv.clone();
			otherCol = (ArrayList<Piece>) pionsr.clone();
			//0 +2 
			if (!conflict(position[0], position[1] + 2, otherCol) && !conflict(position[0], position[1] + 2, sameCoL)
			&& (position[1] + 2 < 12)) {
				Integer[] npos = {position[0], position[1] + 2};
				zbleh.add(npos);
			}
			//0 -2
			if (!conflict(position[0], position[1] - 2, otherCol) && !conflict(position[0], position[1] - 2, sameCoL)
			&& (0 < position[1] - 2)) {
				Integer[] npos = {position[0], position[1] - 2};
				zbleh.add(npos);
			}
			//-2 0
			if (!conflict(position[0] - 2, position[1], otherCol) && !conflict(position[0] - 2, position[1] + 0, sameCoL)
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
			//-2 -2
			if (!conflict(position[0] - 2, position[1] - 2, otherCol) && !conflict(position[0] - 2, position[1] - 2, sameCoL)
			&& (0 < position[0] - 2) && (0 < position[1] - 2)) {
				Integer[] npos = {position[0] - 2, position[1] - 2};
				zbleh.add(npos);
			}
			if (zbleh.isEmpty()) {    //on n'envisage les deplacement en arriere que si les autres sont tous indisponibles
				//+2 +2
				if (!conflict(position[0] + 2, position[1] + 2, otherCol) && !conflict(position[0] + 2, position[1] + 2, sameCoL)
				&& (position[0] + 2 < 12) && (position[1] + 2 < 12)) {
					Integer[] npos = {position[0] + 2, position[1] + 2};
					zbleh.add(npos);
				}
				//+2 0
				if (!conflict(position[0] + 2, position[1], otherCol) && !conflict(position[0] + 2, position[1] + 0, sameCoL)
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
			}

		}
		return zbleh;
	}

}
