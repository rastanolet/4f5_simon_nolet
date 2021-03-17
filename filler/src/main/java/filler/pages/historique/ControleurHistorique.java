
package filler.pages.historique;

import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;

public class   ControleurHistorique 
       extends ControleurModeleVue<HistoriqueLectureSeule, 
                                   Historique,
                                   VueHistorique,
                                   AfficheurHistorique> {
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
	}

	@Override
	protected void demarrer() {
		J.appel(this);
	} 

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}
}
