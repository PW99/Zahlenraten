import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ZahlenratenController implements ActionListener, KeyListener, DocumentListener {
	ZahlenratenModel model;
	ZahlenratenView view;
	JButton button, button1;
	JLabel label3, label4, label5;
	JTextField wunsch, zahl;

	int versuch = 0;
	public int eingabe;
	public int bereich = 100;

	public ZahlenratenController() {
		view = new ZahlenratenView();
		model = new ZahlenratenModel(bereich);
		button = view.button;
		button1 = view.button1;
		label3 = view.label3;
		label4 = view.label4;
		label5 = view.label5;
		wunsch = view.wunsch;
		zahl = view.zahl;

		button.addActionListener(this);
		button1.addActionListener(this);
		JTextField zahl = view.zahl;
		zahl.addKeyListener(this);
		wunsch.getDocument().addDocumentListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {

			try {
				eingabe = Integer.parseInt(zahl.getText());
			} catch (Exception ex) {
				label4.setText("Geben Sie eine Zahl zwischen 1 und " + bereich + " ein!");
			}

			if (eingabe < 1 || eingabe > bereich) {
				label4.setText("Geben Sie eine Zahl zwischen 1 und " + bereich + " ein!");
			}

			if (zahl.getText().isEmpty()) {
				label4.setText("Geben Sie eine Zahl zwischen 1 und 100 ein!");
				eingabe = 0;
			}

			if (eingabe >= 1 && eingabe <= bereich) {

				this.versuch += 1;
				label3.setText("Anzahl Versuche: " + versuch);

				zahl.setText("");
				model.Check(eingabe);
				int richtung = model.richtung;

				if (richtung == 1) {
					label4.setText("Die Zahl ist kleiner.");
				}
				if (richtung == 2) {
					label4.setText("Die Zahl ist grösser.");
				}
				if (richtung == 3) {
					label4.setText("Sie haben die Zahl erraten!");
					label4.setFont(new Font("Helvetica", Font.BOLD, 20));
					label4.setForeground(Color.BLUE);
					button.setEnabled(false);
					zahl.setEnabled(false);
					wunsch.setEnabled(false);
				}
			}
		}

		if (e.getSource() == button1) {
			bereich = 100;
			model = new ZahlenratenModel(bereich);
			label3.setText("Anzahl Versuche: 0");
			label4.setText("");
			label4.setFont(new Font("Helvetica", Font.BOLD, 15));
			label4.setForeground(Color.BLACK);
			label5.setText("Eine Zahl zwischen 1 und " + bereich + ":");
			wunsch.setText("100");
			versuch = 0;
			button.setEnabled(true);
			zahl.setEnabled(true);
			wunsch.setEnabled(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			button.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {

	}

	@Override
	public void keyTyped(KeyEvent ke) {

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		try {
			bereich = Integer.parseInt(wunsch.getText());
			label5.setText("Eine Zahl zwischen 1 und " + bereich + ":");
			label4.setText("");
		} catch (Exception ex) {
			label4.setText("Geben Sie eine Zahl beim Zahlenbereich ein.");
		}

		model = new ZahlenratenModel(bereich);

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			bereich = Integer.parseInt(wunsch.getText());
			label5.setText("Eine Zahl zwischen 1 und " + bereich + ":");
			label4.setText("");
		} catch (Exception ex) {
			label4.setText("Geben Sie eine Zahl beim Zahlenbereich ein.");
		}

		model = new ZahlenratenModel(bereich);

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			bereich = Integer.parseInt(wunsch.getText());
			label5.setText("Eine Zahl zwischen 1 und " + bereich + ":");
			label4.setText("");
		} catch (Exception ex) {
			label4.setText("Geben Sie eine Zahl beim Zahlenbereich ein.");
		}

		model = new ZahlenratenModel(bereich);
	}
}
