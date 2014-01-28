package oving3;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.event.*;

public class PersonPanel extends JPanel implements PropertyChangeListener {
	
	private Person model = null;
	
	JTextField NamePropertyComponent = new JTextField(20);
	JTextField EmailPropertyComponent = new JTextField(20);
	JTextField DateOfBirthPropertyComponent = new JTextField(20);
	JComboBox<Gender> GenderPropertyComponent = new JComboBox<Gender>(Gender.values());
	JSlider HeightPropertyComponent = new JSlider();
	
	public void setModel(Person model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		NamePropertyComponent.setText(model.getName());
		EmailPropertyComponent.setText(model.getEmail());
		DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
		GenderPropertyComponent.setSelectedItem(model.getGender());
		HeightPropertyComponent.setValue(model.getHeight());
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
			GenderPropertyComponent.setSelectedItem(model.getGender());
		
		if (evt.getPropertyName() == Person.HEIGHT_PROPERTY)
			HeightPropertyComponent.setValue(model.getHeight());	
	}
	
	public Person getModel() {
		return model;		
	}

	public PersonPanel() {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel nameLabel = new JLabel("Name:");
		NamePropertyComponent.setName("NamePropertyComponent");
		JLabel emailLabel = new JLabel("Email:");
		EmailPropertyComponent.setName("EmailPropertyComponent");
		JLabel birthLabel = new JLabel("Birthday:");
		DateOfBirthPropertyComponent.setName("DateOfBirthPropertyComponent");
		JLabel genderLabel = new JLabel("Gender:");
		GenderPropertyComponent.setName("GenderPropertyComponent");
		JLabel heightLabel = new JLabel("Height:");
		HeightPropertyComponent.setName("HeightPropertyComponent");
		HeightPropertyComponent.setMaximum(220);
		HeightPropertyComponent.setMinimum(120);
		HeightPropertyComponent.setMajorTickSpacing(10);
		HeightPropertyComponent.setPaintTicks(true);
		HeightPropertyComponent.setPaintLabels(true);
		c.gridx = 0;
		c.gridy = 0;
		add(nameLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		add(NamePropertyComponent, c);
		c.gridy = 1;
		c.gridx = 0;
		add(emailLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		add(EmailPropertyComponent, c);
		c.gridx = 0;
		c.gridy = 2;
		add(birthLabel, c);
		c.gridx = 1;
		c.gridy = 2;
		add(DateOfBirthPropertyComponent, c);
		c.gridx = 0;
		c.gridy = 3;
		add(genderLabel, c);
		c.gridx = 1;
		c.gridy = 3;
		add(GenderPropertyComponent, c);
		c.gridx = 0;
		c.gridy = 4;
		add(heightLabel, c);
		c.gridx = 1;
		c.gridy = 4;
		c.weighty = 0.1;
		add(HeightPropertyComponent, c);
		
		NamePropertyComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model != null) model.setName(NamePropertyComponent.getText());
			}
		});
		
		EmailPropertyComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model != null) model.setEmail(EmailPropertyComponent.getText());
			}
		});
		
		DateOfBirthPropertyComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model != null) model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
			}
		});
		
		GenderPropertyComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gender gender = (Gender) GenderPropertyComponent.getSelectedItem();
				if (model != null) model.setGender(gender);
			}
		});
		
		HeightPropertyComponent.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (model != null) model.setHeight(HeightPropertyComponent.getValue());
			}
		});
		
	}

	public static void main(String[] args) {
		PersonPanel panel = new PersonPanel(); 
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		
		Person person = new Person();
		person.setName("navnet");
		person.setEmail("eposten");
		person.setDateOfBirth("511591");
		person.setGender(Gender.male);
		person.setHeight(10);
		
		panel.setModel(person);
	}

}
