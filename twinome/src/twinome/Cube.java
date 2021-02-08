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

import java.util.LinkedList;

public class Cube extends Piece {
    
    private String sprite;

    public Cube(boolean health, boolean fix, int[] pos, String team){
        super(health, fix, pos, team);
        sprite = "cube.png";//ou un truc du genre
    }
    

//    public void radar(Joueur j){
//        LinkedList<int[]> zbleh = new LinkedList<>();
//        
//        //-1 0
//        if(!selfConflict(position[0]-1,position[1], j)){
//            int[] npos = {position[0]-2,position[1]-2};
//            zbleh.add(npos);
//        }
//        //0 +1
//        if(!selfConflict(position[0],position[1]+1, j)){
//            int[] npos = {position[0]-2,position[1]-2};
//            zbleh.add(npos);
//        }
//        //+1 0
//        if(!selfConflict(position[0]+1,position[1], j)){
//            int[] npos = {position[0]-2,position[1]-2};
//            zbleh.add(npos);
//        }
//        //0 -1
//        if(!selfConflict(position[0],position[1]-1, j)){
//            int[] npos = {position[0]-2,position[1]-2};
//            zbleh.add(npos);
//        }
//    }

    public void blit(){
        
    }
}
