package oving2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class PersonPanel extends JPanel {
	
	private Person model = null;
	
	JTextField NamePropertyComponent = new JTextField();
	JTextField EmailPropertyComponent = new JTextField();
	JTextField DateOfBirthPropertyComponent = new JTextField();
	JComboBox GenderPropertyComponent = new JComboBox(Gender.values());
	JSlider HeightPropertyComponent = new JSlider();
	
	public void setModel(Person model) {
		this.model = model;
		NamePropertyComponent.setText(model.getName());
		EmailPropertyComponent.setText(model.getEmail());
		DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
		GenderPropertyComponent.setSelectedItem(model.getGender());
		HeightPropertyComponent.setValue(model.getHeight());
	}
	
	public Person getModel() {
		model.setName(NamePropertyComponent.getText());
		model.setEmail(EmailPropertyComponent.getText());
		model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
		Gender gender = (Gender) GenderPropertyComponent.getSelectedItem();
		model.setGender(gender);
		model.setHeight(HeightPropertyComponent.getValue());
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
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
