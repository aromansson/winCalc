package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

public class WhiteButton extends JButton { // это будет класс для изготовления
											// обычных кнопок
	public WhiteButton(String name) {
		this.setName(name);
		this.setText(name);
		this.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//		this.setPreferredSize(new Dimension(40, 40));
		this.setBackground(new Color(232, 238, 245));
		this.setFocusable(false);
		// this.setMargin(new Insets(0, 0, 0, 0));
		AbstractBorder brdr = new TextBubbleBorder(Color.gray, 1, 4, 0);
		this.setBorder(brdr);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				char[] ar = e.getComponent().getName().toCharArray();
				NormTextField.addSymbol(ar[0]);
//				System.out.println(e.getComponent().getName());
			}
		});
	}
}
