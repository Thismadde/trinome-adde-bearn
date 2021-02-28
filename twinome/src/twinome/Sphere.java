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
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sphere extends Piece {
    private String sprite;
    private ArrayList<Piece> sameCoL;
    private ArrayList<Piece> otherCol;

    public Sphere(boolean health, boolean fix, Integer[] pos, String team){
        super(health, fix, pos, team);
        sprite = "sphere.png";//ou un truc du genre
    }

    @Override
    public String getType(){
        return "Sphere ";
    }

    @Override
    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){

        
        // renvoie les cases ou le pion peut aller

 

        if (color.equals("rouge")){                                             //selon la couleur du pion on attribue aux deux listes pionsr et pionsv des noms differents (on les clone sous des noms differents en fait)
            sameCoL = (ArrayList<Piece>) pionsr.clone();                        //et apres relecture je me rend compte que ca ne sert a rien, genre vraiment on fait la meme chose aux deux...
            otherCol = (ArrayList<Piece>) pionsv.clone();
        }
        else if (color.equals("vert")){
            sameCoL = (ArrayList<Piece>) pionsv.clone();
            otherCol = (ArrayList<Piece>) pionsr.clone();
        } 

        ArrayList<Integer[]> zbleh = new ArrayList<>();         //liste des cases atteignables disponibles
        
        //-2 -2
        if(!conflict(position[0]-2,position[1]-2, otherCol) && !conflict(position[0]-2,position[1]-2, sameCoL) && (0<position[0]-2) && (0<position[1]-2)){
            Integer[] npos = {position[0]-2,position[1]-2};
            zbleh.add(npos);
        }
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

        return zbleh;
    }

        public void blit(){
        
    }
}
