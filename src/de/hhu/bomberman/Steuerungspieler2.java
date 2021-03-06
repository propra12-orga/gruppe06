public class SteuerungSp2 extends Main {

	/**
	 * Bei einem Tastendruck werden die entsprechenden Parameter veraendert
	 */
	public static void aktionen() {

		/*
		 * Steuerung, StdDraw wurde bearbeitet in Zeile 1363. KeyListener des
		 * Frames wurde bentigt. Wurde einer Pfeiltaste oder iwas gedrckt,
		 * boolean=true, Abfrage hier: kommt "Spieler"-Radius an Rand, setzte
		 * Spieler auf: Position = Rand - Spieler-Radius
		 */

		if (isLeft2()) {
			if (getSp2().getX() < 0 + getFeld()[0][0].size / 2.25 + 0.015)
				getSp2().setX(0 + getFeld()[0][0].size / 2.25);
			else
				getSp2().setX(getSp2().getX() - 0.015 * getSp2().getSpeed() / 4
						/ (getSpielfelder() / 12));
		}
		if (isRight2()) {
			if (getSp2().getX() > 1 - getFeld()[0][0].size / 2.25 - 0.015)
				getSp2().setX(1 - getFeld()[0][0].size / 2.25);
			else
				getSp2().setX(getSp2().getX() + 0.015 * getSp2().getSpeed() / 4
						/ (getSpielfelder() / 12));
		}
		if (isDown2()) {
			if (getSp2().getY() < 0 + getFeld()[0][0].size / 2.25 + 0.015)
				getSp2().setY(0 + getFeld()[0][0].size / 2.25);
			else
				getSp2().setY(getSp2().getY() - 0.015 * getSp2().getSpeed() / 4
						/ (getSpielfelder() / 12));
		}
		if (isUp2()) {
			if (getSp2().getY() > 1 - getFeld()[0][0].size / 2.25 - 0.015)
				getSp2().setY(1 - getFeld()[0][0].size / 2.25);
			else
				getSp2().setY(getSp2().getY() + 0.015 * getSp2().getSpeed() / 4
						/ (getSpielfelder() / 12));
		}

		/*
		 * wenn Tab gedrckt wird:
		 * 
		 * 1)gecheckt, ob der bombencounter gleich 479 ist, wenn ja counter=0;
		 * 
		 * 2)neue Bombe wird im Thread erstellt. vorher wird geprft auf
		 * welchem feld sich der spieler sich befinden, damit die bombe dort
		 * plaziert wird
		 * 
		 * 3)counter wird um eins erweitert
		 * 
		 * 4)space boolean wird auf false gesetzt, damit der befehl nochmal
		 * aufgerufen werden kann
		 */
		if (isSpace2()) {

			if (getBombencounter() == getBombenanzahl() - 1)
				setBombencounter(0);
			// FeldCheck.check(Sp2.getX(), Sp2.getY());

			// bombennummer des spieler2 wird erhoeht
			Feldwiedergabe fw = new Feldwiedergabe();
			fw = FeldCheck.check(getSp2().getX(), getSp2().getY());

			if (getFeld()[fw.getX()][fw.getY()].belegt == false
					& getSp2().getBombenanzahlcounter() < getSp2().getMaxbombenanzahl()) {
				getBombe2()[getBombencounter()] = new BombeSp2(getBombe_x(), getBombe_y(), true,
						FeldCheck.check(getSp2().getX(), getSp2().getY()), getBombencounter(),
						"bombe", 1);
				getBombe2()[getBombencounter()].start();
				getFeld()[getX_feld()][getY_feld()].beinhaltet = "bombe";
				getFeld()[getX_feld()][getY_feld()].belegt = true;
				setBombencounter(getBombencounter() + 1);
				getSp2().setBombenanzahlcounter(getSp2().getBombenanzahlcounter() + 1);

			}
			setSpace2(false);
		}

	}
}

