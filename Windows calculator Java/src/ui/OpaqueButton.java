package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.AbstractBorder;

public class OpaqueButton extends JButton {
	public OpaqueButton(String name) {
		this.setText(name);
		this.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		setContentAreaFilled(false);
		this.setFocusable(false);
		this.setMargin(new Insets(1, 1, 1, 1));
		AbstractBorder brdr = new TextBubbleBorder(Color.gray, 1, 4, 0);
		this.setBorder(brdr);
	}

}
