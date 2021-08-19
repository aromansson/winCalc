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
	static JTextField mainRow;
	static char[] mainArray;
	static int i;
	static boolean comma;

	NormTextField() {
		iniTextField();
	}

	public Container iniTextField() {
		mainArray = new char[8]; // array
		mainArray[mainArray.length - 1] = '0'; // init first array element

		i = mainArray.length - 1; // arraylist iterator
		comma = false; // there is no comma in textfield

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

	public static void setMainRow(char[] c) {

		String string = new String(c);
		mainRow.setText(string);
		for (int i = 0; i < mainArray.length; i++) {
			// if ((int) mainArray[i] == 0)
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
	public static void addMainArrayElement(char c) {

		try {
			if (i >= 1) {
				if (c != '0' && c != ',') {
					mainArray[mainArray.length - 1] = c;
					i--;
				} else if (c == '0') {
					if (i < mainArray.length - 1) {
						mainArray[i] = c;
						i--;
					} else
						mainArray[i] = c;
				} else {
					if (i == mainArray.length - 1) {
						char[] newArray = new char[mainArray.length + 1];
						mainArray = newArray;
						mainArray[mainArray.length - 2] = '0';
						i++;
						mainArray[i] = c;
						i--;
						comma = true;
					} else {
						if (comma == false) {
							char[] newArray = new char[mainArray.length + 1];
							System.arraycopy(mainArray, 0, newArray, 0, mainArray.length);
							mainArray = newArray; // move link
							mainArray[i] = c;
							i++;
							comma = true;

						} else {
							// do nothing
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuilder sbf = new StringBuilder();
		for (int i = mainArray.length - 1; i >= 1; i--) {
			if ((int) mainArray[mainArray.length - 1] == 0) {
				sbf.append(mainArray[i]);
				i--;
				System.out.println(sbf.append(mainArray[i]));
			} else
				i--;
		}

		setMainRow(mainArray);

	}

//	public static void addMainArrayElement(char c) {
//
//		try {
//			if (i < mainArray.length) {
//				if (c != 0 && c != ',') {
//					mainArray[i] = c;
//					i++;
//				} else if (c == '0') {
//					if (i > 0) {
//						mainArray[i] = c;
//						i++;
//					} else
//						mainArray[i] = c;
//				} else {
//					if (i == 0) {
//						char[] newArray = new char[mainArray.length + 1];
//						mainArray = newArray;
//						mainArray[i] = '0';
//						i++;
//						mainArray[i] = c;
//						i++;
//						comma = true;
//					} else {
//						if (comma == false) {
//							char[] newArray = new char[mainArray.length + 1];
//							System.arraycopy(mainArray, 0, newArray, 0, mainArray.length);
//							mainArray = newArray; // move link
//							mainArray[i] = c;
//							i++;
//							comma = true;
//
//						} else {
//							// do nothing
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
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
//		setMainRow(mainArray);
//
//	}

}
