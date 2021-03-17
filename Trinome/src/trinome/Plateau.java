/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trinome;

/**
 *
 * @author Utilisateur
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
        pionsr = new ArrayList<>();
        pionsv = new ArrayList<>();
    }

    public boolean endGame(){       //verification des conditions pour finir la partie

        int ns = 0; 
        int np = 0; 
        int nc = 0;
        for (Piece p: pionsr){  //on parcourt tous les pions rouges pour voir si on a au moins un pion de chaque type principal, 
                                //s'il y en a des figés en zone rouge
            if (p.getType().equals("Cube ")||p.getType().equals("Cube S "))
                nc++;
            if (p.getType().equals("Pyramide ")||p.getType().equals("Pyramide S "))
                np++;
            if (p.getType().equals("Sphere ")||p.getType().equals("Sphere S "))
                ns++;
            if (p.frozen&&(p.getType().equals("Cube ")||p.getType().equals("Cube S ")))
                cfroze=true;
            if (p.frozen&&(p.getType().equals("Pyramide ")||p.getType().equals("Pyramide S ")))
                pfroze=true;
            if (p.frozen&&(p.getType().equals("Sphere ")||p.getType().equals("Sphere S ")))
                sfroze=true;
            //cas particulier pour les pions speciaux qui ont le joker actif, ils ne peuvent etre frozen
            if (p.getType().equals("Cube S ")&& p.position[0]==11 && 4<p.position[1] && p.position[1]<8) 
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
            if (p.frozen&&(p.getType().equals("Cube ")||p.getType().equals("Cube S ")))
                cfroze=true;
            if (p.frozen&&(p.getType().equals("Pyramide ")||p.getType().equals("Pyramide S ")))
                pfroze=true;
            if (p.frozen&&(p.getType().equals("Sphere ")||p.getType().equals("Sphere S ")))
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
        //car quand on avait essaye de la mettre en parametre de classe on arrivait pas a la vider puis la reremplir, 
        //donc c'est plus simple comme ca on a une page vierge a chaque fois

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

    public void newGame(boolean type){ //fonction qui place les pions a des endroits predeterminés; 


        Cube p = new Cube(false, new Integer[] {3,1}, "rouge",false);
        pionsr.add(p);
        Cube p2 = new Cube(false, new Integer[] {1,3}, "rouge",false);
        pionsr.add(p2);
        Cube p3 = new Cube(false, new Integer[] {1,9}, "rouge",false);
        pionsr.add(p3);
        Cube p4 = new Cube (false, new Integer[] {2,10}, "rouge",false);
        pionsr.add(p4);
        Cube p5 = new Cube (false, new Integer[] {3,11}, "rouge",false);
        pionsr.add(p5);
        Sphere p7 = new Sphere(false, new Integer[] {1,5}, "rouge",false);
        pionsr.add(p7);
        Sphere p8 = new Sphere(false, new Integer[] {1,7}, "rouge",false);
        pionsr.add(p8);
        Pyramide p9 = new Pyramide(false, new Integer[] {1,1}, "rouge",false);
        pionsr.add(p9); 
        Pyramide p10 = new Pyramide(false, new Integer[] {1,2}, "rouge",false);
        pionsr.add(p10); 
        Pyramide p11 = new Pyramide(false, new Integer[] {2,1}, "rouge",false);
        pionsr.add(p11); 
        Pyramide p12 = new Pyramide(false, new Integer[] {1,10}, "rouge",false);
        pionsr.add(p12); 
        Pyramide p13 = new Pyramide(false, new Integer[] {2,11}, "rouge",false);
        pionsr.add(p13);
        
        Cube vp = new Cube(false, new Integer[] {9,1}, "vert",false);
        pionsv.add(vp);
        Cube vp2 = new Cube(false, new Integer[] {11,3}, "vert",false);
        pionsv.add(vp2);
        Cube vp3 = new Cube(false, new Integer[] {11,9}, "vert",false);
        pionsv.add(vp3);
        Cube vp4 = new Cube (false, new Integer[] {10,10}, "vert",false);
        pionsv.add(vp4);
        Cube vp5 = new Cube (false, new Integer[] {9,11}, "vert",false);
        pionsv.add(vp5);
        Sphere vp7 = new Sphere(false, new Integer[] {11,5}, "vert",false);
        pionsv.add(vp7);
        Sphere vp8 = new Sphere(false, new Integer[] {11,7}, "vert",false);
        pionsv.add(vp8);
        Pyramide vp9 = new Pyramide(false, new Integer[] {11,1}, "vert",false);
        pionsv.add(vp9); 
        Pyramide vp10 = new Pyramide(false, new Integer[] {11,2}, "vert",false);
        pionsv.add(vp10); 
        Pyramide vp11 = new Pyramide(false, new Integer[] {10,1}, "vert",false);
        pionsv.add(vp11); 
        Pyramide vp12 = new Pyramide(false, new Integer[] {10,11}, "vert",false);
        pionsv.add(vp12); 
        Pyramide vp13 = new Pyramide(false, new Integer[] {11,10}, "vert",false);
        pionsv.add(vp13);
        if (type){                                                        //si on choisit une partie avec pions speciaux
            CubeSpe p6 = new CubeSpe( false, new Integer[] {2,2}, "rouge",false);
            pionsr.add(p6);
            PyramSpe p14 = new PyramSpe(false, new Integer[] {1,11}, "rouge",false);
            pionsr.add(p14);
            SphereSpe p15 = new SphereSpe(false, new Integer[] {1,6}, "rouge",false);
            pionsr.add(p15);
            CubeSpe vp6 = new CubeSpe( false, new Integer[] {10,2}, "vert",false);
            pionsv.add(vp6);
            PyramSpe vp14 = new PyramSpe(false, new Integer[] {11,11}, "vert",false);
            pionsv.add(vp14);
            SphereSpe vp15 = new SphereSpe(false, new Integer[] {11,6}, "vert",false);
            pionsv.add(vp15);
        }
        else{                                                                        //partie normale
            Cube p6 = new Cube( false, new Integer[] {2,2}, "rouge",false);
            pionsr.add(p6);
            Pyramide p14 = new Pyramide(false, new Integer[] {1,11}, "rouge",false);
            pionsr.add(p14);
            Sphere p15 = new Sphere(false, new Integer[] {1,6}, "rouge",false);
            pionsr.add(p15);
            Cube vp6 = new Cube( false, new Integer[] {10,2}, "vert",false);
            pionsv.add(vp6);
            Pyramide vp14 = new Pyramide(false, new Integer[] {11,11}, "vert",false);
            pionsv.add(vp14);
            Sphere vp15 = new Sphere(false, new Integer[] {11,6}, "vert",false);
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

    public void save(int tour){
        Iterator<Piece> it = pionsr.iterator();
        Iterator<Piece> it2 = pionsv.iterator();
        try {
                FileWriter fich = new FileWriter("SaveFile");
                while (it.hasNext()){
                    Piece p = it.next();
                    fich.write(p.getType()+","+p.position[0]+","+p.position[1]+","+Boolean.toString(p.frozen)+","+Boolean.toString(p.jok)+";");
                }
                fich.write(System.lineSeparator());
                while (it2.hasNext()){
                    Piece p = it2.next();
                    fich.write(p.getType()+","+p.position[0]+","+p.position[1]+","+Boolean.toString(p.frozen)+","+Boolean.toString(p.jok)+";");
                }
                fich.write(System.lineSeparator()+tour);
                fich.close();
                
            } catch (Exception e) {
                System.out.println("echec sauvegarde, tant pis!");
            }
    }

    public int reload(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("SaveFile"));
            String ligne = br.readLine();
            String c= "rouge";
            while(ligne!=null){
                String[] pions = ligne.split(";");
                if (c=="rouge"){ 
                    for (String pion: pions){
                        String[] infos = pion.split(",");
                        Integer[] q = {Integer.valueOf(infos[1]),Integer.valueOf(infos[2])};
                        switch(infos[0]){
                            case "Sphere ": Sphere p = new Sphere(Boolean.parseBoolean(infos[3]), q , 
                            "rouge",Boolean.parseBoolean(infos[4]));
                            pionsr.add(p);
                            break;
                            case "Sphere S ": SphereSpe p2 = new SphereSpe(Boolean.parseBoolean(infos[3]), q , 
                            "rouge",Boolean.parseBoolean(infos[4]));
                            pionsr.add(p2);
                            break;
                            case "Cube ": Cube p3 = new Cube(Boolean.parseBoolean(infos[3]), q , 
                            "rouge",Boolean.parseBoolean(infos[4]));
                            pionsr.add(p3);
                            break;
                            case "Cube S ": CubeSpe p4 = new CubeSpe(Boolean.parseBoolean(infos[3]), q , 
                            "rouge",Boolean.parseBoolean(infos[4]));
                            pionsr.add(p4);
                            break;
                            case "Pyramide ": Pyramide p5 = new Pyramide(Boolean.parseBoolean(infos[3]), q ,
                            "rouge",Boolean.parseBoolean(infos[4]));
                            pionsr.add(p5);
                            break;
                            case "Pyramide S ": PyramSpe p6 = new PyramSpe(Boolean.parseBoolean(infos[3]), q , 
                            "rouge",Boolean.parseBoolean(infos[4]));
                            pionsr.add(p6);
                            break;
                            default: break;
                        }
                    }
                }
                if (c=="vert"){ 
                    for (String pion: pions){
                        String[] infos = pion.split(",");
                        Integer[] q = {Integer.valueOf(infos[1]),Integer.valueOf(infos[2])};
                        switch(infos[0]){
                            case "Sphere ": Sphere p = new Sphere(Boolean.parseBoolean(infos[3]), q , 
                            "vert",Boolean.parseBoolean(infos[4]));
                            pionsv.add(p);
                            break;
                            case "Sphere S ": SphereSpe p2 = new SphereSpe(Boolean.parseBoolean(infos[3]), q , 
                            "vert",Boolean.parseBoolean(infos[4]));
                            pionsv.add(p2);
                            break;
                            case "Cube ": Cube p3 = new Cube(Boolean.parseBoolean(infos[3]), q , 
                            "vert",Boolean.parseBoolean(infos[4]));
                            pionsv.add(p3);
                            break;
                            case "Cube S ": CubeSpe p4 = new CubeSpe(Boolean.parseBoolean(infos[3]), q , 
                            "vert",Boolean.parseBoolean(infos[4]));
                            pionsv.add(p4);
                            break;
                            case "Pyramide ": Pyramide p5 = new Pyramide(Boolean.parseBoolean(infos[3]), q , 
                            "vert",Boolean.parseBoolean(infos[4]));
                            pionsv.add(p5);
                            break;
                            case "Pyramide S ": PyramSpe p6 = new PyramSpe(Boolean.parseBoolean(infos[3]), q , 
                            "vert",Boolean.parseBoolean(infos[4]));
                            pionsv.add(p6);
                            break;
                            default: break;
                        }
                    }
                }
                ligne = br.readLine();
                if (c=="vert")break;
                c="vert";
            }
            int tour =  Integer.parseInt(ligne);
            br.close();
            return tour;
        } catch (Exception e) {
            System.out.println("Chargement planté! lancement d'une nouvelle partie normale");
            newGame(false);
        }
        return 1;

    }

}
 