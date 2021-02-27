/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package twinome;

/**
 *
 * @author Utilisateur
 */
public class Piece {
    private boolean isDead;
    protected boolean frozen; 
    public int[] position;
    private String color;

    public  Piece(boolean health, boolean fix, int[] pos, String team){
        isDead = health; frozen = fix; position = pos.clone() ; setColor(team);
    }

    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
        if ((getColor().equals("rouge") && position[1]==1 && 4<position[0] && position[0]<8) || (getColor().equals("vert") && position[1]==11 && 4<position[0] && position[0]<8))
            frozen = true;
    }
    
//    public boolean selfConflict(int p1,int p2, Joueur j){
//        Iterator<Piece> it = j.pawns.iterator();
//        while (it.hasNext()){
//            Piece pawn = it.next();
//            if (pawn.position[0]==p1 && pawn.position[1]==p2){
//                return true;
//            }
//        }
//        return false;
//    }
}
