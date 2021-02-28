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

    private String sprite;
    private ArrayList<Piece> sameCoL;
    private ArrayList<Piece> otherCol;

    public SphereSpe(boolean health, boolean fix, Integer[] pos, String team){
        super(health, fix, pos, team);
    }
    
    @Override
    public String getType(){
        return "Pyramide S ";
    }

    @Override
    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){
        if (color.equals("rouge")){
            sameCoL = (ArrayList<Piece>) pionsr.clone();
            otherCol = (ArrayList<Piece>) pionsv.clone();
        }
        else if (color.equals("vert")){
            sameCoL = (ArrayList<Piece>) pionsv.clone();
            otherCol = (ArrayList<Piece>) pionsr.clone();
        } 

        ArrayList<Integer[]> zbleh = new ArrayList<>();
        
        //-2 0
        if(!conflict(position[0]-2,position[1], otherCol) && !conflict(position[0]-2,position[1]+0, sameCoL) && (0<position[0]-2)){
            Integer[] npos = {position[0]-2,position[1]};
            zbleh.add(npos);
        }
        //-2 +2
        if(!conflict(position[0]-2,position[1]+2, otherCol) && !conflict(position[0]-2,position[1]+2, sameCoL) && (0<position[0]-2) && (position[1]+2)<12){
            Integer[] npos = {position[0]-2,position[1]+2};
            zbleh.add(npos);
        }
        //0 +2 
        if(!conflict(position[0],position[1]+2, otherCol) && !conflict(position[0],position[1]+2, sameCoL) && (position[1]+2<12)){
            Integer[] npos = {position[0],position[1]+2};
            zbleh.add(npos);
        }
        //+2 +2
        if(!conflict(position[0]+2,position[1]+2, otherCol) && !conflict(position[0]+2,position[1]+2, sameCoL) && (position[0]+2<12) && (position[1]+2<12)){
            Integer[] npos = {position[0]+2,position[1]+2};
            zbleh.add(npos);
        }
        //+2 0
        if(!conflict(position[0]+2,position[1], otherCol) && !conflict(position[0]+2,position[1]+0, sameCoL) && (position[0]+2<12)){
            Integer[] npos = {position[0]+2,position[1]};
            zbleh.add(npos);
        }
        if (zbleh.isEmpty()) {
            //+2 -2
            if(!conflict(position[0]+2,position[1]-2, otherCol) && !conflict(position[0]+2,position[1]-2, sameCoL) && (position[0]+2<12) && (0<position[1]-2)){
                Integer[] npos = {position[0]+2,position[1]-2};
                zbleh.add(npos);
            }
            //0 -2
            if(!conflict(position[0],position[1]-2, otherCol) && !conflict(position[0],position[1]-2, sameCoL) && (0<position[1]-2)){
                Integer[] npos = {position[0],position[1]-2};
                zbleh.add(npos);
            }
            //-2 -2
            if(!conflict(position[0]-2,position[1]-2, otherCol) && !conflict(position[0]-2,position[1]-2, sameCoL) && (0<position[0]-2) && (0<position[1]-2)){
                Integer[] npos = {position[0]-2,position[1]-2};
                zbleh.add(npos);
            }

        }
        return zbleh;
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