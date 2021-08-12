package ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Constraints {
	GridBagConstraints c = new GridBagConstraints();
	int gridx, gridy, gridwidth, gridheight;
	double weightx, weighty;
	int anchor, fill;
	Insets insets;
	int ipadx, ipady;
	
	public Constraints() {
		initCosntrains();
		System.out.println("we");
	}
	
	public void initCosntrains() { //инициализируем констрейнс
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
		    c.gridwidth = gridwidth;
		    c.fill = GridBagConstraints.CENTER;
	//	    c.insets = new Insets(2, 11, 2, 2);
		//    c.insets = insets;
		    c.fill = fill;
		    return c;
	}
	
}
