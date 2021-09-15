package arithmetic;

import java.util.ArrayList;
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
	static Stack<String> stack = new Stack<String>(); // cтек операций
	static ArrayList<String> s = new ArrayList<String>(); // строка ОПН
	static Stack<Double> result = new Stack<Double>();
	static double firstOperand;
	static double secondOperand;

	public static int getPriority(String c) {
		int priority = 0;
		switch (c) {
		case "(":
			priority = 0;
			break;
		case ")":
			priority = 0;
			break;
		case "^":
			priority = 1;
			break;
		case "*":
			priority = 2;
			break;
		case "/":
			priority = 2;
			break;
		case "+":
			priority = 3;
			break;
		case "-":
			priority = 3;
			break;
		}
		return priority;
	}

	public static char[] convertToRPN(ArrayList<String> list) { // преобразовываем наш массив из верхнего
																// ряда в ОПН
		for (String string : list) {

			try {
				switch (string) {
				case "(":
					stack.addElement(string);
					break;
				case ")":

					break;
				case "^":
					if (!stack.empty()) {
						if (getPriority(string) < getPriority(stack.peek())) {
							stack.addElement(string);
						} else {
							while (!stack.empty() && getPriority(string) >= getPriority(stack.peek())) {
								s.add(stack.pop());
							}
							stack.addElement(string);
						}
					} else
						stack.addElement(string);
					break;
				case "*":
					if (!stack.empty()) {
						if (getPriority(string) < getPriority(stack.peek())) {
							stack.addElement(string);
						} else {
							while (!stack.empty() && getPriority(string) >= getPriority(stack.peek())) {
								s.add(stack.pop());
							}
							stack.addElement(string);
						}
					} else
						stack.addElement(string);
					break;
				case "/":
					if (!stack.empty()) {
						if (getPriority(string) < getPriority(stack.peek())) {
							stack.addElement(string);
						} else {
							while (!stack.empty() && getPriority(string) >= getPriority(stack.peek())) {
								s.add(stack.pop());
							}
							stack.addElement(string);
						}
					} else
						stack.addElement(string);
					break;
				case "+":
					if (!stack.empty()) {
						if (getPriority(string) < getPriority(stack.peek())) {
							stack.addElement(string);
						} else {
							while (!stack.empty() && getPriority(string) >= getPriority(stack.peek())) {
								s.add(stack.pop());
							}
							stack.addElement(string);
						}
					} else
						stack.addElement(string);
					break;
				case "-":
					if (!stack.empty()) {
						if (getPriority(string) < getPriority(stack.peek())) {
							stack.addElement(string);
						} else {
							while (!stack.empty() && getPriority(string) >= getPriority(stack.peek())) {
								s.add(stack.pop());
							}
							stack.addElement(string);
						}
					} else
						stack.addElement(string);
					break;
				default:
					s.add(string);
					break;
				}
				System.out.println(s);

			} catch (Exception e) {
				continue;
			}
		}
		while (!stack.empty()) {
			s.add(stack.pop());
		}
		// return s;
		System.out.println(s);
		return startStackMachine(s);
	}

	public static char[] startStackMachine(ArrayList<String> list) {// да, назвал так в дань уважения
		// ЭВМ прошлого
		// принимаем на вход массив, сформированный в ОПН
		String resultD;

		while (!list.isEmpty()) {
			try {
				for (String element : list) {
					switch (element) {
					case "^":
						secondOperand = result.pop();
						firstOperand = result.pop();
						result.push(Math.pow(firstOperand, secondOperand));
						list.remove(element);
						break;
					case "*":
						secondOperand = result.pop();
						firstOperand = result.pop();
						result.push(firstOperand * secondOperand);
						list.remove(element);
						break;
					case "/":
						secondOperand = result.pop();
						firstOperand = result.pop();
						result.push(firstOperand / secondOperand);
						list.remove(element);
						break;
					case "+":
						secondOperand = result.pop();
						firstOperand = result.pop();
						result.push(firstOperand + secondOperand);
						list.remove(element);
						break;
					case "-":
						secondOperand = result.pop();
						firstOperand = result.pop();
						result.push(firstOperand - secondOperand);
						list.remove(element);
						break;

					default:
						result.push(Double.parseDouble(element));
						list.remove(element);
						break;
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continue;
			}
		}
		resultD = result.pop().toString();
		return resultD.toCharArray();
	}

	public static void clear() {
		s.clear();
		stack.clear();
		result.clear();
	}

}
