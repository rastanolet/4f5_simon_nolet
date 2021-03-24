
package filler.pages.accueil;

import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurVue;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.modeles.EntrepotDeModeles;
import javafx.scene.Scene;
import javafx.stage.Stage;
import filler.commandes.fermer_historique.FermerHistorique;
import filler.commandes.fermer_historique.FermerHistoriqueRecue;
//import filler.commandes.nouvelle_partie.NouvellePartieLocale;
//import filler.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import filler.commandes.ouvrir_historique.OuvrirHistorique;
import filler.commandes.ouvrir_historique.OuvrirHistoriqueRecue;
import filler.commandes.quitter.Quitter;
import filler.commandes.quitter.QuitterRecue;
import filler.pages.historique.AfficheurHistorique;
import filler.pages.historique.ControleurHistorique;
import filler.pages.historique.Historique;
import filler.pages.historique.VueHistorique;
//import filler.pages.partie.afficheurs.AfficheurPartieLocale;
//import filler.pages.partie.controleurs.ControleurPartieLocale;
//import filler.pages.partie.modeles.PartieLocale;
//import filler.pages.partie.vues.VuePartieLocale;
import filler.pages.historique.Historique;

import static filler.Constantes.*;

import java.io.IOException;
import java.util.Random;

public class ControleurAccueil extends ControleurVue<VueAccueil> {

	private Scene sceneHistorique;
	private Stage dialogueHistorique;
	private Historique historique;

	private Random alea = new Random();

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);


		installerRecepteurCommande(OuvrirHistorique.class, new RecepteurCommandeMVC<OuvrirHistoriqueRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirHistoriqueRecue commande) {
				J.appel(this);
				
				ouvrirHistorique();
			}
		});

		installerRecepteurCommande(FermerHistorique.class, new RecepteurCommandeMVC<FermerHistoriqueRecue>() {
			@Override
			public void executerCommandeMVC(FermerHistoriqueRecue commande) {
				J.appel(this);
				
				fermerHistorique();
			}
		});

		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);

				quitter();
			}
		});
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}

	@Override
	protected void demarrer() {
		J.appel(this);

		try {
			instancierControleurHistorique();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ouvrirPartieLocale();
	}

	private void instancierControleurHistorique() throws Exception {
		J.appel(this);

		ChargeurDeVue<VueHistorique> chargeur;
		chargeur = new ChargeurDeVue<VueHistorique>(CHEMIN_HISTORIQUE_FXML);
		
		sceneHistorique = chargeur.nouvelleScene(LARGEUR_PARAMETRES_PIXELS, 
				                                 HAUTEUR_PARAMETRES_PIXELS);
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		
		historique = EntrepotDeModeles.obtenirModele(Historique.class, idModeleTest);
		
		AfficheurHistorique afficheurHistorique = new AfficheurHistorique();
		
		VueHistorique vueHistorique = chargeur.getVue();
		
		FabriqueControleur.creerControleur(ControleurHistorique.class, 
				                           historique, 
				                           vueHistorique, 
				                           afficheurHistorique);
	}

//	private void ouvrirPartieLocale() {
//		J.appel(this);
//		
//		try {
//
//			partieLocale = EntrepotDeModeles.obtenirModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);
//
//		} catch (IOException e) {
//			
//			creerNouvellePartieLocaleSelonParametres(parametres);
//		}
//		
//		instancierControleurPartieLocale();
//	}
	
//	private void nouvellePartieLocale() {
//		J.appel(this);
//
//		creerNouvellePartieLocaleSelonParametres(parametres);
//
//		instancierControleurPartieLocale();
//	}

//	private void instancierControleurPartieLocale() {
//		J.appel(this);
//
//		VuePartieLocale vuePartieLocale = getVue().creerVuePartieLocale();
//
//		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();
//
//		FabriqueControleur.creerControleur(ControleurPartieLocale.class, 
//			                           	   partieLocale, 
//			                           	   vuePartieLocale, 
//			                           	   afficheur);
//	}

//	private void creerNouvellePartieLocaleSelonParametres(Parametres parametres) {
//		J.appel(this);
//
//		partieLocale = EntrepotDeModeles.creerModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);
//		partieLocale.setCouleurCourante(parametres.getQuiCommence());
//		partieLocale.setLargeur(parametres.getTailleGrille().getLargeur());
//		partieLocale.setHauteur(parametres.getTailleGrille().getHauteur());
//	}

	private void ouvrirHistorique() {
		J.appel(this);
		
		dialogueHistorique = DialogueModal.ouvrirDialogueModal(sceneHistorique);
		
		dialogueHistorique.setMinWidth(LARGEUR_PARAMETRES_PIXELS_MIN);
		dialogueHistorique.setMinHeight(HAUTEUR_PARAMETRES_PIXELS_MIN);

		dialogueHistorique.setWidth(LARGEUR_PARAMETRES_PIXELS);
		dialogueHistorique.setHeight(HAUTEUR_PARAMETRES_PIXELS);

		dialogueHistorique.setMaxWidth(LARGEUR_PARAMETRES_PIXELS_MAX);
		dialogueHistorique.setMaxHeight(HAUTEUR_PARAMETRES_PIXELS_MAX);
	}

	private void fermerHistorique() {
		J.appel(this);
		
		if(dialogueHistorique != null) {
			dialogueHistorique.close();
		}
	}

	private void quitter() {
		J.appel(this);

		//sauvegarderPartieLocale();

		Systeme.quitter();
	}


//	private void sauvegarderPartieLocale() {
//		J.appel(this);
//
//		if (partieLocale != null) {
//			try {
//
//				EntrepotDeModeles.sauvegarderModele(partieLocale);
//
//			} catch (IOException e) {
//
//				Erreur.nonFatale("Impossible de sauvegarder la partie locale", e);
//			}
//		}
//	}
}
