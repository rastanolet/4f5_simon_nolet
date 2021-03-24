
package filler.pages.accueil;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.mvc.Vue;
//import filler.commandes.nouvelle_partie.NouvellePartieLocale;
//import filler.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import filler.commandes.ouvrir_historique.OuvrirHistorique;
import filler.commandes.ouvrir_historique.OuvrirHistoriquePourEnvoi;
import filler.commandes.quitter.Quitter;
import filler.commandes.quitter.QuitterPourEnvoi;
//import filler.pages.partie.vues.VuePartieLocale;

import static filler.Constantes.*;

public class VueAccueil implements Vue, Initializable {
	
	@FXML
	private MenuItem menuNouvellePartieLocale, menuNouvellePartieReseau, menuHistorique, menuQuitter;
	
	@FXML
	private VBox conteneurPartie;
	
	//private NouvellePartieLocalePourEnvoi nouvellePartieLocalePourEnvoi;
	private OuvrirHistoriquePourEnvoi ouvrirHistoriquePourEnvoi;
	private QuitterPourEnvoi quitterPourEnvoi;
	
	private String messageAlerteConnexion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
//		DoitEtre.nonNul(menuNouvellePartieLocale);
		DoitEtre.nonNul(menuHistorique);
		DoitEtre.nonNul(menuQuitter);
		
		messageAlerteConnexion = "Aucune connexion au serveur";
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		//nouvellePartieLocalePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieLocale.class);
		ouvrirHistoriquePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirHistorique.class);
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

//		menuNouvellePartieLocale.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				J.appel(this);
//				
//				nouvellePartieLocalePourEnvoi.envoyerCommande();
//			}
//		});

		menuHistorique.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirHistoriquePourEnvoi.envoyerCommande();
			}
		});
		
		menuQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				quitterPourEnvoi.envoyerCommande();
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

 

	public void alerterErreurConnexion() {
		J.appel(this);

		new Alert(AlertType.ERROR, messageAlerteConnexion).show();
	}

}
