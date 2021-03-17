
package filler.pages.historique;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VueHistorique implements Vue, Initializable {

	@FXML
    private HBox conteneurMatch;
	
	@FXML
	private Text pointJoueur1, pointJoueur2;
	
	//private Map<String, TailleGrille> tailleSelonNom = new HashMap<>();
	//private Map<TailleGrille, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		
		DoitEtre.nonNul(pointJoueur1);
		DoitEtre.nonNul(pointJoueur2);

		//caseRouge.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		
	}


	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
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
			conteneurMatch.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
			break;

		case "Joueur2":
			conteneurMatch.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
			break;
		
		}
	}

}
