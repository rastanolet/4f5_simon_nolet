
package filler.pages.historique;

import filler.enumerations.Match;
import ntro.mvc.modeles.ModeleLectureSeule;

public interface HistoriqueLectureSeule extends ModeleLectureSeule {
	
	//Match getMatch();
	String getGagnant();
    int getPointJoueur1();
    int getPointJoueur2();

}
