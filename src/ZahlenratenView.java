import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ZahlenratenView {
	ZahlenratenController controller;
	public JButton button, button1;
	public JLabel label3, label4, label5;
	public JTextField wunsch, zahl;

	public ZahlenratenView() {

		JFrame frame = new JFrame("Zahlenraten");
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Erraten Sie die unbekannte Zahl.");
		label.setBounds(5, 10, 350, 20);
		label.setVisible(true);
		label.setFont(new Font("Helvetica", Font.BOLD, 20));
		label.setForeground(Color.BLACK);
		frame.add(label);

		JLabel label2 = new JLabel("Ihr Wunschbereich zwischen 1 und ");
		label2.setBounds(5, 50, 260, 20);
		label2.setVisible(true);
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Helvetica", Font.BOLD, 15));
		frame.add(label2);

		label3 = new JLabel("Anzahl Versuche: 0");
		label3.setBounds(5, 170, 200, 20);
		label3.setVisible(true);
		label3.setFont(new Font("Helvetica", Font.BOLD, 12));
		label3.setForeground(Color.BLACK);
		frame.add(label3);

		label4 = new JLabel("");
		label4.setBounds(5, 130, 370, 20);
		label4.setVisible(true);
		label4.setFont(new Font("Helvetica", Font.BOLD, 15));
		label4.setForeground(Color.BLACK);
		frame.add(label4);

		label5 = new JLabel("Eine Zahl zwischen 1 und 100:");
		label5.setBounds(5, 90, 255, 20);
		label5.setVisible(true);
		label5.setFont(new Font("Helvetica", Font.BOLD, 15));
		label5.setForeground(Color.BLACK);
		frame.add(label5);

		wunsch = new JTextField("100");
		wunsch.setBounds(260, 50, 50, 20);
		wunsch.setVisible(true);
		wunsch.setFont(new Font("Helvetica", Font.PLAIN, 12));
		wunsch.setForeground(Color.BLACK);
		frame.add(wunsch);

		zahl = new JTextField("");
		zahl.setBounds(260, 90, 50, 20);
		zahl.setVisible(true);
		zahl.setFont(new Font("Helvetica", Font.PLAIN, 12));
		zahl.setForeground(Color.BLACK);
		frame.add(zahl);

		button = new JButton("Überprüfen");
		button.setBounds(325, 90, 100, 20);
		button.setVisible(true);
		button.setForeground(Color.BLACK);
		frame.add(button);

		button1 = new JButton("neuer Versuch");
		button1.setBounds(305, 170, 120, 20);
		button1.setVisible(true);
		button1.setForeground(Color.BLACK);
		frame.add(button1);

		frame.setLayout(null);
		frame.setVisible(true);
	}

}
