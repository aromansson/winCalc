package ui;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class NormTextField extends Container {
	Container textPanel;
	JTextField upperRow;
	JTextField mainRow;

	NormTextField() {
		iniTextField();
	}

	public Container iniTextField() {
		textPanel = new Container();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		upperRow = new JTextField();
		mainRow = new JTextField();
		// textField.setHorizontalAlignment(JTextField.RIGHT);
		textPanel.add(mainRow);
		textPanel.add(upperRow);
		upperRow.setHorizontalAlignment(JTextField.RIGHT);
		mainRow.setHorizontalAlignment(JTextField.RIGHT);
		System.out.println("rere");
		return textPanel;
		// еще нужно набить сюда ДжЛейблов (2 штуки)
		// нижний будет для ввода чисел (макс. 16) и для вывода результата (макс, 21
		// символ)
		// верхний - для сохранения предыдущего числа или результата при нажатии
	}

}
