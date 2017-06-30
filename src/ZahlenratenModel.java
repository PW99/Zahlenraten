public class ZahlenratenModel {

	ZahlenratenController controller;

	public int richtung;
	public int zahl;

	public ZahlenratenModel(int input) {
		int bereich = input;
		zahl = (int) ((Math.random() * bereich) + 1);
	}

	public void Check(int input) {
		int eingabe = input;

		if (zahl < eingabe) {
			richtung = 1;
		} else if (zahl > eingabe) {
			richtung = 2;
		} else {
			richtung = 3;
		}
	}
}