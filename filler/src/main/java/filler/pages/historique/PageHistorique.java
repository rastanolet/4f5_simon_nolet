package filler.pages.historique;

import javafx.application.Application;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.Initialisateur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;

import static filler.Constantes.*;

import java.util.Random;

public class PageHistorique extends Application{

	static {

		Initialisateur.initialiser();
		
		J.appel(PageHistorique.class);
	}
	
	private Random alea = new Random();
	
	public static void main(String[] args) {
		J.appel(PageHistorique.class);
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		J.appel(this);
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		//Historique historique = EntrepotDeModeles.creerModele(Historique.class, idModeleTest); 
		Historique historique = EntrepotDeModeles.obtenirModele(Historique.class, idModeleTest);
		
		//J.valeurs(historique.getId(), historique.getMatch().getGagnant(), historique.getMatch().getPointJoueur1(),historique.getMatch().getPointJoueur2() );

		
		J.valeurs(historique.getId(), historique.getGagnant(), historique.getPointJoueur1(),historique.getPointJoueur2() );
		
		Systeme.quitter();
		
	}

}
