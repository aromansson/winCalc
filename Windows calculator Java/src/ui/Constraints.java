package ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Constraints {
	GridBagConstraints c = new GridBagConstraints();
	int gridx, gridy, gridwidth = 1, gridheight = 1;
	double weightx, weighty;
	int anchor, fill;
	Insets insets;
	int ipadx, ipady;

	public Constraints() {
		initCosntrains();
	}

	public void initCosntrains() { // инициализируем констрейнс, подходящий для первого элемента
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);
		c.ipadx = 0;
		c.ipady = 0;

	}

	// возвращает настроенный объект GridBagConstraints
	public GridBagConstraints get() {
		return c;
	}

	public GridBagConstraints nextRow() {
		gridy++;
		gridx = 0;
		c.gridx = 0;
		c.gridy = gridy;
		c.gridwidth = 1;
		gridheight = 1;
		c.gridheight = gridheight;
		c.insets.top = 5;
		c.insets.right = 3;
		c.insets.left = 0;
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 10;
		c.ipady = 0;
		return c;
	}

	public GridBagConstraints nextButton() {
		gridx++;
		c.gridx = gridx;
		c.gridwidth = 1;
		c.insets.left = 3;
		c.insets.right = 3;
		return c;
	}

	public GridBagConstraints lastRowButton() {
		gridx++;
		c.gridx = gridx;
		c.anchor = GridBagConstraints.EAST;
		c.insets.right = 0;
		return c;
	}

	// раздвигает ячейку до конца строки
	public GridBagConstraints span() {
		c.gridwidth = GridBagConstraints.HORIZONTAL;
		return c;

	}

	public GridBagConstraints spanY() {
		gridheight++;
		c.gridwidth = 1;
		c.gridheight = gridheight;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		return c;
	}

}
