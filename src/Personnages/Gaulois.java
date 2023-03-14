package Personnages;

import Personnages.Romain;
import Personnages.Equipement;
import Personnages.Musee;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force= " + force + ", effetPotion= " + effetPotion + "]";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci druide , je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	public void faireDonation(Musee musee,Gaulois gaulois) {
		if (nb_trophees!=0) {
			parler("Je donne au musée tous mes trophées :");
			for (int i=0;i<nb_trophees;i++) {
				System.out.println("- "+ trophees[i].toString() +" \n");
				musee.donnerTrophee(gaulois,trophees[i]);
		}
	}
}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		asterix.boirePotion(4);
		Romain minus = new Romain("minus", 6);
		asterix.frapper(minus);
	}
}
