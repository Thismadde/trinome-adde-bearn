
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trinome;
import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class CubeSpe extends Cube{

    public CubeSpe(boolean fix, Integer[] pos, String team, boolean j){
        super(fix, pos, team,j);
    }

    @Override
    public String getType(){
        return "Cube S ";
    }

    @Override
    public void joker(ArrayList<Piece> pions){
        //pour activer le joker des cubes speciaux 

        if (!frozen){               //si le joker est deja activé on ne fait rien
            int n = 0;              //compteur de pions sur la meme diagonale
            for (Piece p: pions){  //on parcourt toutes les pieces de la meme couleur
                if(p.position[0]-position[0]==p.position[1]-position[1])  //si le pion est  sur la meme diagonale \ 
                    n++;
                }
            if(n<2){ //s'il n'y avait pas assez de pions sur la diagonale \, on verifie ceux sur la diagonale /
                n=0; //on remet le compteur a 0
                for (Piece p: pions){ //on reparcourt tous les pions de la meme couleur
                    if(p.position[0]-position[0]==-p.position[1]+position[1])  
                        n++;
                }
            }
            if (n>1)//s'il y a eu assez de pions sur l'une ou l'autre des diagonales
                jok = true;
        }
    }
}
