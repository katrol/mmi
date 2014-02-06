package oving4;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Person {
	public final static String NAME_PROPERTY = "name";
	public final static String BIRTH_PROPERTY = "dateOfBirth";
	public final static String GENDER_PROPERTY = "gender";
	public final static String EMAIL_PROPERTY = "email";
	public final static String HEIGHT_PROPERTY = "height";
	
	private String name;
	private String dateOfBirth;
	private Gender gender;
	private String email;
	private int height;
	
	private PropertyChangeSupport pcs;
	
	public Person(String name) {
		this.name = name;
		pcs = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		pcs.firePropertyChange(NAME_PROPERTY, oldName, name);
		System.out.println("namechange " + name);
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		String oldDate = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(BIRTH_PROPERTY, oldDate, dateOfBirth);
		System.out.println("datechange " + dateOfBirth);
		
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		Gender oldGender = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(GENDER_PROPERTY, oldGender, gender);
		System.out.println("genderchange " + gender);
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		String oldEmail = this.email;
		this.email = email;
		pcs.firePropertyChange(EMAIL_PROPERTY, oldEmail, email);
		System.out.println("emailchange " + email);
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		int oldHeight = this.height;
		this.height = height;
		pcs.firePropertyChange(HEIGHT_PROPERTY, oldHeight, height);
		System.out.println("heightchange " + height);
	}

	@Override
	public String toString() {
		return name + ", " + email;
	}
	
	

}
