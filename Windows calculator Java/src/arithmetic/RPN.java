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
	static ArrayList<String> s = new ArrayList<String>();
	static Stack<Double> result = new Stack<Double>();
	static double firstOperand;
	static double secondOperand;

	public static char[] convertToRPN(ArrayList<String> list) { // преобразовываем наш массив из верхнего
																// ряда в ОПН
		try {
			for (String string : list) {
				switch (string) {
				case "(":
					stack.addElement(string);
					break;
				case ")":

					break;
				case "^":

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
						s.add(stack.pop());
						stack.addElement(string);
					} else {
						stack.addElement(string);
					}
					break;
				case "-":
					if (!stack.empty()) {
						s.add(stack.pop());
						stack.addElement(string);
					} else {
						stack.addElement(string);
					}
					break;

				default:
					s.add(string);
					break;
				}
			}
			while (!stack.empty()) {
				s.add(stack.pop());
			}
			// return s;
		} catch (EmptyStackException e) {
		} catch (Exception e) {
			// TODO: handle exception
		}
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
