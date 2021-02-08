import java.util.Iterator;

public class Piece {
    
    private boolean isDead;
    protected boolean frozen; 
    public int[] position;
    private String color;

    public  Piece(boolean health, boolean fix, int[] pos, String team){
        isDead = health; frozen = fix; position = pos.clone() ; color = team;
    }

    public void dies(){
        isDead = true;
    }

    public void freezes(){
        frozen = true;
    }

    public void cirle(){
        //dessiner un cercle autour du pion
    }
   
    public void moves(int[] newpos){
        position= newpos.clone();
        if ((color.equals("rouge") && position[1]==1 && 4<position[0] && position[0]<8) || (color.equals("vert") && position[1]==11 && 4<position[0] && position[0]<8))
            frozen = true;
    }
    
    public boolean selfConflict(int p1,int p2, Joueur j){
        Iterator<Piece> it = j.pawns.iterator();
        while (it.hasNext()){
            Piece pawn = it.next();
            if (pawn.position[0]==p1 && pawn.position[1]==p2){
                return true;
            }
        }
        return false;
    }
    
}
