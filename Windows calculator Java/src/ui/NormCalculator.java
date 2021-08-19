package ui;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NormCalculator {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	GridBagLayout gbl = new GridBagLayout();
	NormTextField field = new NormTextField(); // поле для ввода цифр обычного калькулятора
	MenuBar menuBar; // экземпляр класса

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
	WhiteButton buttonDot = new WhiteButton(",");
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

	public void initNormCalculator() {

		panel.setLayout(gbl);
		panel.setBorder(BorderFactory.createEmptyBorder(13, 12, 14, 12)); // въебениваем поля по краям панели
		panel.setBackground(new Color(217, 228, 241));
		// (https://stackoverflow.com/questions/5854005/setting-horizontal-and-vertical-margins)
		Constraints c = new Constraints();
		gbl.setConstraints(field.iniTextField(), c.get());
		panel.add(field.textPanel);

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
		frame.setLocationRelativeTo(null);// не привязываем к краям экрана, пусть где-то в центре появляется
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// завершаем программу при закрытии формы

		// тестируем работу сеттера текста для основного поля калькулятора
		field.setMainRow(field.getMainArray());

	}
}
