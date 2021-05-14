/*
 * Création : 30/01/2021
 * Dernière modification : 30/04/2021
 */
package trinome;

/**
 *
 * @author clarisse, mathis
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {

	public ArrayList<Piece> pionsr, pionsv;		// liste des pions verts et rouges
	private boolean cfrozer, pfrozer, sfrozer;		//faux tant que un pion n'est pas figé; c pour cube, p pour pyra, s pour sphere
	private boolean cfrozev, pfrozev, sfrozev;		//pour les verts
	private final String pseudo1;
	private final String pseudo2;
	public int tour = 0;				//0 correspond au tour du rouge, 1 à celui du vert
	public Piece oriPawn;			// pièce sélectionnée en début detour que l'on garde en éméoire

	public Plateau(String a, String b) {
		pionsr = new ArrayList<>();
		pionsv = new ArrayList<>();
		pseudo1 = a;
		pseudo2 = b;
	}

	public boolean endGame() { // verification des conditions pour finir la partie

		int ns = 0;
		int np = 0;
		int nc = 0;
		cfrozer = false;

		for (Piece p : pionsr) { // on parcourt tous les pions rouges pour voir si on a au moins un pion de
			// chaque type principal,
			// s'il y en a des figés en zone rouge

			if (p.getType().equals("Cube S ") && p.position[0] == 11 && 4 < p.position[1] && p.position[1] < 8) {// cas particulier pour les cubes speciaux qui ont peut-etre le joker actif, ils ne
				cfrozer = true;// peuvent etre frozen, donc on verifie leur position sur une case rouge manuellement
			}
			if (p.getType().equals("Cube ") || p.getType().equals("Cube S ")) {
				nc++;
			}
			if (p.getType().equals("Pyramide ") || p.getType().equals("Pyramide S ")) {
				np++;
			}
			if (p.getType().equals("Sphere ") || p.getType().equals("Sphere S ")) {
				ns++;
			}
			if (p.frozen && p.getType().equals("Cube ")) {
				cfrozer = true;
			}
			if (p.frozen && (p.getType().equals("Pyramide ") || p.getType().equals("Pyramide S "))) {
				pfrozer = true;
			}
			if (p.frozen && (p.getType().equals("Sphere ") || p.getType().equals("Sphere S "))) {
				sfrozer = true;
			}

		}
		if (sfrozer && cfrozer && pfrozer) { // si trois pions sont confirmés en zone rouge
			return true;
		}
		if (nc == 0 || np == 0 || ns == 0) // si une des categories est vide, alors la fin de partie est true
		{
			return true;
		}

		ns = 0;
		np = 0;
		nc = 0;
		for (Piece p : pionsv) { // pareil pour les verts	
			if (p.getType().equals("Cube S ") && p.position[0] == 1 && 4 < p.position[1] && p.position[1] < 8) {
				cfrozev = true;
			}
			if (p.getType().equals("Cube ") || p.getType().equals("Cube S ")) {
				nc++;
			}
			if (p.getType().equals("Pyramide ") || p.getType().equals("Pyramide S ")) {
				np++;
			}
			if (p.getType().equals("Sphere ") || p.getType().equals("Sphere S ")) {
				ns++;
			}
			if (p.frozen && (p.getType().equals("Cube ") || p.getType().equals("Cube S "))) {
				cfrozev = true;
			}
			if (p.frozen && (p.getType().equals("Pyramide ") || p.getType().equals("Pyramide S "))) {
				pfrozev = true;
			}
			if (p.frozen && (p.getType().equals("Sphere ") || p.getType().equals("Sphere S "))) {
				sfrozev = true;
			}
		}
		if (nc == 0 || np == 0 || ns == 0) {
			return true;
		}

		if (sfrozev && cfrozev && pfrozev) {
			return true;
		}

		return false;
	}

	public boolean movePawn(Piece pawn, Integer[] newpos, int tour) {

		if (tour == 0) { // tour du rouge
			
			for (Piece p :pionsv) {  //on parcourt les pions adverses
				
				if (Arrays.equals(p.position, newpos)) { // si un pion adverse est sur la case d'arrivée, on le supprime
					if (p.frozen) //sauf s'il est figé, on renvoie alors une non-validation
					{
						return false;
					}
					deletePawn(p);
					break;
				}
			}
		} else if (tour == 1) { // tour du vert, et on fait pareil
			for (Piece p : pionsr) {
				if (Arrays.equals(p.position, newpos)) {
					if (p.frozen) {
						return false;
					}
					deletePawn(p);
					break;
				}
			}
		}
		pawn.movesEnd(newpos, cfrozer, pfrozer, sfrozer, cfrozev, pfrozev, sfrozev); // passage a frozen si besoin, et changement des coordonées
		return true;  //arrivé ici, le déplacement est réussi, on renvoie une validation
	}

	public void newGame(boolean special) { // fonction qui place les pions a des endroits predeterminés;

		//creation d'un Cube non figé au point  3 1        rouge    sans joker
		Cube p = new Cube(false, new Integer[]{3, 1}, "rouge", false);
		//on l'ajoute a la liste
		pionsr.add(p);
		//etc
		Cube p2 = new Cube(false, new Integer[]{1, 3}, "rouge", false);
		pionsr.add(p2);
		Cube p3 = new Cube(false, new Integer[]{1, 9}, "rouge", false);
		pionsr.add(p3);
		Cube p4 = new Cube(false, new Integer[]{2, 10}, "rouge", false);
		pionsr.add(p4);
		Cube p5 = new Cube(false, new Integer[]{3, 11}, "rouge", false);
		pionsr.add(p5);
		Sphere p7 = new Sphere(false, new Integer[]{1, 5}, "rouge", false);
		pionsr.add(p7);
		Sphere p8 = new Sphere(false, new Integer[]{1, 7}, "rouge", false);
		pionsr.add(p8);
		Pyramide p9 = new Pyramide(false, new Integer[]{1, 1}, "rouge", false);
		pionsr.add(p9);
		Pyramide p10 = new Pyramide(false, new Integer[]{1, 2}, "rouge", false);
		pionsr.add(p10);
		Pyramide p11 = new Pyramide(false, new Integer[]{2, 1}, "rouge", false);
		pionsr.add(p11);
		Pyramide p12 = new Pyramide(false, new Integer[]{1, 10}, "rouge", false);
		pionsr.add(p12);
		Pyramide p13 = new Pyramide(false, new Integer[]{2, 11}, "rouge", false);
		pionsr.add(p13);

		Cube vp = new Cube(false, new Integer[]{9, 1}, "vert", false);
		pionsv.add(vp);
		Cube vp2 = new Cube(false, new Integer[]{11, 3}, "vert", false);
		pionsv.add(vp2);
		Cube vp3 = new Cube(false, new Integer[]{11, 9}, "vert", false);
		pionsv.add(vp3);
		Cube vp4 = new Cube(false, new Integer[]{10, 10}, "vert", false);
		pionsv.add(vp4);
		Cube vp5 = new Cube(false, new Integer[]{9, 11}, "vert", false);
		pionsv.add(vp5);
		Sphere vp7 = new Sphere(false, new Integer[]{11, 5}, "vert", false);
		pionsv.add(vp7);
		Sphere vp8 = new Sphere(false, new Integer[]{11, 7}, "vert", false);
		pionsv.add(vp8);
		Pyramide vp9 = new Pyramide(false, new Integer[]{11, 1}, "vert", false);
		pionsv.add(vp9);
		Pyramide vp10 = new Pyramide(false, new Integer[]{11, 2}, "vert", false);
		pionsv.add(vp10);
		Pyramide vp11 = new Pyramide(false, new Integer[]{10, 1}, "vert", false);
		pionsv.add(vp11);
		Pyramide vp12 = new Pyramide(false, new Integer[]{10, 11}, "vert", false);
		pionsv.add(vp12);
		Pyramide vp13 = new Pyramide(false, new Integer[]{11, 10}, "vert", false);
		pionsv.add(vp13);
		if (special) { // si on choisit une partie avec pions speciaux
			CubeSpe p6 = new CubeSpe(false, new Integer[]{2, 2}, "rouge", false);
			pionsr.add(p6);
			PyramSpe p14 = new PyramSpe(false, new Integer[]{1, 11}, "rouge", false);
			pionsr.add(p14);
			SphereSpe p15 = new SphereSpe(false, new Integer[]{1, 6}, "rouge", false);
			pionsr.add(p15);
			CubeSpe vp6 = new CubeSpe(false, new Integer[]{10, 2}, "vert", false);
			pionsv.add(vp6);
			PyramSpe vp14 = new PyramSpe(false, new Integer[]{11, 11}, "vert", false);
			pionsv.add(vp14);
			SphereSpe vp15 = new SphereSpe(false, new Integer[]{11, 6}, "vert", false);
			pionsv.add(vp15);
		} else { // partie normale
			Cube p6 = new Cube(false, new Integer[]{2, 2}, "rouge", false);
			pionsr.add(p6);
			Pyramide p14 = new Pyramide(false, new Integer[]{1, 11}, "rouge", false);
			pionsr.add(p14);
			Sphere p15 = new Sphere(false, new Integer[]{1, 6}, "rouge", false);
			pionsr.add(p15);
			Cube vp6 = new Cube(false, new Integer[]{10, 2}, "vert", false);
			pionsv.add(vp6);
			Pyramide vp14 = new Pyramide(false, new Integer[]{11, 11}, "vert", false);
			pionsv.add(vp14);
			Sphere vp15 = new Sphere(false, new Integer[]{11, 6}, "vert", false);
			pionsv.add(vp15);
		}
	}

	public void deletePawn(Piece pawn) {
		pionsr.remove(pawn);	// on essaie d'effacer le pion specifié indifferement dans chaque liste, car les
		// listes ne sont pas grosses
		pionsv.remove(pawn);
	}

	public void save() {
		try {
			FileWriter fich = new FileWriter("SaveFile_" + pseudo1 + "_" + pseudo2); //on ouvre le fichier aux noms des joueurs, ou on le créé s'il n'existe pas
			for (Piece p : pionsr) { //on parcourt tous les pions rouges
				fich.write(p.getType() + "," + p.position[0] + "," + p.position[1] + "," + Boolean.toString(p.frozen) //on ecrit leurs composantes pertinentes séparées par des , pour chacun sur la premiere ligne
				+ "," + Boolean.toString(p.activeJoker) + ";");  //chaque "bloc" de pion est séparé sur la ligne par des ;
			}
			fich.write(System.lineSeparator()); //on passe a la ligne suivante
			for (Piece p : pionsv) {  //on procede de meme pour lespions verts, juste sur la deuxieme ligne
				fich.write(p.getType() + "," + p.position[0] + "," + p.position[1] + "," + Boolean.toString(p.frozen)
				+ "," + Boolean.toString(p.activeJoker) + ";");
			}
			fich.write(System.lineSeparator() + tour); //enfin on ecrit sur la troisieme ligne le tour actuel
			fich.close();

		} catch (IOException e) {
		}
	}

	public boolean reload() {   //tres peu modulable il me semble mais bon
		try {
			BufferedReader br = new BufferedReader(new FileReader("SaveFile_" + pseudo1 + "_" + pseudo2));  //d'abord on essaie d'ouvrir le fichier aux noms des joueurs, d'ou le try
			String ligne = br.readLine(); //on lit la premiere ligne
			String c = "rouge";  //on sait que cette ligne est rouge
			while (ligne != null) {
				String[] pions = ligne.split(";"); //on separe les infos des differents pions sur la ligne recuperee
				if (c == "rouge") {
					for (String pion : pions) {  //on parcourt ces "pions"
						String[] infos = pion.split(","); //on separe les composants du pion
						Integer[] coord = {Integer.valueOf(infos[1]), Integer.valueOf(infos[2])};
						switch (infos[0]) {  //selon le type spécifié en premier element, on créé un pion different
							case "Sphere ":
								Sphere p = new Sphere(Boolean.parseBoolean(infos[3]), coord, c,
								Boolean.parseBoolean(infos[4]));  //on cré alors le pion selon les elements specifiés
								pionsr.add(p); //on l'ajoute a la liste rouge (car on est dans le cas rouge)
								break;
							case "Sphere S ": //etc
								SphereSpe p2 = new SphereSpe(Boolean.parseBoolean(infos[3]), coord, c,
								Boolean.parseBoolean(infos[4]));
								pionsr.add(p2);
								break;
							case "Cube ":
								Cube p3 = new Cube(Boolean.parseBoolean(infos[3]), coord, c,
								Boolean.parseBoolean(infos[4]));
								pionsr.add(p3);
								break;
							case "Cube S ":
								CubeSpe p4 = new CubeSpe(Boolean.parseBoolean(infos[3]), coord, c,
								Boolean.parseBoolean(infos[4]));
								pionsr.add(p4);
								break;
							case "Pyramide ":
								Pyramide p5 = new Pyramide(Boolean.parseBoolean(infos[3]), coord, c,
								Boolean.parseBoolean(infos[4]));
								pionsr.add(p5);
								break;
							case "Pyramide S ":
								PyramSpe p6 = new PyramSpe(Boolean.parseBoolean(infos[3]), coord, c,
								Boolean.parseBoolean(infos[4]));
								pionsr.add(p6);
								break;
							default:
								break;
						}
					}
				}
				if (c == "vert") {  //on y entre lorsque c'est les pions verts, et pareil que les rouges apres
					for (String pion : pions) {
						String[] infos = pion.split(",");
						Integer[] q = {Integer.valueOf(infos[1]), Integer.valueOf(infos[2])};
						switch (infos[0]) {
							case "Sphere ":
								Sphere p = new Sphere(Boolean.parseBoolean(infos[3]), q, c,
								Boolean.parseBoolean(infos[4]));
								pionsv.add(p);
								break;
							case "Sphere S ":
								SphereSpe p2 = new SphereSpe(Boolean.parseBoolean(infos[3]), q, c,
								Boolean.parseBoolean(infos[4]));
								pionsv.add(p2);
								break;
							case "Cube ":
								Cube p3 = new Cube(Boolean.parseBoolean(infos[3]), q, c,
								Boolean.parseBoolean(infos[4]));
								pionsv.add(p3);
								break;
							case "Cube S ":
								CubeSpe p4 = new CubeSpe(Boolean.parseBoolean(infos[3]), q, c,
								Boolean.parseBoolean(infos[4]));
								pionsv.add(p4);
								break;
							case "Pyramide ":
								Pyramide p5 = new Pyramide(Boolean.parseBoolean(infos[3]), q, c,
								Boolean.parseBoolean(infos[4]));
								pionsv.add(p5);
								break;
							case "Pyramide S ":
								PyramSpe p6 = new PyramSpe(Boolean.parseBoolean(infos[3]), q, c,
								Boolean.parseBoolean(infos[4]));
								pionsv.add(p6);
								break;
							default:
								break;
						}
					}
				}
				ligne = br.readLine();//arrivé ici on a fini une ligne, on passe  a la suivante
				if (c == "vert") {  //si l'on vient de faire les verts, on sort de la boucle (car on est alors sur la troiseme ligne, qui ne porte pas de pion)
					break;
				}
				c = "vert"; //si l'on ne vient pas de faire les verts, on passe c à vert, ainsi on entrera bien dans la boucle verte (car la deuxieme ligne est celle des pions verts)
			}
			tour = Integer.parseInt(ligne); //on est sur la troisieme ligne, qui a le tour.
			br.close();
			return true; //le chargement a reussi
		} catch (Exception e) {
			newGame(false); //le chargment a raté, on lance donc une partie normale vierge
			return false;
		}

	}

	public String choix(Integer[] posi) { //fonction qui intervient lors de la selection du pion dans l'interface graphique
		//posi sont les coordonnées de la case sur laquelle on clique
		String retour = "";
		if (tour == 1) { // tour du vert
			for (Piece p : pionsv) {   //on parcourt tous les pions verts
				if (Arrays.equals(p.position, posi)) {  //si l'un d'eux est sur la case séléctionnée
					if (p.frozen) //s'il est figé, on renvoie ceci
					{
						return "Ce pion est figé.";
					}
					if (p.radar(pionsr, pionsv).isEmpty()) //si le radar est vide, donc si la piece ne peut pas bouger; 
					{
						return "Ce pion n'a pas d'option de déplacement.";
					}
					oriPawn = p;  //sinon on garde le pion en memoire
					return retour;  //si la piece est au joueur vert, on renvoie la somme des messages d'erreurs. un message vide "" equivaut à une validation 
				}
			}
			retour = "Elle n'est pas à " + pseudo2 + "!"; //arrivé ici, la case ne porte pas de pion vert.
		} else { //on fait de meme pour le joueur rouge
			for (Piece p :pionsr) {
				if (Arrays.equals(p.position, posi)) {
					if (p.frozen) {
						return "Ce pion est figé.";
					}
					if (p.radar(pionsr, pionsv).isEmpty()) {
						return "Ce pion n'a pas d'option de déplacement.";
					}
					oriPawn = p;
					return retour;
				}
			}
			retour = "Elle n'est pas à " + pseudo1 + "!"; 
		}
		return "Cette pièce ne peut pas bouger!" + System.lineSeparator() + retour;  //on arrive ici lorsque la case ne porte ni pion rouge, ni pion vert. Elle n'est donc pas au joueur dont c'est le tour. 
														//La string *retour* porte le message d'erruer propre au joueur actuel
	}

	public boolean target(Integer[] posi) {  //pour selectionner une case d'arrivée valide, apres avoir choisi un pion a bouger, avec posi les coordonnées de la case a tester
		ArrayList<Integer[]> possib = oriPawn.radar(pionsr, pionsv);  //on recupere tout d'abord les cases disponibles de notre premier pion, enregistré par choix() dans oriPawn, avec son radar()
		for (Integer[] aaa : possib) {  //on parcourt les possibilités (qui sont des coordonnées)
			if (aaa[0].equals(posi[0]) && aaa[1].equals(posi[1])) { //si les coordonnées de la case sont dans la liste, alors c'est que le deplacement est valide

				if (oriPawn.getType().equals("Pyramide S ")) {
					Integer[] a = {(oriPawn.position[0] + posi[0]) / 2, (oriPawn.position[1] + posi[1]) / 2};
					if (a[0]!=oriPawn.position[0] && a[1]!=oriPawn.position[1])
						movePawn(oriPawn, a, tour); // deplacement intermediaire pour les pyramides speciales
				}
				if (!movePawn(oriPawn, posi, tour)) {  //si le pion n'a pas le droit de bouger en fait (verifie entre autre si le pion visé est figé)
					return false;				//on renvoie false, le mouvement est non validé, le tour ne change pas
				}
				for (Piece pjok : pionsr) { // seuls les cubes speciaux verifient vraiment quelque chose ici
					pjok.joker(pionsr); //on verifie s'il faut acitver le joker du pion APRES son deplacement
				}
				for (Piece pjok : pionsv) {// pour les cubes speciaux verts, idem
					pjok.joker(pionsv);
				}
				tour++;  //on modifie la valeur du tour pour changer le tour. tour peut etre  0 ou 1
				if (tour > 1) {
					tour = 0;
				}
				return true;  //arrivé ici, tout s'est bien passé, le mouvement est valide
			}
		}
		return false;  //ici la case n'est pas dans la liste des deplacments possibles, donc le deplacement n'est pas valide
	}
}
