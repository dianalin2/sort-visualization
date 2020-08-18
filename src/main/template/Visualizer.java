package main.template;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

public class Visualizer extends Canvas {

	private static final long serialVersionUID = 1L;

	private Sorter sorter;
	
	public Visualizer(Sorter sorter) {
		this.sorter = sorter;
	}
	
	public void render() {
		BufferStrategy b = this.getBufferStrategy();
		
		if(b == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = b.getDrawGraphics();
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // Turn on anti-aliasing
		
		// Fill background with black
		g.setColor(Color.black);
		g.fillRect(0, 0, sorter.getArrayLength(), sorter.getArrayLength());
		// Fill background with black
		
		
		// Draw data gathered
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		
		g.setColor(Color.white);
		g.drawString("Swaps: " + sorter.getNumSwaps(), 5, 20);
		g.drawString("Comparisons: " + sorter.getNumCompare(), 5, 40);
		g.drawString("Time elapsed (seconds): " + (sorter.getTimeElapsedMillis() / 1000D), 5, 60);
		if(sorter.isSorted()) g.drawString("Sorted!", 5, 80);
		// Draw data gathered
		
		// Draw array with colored lines
		for(int i = 0; i < sorter.getArrayLength(); i++) {
			g.setColor(new Color(255 - (int)((255.0 / sorter.getArrayLength()) * sorter.getArray()[i]), 255, 255));
			g.drawLine(i, sorter.getArrayLength(), i, sorter.getArrayLength() - sorter.getArray()[i]);
		}
		// Draw array with colored lines
		
		g.dispose();
		b.show();
	}
}
