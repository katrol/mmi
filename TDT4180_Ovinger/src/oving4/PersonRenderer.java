package oving4;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PersonRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {
	final static ImageIcon female = new ImageIcon("/home/katrine/dev/egit/mmi/TDT4180_Ovinger/src/oving4/female.png");
	final static ImageIcon male = new ImageIcon("/home/katrine/dev/egit/mmi/TDT4180_Ovinger/src/oving4/male.png");

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		Person selected = (Person) value;

		String text = selected.toString();
		label.setText(text);
		label.setIcon((selected.getGender() == Gender.female) ? female : male);
		label.setIconTextGap(16);
		
		if (isSelected) {
			label.setBackground(list.getSelectionBackground());
			label.setForeground(list.getSelectionForeground());
		}
		else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return label;
	}

}
