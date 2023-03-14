package Personnages;

import Personnages.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement [2];
	private int nbEquipement=0;
	private String texte;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + " << " + texte + " >>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int oldforce = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e !");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert oldforce > force;
//	}
	public void setEquiper(Equipement equip) {
		this.equipements[nbEquipement] = equip;
		this.nbEquipement++;
		System.out.println(" Le soldat " + nom + "  s'�quipe d'un " + equip.toString() + " .");
	}
	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
		case 2:
			System.out.println(" Le soldat " + nom + "  est d�j� bien prot�g� !");
			break;
		case 0:
			setEquiper(equip);
			break;
		case 1:
			if ((equipements[0]).toString() == equip.toString()) {
				System.out.println(" Le soldat " + nom + "  poss�de deja un " + equip.toString() + " !");
			} else {
				setEquiper(equip);
			}
			break;
		}
	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("A�e");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminu�e
		assert force <= oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + " , et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.Bouclier)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup <= 0) {
			if ((force-forceCoup)<0) {
				return force=0;
			}else {
				return force-forceCoup;
			}
		} else {
			return forceCoup;
		}
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
