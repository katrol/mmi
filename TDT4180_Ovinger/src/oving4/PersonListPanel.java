package oving4;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

public class PersonListPanel extends JPanel {
	
	JList<Person> personList;
	PersonPanel personPanel;
	DefaultListModel<Person> listModel;
	JButton newPersonButton;
	JButton deletePersonButton;
	
	public PersonListPanel() {
		listModel = new DefaultListModel<Person>();
		personList = new JList<Person>(listModel);
		personList.setName("PersonList");
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		newPersonButton = new JButton("Add new person");
		newPersonButton.setName("NewPersonButton");
		deletePersonButton = new JButton("Delete person");
		deletePersonButton.setName("DeletePersonButton");
		
		personList.setCellRenderer(new PersonRenderer());
			
		add(personList, BorderLayout.WEST);
		add(personPanel, BorderLayout.EAST);
		add(newPersonButton);
		add(deletePersonButton);
		
		newPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.addElement(new Person(null));
				personList.setSelectedIndex(listModel.getSize() - 1);
			}
		}
				);
		
		deletePersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listModel.removeElement(personList.getSelectedValue());
				}
				catch (Exception ex) {}
				personList.updateUI();
			}
		});
		
		
		personList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				personPanel.setModel(personList.getSelectedValue());
				listModel.setElementAt(personPanel.getModel(), personList.getSelectedIndex());
			}
			
		});
		
	}
	
	public void setModel(DefaultListModel<Person> model) {
		listModel = model;
		personList.setModel(listModel);
	}
	
	public DefaultListModel<Person> getModel() {
		return listModel;
	}
		
	
	public static void main(String[] args) {
		PersonListPanel panel = new PersonListPanel(); 
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		
		Person person = new Person("navnet");
		person.setEmail("eposten");
		person.setDateOfBirth("511591");
		person.setGender(Gender.male);
		person.setHeight(150);
		
		Person person2 = new Person("navn2");
		person2.setEmail("eposten2");
		person2.setDateOfBirth("222222");
		person2.setGender(Gender.female);
		person2.setHeight(120);
		
		Person person3 = new Person("navn3");
		person3.setEmail("eposten3");
		person3.setDateOfBirth("333333");
		person3.setGender(Gender.female);
		person3.setHeight(130);
		
		DefaultListModel<Person> model = new DefaultListModel<Person>();
		model.addElement(person);
		model.addElement(person2);
		model.addElement(person3);
		
		panel.setModel(model);
		
	}

}
