package filler.pages.historique;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
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
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VueHistorique> chargeur;
		chargeur = new ChargeurDeVue<VueHistorique>(CHEMIN_HISTORIQUE_FXML);

		VueHistorique vue = chargeur.getVue();
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		//Historique historique = EntrepotDeModeles.creerModele(Historique.class, idModeleTest); 
		Historique historique = EntrepotDeModeles.obtenirModele(Historique.class, idModeleTest);
		
		AfficheurHistorique afficheurHistorique = new AfficheurHistorique();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurHistorique.class, historique, vue, afficheurHistorique);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);
		
		capterEvenementFermeture(fenetrePrincipale);

		fenetrePrincipale.show();

		

		
	}
	
	private void capterEvenementFermeture(Stage fenetrePrincipale) {
		J.appel(this);

		fenetrePrincipale.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				J.appel(this);

				Systeme.quitter();
			}
		});
	}

}
