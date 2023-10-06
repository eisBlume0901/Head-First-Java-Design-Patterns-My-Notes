package Part7ObserverPatternInJavaSwingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingObserverExample
{
    JFrame frame;

    public static void main(String[] args)
    {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go()
    {
        frame = new JFrame();

        JButton button = new JButton("Should I do it?");

        // Without Lambda
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());

        /* With Lambda
        button.addActionListener(event ->
			System.out.println("Don't do it, you might regret it!")
		);
		button.addActionListener(event ->
			System.out.println("Come on, do it!")
		);
         */
        frame.getContentPane().add(BorderLayout.CENTER, button);
        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(300,300);
        frame.setVisible(true);

    }
}

// Remove the following classes when you are not using Lambda
class AngelListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Don't do it, you might regret it!");
    }
}

class DevilListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Come on, do it!");
    }
}