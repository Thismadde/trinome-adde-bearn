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
public class CubeSpe extends Cube{

    public CubeSpe(boolean health, boolean fix, Integer[] pos, String team){
        super(health, fix, pos, team);
    }

    @Override
    public String getType(){
        return "Cube S ";
    }

    public void joker(ArrayList<Piece> pions){
        if (!frozen){
            int n = 0;
            for (Piece p: pions){
                if(p.position[0]-position[0]==p.position[1]-position[1])
                    n++;
            }
            if(n<2){
                n=0;
                for (Piece p: pions){
                    if(p.position[0]-position[0]==-p.position[1]+position[1])
                        n++;
                }
            }
            if (n>1)
                jok = true;
        }
    }
}
