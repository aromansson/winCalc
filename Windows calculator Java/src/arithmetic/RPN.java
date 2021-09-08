package arithmetic;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class RPN { // моя попытка написать reverse polish notation
	/*
	 * как я буду рассуждать нужно создать массив ArrayList<char[]> куда будем
	 * заносить а) числа б) знаки идея в том, чтобы числа, к которым будет
	 * применяться один и тот же знак, заносить подряд, в начало массива, а знаки -
	 * в конец. Есть вопрос по скобкам, посмотрю в интернете, как это делается такой
	 * вид массива выбран не случайно: его легко расширять при добавлении символов
	 * или сужать при освобождении стека
	 * https://stackoverflow.com/questions/14100522/reverse-polish-notation-java
	 */
	static Stack<String> stack = new Stack<String>();
	static String s = new String();
	static double number1;
	static double number2;

	public static String convertToRPN(ArrayList<String> list) { // преобразовываем в
																// обратную польскую
																// нотацию
		try {
			for (String string : list) {
				switch (string) {
				case "(":
					stack.addElement(string);
					break;
				case "^":

					break;
				case ")":

					break;
				case "*":
					if (!stack.empty()) {
						stack.addElement(string);
					} else {
						stack.addElement(string);
					}
					break;
				case "/":
					if (!stack.empty()) {
						stack.addElement(string);
					} else {
						stack.addElement(string);
					}
					break;
				case "+":
					if (!stack.empty()) {
						s += stack.pop();
						stack.addElement(string);
					} else {
						stack.addElement(string);
					}
					break;
				case "-":
					if (!stack.empty()) {
						s += stack.pop();
						stack.addElement(string);
					} else {
						stack.addElement(string);
					}
					break;

				default:
					s += string;
					break;
				}
			}
			while (!stack.empty()) {
				s += stack.pop();
			}
			return s;
		} catch (EmptyStackException e) {
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;

	}

	public void startStackMachine(ArrayList<String> list) {// да, назвал так в дань уважения
															// ЭВМ прошлого
		// принимаем на вход наш лист из массива,
		// формируемого в текстовом поле

	}

	public static void clear() {
		s = new String();
		stack.clear();
	}

}
