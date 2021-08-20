package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;

import javax.security.auth.kerberos.KerberosCredMessage;
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
		mainArray[mainArray.length - 1] = '0'; // init last array element

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

	public static char[] getMainArray() {
		return mainArray;
	}

	public void setMainArray(char[] mainArray) {
		this.mainArray = mainArray;
	}

	public static void addSymbol(char c) {
		try {
			if (i >=0 ) { //если счетчик массива больше или равен единице (идем с конца в начало)
				if (c != '0' && c != ',') { //если мы вводим цифру от 1 до 9
					if (i == mainArray.length - 1) { //если мы вводим в последнее число массива
						mainArray[mainArray.length - 1] = c; //то присваиваем это значение последнему элементу массива
						i--; //уменьшаем счетчик массива на единицу
					} else { //если же это не последнее число
						for(int k = i; k < mainArray.length - 1; k++) { //пробегаем по массиву от вводимого элемента до конца
							mainArray[k]= mainArray[k+1]; //записываем последующее значение в предыдущее 
						}
							mainArray[mainArray.length - 1] = c; //а последнему элементу присваиваем вводимое нами число
							i--; //уменьшаем счетчик массива на единицу
					}
				} else if (c == '0') { //если мы вводим 0
					if (i == mainArray.length - 1) { //если вводим в последнее значение массива
						mainArray[i] = c; //просто заново присваиваем туда 0 и не меняем счетчик.
						//по факту наверное можно будет удалить эту строку и ничего не делать
					} else { //иначе поступаем точно так же, как в предыдущем случае
						for(int k = i; k < mainArray.length - 1; k++) { //пробегаем по массиву от вводимого элемента до конца
							mainArray[k]= mainArray[k+1]; //записываем последующее значение в предыдущее 
						}
							mainArray[mainArray.length - 1] = c; //а последнему элементу присваиваем вводимое нами число
							i--; //уменьшаем счетчик массива на единицу
					}
				} else { //если вводим запятую
					if (i == mainArray.length - 1) { //вводим в последнее значение (это первый введенный нами символ
						char[] newArray = new char[mainArray.length + 1]; //создаем новый массив на единицу длиннее нашего
						mainArray = newArray; //присваиваем ссылку нашего массива на новый
						mainArray[i] = '0'; //ставим в предпоследнее значение 0
				//		i++; //увеличиваем счетчик
						mainArray[i+1] = c; //сюда заносим вводимую нами запятую
						i--; //уменьшаем значение счетчика на 2 единицы
						comma = true; //меняем логическое значение, чтобы в следующий раз запятую не добавить
					} else { //если вводим не в первое значение
						if (comma == false) { //если запятую еще можно ставить
							char[] newArray = new char[mainArray.length + 1]; //также создаем новый массив на единицу длиннее нашего
							for (int k = 0; k < mainArray.length; k++) { // циклом копируем значения
								newArray[k] = mainArray[k];
							}
							mainArray = newArray; //присваиваем ссылку нашего массива на новый
							mainArray[mainArray.length -1] = c; 
							comma = true; //меняем логическое значение, чтобы в следующий раз запятую не добавить

						} else {
							// тупо морозимся
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("ну обосрались, бывает");
			e.printStackTrace();
		}

		StringBuilder sbf = new StringBuilder();
		for (int i = mainArray.length - 1; i >= 0; i--) {
			if ((int) mainArray[mainArray.length - 1] == 0) {
				sbf.append(mainArray[i]);
				i--;
			} else
				i--;
		}

		setMainRow(mainArray);

	}

	public static void removeSymbol(char c) {
		// char[] array = getMainArray();
		if (mainArray[mainArray.length - 2] == (Character) null) {
			if (mainArray[mainArray.length - 1] != '0') {
				mainArray[mainArray.length - 1] = '0';
				setMainRow(mainArray);
			}
		}
	}
}
