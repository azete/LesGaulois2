package Personnages;
import Personnages.Romain;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom="+ nom + ", force= "+ force + ", effetPotion= " + effetPotion + "]";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le gaulois " + nom+ " : ";
	}
	public void frapper (Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "+ romain.getNom());
		romain.recevoirCoup((force/3)*effetPotion);
	}
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci druide , je sens que ma force est "+ forcePotion+  " fois décuplée.");
	}
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("asterix",8);
		asterix.boirePotion(4);
		Romain minus= new Romain("minus",6);
		asterix.frapper(minus);
	}
}
