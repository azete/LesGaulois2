package Personnages;

public enum Equipement {
	Casque("Casque"), Bouclier("Bouclier");
	private String nom;
	
	private Equipement(String nom) {
		this.nom=nom;
	}
	public String toString() {
		return nom;
	}
}
