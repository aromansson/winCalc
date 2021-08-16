package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

public class MenuBar {

	public JMenuBar initMenuBar() {
		JMenuBar menu = new JMenuBar(); // менюбар
		JMenu view = new JMenu("Вид");
		view.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JRadioButtonMenuItem regular = new JRadioButtonMenuItem("Обычный");
		regular.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(regular);
		JRadioButtonMenuItem engineer = new JRadioButtonMenuItem("Инженерный");
		engineer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(engineer);
		JRadioButtonMenuItem programmer = new JRadioButtonMenuItem("Программист");
		programmer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(programmer);
		JRadioButtonMenuItem statistic = new JRadioButtonMenuItem("Статистика");
		statistic.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(statistic);
		view.add(new JSeparator());
		JMenuItem jrnl = new JMenuItem("Журнал");
		jrnl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(jrnl);
		JMenuItem groupNum = new JMenuItem("Группировка цифр по разрядам");
		groupNum.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(groupNum);
		view.add(new JSeparator());
		JRadioButtonMenuItem usual = new JRadioButtonMenuItem("Обычный");
		usual.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(usual);
		JRadioButtonMenuItem transNum = new JRadioButtonMenuItem("Преобразование единиц");
		transNum.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(transNum);
		JRadioButtonMenuItem dateCalc = new JRadioButtonMenuItem("Вычисление даты");
		dateCalc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(dateCalc);
		JMenu sheets = new JMenu("Листы");
		sheets.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		view.add(sheets);
		JRadioButtonMenuItem credit = new JRadioButtonMenuItem("Ипотека");
		credit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		sheets.add(credit);
		JRadioButtonMenuItem autoLeasing = new JRadioButtonMenuItem("Автолизинг");
		autoLeasing.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		sheets.add(autoLeasing);
		JRadioButtonMenuItem economy = new JRadioButtonMenuItem("Экономия (миль/галлон)");
		economy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		sheets.add(economy);
		JRadioButtonMenuItem fuelEconomy = new JRadioButtonMenuItem("Экономия топлива (л/100 км)");
		fuelEconomy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		sheets.add(fuelEconomy);

		JMenu edit = new JMenu("Правка");
		edit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem copy = new JMenuItem("Копировать");
		copy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		edit.add(copy);
		JMenuItem paste = new JMenuItem("Вставить");
		paste.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		edit.add(paste);
		edit.add(new JSeparator());
		JMenu journal = new JMenu("Журнал");
		journal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		edit.add(journal);
		JMenuItem copyJournal = new JMenuItem("Копировать журнал");
		copyJournal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		journal.add(copyJournal);
		JMenuItem change = new JMenuItem("Изменить");
		change.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		journal.add(change);
		JMenuItem undo = new JMenuItem("Отменить правку");
		undo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		journal.add(undo);
		JMenuItem clean = new JMenuItem("Очистить журнал");
		clean.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		journal.add(clean);

		JMenu help = new JMenu("Справка");
		help.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem viewHelp = new JMenuItem("Просмотреть справку");
		viewHelp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JMenuItem about = new JMenuItem("О программе");
		about.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		help.add(viewHelp);
		help.add(new JSeparator());
		help.add(about);

		menu.add(view);
		menu.add(edit);
		menu.add(help);
		menu.setMaximumSize(new Dimension(Integer.MAX_VALUE, menu.getMinimumSize().height));
//		edit.add(Box.createRigidArea(new Dimension(100,10)));
//		help.add(Box.createRigidArea(new Dimension(100,10)));
		return menu;
	}
}
