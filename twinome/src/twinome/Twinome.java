import java.util.ArrayList;
import java.util.Arrays;
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
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle partie créer? Normale(N) ou spéciale(S)?");
        Plateau plato = new Plateau();
        plato.newGame(sc.next().equals("N"));
        int tour = 1;
        boolean play =true;
        Integer[] newpos = new Integer[2];
        do{
            plato.blitMatrix();
            Piece p = plato.selectPawn(tour,sc);
            ArrayList<Integer[]> possib = p.radar(plato.pionsr, plato.pionsv);
            //possib.forEach(System.out::println);
            if (possib.isEmpty()){
                System.out.println("pion non bougeable");
                continue;
            }
            for (Integer[] ui: possib){
                System.out.println(Arrays.toString(ui));
            }
            System.out.println("taper les coordonnées de destination");    
            newpos[0] = sc.nextInt();
            newpos[1] = sc.nextInt();
            boolean z = false;
            for (Integer[] possibI: possib){
                if (possibI[0] == newpos[0] && possibI[1]==newpos[1]){
                    if (p.getType().equals("Pyramide S ")){
                        Integer[] a = {p.position[0]+1/2*(p.position[0]-newpos[0]),p.position[1]+1/2*(p.position[1]-newpos[1])};
                        plato.movePawn(p,a, tour);
                    }
                    plato.movePawn(p, newpos, tour);
                    z = false;
                }
            }
            for (Piece pjok: plato.pionsr){
                pjok.joker(plato.pionsr);
            }
            for (Piece pjok: plato.pionsv){
                pjok.joker(plato.pionsv);
            }
            if(z){System.out.println("Position non valide!");continue;}
            if (!plato.cfroze && (p.getType().equals("Cube ") || (p.getType().equals("Cube S ")&&!p.jok))&&p.frozen)
                plato.cfroze  = true;
            if (!plato.pfroze && (p.getType().equals("Pyramide ") || p.getType().equals("Pyramide S "))&&p.frozen)
                plato.pfroze  = true;
            if (!plato.sfroze && (p.getType().equals("Sphere ") || p.getType().equals("Sphere S "))&&p.frozen)
                plato.sfroze  = true;
            if(plato.endGame()){
                System.out.println("Le gagnant est : "+p.getColor());
                break;
            }
            //System.out.println("Continuer? (oui = O, non = N)");
            //play = sc.next().equals("O");
            ////if(tour==1)
            //    tour=0;
            //else if(tour==0)
            //    tour=1;
        }while (play);
        sc.close();




    }

}
