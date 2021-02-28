import java.util.ArrayList;

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
public class PyramSpe extends Pyramide{
    
    private ArrayList<Piece> samecol;

    public PyramSpe(boolean health, boolean fix, Integer[] pos, String team){
        super(health, fix, pos, team);
    }
@Override
    public String getType(){
        return "Pyramide S ";
    }

    @Override
    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){
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

        //-2 -2
        if(conflict(position[0]-1,position[1]-1, samecol) && (0<position[0]-2) && (0<position[1]-2)){
            Integer[] npos = {position[0]-2,position[1]-2};
            zbleh.add(npos);
        }
        //-2 +2
        if(conflict(position[0]-1,position[1]+1, samecol) && (0<position[0]-2) && (position[1]+2<12)){
            Integer[] npos = {position[0]-2,position[1]+2};
            zbleh.add(npos);
        }
        //+2 +2
        if(conflict(position[0]+1,position[1]+1, samecol) && (position[0]+2<12) && (position[1]+1<2)){
            Integer[] npos = {position[0]+2,position[1]+2};
            zbleh.add(npos);
        }
        //+2 -2
        if(conflict(position[0]+1,position[1]-1, samecol) && (position[0]+2<12) && (0<position[1]-2)){
            Integer[] npos = {position[0]+2,position[1]-2};
            zbleh.add(npos);
        }
    
        return zbleh;
    }

}
