package Histoire;
import Personnages.Gaulois;
import Personnages.Romain;
import Personnages.Druide;
public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		Druide panoramix= new Druide("panoramix", 5,10);
		Gaulois Ob�lix= new Gaulois("Ob�lix", 15);
		panoramix.parler("Je vais preparer une petite Potion..");
		panoramix.preparerPotion();
		panoramix.booster(Ob�lix);
		Ob�lix.parler("Par B�l�nos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour a tous");
		Romain minus= new Romain("minus",6);
		minus.parler("Un GAU... Un GAUGAU....");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}
