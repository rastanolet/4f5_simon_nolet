package filler.pages.historique;

import filler.enumerations.Match;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Historique extends Modele<HistoriqueLectureSeule> implements HistoriqueLectureSeule {
	
	//private Match match;
	private String gagnant = "";
    private int pointJoueur1;
	private int pointJoueur2;
	

	@Override
	public void apresCreation() {
		J.appel(this);
		
		// match = Match.MATCH_NULL;
		
		gagnant = "Joueur1";
		pointJoueur1 = 0;
		pointJoueur2= 0;
		
	
	}



	@Override
	public void apresChargementJson() {
		J.appel(this);
		
		//DoitEtre.nonNul(match);
		DoitEtre.nonNul(gagnant);
		DoitEtre.nonNul(pointJoueur1);
		DoitEtre.nonNul(pointJoueur1);
		
	}



	public String getGagnant() {
		return gagnant;
	}



	public void setGagnant(String gagnant) {
		this.gagnant = gagnant;
	}



	public int getPointJoueur1() {
		return pointJoueur1;
	}



	public void setPointJoueur1(int pointJoueur1) {
		this.pointJoueur1 = pointJoueur1;
	}



	public int getPointJoueur2() {
		return pointJoueur2;
	}



	public void setPointJoueur2(int pointJoueur2) {
		this.pointJoueur2 = pointJoueur2;
	}



	@Override
	public Match getMatch() {
		// TODO Auto-generated method stub
		return null;
	}


	



	




	


}
