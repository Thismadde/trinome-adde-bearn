/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.LinkedList;

/**
 *
 * @author clary
 */
public class CubeSpe extends Cube{

    public CubeSpe(boolean health, boolean fix, int[] pos, String team) {
        super(health, fix, pos, team);
    }
    
        @Override
    public void radar(Joueur j){
        LinkedList<int[]> zbleh = new LinkedList<>();
        
        //-1 0
        if(!selfConflict(position[0]-1,position[1], j)){
            int[] npos = {position[0]-1,position[1]};
            zbleh.add(npos);
        }
        //0 +1
        if(!selfConflict(position[0],position[1]+1, j)){
            int[] npos = {position[0],position[1]+1};
            zbleh.add(npos);
        }
        //+1 0
        if(!selfConflict(position[0]+1,position[1], j)){
            int[] npos = {position[0]+1,position[1]};
            zbleh.add(npos);
        }
        //0 -1
        if(!selfConflict(position[0],position[1]-1, j)){
            int[] npos = {position[0],position[1]-1};
            zbleh.add(npos);
        }
   
            
        }
    }  
      
