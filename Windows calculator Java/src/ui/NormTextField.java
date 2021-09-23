package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public class NormTextField extends JPanel {

	JPanel textPanel;
	static JTextField upperRow;
	static JTextField mainRow;
	static char[] mainArray;
	static int i; // итератор массива текстового поля. Зря связался с эрреями, надо переделать
	static boolean comma;
	static final int MAINROW_SIZE = 17;
	static char[] memory; // здесь необходимо разобраться, как правильнее организовать массив памяти
	static ArrayList<String> calculatorStack;
	static JLabel memo;

	NormTextField() {
		iniTextField();
	}

	public Container iniTextField() {
		mainArray = new char[MAINROW_SIZE]; // array
		mainArray[mainArray.length - 1] = '0'; // init last array element
		memory = new char[MAINROW_SIZE + 1];
		memory[memory.length - 1] = '0'; // init last array element

		calculatorStack = new ArrayList<String>();

		i = mainArray.length - 1; // arraylist iterator
		comma = false; // there is no comma in textfield

		textPanel = new JPanel();

		textPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		textPanel.setBackground(Color.WHITE);
		
		//добавлено сегодня
		JPanel textPanel1 = new JPanel();
		JPanel textPanel2 = new JPanel();
	//	textPanel1.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel2.setLayout(new FlowLayout(FlowLayout.TRAILING,0,0));
//конец добавки сегодня
		
		AbstractBorder brdr = new TextBubbleBorder(Color.gray, 1, 4, 0);
		textPanel.setBorder(brdr);

		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

		upperRow = new JTextField(SwingConstants.RIGHT);
		upperRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, upperRow.getMinimumSize().height));
		upperRow.setHorizontalAlignment(JTextField.RIGHT);
		upperRow.setFont(new Font("Consolas", Font.PLAIN, 12));
		upperRow.setBorder(null);
		upperRow.setFocusable(false);
		
		memo = new JLabel(" ");
		memo.setHorizontalAlignment(SwingConstants.LEFT);

		mainRow = new JTextField("0", SwingConstants.RIGHT);
		mainRow.setFont(new Font("Consolas", Font.PLAIN, 23));
		mainRow.setHorizontalAlignment(JTextField.RIGHT);
		mainRow.setFocusable(false);
		mainRow.setBorder(null);
		
		//добавлено сегодня
		textPanel.add(textPanel1);
		textPanel.add(textPanel2);
		textPanel1.add(upperRow);
		textPanel2.add(memo);
		textPanel2.add(mainRow);
		
		
		//конец добавки сегодня
		
//		textPanel.add(upperRow);
//		mainRow.add(memo);
//		textPanel.add(mainRow);
		return textPanel;

	}

	public static String getMainRow() {
		StringBuilder sbm = new StringBuilder();
		for (int k = 0; k < mainRow.getText().length(); k++) {
			if ((int) mainRow.getText().charAt(k) != 0) {
				sbm.append(mainRow.getText().charAt(k));
			}
		}
		String string = new String(sbm);
		string = string.indexOf(".") < 0 ? string : string.replaceAll("0*$", "").replaceAll("\\.$", "");
		return string;
	}

	public static void setMainRow(char[] c) {

		String string = new String(c);
		if (string.length() > MAINROW_SIZE + 1) {
			string = string.substring(0, MAINROW_SIZE + 2); // берем запас под запятую и знак минус
		}
		mainRow.setText(string);
	}

	public static char[] getMainArray() {
		return mainArray;
	}

	public static void setMainArray(char[] mainArray) {
		NormTextField.mainArray = mainArray;
	}

	public static void addSymbol(char c) {
		try {
			if (i == mainArray.length - 1) { // если вводим в последний символ массива
				if (mainArray[i] == '0') { // при этом последний символ равен нулю
					if (c == '.') { // если вводим запятую
						char[] newArray = new char[mainArray.length + 1]; // создаем новый массив на единицу длиннее
						setMainArray(newArray); // устанавливаем новый массив в главный
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
						setMainArray(newArray); // устанавливаем новый массив в главный
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
						setMainArray(newArray); // устанавливаем новый массив в главный
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
		mainRowFontChanger();
		System.out.println("длина массива равна " + mainArray.length + ", а И = " + i);

	}

	public static void removeSymbol() { // удаление символа
		System.out.println("mainArray.length = " + mainArray.length);
		System.out.println("i = " + i + " mainArray[i] = " + mainArray[i]);
		if (i == mainArray.length - 1 || mainArray[mainArray.length - 2] == '-') { // если удаляем последний символ или
																					// предпоследний - "-"
			char[] newArray = new char[MAINROW_SIZE]; // сбрасываем массив к стандартному размеру
			newArray[i] = '0'; // последний символ ставим 0
			setMainArray(newArray); // задаем его в главный массив

		} else { // если удаляем не последний символ
			if (mainArray[mainArray.length - 1] == '.') { // если предпоследний символ - точка
				char[] newArray = new char[mainArray.length - 1]; // делаем новый массив на 1 короче
				for (int k = i; k < newArray.length; k++) {// бежим циклом по новому массиву
					newArray[k] = mainArray[k]; // копируем значения из старого массива
				}
				setMainArray(newArray);
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
		setMainArray(newArray);
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
		memory[memory.length - 1] = '0';
	}

	public static void memoryPlus(String str) {
		double d = Double.parseDouble(new String(memory)) + Double.parseDouble(str);
		String string = Double.toString(d);
		// use solution from
		// https://stackoverflow.com/questions/14984664/remove-trailing-zero-in-java
		string = string.indexOf(".") < 0 ? string : string.replaceAll("0*$", "").replaceAll("\\.$", "");

		if (string.length() > NormTextField.MAINROW_SIZE + 2) { // тут может быть прикол с переполнением, как и в
																// текстовом поле
			String string1 = string.substring(0, MAINROW_SIZE + 2); // но вернемся к этому потом
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
		setMainArray(new char[MAINROW_SIZE]);
		mainArray[mainArray.length - 1] = '0'; // init last array element
		i = mainArray.length - 1; // arraylist iterator
		comma = false;
	}

	public static void memoryMinus(String str) {
		double d = Double.parseDouble(new String(memory)) - Double.parseDouble(str);
		String string = Double.toString(d);
		// use solution from
		// https://stackoverflow.com/questions/14984664/remove-trailing-zero-in-java
		string = string.indexOf(".") < 0 ? string : string.replaceAll("0*$", "").replaceAll("\\.$", "");

		if (string.length() > NormTextField.MAINROW_SIZE + 1) {
			String string1 = string.substring(0, MAINROW_SIZE + 1);
			memorySet(string1);
		} else {
			memorySet(string);
		}
	}

	public static void negateOp() {
		if (!mainArrayIsClear()) {
			if (Double.parseDouble(getMainRow()) > 0d) {
				char[] newArray = new char[mainArray.length + 1]; // создаем новый массив на единицу длиннее
				for (int k = 0; k < mainArray.length; k++) {
					newArray[k + 1] = mainArray[k];
				}
				newArray[i] = '-';
				setMainArray(newArray);
				setMainRow(newArray);
				System.out.println("длина массива равна " + mainArray.length + ", а И = " + i);
			} else if (Double.parseDouble(getMainRow()) < 0d) {
				char[] newArray = new char[mainArray.length - 1]; // создаем новый массив на единицу короче
				if (i > 0) {
					newArray[i - 1] = 0;
				} else {
					newArray[i] = 0;
				}
				for (int k = i; k < newArray.length; k++) {
					newArray[k] = mainArray[k + 1];
				}
				setMainArray(newArray);
				setMainRow(mainArray);
				mainRowFontChanger();
			}

		} else {
			if (Double.parseDouble(getMainRow()) != 0d) { // TODO: нашел бажок (когда массив сброшен и
				// число занимает всё поле, тогда не остается места для замены знака),
				// первая мысль говорит, что можно это обойти ограничением мейнроу+3
				double negateD = -1 * Double.parseDouble(getMainRow());
				String negateStr = Double.toString(negateD);
				negateStr = negateStr.indexOf(".") < 0 ? negateStr
						: negateStr.replaceAll("0*$", "").replaceAll("\\.$", "");
				setMainRow(negateStr.toCharArray());
			}
		}
	}

	public static void addEquals(String str) { // TODO возможно, приспособим под квадратный корень и дробь
		StringBuilder sb = new StringBuilder();
		sb.append(getUpperRow());
		String upperRowNew = new String(sb);
		calculatorStack.add(str); // добавляем число в стек
		upperRowNew = upperRowNew + str;
		upperRow.setText(upperRowNew);

	}

	public static void addToUpperRow(String number, String oper) {
		StringBuilder sb = new StringBuilder(); // готовым новый билдер
		if (mainArrayIsClear() && !upperRow.getText().equals("")) { // если основной массив сброшен,
			// но в верхнем ряду что-то есть
			sb.append(getUpperRow()); // кидаем верхний ряд в билдер
			sb.replace(sb.length() - 3, sb.length(), oper); // добавляем туда оператор
			calculatorStack.remove(calculatorStack.size() - 1); // удаляем последний элемент стека
			calculatorStack.add(oper.substring(oper.length() - 2, oper.length() - 1)); // добавляем знак заново
																						// (возможно, тут перепишу на
																						// свич кейз)
			String upperRowNew = new String(sb); // заводим строку из нашего билдера
			upperRow.setText(upperRowNew); // кидаем строку обратно в верхний ряд
		} else { // если массив не сброшен
			sb.append(getUpperRow()); // кидаем верхний ряд в билдер
			sb.append(number); // кидаем число из массива в билдер
			String upperRowNew = new String(sb); // зводим строку из нашего билдера
			calculatorStack.add(getMainRow()); // добавляем число в стек
			upperRowNew += oper; // добавляем математический оператор в строку
			calculatorStack.add(oper.substring(oper.length() - 2, oper.length() - 1));
			upperRow.setText(upperRowNew);
		}

	}

	public static void oneToX() {
		StringBuilder sb = new StringBuilder(); // готовым новый билдер
		sb.append(getUpperRow()); // кидаем верхний ряд в билдер
		sb.append("1 / "); //
		calculatorStack.add("1");
		sb.append(getMainRow());
		String upperRowNew = new String(sb); // зводим строку из нашего билдера
		calculatorStack.add("/");
		upperRow.setText(upperRowNew);
	}

	public static String getUpperRow() {
		StringBuilder sbr = new StringBuilder();
		for (int k = 0; k < upperRow.getText().length(); k++) { // проходимся циклом по строке, чтобы не добавлять
			// пустые символы
			if ((int) upperRow.getText().charAt(k) != 0) {
				sbr.append(upperRow.getText().charAt(k));
			}
		}
		String upperRowNew = new String(sbr);
		upperRowNew = upperRowNew.indexOf(".") < 0 ? upperRowNew
				: upperRowNew.replaceAll("0*$", "").replaceAll("\\.$", "");
		return upperRowNew;
	}

	public static void setUpperRow(JTextField upperRow) {
		NormTextField.upperRow = upperRow;
	}

	public static void clearUpperRow() {
		upperRow.setText("");
	}

	public static boolean mainArrayIsClear() {
		if (mainArray.length == MAINROW_SIZE && mainArray[mainArray.length - 1] == '0' && i == mainArray.length - 1) {
			return true;
		} else
			return false;
	}

	public static void mainRowFontChanger() {
		int x = 0; // переменная для счета символов
		StringBuilder sbm = new StringBuilder();
		for (int k = 0; k < mainRow.getText().length(); k++) {
			if ((int) mainRow.getText().charAt(k) != 0) {
				sbm.append(mainRow.getText().charAt(k));
			}
		}
		String string = new String(sbm);
		x = string.length();
		if (x <= 12) {
			mainRow.setFont(new Font("Consolas", Font.PLAIN, 24));
		} else if (x > 12 && x <= 15) {
			mainRow.setFont(new Font("Consolas", Font.PLAIN, 21));
		} else {
			mainRow.setFont(new Font("Consolas", Font.PLAIN, 16));
		}
		// если 13 элементов, то размер шрифта уменьшается
		// если 17 - тоже уменьшается
		// макс размер- 19 (с минусом и запятой, без них 16 или 17

	}

	public static void memoIndicator() {
		double d = Double.parseDouble(new String(memory));
		if (d != 0d) {
			memo.setText("M");
		} else {
			memo.setText("");
		}
	}
}
