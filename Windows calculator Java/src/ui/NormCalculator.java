package ui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import arithmetic.RPN;

public class NormCalculator {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	GridBagLayout gbl = new GridBagLayout();
	NormTextField field = new NormTextField(); // поле для ввода цифр обычного калькулятора
	MenuBar menuBar; // экземпляр класса
	static JLabel memo = new JLabel(" ");

	// инициализируем все кнопки
	WhiteButton button1 = new WhiteButton("1");
	WhiteButton button2 = new WhiteButton("2");
	WhiteButton button3 = new WhiteButton("3");
	WhiteButton button4 = new WhiteButton("4");
	WhiteButton button5 = new WhiteButton("5");
	WhiteButton button6 = new WhiteButton("6");
	WhiteButton button7 = new WhiteButton("7");
	WhiteButton button8 = new WhiteButton("8");
	WhiteButton button9 = new WhiteButton("9");
	WhiteButton button0 = new WhiteButton("0");
	GreyButton buttonPlus = new GreyButton("+");
	GreyButton buttonEqual = new GreyButton("=");
	GreyButton buttonMinus = new GreyButton("-");
	GreyButton buttonMultipl = new GreyButton("*");
	GreyButton buttonDivide = new GreyButton("/");
	GreyButton buttonPercent = new GreyButton("%");
	WhiteButton buttonDot = new WhiteButton(".");
	GreyButton buttonOneX = new GreyButton("1/x");
	GreyButton buttonSqrt = new GreyButton("\u221A");
	GreyButton buttonPlusMinus = new GreyButton("\u00B1");
	GreyButton buttonC = new GreyButton("C");
	GreyButton buttonCE = new GreyButton("CE");
	GreyButton buttonBack = new GreyButton("\u2190");
	OpaqueButton buttonMC = new OpaqueButton("MC");
	OpaqueButton buttonMR = new OpaqueButton("MR");
	OpaqueButton buttonMS = new OpaqueButton("MS");
	OpaqueButton buttonMPlus = new OpaqueButton("M+");
	OpaqueButton buttonMMinus = new OpaqueButton("M-");

	public NormCalculator() { // пиздякнем конструктор
		initNormCalculator();
	}

	public void initNormCalculator() {
		panel.setLayout(gbl);
		panel.setBorder(BorderFactory.createEmptyBorder(13, 12, 14, 12)); // въебениваем поля по краям панели
		panel.setBackground(new Color(217, 228, 241));
		// (https://stackoverflow.com/questions/5854005/setting-horizontal-and-vertical-margins)
		Constraints c = new Constraints();
		// gbl.setConstraints(field.iniTextField(), c.get());
		panel.add(memo);
		panel.add(field.textPanel, c.get());
//		panel.add(field.textPanel);

		panel.add(buttonMC, c.nextRow());
		panel.add(buttonMR, c.nextButton());
		panel.add(buttonMS, c.nextButton());
		panel.add(buttonMPlus, c.nextButton());
		panel.add(buttonMMinus, c.lastRowButton());

		panel.add(buttonBack, c.nextRow());
		panel.add(buttonCE, c.nextButton());
		panel.add(buttonC, c.nextButton());
		panel.add(buttonPlusMinus, c.nextButton());
		panel.add(buttonSqrt, c.lastRowButton());

		panel.add(button7, c.nextRow());
		panel.add(button8, c.nextButton());
		panel.add(button9, c.nextButton());
		panel.add(buttonDivide, c.nextButton());
		panel.add(buttonPercent, c.lastRowButton());

		panel.add(button4, c.nextRow());
		panel.add(button5, c.nextButton());
		panel.add(button6, c.nextButton());
		panel.add(buttonMultipl, c.nextButton());
		panel.add(buttonOneX, c.lastRowButton());

		panel.add(button1, c.nextRow());
		panel.add(button2, c.nextButton());
		panel.add(button3, c.nextButton());
		panel.add(buttonMinus, c.nextButton());
		c.lastRowButton();
		panel.add(buttonEqual, c.spanY());

		c.nextRow();
		panel.add(button0, c.span());
		c.nextButton();
		panel.add(buttonDot, c.nextButton());
		panel.add(buttonPlus, c.nextButton());

		menuBar = new MenuBar();
		frame.setJMenuBar(menuBar.initMenuBar());
		frame.setContentPane(panel);
		frame.setSize(228, 322); // размер фрейма
		frame.setResizable(false); // не разрешаем менять размер
		frame.setVisible(true); // делаем видимым
		frame.setTitle("Калькулятор"); // добавляем заголовок окна
		frame.setLocationRelativeTo(null);// не привязываем к краям экрана, пусть где-то в центре появляется
		// сетапаем картинку нашему калькулятору, взято отсюда
		// https://ourcodeworld.com/articles/read/835/how-to-change-a-frame-s-title-bar-icon-application-icon-in-java-awt-toolkit
		Image img = Toolkit.getDefaultToolkit().getImage("src/wincalc.png");
		// Image img =
		// Toolkit.getDefaultToolkit().getImage("src/windows-calculator-icon-8.png");
		frame.setIconImage(img);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// завершаем программу при закрытии формы

		frame.addKeyListener(new KeyAdapter() { // добавляем ввод циферок с клавиатуры и нумпада

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_NUMPAD9:
					NormTextField.addSymbol('9');
					break;
				case KeyEvent.VK_NUMPAD8:
					NormTextField.addSymbol('8');
					break;
				case KeyEvent.VK_NUMPAD7:
					NormTextField.addSymbol('7');
					break;
				case KeyEvent.VK_NUMPAD6:
					NormTextField.addSymbol('6');
					break;
				case KeyEvent.VK_NUMPAD5:
					NormTextField.addSymbol('5');
					break;
				case KeyEvent.VK_NUMPAD4:
					NormTextField.addSymbol('4');
					break;
				case KeyEvent.VK_NUMPAD3:
					NormTextField.addSymbol('3');
					break;
				case KeyEvent.VK_NUMPAD2:
					NormTextField.addSymbol('2');
					break;
				case KeyEvent.VK_NUMPAD1:
					NormTextField.addSymbol('1');
					break;
				case KeyEvent.VK_NUMPAD0:
					NormTextField.addSymbol('0');
					break;
				case KeyEvent.VK_ENTER:
					NormTextField.addEquals(NormTextField.getMainRow()); // работает
					System.out.println(NormTextField.calculatorStack);
					// System.out.println(RPN.convertToRPN(NormTextField.calculatorStack));
					NormTextField.clearUpperRow();
					NormTextField.resetMainArray();
					String tempString = new String(RPN.convertToRPN(NormTextField.calculatorStack));
					tempString = tempString.indexOf(".") < 0 ? tempString
							: tempString.replaceAll("0*$", "").replaceAll("\\.$", "");
					NormTextField.setMainRow(tempString.toCharArray());
					RPN.clear();
					NormTextField.calculatorStack.clear();
					NormTextField.mainRowFontChanger();
					break;
				case KeyEvent.VK_DECIMAL:
					NormTextField.addSymbol('.');
					break;
				case KeyEvent.VK_ADD:
					NormTextField.addSignToUpperRow("+");
					NormTextField.resetMainArray();
					break;
				case KeyEvent.VK_SUBTRACT:
					NormTextField.addSignToUpperRow("-");
					NormTextField.resetMainArray();
					break;
				case KeyEvent.VK_MULTIPLY:
					NormTextField.addSignToUpperRow("*");
					NormTextField.resetMainArray();
					break;
				case KeyEvent.VK_DIVIDE:
					NormTextField.addSignToUpperRow("/");
					NormTextField.resetMainArray();
					break;
				case KeyEvent.VK_9:
					NormTextField.addSymbol('9');
					break;
				case KeyEvent.VK_8:
					NormTextField.addSymbol('8');
					break;
				case KeyEvent.VK_7:
					NormTextField.addSymbol('7');
					break;
				case KeyEvent.VK_6:
					NormTextField.addSymbol('6');
					break;
				case KeyEvent.VK_5:
					NormTextField.addSymbol('5');
					break;
				case KeyEvent.VK_4:
					NormTextField.addSymbol('4');
					break;
				case KeyEvent.VK_3:
					NormTextField.addSymbol('3');
					break;
				case KeyEvent.VK_2:
					NormTextField.addSymbol('2');
					break;
				case KeyEvent.VK_1:
					NormTextField.addSymbol('1');
					break;
				case KeyEvent.VK_0:
					NormTextField.addSymbol('0');
					break;
				case KeyEvent.VK_COMMA:
					NormTextField.addSymbol('.');
					break;
				case KeyEvent.VK_ESCAPE:
					NormTextField.clearCE();
					NormTextField.clearUpperRow();
					NormTextField.mainRowFontChanger();
					break;
				case KeyEvent.VK_BACK_SPACE:
					NormTextField.removeSymbol();
					NormTextField.mainRowFontChanger();
					break;
				case KeyEvent.VK_SLASH:
					NormTextField.addSignToUpperRow("/");
					NormTextField.resetMainArray();
					break;
				case KeyEvent.VK_MINUS:
					NormTextField.addSignToUpperRow("+");
					NormTextField.resetMainArray();
					break;

				default:
					break;
				}
			}

		});
	}
}
