package filler.enumerations;

import ntro.debogage.J;


public enum Match {
	
	MATCH_NULL("Joueur1", 0, 0);
	
	private String gagnant = "";
    private int pointJoueur1;
	private int pointJoueur2;
	
	private Match(String gagnant, int pointJoueur1, int pointJoueur2) {
		J.appel(this);

		this.pointJoueur1 = pointJoueur1;
		this.pointJoueur2 = pointJoueur2;
		this.gagnant = gagnant;
	}
	
	public String getGagnant(){
		return gagnant;
	}
	
	public int getPointJoueur1(){
		return pointJoueur1;
	}
	
	public int getPointJoueur2(){
		return pointJoueur2;
	}

}

