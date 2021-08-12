package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

public class GreyButton extends JButton {
	public GreyButton(String name) {
		this.setText(name);
		this.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.setBackground(Color.gray);
		this.setOpaque(true);
		this.setMargin(new Insets(1, 1, 1, 1));
	}
}
