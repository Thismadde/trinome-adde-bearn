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
public class PyramSpe extends Pyramide{
    
    public PyramSpe(boolean health, boolean fix, Integer[] pos, String team){
        super(health, fix, pos, team);
    }
@Override
    public String getType(){
        return "Pyramide S ";
    }


}
