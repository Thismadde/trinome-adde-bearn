/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;


/**
 *
 * @author utilisateur
 */
public class Pyramide extends Piece {

    private String sprite;
    private ArrayList<Piece> samecol;

    public Pyramide( boolean fix, Integer[] pos, String team, boolean j){
        super( fix, pos, team,j);
        sprite = "pyramide.png";//ou un truc du genre
    }

    @Override
    public String getType(){
        return "Pyramide ";
    }
    
    @Override
    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){

        //renvoie la liste des cases ou le pion peut aller
        // meme principe que pour le cube, seul les cases testées changent
        
        if (color.equals("rouge")){
            samecol = (ArrayList<Piece>) pionsr.clone();
        }
        else if (color.equals("vert")){
            samecol = (ArrayList<Piece>) pionsv.clone();
        } 

        ArrayList<Integer[]> zbleh = new ArrayList<>();
        
        //-1 -1
        if(!conflict(position[0]-1,position[1]-1, samecol) && (0<position[0]-1) && (0<position[1]-1)){
            Integer[] npos = {position[0]-1,position[1]-1};
            zbleh.add(npos);
        }
        //-1 +1
        if(!conflict(position[0]-1,position[1]+1, samecol) && (0<position[0]-1) && (position[1]+1<12)){
            Integer[] npos = {position[0]-1,position[1]+1};
            zbleh.add(npos);
        }
        //+1 +1
        if(!conflict(position[0]+1,position[1]+1, samecol) && (position[0]+1<12) && (position[1]+1<12)){
            Integer[] npos = {position[0]+1,position[1]+1};
            zbleh.add(npos);
        }
        //+1 -1
        if(!conflict(position[0]+1,position[1]-1, samecol) && (position[0]+1<12) && (0<position[1]-1)){
            Integer[] npos = {position[0]+1,position[1]-1};
            zbleh.add(npos);
        }
    
        return zbleh;
    }
    
    public void blit(){
        
    }
}
