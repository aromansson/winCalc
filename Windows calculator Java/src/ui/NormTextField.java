package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NormTextField extends Container {
	Container textPanel;
	JTextField upperRow;
	JTextField mainRow;

	NormTextField() {
		iniTextField();
	}

	public Container iniTextField() {
		textPanel = new Container();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		
		upperRow = new JTextField("0", SwingConstants.RIGHT);
		upperRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, upperRow.getMinimumSize().height));
		upperRow.setHorizontalAlignment(JTextField.RIGHT);
		upperRow.setFont(new Font("Consolas", Font.PLAIN, 12));
		upperRow.setBorder(null);
		upperRow.setFocusable(false);
		
		mainRow = new JTextField("0", SwingConstants.RIGHT);
		mainRow.setPreferredSize(new Dimension(Integer.MAX_VALUE, mainRow.getPreferredSize().height));
		mainRow.setFont(new Font("Consolas", Font.PLAIN, 20));
		mainRow.setHorizontalAlignment(JTextField.RIGHT);
		mainRow.setFocusable(false);
		mainRow.setBorder(null);
		textPanel.add(upperRow);
		textPanel.add(mainRow);
		System.out.println("rere");
		return textPanel;
		
	}

}
