/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author utilisateur
 */
import java.util.ArrayList;


public class Cube extends Piece {
    
    private ArrayList<Piece> sameCol;

    public Cube( boolean fix, Integer[] pos, String team, boolean j){
        super(fix, pos, team,j);
    }
    
    public String getType(){
        return "Cube ";
    }

    @Override
    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){

        // renvoie les cases ou le pion peut aller


        if (color.equals("rouge")){                                 //
            sameCol = (ArrayList<Piece>) pionsr.clone();            //
        }                                                           // selon la couleur du pion, on etudiera une liste differente
        else if (color.equals("vert")){                             //
            sameCol = (ArrayList<Piece>) pionsv.clone();            //
        } 

        ArrayList<Integer[]> zbleh = new ArrayList<>();   //liste des cases atteignables disponibles

        //-1 0    <= deplacement testé sur lase de coordonnées [x-1,y]
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

    public void blit(){ //pour l'interface graphique peut-etre
        
    }
}
