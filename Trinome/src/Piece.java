public class Piece {
    
    private boolean isDead;
    private boolean frozen; 
    private int[] position;
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
}
