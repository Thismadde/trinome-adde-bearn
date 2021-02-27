import java.util.Iterator;

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
        System.out.println("fhdbv");
        Pyramide p;
        int[] e1 = new int[] {1,1};
        p = new Pyramide(true, false, e1,"rouge");
        System.out.println(p.getClass());
        Plateau plato = new Plateau();
        Pyramide p2;
        
        int[] e2 = new int[] {2,1};
        p2 = new Pyramide(true, false, e2,"rouge");
        Pyramide p3;        
        
        int[] e3 = new int[] {1,3};
        p3 = new Pyramide(true, false, e3,"rouge");
        Pyramide p4;        
        
        int[] e4 = new int[] {4,4};
        p4 = new Pyramide(true, false, e4,"rouge");

        Pyramide p5;
        int[] e5 = new int[] {2,2};        
        p5 = new Pyramide(true, false, e5,"rouge");

        plato.pions.add(p);
        plato.pions.add(p2);
        plato.pions.add(p3);
        plato.pions.add(p4);
        plato.pions.add(p5);

        String[][] a = new String[11][11];
        Iterator<Piece> it = plato.pions.iterator();
        while (it.hasNext()){
            Piece pion =it.next();
            int x = pion.position[0];
            int y = pion.position[1];
            a[x][y] = pion.getClass()+pion.getColor();
        }
         for (int i=0; i<10;i++){
            for (int j=0; j<10; j++){
                try{
                    System.out.print(a[i][j]+" | ");
                 }
                 catch(Exception e){
                    System.out.print("x | ");
                }
            }
            System.out.println(System.lineSeparator());
        }
    }

}
