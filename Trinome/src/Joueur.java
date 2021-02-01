import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Joueur {
    
    private String name;
    private LinkedList<Piece> pawns;
    private String color;

    public Joueur(String n, String c){
        name = n; color = c;
    }

    public int[][] selectPawn(){
        //return pawn.radar();
    }

    public void movePawn(Piece pawn, int[] newpos, Joueur j){
        Iterator<Piece> it = j.pawns.iterator();
        while (it.hasNext()){
            Piece p = it.next();
            if (p.position.equals(newpos){
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
            if (pawn.equals(p){
                pawn =null;
            }
    }

    public void pause(){

    }
}
