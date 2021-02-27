import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

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
public class Twinome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

 //       Plateau platoo = new Plateau();
//
 //       Pyramide p = new Pyramide(true, false, new int[] {3,1},"rouge");
//
 //       Sphere p2;
 //       int[] e2 = new int[] {2,1};
 //       p2 = new Sphere(true, false, e2,"rouge");
//
 //       SphereSpe p3;        
 //       int[] e3 = new int[] {1,3};
 //       p3 = new SphereSpe(true, false, e3,"rouge");
//
 //       Cube p4;        
 //       int[] e4 = new int[] {4,4};
 //       p4 = new Cube(true, false, e4,"vert");
//
//
 //       Cube p5;
 //       int[] e5 = new int[] {2,2};        
 //       p5 = new Cube(true, false, e5,"rouge");
//
 //       platoo.pionsr.add(p);
 //       platoo.pionsr.add(p2);
 //       platoo.pionsr.add(p3);
 //       platoo.pionsv.add(p4);
 //       platoo.pionsv.add(p5);
//
 //       String[][] a = new String[11][11];
 //       Iterator<Piece> it = platoo.pionsr.iterator();
 //       while (it.hasNext()){
 //           Piece pion =it.next();
 //           int x = pion.position[0];
 //           int y = pion.position[1];
 //           a[x-1][y-1] = pion.getType()+pion.getColor();
 //       }
 //        for (int i=0; i<11;i++){
 //           for (int j=0; j<11; j++){
 //               if (a[i][j]==null){
 //               System.out.print("      x       | ");
 //               }
 //               else{
 //                    System.out.print(a[i][j]+" | ");
 //               }
 //           }
 //           System.out.println(System.lineSeparator());
 //       }
 //       Piece Px = platoo.selectPawn(1);
 //       System.out.println((Px.radar(platoo.pionsr,platoo.pionsv)));
 //       Scanner sc  = new Scanner(System.in);
 //       int[] n = new int[2];
 //       System.out.println("coordonee 1");
 //       n[0] = sc.nextInt();
 //       System.out.println("coordonee 2");
 //       n[1] = sc.nextInt();
 //       Px.moves(n);
//
//
 //       System.out.println(System.lineSeparator());
 //       a = new String[12][12];
 //       Iterator<Piece> it2 = platoo.pionsr.iterator();
 //       while (it2.hasNext()){
 //           Piece pion =it2.next();
 //           int x = pion.position[0];
 //           int y = pion.position[1];
 //           a[x-1][y-1] = pion.getType()+pion.getColor();
 //       }
 //        for (int i=0; i<11;i++){
 //           for (int j=0; j<11; j++){
 //               if (a[i][j]==null){
 //               System.out.print("      x       | ");
 //               }
 //               else{
 //                    System.out.print(a[i][j]+" | ");
 //               }
 //           }
 //           System.out.println(System.lineSeparator());
 //       }


        Plateau plato = new Plateau();
        plato.newGame();
        int tour = 1;
        boolean play =true;
        Scanner sc = new Scanner(System.in);
        Integer[] newpos = new Integer[2];
        do{
            plato.blitMatrix();
            Piece p = plato.selectPawn(tour);
            ArrayList<Integer[]> possib = p.radar(plato.pionsr, plato.pionsv);
            possib.forEach(System.out::println);
            for (Integer[] ui: possib){
                System.out.println(Arrays.toString(ui));
            }
            System.out.println("taper les coordonnées de destination");    
            newpos[0] = sc.nextInt();
            newpos[1] = sc.nextInt();
            boolean z = false;
            for (Integer[] possibI: possib){
                if (possibI[0] == newpos[0] && possibI[1]==newpos[1]){
                    plato.movePawn(p, newpos, tour);
                    z = false;
                }
            }
            if(z){System.out.println("Position non valide!");continue;}
            if (!plato.cfroze && (p.getType().equals("Cube ") || p.getType().equals("Cube S "))&&!p.frozen)
                plato.cfroze  = true;
            if (!plato.pfroze && (p.getType().equals("Pyramide ") || p.getType().equals("Pyramide S "))&&!p.frozen)
                plato.pfroze  = true;
            if (!plato.sfroze && (p.getType().equals("Sphere ") || p.getType().equals("Sphere S "))&&!p.frozen)
                plato.sfroze  = true;
            if(plato.endGame()){
                System.out.println("Le gagnant est : "+p.getColor());
                break;
            }
            System.out.println("Continuer? (oui = O, non = N)");
            play = sc.next().equals("O");
            if(tour==1)
                tour=0;
            else if(tour==0)
                tour=1;
        }while (play);
        sc.close();







    }

}
