package tttmodell;

import java.util.ArrayList;
import java.util.Collections;

public class TTTModell {
	private char[][] gitter = null;
	ArrayList<String> computerzufall = new ArrayList<String>();
	private String comp; // schau nochmal ob nötig

	public TTTModell() {
		gitter = new char[3][3];

		for (int i = 0; i < 3; i++) {
			for (int a = 0; a < 3; a++) {
				gitter[i][a] = ' ';
			}
		}
	}

	// Methoden
	public void spielereins(int i, int a) {
		gitter[i][a] = 'X';
	}

	public void spielerzwei(int i, int a) {
		gitter[i][a] = 'O';
	}

	public void freierKasten() {
		for (int i = 0; i < 3; i++) {
			for (int a = 0; a < 3; a++) {
				computerzufall.add(i + "," + a);
			}
		}
	Collections.shuffle(computerzufall);
	for (String number : computerzufall) {

	String[] splitten = number.split(",");
	int i = Integer.parseInt(splitten[0]);
		int a = Integer.parseInt(splitten[1]);
		
		if (getZelle(i, a) == 'O') {
				freierKasten();
}
		if (getZelle(i, a) == ' ') {
			spielerzwei(i, a);
			break; // maybe unnötig
}
	if (getZelle(i, a) == 'X') {
		freierKasten();
		}	
	break;
		}
	}
//Wenn Computer Gewinnt ->
	public boolean gewinnErmitteln() {
		boolean gewonnen = false;

		// Checkt die Zeile
		for (int i = 0; i < 3; i++) {
			if (gitter[i][0] == gitter[i][1] && gitter[i][1] == gitter[i][2] && gitter[i][0] == 'O') {
				return true;
			}

		}

		// Checkt die Spalte
		for (int a = 0; a < 3; a++) {
			if (gitter[0][a] == gitter[1][a] && gitter[1][a] == gitter[2][a] && gitter[0][a] == 'O') {
				gewonnen = true;
			}

		}

		// Check die Diagonale
		if (gitter[0][0] == gitter[1][1] && gitter[1][1] == gitter[2][2] && gitter[0][0] == 'O') {
			gewonnen = true;
		}
		if (gitter[2][0] == gitter[1][1] && gitter[1][1] == gitter[0][2] && gitter[2][0] == 'O') {
			gewonnen = true;
		}

		// Kein Sieger
		return gewonnen;

	}
	// Wenn Spieler gewinnt ->
	public boolean gewinnErmitteln2() {
		boolean gewonnen = false;

		// Checkt die Zeile
		for (int i = 0; i < 3; i++) {
			if (gitter[i][0] == gitter[i][1] && gitter[i][1] == gitter[i][2] && gitter[i][0] == 'X') {
				return true;
			}

		}

		// Checkt die Spalte
		for (int a = 0; a < 3; a++) {
			if (gitter[0][a] == gitter[1][a] && gitter[1][a] == gitter[2][a] && gitter[0][a] == 'X') {
				gewonnen = true;
			}

		}

		// Check die Diagonale
		if (gitter[0][0] == gitter[1][1] && gitter[1][1] == gitter[2][2] && gitter[0][0] == 'X') {
			gewonnen = true;
		}
		if (gitter[2][0] == gitter[1][1] && gitter[1][1] == gitter[0][2] && gitter[2][0] == 'X') {
			gewonnen = true;
		}

		// Kein Sieger
		return gewonnen;

	}

	public boolean oberflaeche(char[][] gitter) {
		for (int i = 0; i < 3; i++) {
			for (int a = 0; a < 3; a++) {
				if (gitter[i][a] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	public void visualisieren() {
		System.out.println("-----------");
		System.out.println("|" + gitter[0][0] + "|" + gitter[0][1] + "|" + gitter[0][2] + "|");
		System.out.println("|" + gitter[1][0] + "|" + gitter[1][1] + "|" + gitter[1][2] + "|");
		System.out.println("|" + gitter[2][0] + "|" + gitter[2][1] + "|" + gitter[2][2] + "|");
		System.out.println("-----------");
	}

	public char getZelle(int i, int a) {
		return gitter[i][a];
	}
}