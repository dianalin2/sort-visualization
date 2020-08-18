package main.template;

import java.util.Random;

public class Main implements Runnable {

	private Thread thread;
	
	public static String TITLE = "Sort Visualization";
	
	int[] array;
		
	private boolean running = false;
	
	private Visualizer visualizer;
	private Sorter sorter;
	
	public Main(int size, Sorter sorter) {
		array = new int[size];
		
		init();

		this.sorter = sorter;
		sorter.sort(array);
		
		this.visualizer = new Visualizer(sorter);
		
		new Window(visualizer, size, size, TITLE);
		
	}
	
	private Random r = new Random();

	private void init() {
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		for(int i = 0; i < array.length; i++) {
			Sorter.swap(array, i, r.nextInt(array.length));
		}
		
	}
	
	public synchronized void start() {
		if(running) return;
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		if(!running) return;
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	// Basic loop
	public void run() {
		double delta = 0;
		long lastTime = System.nanoTime();
		double lastTimer = System.currentTimeMillis();
//		int fps = 0; For testing
		
		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / sorter.getTPS();
			if(delta >= 1) {
				sorter.tick();
				visualizer.render();
//				fps++;
				delta -= 1;
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer = System.currentTimeMillis();
//				System.out.println(fps); For testing
//				fps = 0;
			}

			lastTime = currentTime;
		}
		
		this.stop();
	}
}
