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
	static JTextField mainRow;
	static char[] mainArray;
	static int i;
	static boolean comma;
	static final int MAINROW_SIZE = 8;
	static char[] memory; //здесь необходимо разобраться, как правильнее организовать массив памяти
	static ArrayList<char[]> calculatorStack; 

	NormTextField() {
		iniTextField();
	}

	public Container iniTextField() {
		mainArray = new char[MAINROW_SIZE]; // array
		mainArray[mainArray.length - 1] = '0'; // init last array element
		memory = new char[MAINROW_SIZE+1];
		memory[memory.length -1] = '0'; // init last array element
		

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
		return textPanel;

	}

	public JTextField getMainRow() {
		return mainRow;
	}

	public static void setMainRow(char[] c) {

		String string = new String(c);
		mainRow.setText(string);
	}

	public static char[] getMainArray() {
		return mainArray;
	}

	public void setMainArray(char[] mainArray) {
		this.mainArray = mainArray;
	}

	public static void addSymbol(char c) {
		try {
			if (i == mainArray.length - 1) { // если вводим в последний символ массива
				if (mainArray[i] == '0') { // при этом последний символ равен нулю
					if (c == '.') { // если вводим запятую
						char[] newArray = new char[mainArray.length + 1]; // создаем новый массив на единицу длиннее
						mainArray = newArray; // присваиваем ссылку нашего массива на новый
						mainArray[i] = '0'; // ставим в предпоследнее значение 0
						mainArray[i + 1] = c; // сюда заносим вводимую нами запятую
						comma = true; // меняем логическое значение, чтобы в следующий раз запятую не добавить
					} else { // любое другое число
						mainArray[mainArray.length - 1] = c; // меняем ноль на вводимую цифру
					}
				} else { // если последний символ в массиве не ноль
					if (c == '.' && comma == false) { // если вводим запятую
						char[] newArray = new char[mainArray.length + 1]; // создаем новый массив на единицу длиннее
						newArray[i] = mainArray[i]; // переносим туда наше последнее значение(оно будет предпоследним)
						newArray[i + 1] = c; // в последнее вносим запятую
						mainArray = newArray; // присваиваем ссылку нашего массива на новый
						comma = true; // меняем логическое значение, чтобы в следующий раз запятую не добавить
					} else { // если вводим любую цифру
						mainArray[i - 1] = mainArray[i]; // последний символ ставим в предпоследний
						mainArray[i] = c; // в последний ставим 0 (который мы вводим)
						i--;
					}
				}
			} else if (i < mainArray.length - 1 && i > 0) { // если счетчик массива находится между 0 и концом массива
				if (c == '.') { // вводим запятую
					if (comma == false) { // и ее можно вводить
						char[] newArray = new char[mainArray.length + 1]; // создаем новый массив на единицу длиннее
						for (int k = 0; k < mainArray.length; k++) { // бежим по массиву циклом
							newArray[k] = mainArray[k]; // переносим все значения из старого в новый
						}
						newArray[newArray.length - 1] = c; // в последнее вносим запятую
						mainArray = newArray; // присваиваем ссылку нашего массива на новый
						comma = true; // меняем логическое значение, чтобы в следующий раз запятую не добавить
					} else {
						// если вводить нельзя, то ничего не делаем
					}
				} else { // если вводим какие-то цифры
					for (int k = i; k < mainArray.length; k++) { // бежим по главному мкссиву массиву
						mainArray[k - 1] = mainArray[k]; // меняем предыдущие значения на последующие
					}
					mainArray[mainArray.length - 1] = c; // в последний ставим вводимый символ
					i--; // уменьшаем счетчик И
				}
			} else {
				// если И = 0, то ничего не делаем
			}
		} catch (Exception e) {
			System.out.println("ну обосрались, бывает");
			e.printStackTrace();
		}

		setMainRow(mainArray);
		System.out.println("длина массива равна " + mainArray.length + ", а И = " + i);

	}

	public static void removeSymbol() {
		System.out.println("mainArray.length = " + mainArray.length);
		System.out.println("i = " + i + " mainArray[i] = " + mainArray[i]);
		if (i == mainArray.length - 1) {
			mainArray[i] = '0';
		} else {
			if (mainArray[mainArray.length - 1] == '.') {
				char[] newArray = new char[mainArray.length - 1];
				for (int k = i; k < newArray.length; k++) {
					newArray[k] = mainArray[k];
				}
				mainArray = newArray;
				comma = false;
			} else {
				for (int k = mainArray.length - 1; k > i; k--) {
					mainArray[k] = mainArray[k - 1];
				}
				mainArray[i] = 0;
				i++;
			}
		}
		setMainRow(mainArray);
		System.out.println("длина массива равна " + mainArray.length + ", а И = " + i);
	}

	public static void clearCE() {
		char[] newArray = new char[MAINROW_SIZE];
		for (int k = i; k < newArray.length; k++) {
			newArray[k] = 0;
		}
		mainArray = newArray;
		i = mainArray.length - 1;
		mainArray[i] = '0';
		comma = false;
		setMainRow(mainArray);

	}

	public static void memoryRecall() { // получение памяти и отображение ее в текстовом поле
		setMainRow(memoryGet());
	}

	public static void memorySet(String str) {
		char[] array = str.toCharArray();
		memory = array;
	}
	
	public static char[] memoryGet() {
		return memory;
	}
	
	public static void memoryClear() {
		for (int k = 0; k < memory.length; k++) {
			memory[k] = 0;
		}
		memory[memory.length -1] = '0';
	}
	
	public static void memoryPlus(String str) {
		double d = Double.parseDouble(new String(memory)) + Double.parseDouble(str);
		String string = Double.toString(d);
		//use solution from https://stackoverflow.com/questions/14984664/remove-trailing-zero-in-java
		string = string.indexOf(".") < 0 ? string : string.replaceAll("0*$", "").replaceAll("\\.$", "");
		
		if(string.length() > NormTextField.MAINROW_SIZE+1) {
			String string1 = string.substring(0, MAINROW_SIZE+1);
			memorySet(string1);
		} else {
			memorySet(string);
		}
		
//		char[] c1 = string.toCharArray();
//		if (c1.length > NormTextField.MAINROW_SIZE+1) {
//			char[] newC1= new char[NormTextField.MAINROW_SIZE];
//			for (int k = 0; k < newC1.length; k++) {
//				newC1[k] = c1[k];
//			}
//			NormTextField.memorySet(newC1);
//		} else {
//			NormTextField.memorySet(c1);
//		}
	}
	
	public static void resetMainArray() {
		mainArray = new char[MAINROW_SIZE]; // array
		mainArray[mainArray.length - 1] = '0'; // init last array element
		i = mainArray.length - 1; // arraylist iterator
		comma = false;
	}
	
	public static void memoryMinus(String str) {
		double d = Double.parseDouble(new String(memory)) - Double.parseDouble(str);
		String string = Double.toString(d);
		//use solution from https://stackoverflow.com/questions/14984664/remove-trailing-zero-in-java
		string = string.indexOf(".") < 0 ? string : string.replaceAll("0*$", "").replaceAll("\\.$", "");
		
		if(string.length() > NormTextField.MAINROW_SIZE+1) {
			String string1 = string.substring(0, MAINROW_SIZE+1);
			memorySet(string1);
		} else {
			memorySet(string);
		}
	
	}
	

}
