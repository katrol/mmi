package oving3;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.event.*;

public class PassivePersonPanel extends PersonPanel {
	Person model;

	JTextField GenderPropertyComponent2;
	JTextField HeightPropertyComponent2;
	
	public PassivePersonPanel() {
		super();
		GridBagConstraints c = new GridBagConstraints();
		NamePropertyComponent.setEditable(false);
		EmailPropertyComponent.setEditable(false);
		DateOfBirthPropertyComponent.setEditable(false);
		GenderPropertyComponent.setVisible(false);
		HeightPropertyComponent.setVisible(false);
		GenderPropertyComponent2 = new JTextField(20);
		GenderPropertyComponent2.setEditable(false);
		HeightPropertyComponent2 = new JTextField(20);
		HeightPropertyComponent2.setEditable(false);
		
		c.gridx = 1;
		c.gridy = 3;
		add(GenderPropertyComponent2, c);
		c.gridx = 1;
		c.gridy = 4;
		add(HeightPropertyComponent2, c);

	}	
	
	public void setModel(Person model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		NamePropertyComponent.setText(model.getName());
		EmailPropertyComponent.setText(model.getEmail());
		DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
		GenderPropertyComponent2.setText( model.getGender().name());
		HeightPropertyComponent2.setText(Integer.toString(model.getHeight()));
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == Person.NAME_PROPERTY) {
			NamePropertyComponent.setText(model.getName());
			System.out.println("haoeutnsih");}
		
		if (evt.getPropertyName() == Person.EMAIL_PROPERTY)
			EmailPropertyComponent.setText(model.getEmail());
		
		if (evt.getPropertyName() == Person.BIRTH_PROPERTY)
			DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
		
		if (evt.getPropertyName() == Person.GENDER_PROPERTY)
			GenderPropertyComponent2.setText( model.getGender().name());
		
		if (evt.getPropertyName() == Person.HEIGHT_PROPERTY)
			HeightPropertyComponent2.setText(Integer.toString(model.getHeight()));	
	}
	
	public static void main(String[] args) {
		PersonPanel panel = new PersonPanel();
		PassivePersonPanel passivePanel = new PassivePersonPanel();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.getContentPane().add(passivePanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
		Person person = new Person();
		person.setName("navnet");
		person.setEmail("eposten");
		person.setDateOfBirth("511591");
		person.setGender(Gender.male);
		person.setHeight(10);
		
		panel.setModel(person);
		passivePanel.setModel(person);
	}

}
