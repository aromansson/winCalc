package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar{
	
	public JMenuBar initMenuBar() {
		JMenuBar menu = new JMenuBar(); //менюбар
		JMenu view = new JMenu("Вид");
		view.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem exit = new JMenuItem("Выход");
		exit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(exit);
		JMenu edit = new JMenu("Правка");
		edit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem copy = new JMenuItem("Копировать");
		copy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem paste = new JMenuItem("Вставить");
		paste.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		edit.add(copy);
		edit.add(paste);
		JMenu help = new JMenu("Справка");
		help.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem viewHelp = new JMenuItem("Показать справку");
		viewHelp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem about = new JMenuItem("О программе");
		about.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		help.add(viewHelp);
		help.add(about);
		menu.add(view);
		menu.add(edit);
		menu.add(help);
//		edit.add(Box.createRigidArea(new Dimension(100,10)));
//		help.add(Box.createRigidArea(new Dimension(100,10)));
		return menu;
	}
}
