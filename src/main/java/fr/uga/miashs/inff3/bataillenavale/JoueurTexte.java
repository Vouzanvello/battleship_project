package fr.uga.miashs.inff3.bataillenavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {
	private Scanner sc;

	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	public JoueurTexte(GrilleNavale g) {
		super(g);
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		// Réalise l'affichage à la console des étapes de jeu.
		// c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de l'attaque. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.
		if (etat==GAMEOVER)
			System.out.println("Gagné !");
		if (etat==TOUCHE)
			System.out.println(super.getNom()+", vous avez touché un navire en "+ c);
		if (etat==COULE)
			System.out.println(super.getNom()+", tir en "+c+" : un navire a coulé");
		if (etat==A_L_EAU)
			System.out.println(super.getNom()+", vous avez tiré dans l'eau en " + c);
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		//c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de ce tir. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER. 
		if (etat==GAMEOVER)
			System.out.println("Vous avez perdu :(");
		if (etat==TOUCHE)
			System.out.println(super.getNom()+", un navire a été touché en " + c);
		if (etat==COULE)
			System.out.println(super.getNom()+", tir en "+c+" : un navire a coulé");
		if (etat==A_L_EAU)
			System.out.println(super.getNom()+", tir en "+c+" :  tout va bien yayyy");
	}
	
	public Coordonnee choixAttaque() {
		Scanner sc = new Scanner(System.in);
		// recueille au clavier la saisie de la coordonnée à attaquer
		System.out.println(super.getNom()+", choisissez les coordonnées de l'attaque : ");
		// enregistrement de l'input dans une nouvelle coordonnee
		Coordonnee attaque = new Coordonnee(sc.next());
		//exception si coordonnee hors des limites de la grille
		//METTRE UN TRY CATCH A LA PLACE
		if (attaque.getColonne() >= this.getTailleGrille() || attaque.getLigne() >= this.getTailleGrille()) 
				throw new IllegalArgumentException("taille hors limites");
		return attaque; 
	}

	public static void main(String[] args) {
		Coordonnee c = new Coordonnee("B3");
		GrilleNavale g = new GrilleNavale(10,2);
		JoueurTexte j = new JoueurTexte(g, "sylvain");
		j.choixAttaque(); j.retourAttaque(c, 2);
	}
}