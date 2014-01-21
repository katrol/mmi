package oving1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonsNText extends JPanel {
	JTextField TextLine = new JTextField(25);
	JToggleButton UpperCaseButton;
	JToggleButton LowerCaseButton;
	ButtonGroup group;
	JCheckBox ContinousButton;
	
	public ButtonsNText() {
		super();
		TextLine = new JTextField(25);
		TextLine.setName("TextLine");
		
		UpperCaseButton = new JToggleButton("Upper case");
		UpperCaseButton.setName("UpperCaseButton");
		LowerCaseButton = new JToggleButton("Lower case");
		LowerCaseButton.setName("LowerCaseButton");
		
		group = new ButtonGroup();
		ContinousButton = new JCheckBox("Continous?");
		ContinousButton.setName("ContinuousButton");
		setPreferredSize(new Dimension(700, 50));
		add(TextLine);
		group.add(UpperCaseButton);
		group.add(LowerCaseButton);
		add(UpperCaseButton);
		add(LowerCaseButton);
		add(ContinousButton);
		UpperCaseButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if (UpperCaseButton.isSelected()) {
					upper(TextLine.getText());
				}
				else {
					lower(TextLine.getText());
				}
			}
		});
		
		LowerCaseButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if (LowerCaseButton.isSelected()) {
					lower(TextLine.getText());
				}
				else {
					upper(TextLine.getText());
				}
			}
		});
		TextLine.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == 10) //enter
				{
					if (UpperCaseButton.isSelected())
					{
						upper(TextLine.getText());
					}
					else
					{
						lower(TextLine.getText());
					}
				}
			}
			
			public void keyTyped(KeyEvent e)
			{
				
			}
			
			public void keyReleased(KeyEvent e)
			{
				if (ContinousButton.isSelected())
				{
					int caret = TextLine.getCaretPosition();
					if (UpperCaseButton.isSelected())
					{
						upper(TextLine.getText());
					}
					else
					{
						lower(TextLine.getText());
					}
					TextLine.setCaretPosition(caret);
				}
			}
		});
		
	}
	
	private void upper(String text)
	{
		TextLine.setText(text.toUpperCase());
	}
	
	private void lower(String text)
	{
		TextLine.setText(text.toLowerCase());
	}

	public static void main(String[] args) {
		ButtonsNText panel = new ButtonsNText();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}


// Teori

// leksikalsk: keylistener, lytter direkte til om taster på tastaturet blir trykket på
// syntaktisk: itemlistener lytter til om det skjer noe med knappene

// lexikalske blir veldig smått og detaljert, mindre styr med syntaktiske hendelser.

// i stedet for keylistener kunne jeg sikkert ha brukt changelistener til å merke når det blir skrevet i textline
