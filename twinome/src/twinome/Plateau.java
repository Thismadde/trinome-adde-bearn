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

import java.util.ArrayList;
import java.util.Iterator;

public class Plateau {
    
    public ArrayList<Piece> pions;
    private String sprite;

    public Plateau(){
        pions = new ArrayList<Piece>();
    }

//    public String isOccupied(int p1, int p2, Joueur j){
//        if (Math.min(p1,p2)<1 || Math.max(p1,p2)>11){
//            return "nope";
//        }
//        Iterator<Piece> it = j.pawns.iterator();
//        while (it.hasNext()){
//            Piece pawn = it.next();
//            if (pawn.position[0]==p1 && pawn.position[1]==p2){
//                return "nope";
//            }
//        }
//        return "ok";
//    }

    public void blit(){

    }

    public void lightUp(){

    }
}
