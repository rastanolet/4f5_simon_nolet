
package filler.pages.historique;

import ntro.debogage.J;
import ntro.mvc.Afficheur;

public class   AfficheurHistorique 
       extends Afficheur<HistoriqueLectureSeule, VueHistorique> {

	@Override
	public void initialiserAffichage(HistoriqueLectureSeule modeleLectureSeule, VueHistorique vue) {
		J.appel(this);
	}

	@Override
	public void rafraichirAffichage(HistoriqueLectureSeule modeleLectureSeule, VueHistorique vue) {
		J.appel(this);

		vue.afficherQuiAGagner(modeleLectureSeule.getGagnant(), modeleLectureSeule.getPointJoueur1(), modeleLectureSeule.getPointJoueur2());
		
	}

}
