package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.AbstractBorder;

import arithmetic.RPN;

public class GreyButton extends JButton {
	public GreyButton(String name) {
		this.setText(name);
		this.setName(name);
		this.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		this.setBackground(Color.lightGray);
		this.setOpaque(true);
		this.setFocusable(false);
		this.setMargin(new Insets(1, 1, 1, 1));
		AbstractBorder brdr = new TextBubbleBorder(Color.gray, 1, 4, 0);
		this.setBorder(brdr);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getComponent().getName());
				switch (e.getComponent().getName()) {
				case "←":
					NormTextField.removeSymbol();
					NormTextField.mainRowFontChanger();
					break;

				case "CE":
					NormTextField.clearCE();
					NormTextField.mainRowFontChanger();
					break;

				case "C":
					NormTextField.clearCE();
					NormTextField.clearUpperRow();
					NormTextField.calculatorStack.clear();
					RPN.clear();
					NormTextField.mainRowFontChanger();
					break;

				case "+":
					NormTextField.addToUpperRow(NormTextField.getMainRow(), " + ");
					NormTextField.resetMainArray();
					break;

				case "-":
				//	NormTextField.addToUpperRow(NormTextField.getMainRow(), " - ");
					NormTextField.addSignToUpperRow ("-");
					NormTextField.resetMainArray();
					break;

				case "*":
					//NormTextField.addToUpperRow(NormTextField.getMainRow(), " * ");
					NormTextField.addSignToUpperRow ("*");
					NormTextField.resetMainArray();
					break;

				case "/":
					NormTextField.addToUpperRow(NormTextField.getMainRow(), " / ");
					NormTextField.resetMainArray();
					break;
				case "±":
					NormTextField.negateOp();
//					NormTextField.resetMainArray();
					break;

//				case "√":
//					double square = Math.sqrt(Double.parseDouble(NormTextField.getMainRow()));
//					char[] sqChar = Double.toString(square).toCharArray();
//					NormTextField.setMainRow(sqChar);
//					NormTextField.addToUpperRow(NormTextField.getMainRow());
//					NormTextField.resetMainArray();
//					break;

				case "1/x":
					NormTextField.oneToX();
					NormTextField.resetMainArray();
					break;

				case "=":
					NormTextField.addEquals(NormTextField.getMainRow()); // работает
					// System.out.println(NormTextField.getUpperRow());
					System.out.println(RPN.convertToRPN(NormTextField.calculatorStack));
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

				default:
					break;
				}
			}
		});
	}
}
