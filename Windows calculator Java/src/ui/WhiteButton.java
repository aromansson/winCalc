package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

public class WhiteButton extends JButton{ //это будет класс для изготовления обычных кнопок

public WhiteButton(String name) {
	this.setText(name);
	this.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	this.setPreferredSize(new Dimension(40, 40));
	this.setMargin(new Insets(5, 0, 5, 0));
}
	
	

}
