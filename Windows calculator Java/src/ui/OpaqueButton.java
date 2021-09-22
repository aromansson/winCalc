package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.AbstractBorder;

public class OpaqueButton extends JButton {
	public OpaqueButton(String name) {
		this.setText(name);
		this.setName(name);
		this.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		setContentAreaFilled(false);
		this.setFocusable(false);
		this.setMargin(new Insets(1, 1, 1, 1));
		AbstractBorder brdr = new TextBubbleBorder(Color.gray, 1, 4, 0);
		this.setBorder(brdr);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getComponent().getName());
				switch (e.getComponent().getName()) {
				case "MC":
					NormTextField.memoryClear();
					NormTextField.resetMainArray();
					NormTextField.memoIndicator();
					break;
				case "MR":
					NormTextField.memoryRecall();
					NormTextField.resetMainArray();
					break;
				case "MS":
					NormTextField.memorySet(NormTextField.mainRow.getText());
					NormTextField.resetMainArray();
					NormTextField.memoIndicator();
					break;
				case "M+":
					NormTextField.memoryPlus(NormTextField.mainRow.getText());
					NormTextField.resetMainArray();
					NormTextField.memoIndicator();
					break;
				case "M-":
					NormTextField.memoryMinus(NormTextField.mainRow.getText());
					NormTextField.resetMainArray();
					NormTextField.memoIndicator();
					break;

				default:
					break;
				}
			}
		});
	}

}
