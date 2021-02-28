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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Plateau {
    
    public ArrayList<Piece> pionsr; //liste des pions rouges
    public ArrayList<Piece> pionsv; //liste des pions verts
    public boolean cfroze;
    public boolean pfroze;
    public boolean sfroze;


    public Plateau(){
        pionsr = new ArrayList<Piece>();
        pionsv = new ArrayList<Piece>();
    }

    public boolean endGame(){       //verification des conditions pour finir la partie

        int ns = 0; int np = 0; int nc = 0;
        for (Piece p: pionsr){  //on parcourt tous les pions rouges pour voir si on a au moins un pion de chaque type principal, s'il y en a des figés en zone rouge
            if (p.getType().equals("Cube ")||p.getType().equals("Cube S "))
                nc++;
            if (p.getType().equals("Pyramide ")||p.getType().equals("Pyramide S "))
                np++;
            if (p.getType().equals("Sphere ")||p.getType().equals("Sphere S "))
                ns++;
            if (p.getType().equals("Cube ")||p.getType().equals("Cube S ")&&p.frozen)
                cfroze=true;
            if (p.getType().equals("Pyramide ")||p.getType().equals("Pyramide S ")&&p.frozen)
                pfroze=true;
            if (p.getType().equals("Sphere ")||p.getType().equals("Sphere S ")&&p.frozen)
                sfroze=true;
            if (p.getType().equals("Cube S ")&& p.position[0]==11 && 4<p.position[1] && p.position[1]<8) //cas particulier pour les pions speciaux qui ont le joker actif, ils ne peuvent etre frozen
                cfroze=true;

        }
        if (sfroze&&cfroze&&pfroze){  //si trois pions sont confirmés en zone rouge
            System.out.println("Gagnant designé!");
            return true;
        }
        cfroze = sfroze = pfroze =false; //reset pour tester les verts
        if (nc==0||np==0||ns==0)  //si une des categories est vide, alors la fin de partie est true
            return true;

        ns = 0; np = 0; nc = 0;
        for (Piece p: pionsv){  //pareil pour les verts
            if (p.getType().equals("Cube ")||p.getType().equals("Cube S "))
                nc++;
            if (p.getType().equals("Pyramide ")||p.getType().equals("Pyramide S "))
                np++;
            if (p.getType().equals("Sphere ")||p.getType().equals("Sphere S "))
                ns++;
            if (p.getType().equals("Cube ")||p.getType().equals("Cube S ")&&p.frozen)
                cfroze=true;
            if (p.getType().equals("Pyramide ")||p.getType().equals("Pyramide S ")&&p.frozen)
                pfroze=true;
            if (p.getType().equals("Sphere ")||p.getType().equals("Sphere S ")&&p.frozen)
                sfroze=true;
            if (p.getType().equals("Cube S ")&& p.position[0]==1 && 4<p.position[1] && p.position[1]<8)
                cfroze=true;

        }
        if (nc==0||np==0||ns==0)
            return true;

        if (sfroze&&cfroze&&pfroze){
            System.out.println("Gagnant designé!");
            return true;
        }
        cfroze = sfroze = pfroze =false;

        return false;
    }


    public void movePawn(Piece pawn, Integer[] newpos, int tour){
        pawn.movesEnd(newpos);   //passage a frozen si besoin, et changement des coordonées

        if(tour==1){ //tour du rouge
            Iterator<Piece> it = pionsv.iterator();
            while (it.hasNext()){  //si un pion adverse est sur la case d'arrivée, on le supprime
                Piece p = it.next();
                if (Arrays.equals(p.position,newpos)){
                    deletePawn(p);
                    return;
                }
            }
        }
        else{ //tour du vert, et on fait pareil
            Iterator<Piece> it = pionsr.iterator();
            while (it.hasNext()){
                Piece p = it.next();
                if (p.position[0]==newpos[0]&&p.position[1]==newpos[1]){
                    deletePawn(p);
                    return;
                }
            }
        }
    }

    public void blitMatrix(){  //afficher le tableau sous forme de matrice dans la console

        String[][] a = new String[11][11]; //on genere une nouvelle matrice a chaque fois, 
        //car quand on avait essaye de la mettre en parametre de classe on arrivait pas a la vider puis la reremplir, donc c'est plus simple comme ca on a une page vierge a chaque fois

        Iterator<Piece> it = pionsr.iterator();
        while (it.hasNext()){//on remplit les cases correspondants aux coordonees des pions avec les infos necessaires pour les rouges...
            Piece pion =it.next();
            int x = pion.position[0];
            int y = pion.position[1];
            a[x-1][y-1] = pion.getType()+pion.getColor();
        }
        
        Iterator<Piece> it2 = pionsv.iterator(); //...puis pour les verts
        while (it2.hasNext()){
            Piece pion =it2.next();
            int x = pion.position[0];
            int y = pion.position[1];
            a[x-1][y-1] = pion.getType()+pion.getColor();
        }

        //les cases non affectées par ces deux boucles restent a null
        
        for (int i=0; i<11;i++){         
            for (int j=0; j<11; j++){//on parcourt chacune des cases de la matrice et on l'affiche
                if (a[i][j]==null){
                System.out.print("      x       | ");
                }
                else{
                    System.out.print(a[i][j]+" | ");
                }
            }
            System.out.println(System.lineSeparator());
        }
        
        
    }

    public void newGame(boolean type){ //fonction qui place les pions a des endroits predeterminés; la fonction chargement de sauvegarde a venir fera pareil, mais avec comme argument pour les pieces ce qu'il y aura dans le doc txt

        Cube p = new Cube(true, false, new Integer[] {10,4}, "rouge");
        pionsr.add(p);
        Cube p2 = new Cube(true, false, new Integer[] {8,3}, "rouge");
        pionsr.add(p2);
        Cube p3 = new Cube(true, false, new Integer[] {1,9}, "rouge");
        pionsr.add(p3);
        Cube p4 = new Cube (true, false, new Integer[] {2,10}, "rouge");
        pionsr.add(p4);
        Cube p5 = new Cube (true, false, new Integer[] {3,11}, "rouge");
        pionsr.add(p5);
        Sphere p7 = new Sphere(true, false, new Integer[] {1,5}, "rouge");
        pionsr.add(p7);
        Sphere p8 = new Sphere(true, false, new Integer[] {1,7}, "rouge");
        pionsr.add(p8);
        Pyramide p9 = new Pyramide(true, false, new Integer[] {1,1}, "rouge");
        pionsr.add(p9); 
        Pyramide p10 = new Pyramide(true, false, new Integer[] {1,2}, "rouge");
        pionsr.add(p10); 
        Pyramide p11 = new Pyramide(true, false, new Integer[] {2,1}, "rouge");
        pionsr.add(p11); 
        Pyramide p12 = new Pyramide(true, false, new Integer[] {1,10}, "rouge");
        pionsr.add(p12); 
        Pyramide p13 = new Pyramide(true, false, new Integer[] {2,11}, "rouge");
        pionsr.add(p13);
        
        Cube vp = new Cube(true, false, new Integer[] {9,1}, "vert");
        pionsv.add(vp);
        Cube vp2 = new Cube(true, false, new Integer[] {11,3}, "vert");
        pionsv.add(vp2);
        Cube vp3 = new Cube(true, false, new Integer[] {11,9}, "vert");
        pionsv.add(vp3);
        Cube vp4 = new Cube (true, false, new Integer[] {10,10}, "vert");
        pionsv.add(vp4);
        Cube vp5 = new Cube (true, false, new Integer[] {9,11}, "vert");
        pionsv.add(vp5);
        Sphere vp7 = new Sphere(true, false, new Integer[] {11,5}, "vert");
        pionsv.add(vp7);
        Sphere vp8 = new Sphere(true, false, new Integer[] {11,7}, "vert");
        pionsv.add(vp8);
        Pyramide vp9 = new Pyramide(true, false, new Integer[] {11,1}, "vert");
        pionsv.add(vp9); 
        Pyramide vp10 = new Pyramide(true, false, new Integer[] {11,2}, "vert");
        pionsv.add(vp10); 
        Pyramide vp11 = new Pyramide(true, false, new Integer[] {10,1}, "vert");
        pionsv.add(vp11); 
        Pyramide vp12 = new Pyramide(true, false, new Integer[] {10,11}, "vert");
        pionsv.add(vp12); 
        Pyramide vp13 = new Pyramide(true, false, new Integer[] {11,10}, "vert");
        pionsv.add(vp13);
        if (!type){                                                                 //si on choisit une partie avec pions speciaux
            CubeSpe p6 = new CubeSpe( true, false, new Integer[] {11,4}, "rouge");
            pionsr.add(p6);
            PyramSpe p14 = new PyramSpe(true, false, new Integer[] {1,11}, "rouge");
            pionsr.add(p14);
            SphereSpe p15 = new SphereSpe(true, false, new Integer[] {1,6}, "rouge");
            pionsr.add(p15);
            CubeSpe vp6 = new CubeSpe( true, false, new Integer[] {10,2}, "vert");
            pionsv.add(vp6);
            PyramSpe vp14 = new PyramSpe(true, false, new Integer[] {11,11}, "vert");
            pionsv.add(vp14);
            SphereSpe vp15 = new SphereSpe(true, false, new Integer[] {11,6}, "vert");
            pionsv.add(vp15);
        }
        else{                                                                        //partie normale
            Cube p6 = new Cube( true, false, new Integer[] {2,2}, "rouge");
            pionsr.add(p6);
            Pyramide p14 = new Pyramide(true, false, new Integer[] {1,11}, "rouge");
            pionsr.add(p14);
            Sphere p15 = new Sphere(true, false, new Integer[] {1,6}, "rouge");
            pionsr.add(p15);
            Cube vp6 = new Cube( true, false, new Integer[] {10,2}, "vert");
            pionsv.add(vp6);
            Pyramide vp14 = new Pyramide(true, false, new Integer[] {11,11}, "vert");
            pionsv.add(vp14);
            Sphere vp15 = new Sphere(true, false, new Integer[] {11,6}, "vert");
            pionsv.add(vp15);
        }
    }
    
    public Piece selectPawn(int tour, Scanner sc){
        
        boolean b = true; //condition pour sortir de la boucle
        do{
            int i = 1;
            if (tour==1){ //le tour 1 est associé au joeur rouge
                System.out.println("Tour du joueur rouge");
                Iterator<Piece> it = pionsr.iterator();
                while (it.hasNext()){
                    Piece p = it.next();
                    System.out.println(Arrays.toString(p.position)+i); //on affiche toutes les pieces du joueur, avec leur numero dans la liste qui est i
                    i++;
                }
                System.out.println("mettre numero du point choisi");
                Piece a = pionsr.get(sc.nextInt()-1); //on recupere le pion specifié
                if (!a.frozen||a.jok) //s'il n'est pas figé, on le renvoie
                    return a;
            }
            else{       //si tour n'est pas 1 mais 0 on arrive ici, et on refait pareil mais pour le joueur vert
                System.out.println("Tour du joueur vert");
                Iterator<Piece> it = pionsv.iterator();
                while (it.hasNext()){
                    Piece p = it.next();
                    System.out.println(Arrays.toString(p.position)+i);
                    i++;
                }
                System.out.println("mettre numero du point choisi");
                Piece a = pionsv.get(sc.nextInt()-1);
                if (!a.frozen||a.jok)
                    return a;
            }
            System.out.println("ce pion est figé!"); //si le pion est figé on arrive ultimement ici, et on recommence la boucle sans changer de joueur du coup
        }while (b);
        return pionsr.get(1);//juste pour que Java soit content; on n'y arrive jamais, b etant toujours true
    }

    public void deletePawn(Piece pawn){
        pionsr.remove(pawn);    //on essaie d'effacer le pion specifié indifferement dans chaque liste, car les listes ne sont pas grosses
        pionsv.remove(pawn);
    }

    public void blit(){

    }

}
