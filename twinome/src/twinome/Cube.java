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
import java.util.LinkedList;

public class Cube extends Piece {
    
    private String sprite;
    private ArrayList<Piece> sameCol;

    public Cube(boolean health, boolean fix, Integer[] pos, String team){
        super(health, fix, pos, team);
        sprite = "cube.png";//ou un truc du genre
    }
    
    public String getType(){
        return "Cube ";
    }

    @Override
    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){
        if (color.equals("rouge")){
            sameCol = (ArrayList<Piece>) pionsr.clone();
        }
        else if (color.equals("vert")){
            sameCol = (ArrayList<Piece>) pionsv.clone();
        } 

        ArrayList<Integer[]> zbleh = new ArrayList<>();

        //-1 0
        if(!conflict(position[0]-1,position[1], sameCol) && (0<position[0]-1)){
            Integer[] npos = {position[0]-1,position[1]};
            zbleh.add(npos);
        }
        //0 +1
        if(!conflict(position[0],position[1]+1, sameCol) && (position[1]+1<12)){
            Integer[] npos = {position[0],position[1]+1};
            zbleh.add(npos);
        }
        //+1 0
        if(!conflict(position[0]+1,position[1], sameCol) && (position[0]+1<12)){
            Integer[] npos = {position[0]+1,position[1]};
            zbleh.add(npos);
        }
        //0 -1
        if(!conflict(position[0],position[1]-1, sameCol) && (0<position[1]-1)){
            Integer[] npos = {position[0],position[1]-1};
            zbleh.add(npos);
        }
        return zbleh;
    }

    public void blit(){
        
    }
}
