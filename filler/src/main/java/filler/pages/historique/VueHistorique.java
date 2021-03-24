
package filler.pages.historique;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import filler.commandes.fermer_historique.FermerHistorique;
import filler.commandes.fermer_historique.FermerHistoriquePourEnvoi;
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VueHistorique implements Vue, Initializable {
	
	private FermerHistoriquePourEnvoi fermerHistorique;

	@FXML
    private HBox conteneurMatch;
	
	@FXML
	private Text pointJoueur1, pointJoueur2;
	
	@FXML
    private Button boutonTerminer;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		
		DoitEtre.nonNul(pointJoueur1);
		DoitEtre.nonNul(pointJoueur2);
		DoitEtre.nonNul(boutonTerminer);

		
	}


	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		fermerHistorique = FabriqueCommande.obtenirCommandePourEnvoi(FermerHistorique.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		boutonTerminer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerHistorique.envoyerCommande();
			}
		});
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherQuiAGagner(String gagnant, int pointJouer1, int pointJouer2) {
		J.appel(this);
		
		DoitEtre.nonNul(gagnant);
		DoitEtre.nonNul(pointJouer1);
		DoitEtre.nonNul(pointJouer2);
		
		pointJoueur1.setText("Joueur1: " + pointJouer1);
		pointJoueur2.setText("Joueur2: " + pointJouer2);
		

		switch(gagnant) {
		
		case "Joueur1":
			conteneurMatch.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(20), null)));
			conteneurMatch.setBorder(new Border(new BorderStroke(Color.BLACK,
					BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(2))));
			break;

		case "Joueur2":
			conteneurMatch.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(20), null)));
			conteneurMatch.setBorder(new Border(new BorderStroke(Color.BLACK,
			        BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(2))));
			break;
		
		}
	}

}
