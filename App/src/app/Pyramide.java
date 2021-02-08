/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author clary
 */
public class Pyramide extends Piece {

    private String sprite;
    private String[] options;

    public Pyramide(boolean health, boolean fix, int[] pos, String team){
        super(health, fix, pos, team);
        sprite = "pyramide.png";//ou un truc du genre
    }



<<<<<<< HEAD
    public void radar(Joueur j){
        LinkedList<int[]> zbleh = new LinkedList<>();
        
        //-1 +1
        if(!selfConflict(position[0]-1,position[1]+1, j)){
            int[] npos = {position[0]-1,position[1]+1};
            zbleh.add(npos);
        }
        //-1 -1
        if(!selfConflict(position[0]-1,position[1]-1, j)){
            int[] npos = {position[0]-1,position[1]-1};
            zbleh.add(npos);
        }
        //+1 +1
        if(!selfConflict(position[0]+1,position[1]+1, j)){
            int[] npos = {position[0]+1,position[1]+1};
            zbleh.add(npos);
        }
        //+1 -1
        if(!selfConflict(position[0]+1,position[1]-1, j)){
            int[] npos = {position[0]+1,position[1]-1};
            zbleh.add(npos);
        } else {
            
        }
        
=======
    public void radar(){
>>>>>>> f85dd30ff7cf512d6311453df7e39168dbe562b5

    }

    public void blit(){
        
    }
}
