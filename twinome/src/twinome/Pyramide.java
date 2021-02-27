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
public class Pyramide extends Piece{
    private String sprite;
    private String[] options;

    public Pyramide(boolean health, boolean fix, int[] pos, String team){
        super(health, fix, pos, team);
        sprite = "pyramide.png";//ou un truc du genre
    }



    public void radar(){

    }

    public void blit(){
        
    }
}
