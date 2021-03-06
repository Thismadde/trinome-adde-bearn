/*TPAA trinome
Mathis Adde
Clarisse Béarn
 */
package app;

import java.util.ArrayList;


/**
 *
 * @author utilisateur
 */
public class PyramSpe extends Pyramide{
    private ArrayList<Piece> samecol;
    private ArrayList<Piece> othercol;

    public PyramSpe(  boolean fix, Integer[] pos, String team, boolean j){
        super(fix, pos, team,j);
    }
@Override
    public String getType(){
        return "Pyramide S ";
    }

    @Override
    public ArrayList<Integer[]> radar(ArrayList<Piece> pionsr, ArrayList<Piece> pionsv){ 

        //de meme que pour pyramide

        if (color.equals("rouge")){
            samecol = (ArrayList<Piece>) pionsr.clone();
            othercol = (ArrayList<Piece>) pionsv.clone();
        }
        else if (color.equals("vert")){
            samecol = (ArrayList<Piece>) pionsv.clone();
            othercol  = (ArrayList<Piece>) pionsr.clone();
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
        if(conflict(position[0]-1,position[1]-1, othercol) && (0<position[0]-2) && (0<position[1]-2) && !conflict(position[0]-2,position[1]-2, samecol) && !conflict(position[0]-2,position[1]-2, othercol)) {  //
            Integer[] npos = {position[0]-2,position[1]-2};                                                                                                     //
            zbleh.add(npos);                                                                                                                                    //
        }                                                                                                                                                       //
        //-2 +2                                                                                                                                                 //
        if(conflict(position[0]-1,position[1]+1, othercol) && (0<position[0]-2) && (position[1]+2<12) && !conflict(position[0]-2,position[1]+2, samecol)&& !conflict(position[0]-2,position[1]+2, othercol)) {  //
            Integer[] npos = {position[0]-2,position[1]+2};                                                                                                     //ici on verifie
            zbleh.add(npos);                                                                                                                                    // si il y a bien un ennemi a 1 case de distance,
        }                                                                                                                                                       // et si la case suivante est libre
        //+2 +2                                                                                                                                                 //
        if(conflict(position[0]+1,position[1]+1, othercol) && (position[0]+2<12) && (position[1]+1<2) && !conflict(position[0]+2,position[1]+2, samecol)&& !conflict(position[0]+2,position[1]+2, othercol))  { //
            Integer[] npos = {position[0]+2,position[1]+2};                                                                                                     //
            zbleh.add(npos);                                                                                                                                    //
        }                                                                                                                                                       //
        //+2 -2                                                                                                                                                 //
        if(conflict(position[0]+1,position[1]-1, othercol) && (position[0]+2<12) && (0<position[1]-2) && !conflict(position[0]+2,position[1]-2, samecol) && !conflict(position[0]+2,position[1]-2, othercol)) {  //
            Integer[] npos = {position[0]+2,position[1]-2};                                                                                                     //
            zbleh.add(npos);                                                                                                                                    //
        }
    
        return zbleh;
    }

}