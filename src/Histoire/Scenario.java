package Histoire;
import Personnages.Gaulois;
import Personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		asterix.parler("Bonjour a tous");
		Romain minus= new Romain("minus",6);
		minus.parler("Un GAU... Un GAUGAU....");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}
