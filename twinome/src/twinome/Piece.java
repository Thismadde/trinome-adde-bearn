/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twinome;


import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;

/**
 *
 * @author Utilisateur
 */
public class Piece {

	protected boolean frozen;		//caractère figé de la pièce, true si elle l'est, false sinon
	public Integer[] position;		//tableau des coordonées du pion
	public String color;			//couleur du pion
	public boolean joker = false;	//joker des cubes speciaux
	public ImageIcon sprite;		

	public Piece(boolean fix, Integer[] pos, String team, boolean j) {
		frozen = fix;
		position = pos;
		color = team;
		joker = j;
	}

	public String getColor() {
		return color;
	}

	public String getType() {   //type de la pièce, varie selon les sous-classes
		return "Piepiece";
	}

	public void joker(ArrayList<Piece> pions) { //pour pouvoir appeler joker() sur toutes les pieces,
					// meme si dans les fait seule le joker des cubes speciaux nous interesse
	}

	public void movesEnd(Integer[] newpos, boolean cfrozer, boolean pfrozer, boolean sfrozer, boolean cfrozev, boolean pfrozev, boolean sfrozev) { //sert a actualiser la position du point apres avoir selectionné la destination, 
		//et a changer le caractere figé des pieces selon leur position apres le deplacement
		position = newpos.clone();
		
		if ((getColor().equals("rouge") && position[0] == 11 && 4 < position[1] && position[1] < 8) //conditions de position pour les rouges
			|| (getColor().equals("vert") && position[0] == 1 && 4 < position[1] && position[1] < 8)) //conditions de position pour les verts
		{
			if (getColor().equals("rouge") &&									//pour les pieces rouges
			(((getType().equals("Cube ") || (getType().equals("Cube S ")&&!joker)) && !cfrozer)|| //Si c'est un cube (ou cube special SANS joker) et qu'il n'y a pas deja un cube figé
			((getType().equals("Pyramide ") || getType().equals("Pyramide S ")) && !pfrozer)|| //		  une pyramide ou pyramide speciale					une pyramide figée
			((getType().equals("Sphere ") || getType().equals("Sphere S "))&& !sfrozer)))	//                     une sphere ou sphere speciale					une sphere figée
				frozen = true;										// alors on fige cette pièce
			
			//pareil pour les verts
			if(getColor().equals("vert") && (((getType().equals("Cube ") || (getType().equals("Cube S ")&&!joker)) && !cfrozev)||((getType().equals("Pyramide ") || getType().equals("Pyramide S "))&& !pfrozev)|| ((getType().equals("Sphere ") || getType().equals("Sphere S "))&& !sfrozev)))
				frozen = true;
		}
	}

	public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv) { //pareil que joker() plus haut ^
		return new ArrayList<>();
	}

	public boolean conflict(int pos1, int pos2, ArrayList<Piece> pions) { //verifie si un pion de la liste occupe deja la case 
												// repérée par les positions pos1 et pos2 
		Iterator<Piece> it = pions.iterator();
		while (it.hasNext()) {       //on parcourt la liste des pions
			Piece pawn = it.next();
			if (pawn.position[0] == pos1 && pawn.position[1] == pos2) { //Si un des pions de la liste a les memes coordonnées
				return true;    //alors il y a conflit
			}
		}
		return false; //sinon la place est libre
	}
}