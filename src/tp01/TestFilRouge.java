package tp01;

import java.util.Iterator;
import java.util.Scanner;

public class TestFilRouge {

	public static void main(String[] args) {
		Menu m = new Menu();
		Personne p = new Personne("Jacques", "DUMONT", 60);
		p.nouveauCompte(1000.00,"A");
		p.nouveauCompte(100.0,"B");
		p.nouveauCompte(10.0,"C");
		
		

		Scanner sc = new Scanner(System.in);
		int nb = 5;
		if (sc.hasNextInt()) {
			nb = sc.nextInt();
		} else {
			System.err.println("Il faut saisir un nombre !");
		}

		switch (nb) {
		case 1:
			Iterator<CompteBancaire> listeCompte = p.getCompteBancaires().iterator();
			while(listeCompte.hasNext()){
				CompteBancaire cb = listeCompte.next();
				System.out.println(cb);
			}
			break;
		case 2:
			
			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;

		}

	}
}
