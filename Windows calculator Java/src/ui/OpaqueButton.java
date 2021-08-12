package ui;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

public class OpaqueButton extends JButton{
	public OpaqueButton(String name){
		this.setText(name);
		this.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setContentAreaFilled(false);
		this.setMargin(new Insets(5, 0, 5, 0));
	}
	
}
