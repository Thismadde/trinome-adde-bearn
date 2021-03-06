/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twinome;

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

	public ArrayList<Piece> pionsr, pionsv; // liste des pions verts et rouges
	private boolean cfrozer, pfrozer,  sfrozer;		//faux tant que un pion n'est pas figé; c pour cube, p pour pyra, s pour sphere
	private boolean cfrozev, pfrozev,  sfrozev;		//pour les verts
	private final String pseudo1;
	private final String pseudo2;
	public int tour = 0;
	public Integer[] oriPosi;
	private Piece oriPawn;

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
			
// cas particulier pour les pions speciaux qui ont le joker actif, ils ne
			// peuvent etre frozen
			
			if (p.getType().equals("Cube S ") && p.position[0] == 11 && 4 < p.position[1] && p.position[1] < 8) {
				cfrozer = true;
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

	public void movePawn(Piece pawn, Integer[] newpos, int tour) {
		pawn.movesEnd(newpos,cfrozer, pfrozer, sfrozer, cfrozev, pfrozev, sfrozev); // passage a frozen si besoin, et changement des coordonées

		if (tour == 0) { // tour du rouge
			Iterator<Piece> it = pionsv.iterator();
			while (it.hasNext()) { // si un pion adverse est sur la case d'arrivée, on le supprime
				Piece p = it.next();
				if (Arrays.equals(p.position, newpos)) {
					deletePawn(p);
					return;
				}
			}
		} else { // tour du vert, et on fait pareil
			Iterator<Piece> it = pionsr.iterator();
			while (it.hasNext()) {
				Piece p = it.next();
				if (Arrays.equals(p.position, newpos)) {
					deletePawn(p);
					return;
				}
			}
		}
	}

	public void newGame(boolean special) { // fonction qui place les pions a des endroits predeterminés;

		Cube p = new Cube(false, new Integer[] { 3, 1 }, "rouge", false);
		pionsr.add(p);
		Cube p2 = new Cube(false, new Integer[] { 1, 3 }, "rouge", false);
		pionsr.add(p2);
		Cube p3 = new Cube(false, new Integer[] { 1, 9 }, "rouge", false);
		pionsr.add(p3);
		Cube p4 = new Cube(false, new Integer[] { 2, 10 }, "rouge", false);
		pionsr.add(p4);
		Cube p5 = new Cube(false, new Integer[] { 3, 11 }, "rouge", false);
		pionsr.add(p5);
		Sphere p7 = new Sphere(false, new Integer[] { 1, 5 }, "rouge", false);
		pionsr.add(p7);
		Sphere p8 = new Sphere(false, new Integer[] { 1, 7 }, "rouge", false);
		pionsr.add(p8);
		Pyramide p9 = new Pyramide(false, new Integer[] { 1, 1 }, "rouge", false);
		pionsr.add(p9);
		Pyramide p10 = new Pyramide(false, new Integer[] { 1, 2 }, "rouge", false);
		pionsr.add(p10);
		Pyramide p11 = new Pyramide(false, new Integer[] { 2, 1 }, "rouge", false);
		pionsr.add(p11);
		Pyramide p12 = new Pyramide(false, new Integer[] { 1, 10 }, "rouge", false);
		pionsr.add(p12);
		Pyramide p13 = new Pyramide(false, new Integer[] { 2, 11 }, "rouge", false);
		pionsr.add(p13);

		Cube vp = new Cube(false, new Integer[] { 9, 1 }, "vert", false);
		pionsv.add(vp);
		Cube vp2 = new Cube(false, new Integer[] { 11, 3 }, "vert", false);
		pionsv.add(vp2);
		Cube vp3 = new Cube(false, new Integer[] { 11, 9 }, "vert", false);
		pionsv.add(vp3);
		Cube vp4 = new Cube(false, new Integer[] { 10, 10 }, "vert", false);
		pionsv.add(vp4);
		Cube vp5 = new Cube(false, new Integer[] { 9, 11 }, "vert", false);
		pionsv.add(vp5);
		Sphere vp7 = new Sphere(false, new Integer[] { 11, 5 }, "vert", false);
		pionsv.add(vp7);
		Sphere vp8 = new Sphere(false, new Integer[] { 11, 7 }, "vert", false);
		pionsv.add(vp8);
		Pyramide vp9 = new Pyramide(false, new Integer[] { 11, 1 }, "vert", false);
		pionsv.add(vp9);
		Pyramide vp10 = new Pyramide(false, new Integer[] { 11, 2 }, "vert", false);
		pionsv.add(vp10);
		Pyramide vp11 = new Pyramide(false, new Integer[] { 10, 1 }, "vert", false);
		pionsv.add(vp11);
		Pyramide vp12 = new Pyramide(false, new Integer[] { 10, 11 }, "vert", false);
		pionsv.add(vp12);
		Pyramide vp13 = new Pyramide(false, new Integer[] { 11, 10 }, "vert", false);
		pionsv.add(vp13);
		if (special) { // si on choisit une partie avec pions speciaux
			CubeSpe p6 = new CubeSpe(false, new Integer[] { 2, 2 }, "rouge", false);
			pionsr.add(p6);
			PyramSpe p14 = new PyramSpe(false, new Integer[] { 1, 11 }, "rouge", false);
			pionsr.add(p14);
			SphereSpe p15 = new SphereSpe(false, new Integer[] { 1, 6 }, "rouge", false);
			pionsr.add(p15);
			CubeSpe vp6 = new CubeSpe(false, new Integer[] { 10, 2 }, "vert", false);
			pionsv.add(vp6);
			PyramSpe vp14 = new PyramSpe(false, new Integer[] { 11, 11 }, "vert", false);
			pionsv.add(vp14);
			SphereSpe vp15 = new SphereSpe(false, new Integer[] { 11, 6 }, "vert", false);
			pionsv.add(vp15);
		} else { // partie normale
			Cube p6 = new Cube(false, new Integer[] { 2, 2 }, "rouge", false);
			pionsr.add(p6);
			Pyramide p14 = new Pyramide(false, new Integer[] { 1, 11 }, "rouge", false);
			pionsr.add(p14);
			Sphere p15 = new Sphere(false, new Integer[] { 1, 6 }, "rouge", false);
			pionsr.add(p15);
			Cube vp6 = new Cube(false, new Integer[] { 10, 2 }, "vert", false);
			pionsv.add(vp6);
			Pyramide vp14 = new Pyramide(false, new Integer[] { 11, 11 }, "vert", false);
			pionsv.add(vp14);
			Sphere vp15 = new Sphere(false, new Integer[] { 11, 6 }, "vert", false);
			pionsv.add(vp15);
		}
	}

	public void deletePawn(Piece pawn) {
		pionsr.remove(pawn);	// on essaie d'effacer le pion specifié indifferement dans chaque liste, car les
						// listes ne sont pas grosses
		pionsv.remove(pawn);
	}

	public void save() {
		Iterator<Piece> it = pionsr.iterator();
		Iterator<Piece> it2 = pionsv.iterator();
		try {
			FileWriter fich = new FileWriter("SaveFile_" + pseudo1 + "_" + pseudo2);
			while (it.hasNext()) {
				Piece p = it.next();
				fich.write(p.getType() + "," + p.position[0] + "," + p.position[1] + "," + Boolean.toString(p.frozen)
						+ "," + Boolean.toString(p.joker) + ";");
			}
			fich.write(System.lineSeparator());
			while (it2.hasNext()) {
				Piece p = it2.next();
				fich.write(p.getType() + "," + p.position[0] + "," + p.position[1] + "," + Boolean.toString(p.frozen)
						+ "," + Boolean.toString(p.joker) + ";");
			}
			fich.write(System.lineSeparator() + tour);
			fich.close();

		} catch (Exception e) {
		}
	}

	public boolean reload() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("SaveFile_" + pseudo1 + "_" + pseudo2));
			String ligne = br.readLine();
			String c = "rouge";
			while (ligne != null) {
				String[] pions = ligne.split(";");
				if (c == "rouge") {
					for (String pion : pions) {
						String[] infos = pion.split(",");
						Integer[] q = { Integer.valueOf(infos[1]), Integer.valueOf(infos[2]) };
						switch (infos[0]) {
						case "Sphere ":
							Sphere p = new Sphere(Boolean.parseBoolean(infos[3]), q, "rouge",
									Boolean.parseBoolean(infos[4]));
							pionsr.add(p);
							break;
						case "Sphere S ":
							SphereSpe p2 = new SphereSpe(Boolean.parseBoolean(infos[3]), q, "rouge",
									Boolean.parseBoolean(infos[4]));
							pionsr.add(p2);
							break;
						case "Cube ":
							Cube p3 = new Cube(Boolean.parseBoolean(infos[3]), q, "rouge",
									Boolean.parseBoolean(infos[4]));
							pionsr.add(p3);
							break;
						case "Cube S ":
							CubeSpe p4 = new CubeSpe(Boolean.parseBoolean(infos[3]), q, "rouge",
									Boolean.parseBoolean(infos[4]));
							pionsr.add(p4);
							break;
						case "Pyramide ":
							Pyramide p5 = new Pyramide(Boolean.parseBoolean(infos[3]), q, "rouge",
									Boolean.parseBoolean(infos[4]));
							pionsr.add(p5);
							break;
						case "Pyramide S ":
							PyramSpe p6 = new PyramSpe(Boolean.parseBoolean(infos[3]), q, "rouge",
									Boolean.parseBoolean(infos[4]));
							pionsr.add(p6);
							break;
						default:
							break;
						}
					}
				}
				if (c == "vert") {
					for (String pion : pions) {
						String[] infos = pion.split(",");
						Integer[] q = { Integer.valueOf(infos[1]), Integer.valueOf(infos[2]) };
						switch (infos[0]) {
						case "Sphere ":
							Sphere p = new Sphere(Boolean.parseBoolean(infos[3]), q, "vert",
									Boolean.parseBoolean(infos[4]));
							pionsv.add(p);
							break;
						case "Sphere S ":
							SphereSpe p2 = new SphereSpe(Boolean.parseBoolean(infos[3]), q, "vert",
									Boolean.parseBoolean(infos[4]));
							pionsv.add(p2);
							break;
						case "Cube ":
							Cube p3 = new Cube(Boolean.parseBoolean(infos[3]), q, "vert",
									Boolean.parseBoolean(infos[4]));
							pionsv.add(p3);
							break;
						case "Cube S ":
							CubeSpe p4 = new CubeSpe(Boolean.parseBoolean(infos[3]), q, "vert",
									Boolean.parseBoolean(infos[4]));
							pionsv.add(p4);
							break;
						case "Pyramide ":
							Pyramide p5 = new Pyramide(Boolean.parseBoolean(infos[3]), q, "vert",
									Boolean.parseBoolean(infos[4]));
							pionsv.add(p5);
							break;
						case "Pyramide S ":
							PyramSpe p6 = new PyramSpe(Boolean.parseBoolean(infos[3]), q, "vert",
									Boolean.parseBoolean(infos[4]));
							pionsv.add(p6);
							break;
						default:
							break;
						}
					}
				}
				ligne = br.readLine();
				if (c == "vert") {
					break;
				}
				c = "vert";
			}
			tour = Integer.parseInt(ligne);
			br.close();
			return true;
		} catch (Exception e) {
			newGame(false);
			return false;
		}

	}

	public String choix(Integer[] posi) {
		String retour = ""; 
		if (tour == 1) { // tour du vert
			Iterator<Piece> it = pionsv.iterator();
			while (it.hasNext()) {
				Piece p = it.next();
				if (Arrays.equals(p.position, posi)){
					if (p.frozen)
						return "Ce pion est figé.";
					if (p.radar(pionsr, pionsv).isEmpty())
						return "Ce pion n'a pas d'option de déplacement.";
					oriPosi = posi;
					oriPawn = p;
					return retour;
				}
			}
			retour = "Elle n'est pas à " + pseudo2 + "!";
		} else {
			Iterator<Piece> it = pionsr.iterator();
			while (it.hasNext()) {
				Piece p = it.next();
				if (Arrays.equals(p.position, posi)){
					if (p.frozen)
						return "Ce pion est figé.";
					if (p.radar(pionsr, pionsv).isEmpty())
						return "Ce pion n'a pas d'option de déplacement.";
					oriPosi = posi;
					oriPawn = p;
					return retour;
				}
			}
			retour = "Elle n'est pas à " + pseudo1 + "!";
		}
		return "Cette pièce ne peut pas bouger!" + System.lineSeparator() + retour;
	}

	public boolean target(Integer[] posi) {
		ArrayList<Integer[]> possib = oriPawn.radar(pionsr, pionsv);
		for (Integer[] aaa : possib) {
			if (aaa[0].equals(posi[0]) && aaa[1].equals(posi[1])) {

				if (oriPawn.getType().equals("Pyramide S ")) {
					Integer[] a = { (oriPawn.position[0] + posi[0]) / 2, (oriPawn.position[1] + posi[1]) / 2 };
					movePawn(oriPawn, a, tour); // deplacement intermediaire pour les pyramides speciales
				}
				movePawn(oriPawn, posi, tour);
				for (Piece pjok : pionsr) { // seuls les cubes speciaux verifient vraiment quelque chose ici
					pjok.joker(pionsr);
				}
				for (Piece pjok : pionsv) {// pour les cubes speciaux verts
					pjok.joker(pionsv);
				}
				tour++;
				if (tour > 1) {
					tour = 0;
				}
				return true;
			}
		}
		return false;
	}
}
