import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
    public Integer[] position;
    public String color;

    public  Piece(boolean health, boolean fix, Integer[] pos, String team){
        isDead = health; frozen = fix; position = pos.clone() ; setColor(team);
    }

    public String getColor() {
		return color;
	}

    public String getType(){
        return "Piepiece";
    }

	public void setColor(String color) {
		this.color = color;
	}

	public void dies(){
        isDead = true;
    }

    public void cirle(){
        //dessiner un cercle autour du pion
    }
   
    public void movesEnd(Integer[] newpos){
        position= newpos.clone();
        if ((getColor().equals("rouge") && position[1]==1 && 4<position[0] && position[0]<8) || (getColor().equals("vert") && position[1]==11 && 4<position[0] && position[0]<8))
            frozen = true;
    }

    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){
        System.out.println("Piece mal définie(je crois)");
        return new ArrayList<>();
    }
    
    public boolean conflict(int p1,int p2, ArrayList<Piece> pions){
        Iterator<Piece> it = pions.iterator();
        while (it.hasNext()){
            Piece pawn = it.next();
            if (pawn.position[0]==p1 && pawn.position[1]==p2){
                return true;
            }
        }
        return false;
    }
}
