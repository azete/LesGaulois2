package Personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax, int forcePotion) {
		this.nom = nom;
		this.forcePotion = forcePotion;
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
		parler("Bonjour , je suis de le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin
				+ " � " + effetPotionMax + " .");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " << " + texte + " >> ");
	}

	private String prendreParole() {
		return "Le druide " + nom + ":";
	}

	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(this.effetPotionMax - this.effetPotionMin) + this.effetPotionMin;
		if (forcePotion > 7) {
			parler(" j'ai preparer une super potion de force " + "" + forcePotion);
		} else {
			parler(" Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide Panoramix = new Druide("Panoramix", 5, 10, 1);
		Panoramix.preparerPotion();
	}
}
