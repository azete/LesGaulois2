package Personnages;

import personnages.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement [2];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " << " + texte + " >>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int oldforce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		assert oldforce > force;
	}
	public void setEquiper(Equipement equip) {
		this.equipements[nbEquipement] = equip;
		this.nbEquipement++;
		System.out.println(" Le soldat " + nom + "  s'équipe d'un " + equip.toString() + " .");
	}
	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
		case 2:
			System.out.println(" Le soldat " + nom + "  est déjà bien protégé !");
			break;
		case 0:
			setEquiper(equip);
			break;
		case 1:
			if ((equipements[0]).toString() == equip.toString()) {
				System.out.println(" Le soldat " + nom + "  possède deja un " + equip.toString() + " !");
			} else {
				setEquiper(equip);
			}
			break;
		}
	}
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(8);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
	}
}
