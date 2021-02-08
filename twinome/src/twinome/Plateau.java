import java.util.Iterator;

public class Plateau {
    
    private int[] dimensions;
    private String sprite;

    public Plateau(int[] topL, int[] botR){
        dimensions = new int[] {botR[0]-topL[0], botR[1]-topL[1]};
    }

    public String isOccupied(int p1, int p2, Joueur j){
        if (Math.min(p1,p2)<1 || Math.max(p1,p2)>11){
            return "nope";
        }
        Iterator<Piece> it = j.pawns.iterator();
        while (it.hasNext()){
            Piece pawn = it.next();
            if (pawn.position[0]==p1 && pawn.position[1]==p2){
                return "nope";
            }
        }
        return "ok";
    }

    public void blit(){

    }

    public void lightUp(){

    }
}
