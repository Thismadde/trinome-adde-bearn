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
    public String getType(){
        return "Cube S ";
    }


}
