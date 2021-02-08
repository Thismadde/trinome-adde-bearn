/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twinome;

/**
 *
 * @author Utilisateur
 */
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Sphere extends Piece {
    
    private String sprite;

    public Sphere(boolean health, boolean fix, int[] pos, String team){
        super(health, fix, pos, team);
        sprite = "sphere.png";//ou un truc du genre
    }


//    public ArrayList<int[]> radar(Plateau plato, Joueur j, Joueur j2){
//        ArrayList<int[]> zbleh = new ArrayList<>();
//        
//        //-2 -2
//        if(plato.isOccupied(position[0]-2,position[1]-2, j).equals("ok") && !selfConflict(position[0]-2,position[1]-2, j2)){
//            int[] npos = {position[0]-2,position[1]-2};
//            zbleh.add(npos);
//        }
//        //-2 0
//        if(plato.isOccupied(position[0]-2,position[1], j).equals("ok") && !selfConflict(position[0]-2,position[1]+0, j2)){
//            int[] npos = {position[0]-2,position[1]};
//            zbleh.add(npos);
//        }
//        //-2 +2
//        if(plato.isOccupied(position[0]-2,position[1]+2, j).equals("ok") && !selfConflict(position[0]-2,position[1]+2, j2)){
//            int[] npos = {position[0]-2,position[1]+2};
//            zbleh.add(npos);
//        }
//        //0 +2 
//        if(plato.isOccupied(position[0],position[1]+2, j).equals("ok") && !selfConflict(position[0],position[1]+2, j2)){
//            int[] npos = {position[0],position[1]+2};
//            zbleh.add(npos);
//        }
//        //+2 +2
//        if(plato.isOccupied(position[0]+2,position[1]+2, j).equals("ok") && !selfConflict(position[0]+2,position[1]+2, j2)){
//            int[] npos = {position[0]+2,position[1]+2};
//            zbleh.add(npos);
//        }
//        //+2 0
//        if(plato.isOccupied(position[0]+2,position[1], j).equals("ok") && !selfConflict(position[0]+2,position[1]+0, j2)){
//            int[] npos = {position[0]+2,position[1]};
//            zbleh.add(npos);
//        }
//        //+2 -2
//        if(plato.isOccupied(position[0]+2,position[1]-2, j).equals("ok") && !selfConflict(position[0]+2,position[1]-2, j2)){
//            int[] npos = {position[0]+2,position[1]-2};
//            zbleh.add(npos);
//        }
//        //0 -2
//        if(plato.isOccupied(position[0],position[1]-2, j).equals("ok") && !selfConflict(position[0],position[1]-2, j2)){
//            int[] npos = {position[0],position[1]-2};
//            zbleh.add(npos);
//        }
//
//        return zbleh;
//    }

    public void blit(){
        
    }
}
