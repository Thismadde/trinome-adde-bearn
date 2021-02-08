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
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur {
    
    private String name;
    public ArrayList<Piece> pawns;
    private String color;

    public Joueur(String n, String c){
        name = n; color = c;
    }

    public ArrayList<int[]> selectPawn(){
        //lister les pawns du joueur, select un, puis return 
        for (int i=0; i<pawns.size();i++){
            System.out.println(Arrays.toString(pawns.get(i).position));
        }
        Scanner sc = new Scanner(System.in);
        int popos1 = sc.nextInt(); int popos2 = sc.nextInt();
        pawns.;
        return pawn.radar();
    }

    public void movePawn(Piece pawn, int[] newpos, Joueur j){
        Iterator<Piece> it = j.pawns.iterator();
        while (it.hasNext()){
            Piece p = it.next();
            if (p.position.equals(newpos)){
                j.deletePawn(p);
            }
            
        }
        //verifier si case occu par ennemi, si oui pawn ennemi =null
        pawn.moves(newpos);
    }

    public void deletePawn(Piece p){
        Iterator<Piece> it = pawns.iterator();
        while (it.hasNext()){
            Piece pawn = it.next();
            if (pawn.equals(p)){
                pawns.remove(pawn);
                break;
            }
        }
    }

    public void pause(){

    }
}
