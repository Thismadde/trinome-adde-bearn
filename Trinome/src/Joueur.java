import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Joueur {
    
    private String name;
    public LinkedList<Piece> pawns;
    private String color;

    public Joueur(String n, String c){
        name = n; color = c;
    }

    public LinkedList<int[]> selectPawn(){
        //lister les pawns du joueur, select un, puis return 
        
        return pawn.radar();
    }

    public void movePawn(Piece pawn, int[] newpos, Joueur j){
        Iterator<Piece> it = j.pawns.iterator();
        while (it.hasNext()){
            Piece p = it.next();
            if (p.position.equals(newpos)){
                j.deletePawn(p);
            }
            
        }
        //verifier si case occu par ennemi, si oui pawn ennemi =null
        pawn.moves(newpos);
    }

    public void deletePawn(Piece p){
        Iterator<Piece> it = pawns.iterator();
        while (it.hasNext()){
            Piece pawn = it.next();
            if (pawn.equals(p)){
                pawns.remove(pawn);
                break;
            }
        }
    }

    public void pause(){

    }
}
