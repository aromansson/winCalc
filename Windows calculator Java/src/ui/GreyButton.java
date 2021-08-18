package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.AbstractBorder;

public class GreyButton extends JButton {
	public GreyButton(String name) {
		this.setText(name);
		this.setName(name);
		this.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		this.setBackground(Color.lightGray);
		this.setOpaque(true);
		this.setFocusable(false);
		this.setMargin(new Insets(1, 1, 1, 1));
		AbstractBorder brdr = new TextBubbleBorder(Color.gray, 1, 4, 0);
		this.setBorder(brdr);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getComponent().getName());

			}
		});
	}
}
