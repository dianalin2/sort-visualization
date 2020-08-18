package main.template;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	public Window(Visualizer visualizer, int width, int height, String title) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setTitle(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println(frame.getInsets());
				
		visualizer.setPreferredSize(new Dimension(width, height));
		
		frame.setResizable(false);
		
		panel.add(visualizer);
		panel.setBackground(Color.black);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);

	}
}
