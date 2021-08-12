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
		System.out.println("we");
	}

	public void initCosntrains() { // инициализируем констрейнс
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(6, 11, 11, 11);
		c.ipadx = 0;
		c.ipady = 30;

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
		// c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(2, 11, 2, 2);
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 10;
		c.ipady = 0;
		return c;
	}

	public GridBagConstraints nextButton() {
		gridx++;
		c.gridx = gridx;
		c.gridwidth = 1;
		// c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(2, 2, 2, 2);
		return c;
	}

	public GridBagConstraints lastRowButton() {
		gridx++;
		c.gridx = gridx;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(2, 2, 2, 11);
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
