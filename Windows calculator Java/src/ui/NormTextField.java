package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

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
	String mainString;
	String upperString;

	NormTextField() {
		iniTextField();
	}

	public Container iniTextField() {
		mainArray = new char[17]; // array
		mainArray[0] = '1'; // init first arrray element
		mainArray[1] = '2'; // init first arrray element
		mainArray[2] = '3'; // init first arrray element
		mainArray[3] = '4'; // init first arrray element
		mainArray[4] = '5'; // init first arrray element
		mainArray[5] = '6'; // init first arrray element
		mainArray[6] = '7'; // init first arrray element
		mainArray[7] = '8'; // init first arrray element
		mainArray[8] = '9'; // init first arrray element
		mainArray[9] = '0'; // init first arrray element
		mainArray[10] = '1'; // init first arrray element
		mainArray[11] = '2'; // init first arrray element
		mainArray[12] = '3'; // init first arrray element
		mainArray[13] = '4'; // init first arrray element
		mainArray[14] = '5'; // init first arrray element
		mainArray[15] = '6'; // init first arrray element
		mainArray[16] = '7'; // init first arrray element
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

	public String mainArrayToMainRow() {
		StringBuilder sbf = new StringBuilder();
		for (int i = 0; i < mainArray.length-1; i++) {
			if ((int) mainArray[i] == 0) {
				sbf.append(mainArray[i]);
				i++;
				System.out.println(sbf.append(mainArray[i]));
			} else
				i++;
		}

		mainString = new String(sbf.append(mainArray));
		return mainString;
	}
	
	public JTextField getMainRow() {
		return mainRow;
	}
	
	public void setMainRow() {
		mainArrayToMainRow();
		this.mainRow.setText(mainString);
	}

}
