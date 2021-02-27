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

public class SphereSpe extends Sphere {

    public SphereSpe(boolean health, boolean fix, Integer[] pos, String team){
        super(health, fix, pos, team);
    }
    
    public String getType(){
        return "Pyramide S ";
    }


//    @Override
//    public ArrayList<int[]> radar(Plateau plato, Joueur j, Joueur j2){
//        ArrayList<int[]> zbleh = new ArrayList<>();
//        
//        //-2 -2
//        if(plato.isOccupied(position[0]-2,position[1]-2, j).equals("ok") && !selfConflict(-2,-2, j2)){
//            int[] npos = {position[0]-2,position[1]-2};
//            zbleh.add(npos);
//        }
//        //-2 0
//        if(plato.isOccupied(position[0]-2,position[1], j).equals("ok") && !selfConflict(-2,0, j2)){
//            int[] npos = {position[0]-2,position[1]};
//            zbleh.add(npos);
//        }
//        //+2 0
//        if(plato.isOccupied(position[0]+2,position[1], j).equals("ok") && !selfConflict(2,0, j2)){
//            int[] npos = {position[0]+2,position[1]};
//            zbleh.add(npos);
//        }
//        //+2 -2
//        if(plato.isOccupied(position[0]+2,position[1]-2, j).equals("ok") && !selfConflict(2,-2, j2)){
//            int[] npos = {position[0]+2,position[1]-2};
//            zbleh.add(npos);
//        }
//        //0 -2
//        if(plato.isOccupied(position[0],position[1]-2, j).equals("ok") && !selfConflict(0,-2, j2)){
//            int[] npos = {position[0],position[1]-2};
//            zbleh.add(npos);
//        }
//        if (zbleh.isEmpty()) {
//            
//            //-2 +2
//            if(plato.isOccupied(position[0]-2,position[1]+2, j).equals("ok") && !selfConflict(-2,2, j2)){
//                int[] npos = {position[0]-2,position[1]+2};
//                zbleh.add(npos);
//            }
//            //0 +2 
//            if(plato.isOccupied(position[0],position[1]+2, j).equals("ok") && !selfConflict(0,2, j2)){
//                int[] npos = {position[0],position[1]+2};
//                zbleh.add(npos);
//            }
//            //+2 +2
//            if(plato.isOccupied(position[0]+2,position[1]+2, j).equals("ok") && !selfConflict(2,2, j2)){
//                int[] npos = {position[0]+2,position[1]+2};
//                zbleh.add(npos);
//            }
//        }
//        return zbleh;
//    }
    
}