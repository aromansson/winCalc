package ui;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NormCalculator {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	GridBagLayout gbl = new GridBagLayout();
	GridBagHelper helper = new GridBagHelper();

	JTextField inputField = new JTextField(); // поле для ввода цифр
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
	WhiteButton buttonMinus = new WhiteButton("-");
	WhiteButton buttonMultipl = new WhiteButton("*");
	WhiteButton buttonDivide = new WhiteButton("/");
	WhiteButton buttonPercent = new WhiteButton("%");
	WhiteButton buttonDot = new WhiteButton(".");
	WhiteButton buttonOneX = new WhiteButton("1/x");
	WhiteButton buttonSqrt = new WhiteButton("\u221A");
	WhiteButton buttonPlusMinus = new WhiteButton("\u00B1");
	WhiteButton buttonC = new WhiteButton("C");
	WhiteButton buttonCE = new WhiteButton("CE");
	WhiteButton buttonBack = new WhiteButton("\u2190");
	OpaqueButton buttonMC = new OpaqueButton("MC");
	OpaqueButton buttonMR = new OpaqueButton("MR");
	OpaqueButton buttonMS = new OpaqueButton("MS");
	OpaqueButton buttonMPlus = new OpaqueButton("M+");
	OpaqueButton buttonMMinus = new OpaqueButton("M-");

	public void initNormCalculator() {

		panel.setLayout(gbl);
		Constraints c = new Constraints();
		gbl.setConstraints(inputField, c.get());
		panel.add(inputField);
		c.nextRow();
		panel.add(button0, c.get());
//		helper.nextRow().setInsets(11, 5, 0, 5);
//		panel.add(button1);
//		helper.nextCell().gap(5);
//		helper.nextCell().get();
//		panel.add(button2);
//		helper.nextCell().gap(5);
//		panel.add(button3, helper.get());
//		helper.nextRow();
//		panel.add(button4, helper.get());
//		helper.nextCell().gap(5);
//		panel.add(button5, helper.get());
		
//		panel.add(button2);
//		panel.add(button3);
//		panel.add(button4);
//		panel.add(button5);
//		panel.add(button6);
//		panel.add(button7);
//		panel.add(button8);
//		panel.add(button9);
//		panel.add(button0);
//		panel.add(buttonDot);
//		panel.add(buttonPlus);
//		panel.add(buttonEqual);
		
		MenuBar menuBar = new MenuBar();
		frame.setJMenuBar(menuBar.initMenuBar());
		frame.setContentPane(panel);
		frame.setSize(228, 323); // размер фрейма
		frame.setResizable(false); // не разрешаем менять размер
		frame.setVisible(true); // делаем видимым
		frame.setLocationRelativeTo(null);// не привязываем к краям экрана, пусть где-то в центре появляется
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// завершаем программу при закрытии формы
	}

}
