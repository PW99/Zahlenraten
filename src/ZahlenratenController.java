import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ZahlenratenController implements ActionListener, KeyListener {
	ZahlenratenModel model;
	ZahlenratenView view;
	JButton button, button1;
	JLabel label3, label4;
	JTextField zahl;

	int versuch = 0;
	public int eingabe;

	public ZahlenratenController() {
		view = new ZahlenratenView();
		model = new ZahlenratenModel();
		button = view.button;
		button1 = view.button1;
		label3 = view.label3;
		label4 = view.label4;
		zahl = view.zahl;

		button.addActionListener(this);
		button1.addActionListener(this);
		JTextField zahl = view.zahl;
		zahl.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {

			try {
				eingabe = Integer.parseInt(zahl.getText());
			} catch (Exception ex) {
				label4.setText("Geben Sie eine Zahl zwischen 1 und 100 ein!");
			}

			if (eingabe < 1 || eingabe > 100) {
				label4.setText("Geben Sie eine Zahl zwischen 1 und 100 ein!");
			}
			
			if (zahl.getText().isEmpty()) {
				label4.setText("Geben Sie eine Zahl zwischen 1 und 100 ein!");
				eingabe = 0;
			}
			
			if (eingabe >= 1 && eingabe <= 100) {

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
					label4.setText("Du hast die Zahl erraten!");
					label4.setFont(new Font("Helvetica", Font.BOLD, 20));
					label4.setForeground(Color.BLUE);
					button.setEnabled(false);
					zahl.setEnabled(false);
				}
			}
		}

		if (e.getSource() == button1) {
			model = new ZahlenratenModel();
			label3.setText("Anzahl Versuche: 0");
			label4.setText("");
			label4.setFont(new Font("Helvetica", Font.BOLD, 15));
			label4.setForeground(Color.BLACK);
			versuch = 0;
			button.setEnabled(true);
			zahl.setEnabled(true);
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
}
