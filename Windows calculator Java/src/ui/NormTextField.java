package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public class NormTextField extends JPanel {


	JPanel textPanel;
	JTextField upperRow;
	JTextField mainRow;
	char[] mainArray;
	int i;

	NormTextField() {
		iniTextField();
	}

	public Container iniTextField() {
		mainArray = new char[17]; // array
		mainArray[16] = '1'; // init first array element
		mainArray[15] = '2'; // init first array element
		
		
		i = 0; // arraylist iterator

		textPanel = new JPanel();

		textPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		textPanel.setBackground(Color.WHITE);

		AbstractBorder brdr = new TextBubbleBorder(Color.gray, 1, 4, 0);
		textPanel.setBorder(brdr);

		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

		upperRow = new JTextField("0", SwingConstants.RIGHT);
		upperRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, upperRow.getMinimumSize().height));
		upperRow.setHorizontalAlignment(JTextField.RIGHT);
		upperRow.setFont(new Font("Consolas", Font.PLAIN, 12));
		upperRow.setBorder(null);
		upperRow.setFocusable(false);

		mainRow = new JTextField("0", SwingConstants.RIGHT);
		mainRow.setFont(new Font("Consolas", Font.PLAIN, 23));
		mainRow.setHorizontalAlignment(JTextField.RIGHT);
		mainRow.setFocusable(false);
		mainRow.setBorder(null);
		textPanel.add(upperRow);
		textPanel.add(mainRow);
//		mainArrayToMainRow();
		return textPanel;

	}

	

	public JTextField getMainRow() {
		return mainRow;
	}

	public void setMainRow(char[] c) {
		
		String string = new String(c);
		this.mainRow.setText(string);
		for (int i = 0; i < mainArray.length; i++) {
	//		if ((int) mainArray[i] == 0)
				}
	}

	public char[] getMainArray() {
		return mainArray;
	}
	
	public void setMainArray(char[] mainArray) {
		this.mainArray = mainArray;
	}
	
//	public String mainArrayToMainRow() {
//		StringBuilder sbf = new StringBuilder();
//		for (int i = 0; i < mainArray.length - 1; i++) {
//			if ((int) mainArray[i] == 0) {
//				sbf.append(mainArray[i]);
//				i++;
//				System.out.println(sbf.append(mainArray[i]));
//			} else
//				i++;
//		}
//
//		mainString = new String(sbf.append(mainArray));
//		return mainString;
//	}
//	
	public void addMainArrayElement
}
