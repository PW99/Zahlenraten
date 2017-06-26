public class ZahlenratenModel {

	ZahlenratenController controller;
	ZahlenratenView view;

	public int richtung;
	public int zahl;

	public ZahlenratenModel() {

		int zahl = (int) ((Math.random() * 100) + 1);
		this.zahl = zahl;
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
