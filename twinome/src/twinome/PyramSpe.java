/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twinome;

import java.util.ArrayList;
/**
 *
 * @author Utilisateur
 */
public class PyramSpe extends Pyramide {

	private ArrayList<Piece> samecol;
	private ArrayList<Piece> othercol;

	public PyramSpe(boolean fix, Integer[] pos, String team, boolean j) {
		super(fix, pos, team, j);
		if (team == "vert") {
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/pyraVs.png"));
		} else if (team == "rouge") {
			sprite = new javax.swing.ImageIcon(getClass().getResource("/pfiches/recherche sprites/pyraRs.png"));
		}
	}

	@Override
	public String getType() {
		return "Pyramide S ";
	}

	@Override
	public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv) {

		//de meme que pour pyramide
		if (color.equals("rouge")) {
			samecol = (ArrayList<Piece>) pionsr.clone();
			othercol = (ArrayList<Piece>) pionsv.clone();
		} else if (color.equals("vert")) {
			samecol = (ArrayList<Piece>) pionsv.clone();
			othercol = (ArrayList<Piece>) pionsr.clone();
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

		//-2 -2                                                                                             
		if (conflict(position[0] - 1, position[1] - 1, othercol) && (0 < position[0] - 2) && (0 < position[1] - 2)//ici on verifie si il y a bien un ennemi a 1 case de distance, et si la case suivante est libre
		&& !conflict(position[0] - 2, position[1] - 2, samecol) && !conflict(position[0] - 2, position[1] - 2, othercol)) {  //
			Integer[] npos = {position[0] - 2, position[1] - 2};                                                       //
			zbleh.add(npos);                                                                                      //
		}                                                                                                         //
		//-2 +2                                                                                                   //
		if (conflict(position[0] - 1, position[1] + 1, othercol) && (0 < position[0] - 2) && (position[1] + 2 < 12)
		&& !conflict(position[0] - 2, position[1] + 2, samecol) && !conflict(position[0] - 2, position[1] + 2, othercol)) {  //
			Integer[] npos = {position[0] - 2, position[1] + 2};                                                       //
			zbleh.add(npos);                                                            //
		}         
		//+2 +2                                                                         //
		if (conflict(position[0] + 1, position[1] + 1, othercol) && (position[0] + 2 < 12) && (position[1] + 1 < 12)
		&& !conflict(position[0] + 2, position[1] + 2, samecol) && !conflict(position[0] + 2, position[1] + 2, othercol)) { //
			Integer[] npos = {position[0] + 2, position[1] + 2};                                                       //
			zbleh.add(npos);                                                                                      //
		}                                                                                                         //
		//+2 -2                                                                                                   //
		if (conflict(position[0] + 1, position[1] - 1, othercol) && (position[0] + 2 < 12) && (0 < position[1] - 2)
		&& !conflict(position[0] + 2, position[1] - 2, samecol) && !conflict(position[0] + 2, position[1] - 2, othercol)) {  //
			Integer[] npos = {position[0] + 2, position[1] - 2};                                                       //
			zbleh.add(npos);                                                                                      //
		}

		return zbleh;
	}

}
