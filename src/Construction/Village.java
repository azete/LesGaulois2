package Construction;

import Personnages.Chef;
import Personnages.Gaulois;
import Personnages.Romain;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois=0;
	Gaulois[] villageois;
	
	public Village(String nom,int nbVillageoisMax) {
		this.nom=nom;
		villageois= new Gaulois[nbVillageoisMax];
	}
	public void setChef(Chef chef) {
		this.chef=chef;
	}
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois villageois) {
		this.villageois[nbVillageois] = villageois;
		nbVillageois += 1;
	}
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef.getNom()+" se trouvent les légendaires Gaulois: \n");
		for (int i=0;i<nbVillageois;i++) {
			System.out.println("- " + villageois[i].getNom()+  "\n");
		}
	}
	public static void main(String[] args) {
		Village oui= new Village("Village des Irréductibles",30);
//		Gaulois gaulois=oui.trouverHabitant(30);
//		on demande de trouver un habitant qui n'existe pas encore
		Chef chef=new Chef("Abraracourcix",6,0,oui);
		oui.setChef(chef);
		Gaulois asterix=new Gaulois("Astérix",8);
		oui.ajouterHabitant(asterix);
//		Gaulois gaulois=oui.trouverHabitant(1);
//		System.out.println(asterix);
		Gaulois obélix=new Gaulois ("Obélix",25);
		oui.ajouterHabitant(obélix);
		oui.afficherVillageois();
	}
}