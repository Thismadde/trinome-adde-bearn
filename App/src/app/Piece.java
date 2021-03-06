/*TPAA trinome
Mathis Adde
Clarisse Béarn
 */
package app;

/**
 *
 * @author utilisateur
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Piece {
    protected boolean frozen; 
    public Integer[] position;
    public String color;
    public boolean jok = false;

    public  Piece(boolean fix, Integer[] pos, String team, boolean j){
        frozen = fix; position = pos.clone() ; color = team; jok = j;
    }

    public String getColor() {
		return color;
	}

    public String getType(){
        return "Piepiece";
    }

    public void joker(ArrayList<Piece> pions){ //pour pouvoir appeler joker sur toutes les pieces, meme si dans les fait seule le joker() des cubes speciaux nous interesse
    }
   
    public void movesEnd(Integer[] newpos){ //sert a actualiser la position du point apres avoir selectionné la destination,  
        position= newpos.clone();           //et a changer le caractere figé des pieces selon leur position apres le deplacement
        if ((getColor().equals("rouge") && position[0]==11 && 4<position[1] && position[1]<8) ||   //conditions pour les rouges
            (getColor().equals("vert")  && position[0]==1  && 4<position[1] && position[1]<8))     //conditions pour les verts
            frozen = true;
    }

    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){ //pareil que joker() plus haut ^
        return new ArrayList<>();
    }
    
    public boolean conflict(int pos1,int pos2, ArrayList<Piece> pions){ //verifie si un pion de la liste occupe deja la case repérée par les positions pos1 et pos2 
        Iterator<Piece> it = pions.iterator();
        while (it.hasNext()){       //on parcourt la liste des pions
            Piece pawn = it.next();
            if (pawn.position[0]==pos1 && pawn.position[1]==pos2){ //Si un des pions de la liste a les memes coordonnées
                return true;    //alors il y a conflit
            }
        }
        return false; //sinon laplace est libre
    }
}
