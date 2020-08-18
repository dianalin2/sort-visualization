package main.template;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dialog {
		
	JSpinner sizeSpinner;
	
	public Dialog(Sorter sorter) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JDialog d = new JDialog();
		JPanel p = new JPanel();
		JLabel l = new JLabel("Array Size:");
		
		p.setPreferredSize(new Dimension(300, 50));
		
		d.setTitle("Set Array Size - " + Main.TITLE);
		
		SpinnerModel sizeSpinnerModel = new SpinnerNumberModel(500, 50, 1000, 1);
		sizeSpinner = new JSpinner(sizeSpinnerModel);
		l.setLabelFor(sizeSpinner);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main((int) sizeSpinner.getValue(),sorter).start();
			}
		});
		
		d.add(p);
		
		d.setPreferredSize(new Dimension(300, 75));
		p.add(l);
		p.add(sizeSpinner);
		p.add(okButton);
		
		d.setVisible(true);
		d.pack();
		d.setLocationRelativeTo(null);
	}
}
