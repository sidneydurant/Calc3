
import java.awt.Canvas;
import javax.swing.*;

public class Frame extends Canvas {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 400;
	public static final int TICK = 42;
        
        public static final boolean savingData = false;

	public static boolean paused = false;

	public static void main(String[] args) {

		final JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		//frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setFocusable(true);
		
		final Screen world = new Screen(frame.getWidth(), frame.getHeight());
		frame.add( world );

		frame.setVisible(true);

		Thread runThread = new Thread(new Runnable() {
			public void run() {
                            
                                for( int i = 0; i<=120; i++){
					long time = System.currentTimeMillis();
					world.repaint();

                                        
                                        try { ///////
                                            if(savingData){
                                                Thread.sleep( 100 );
                                            }else{
                                                Thread.sleep( 5 );
                                            }
                                        } catch ( Exception e ) {
                                                e.printStackTrace();
                                        }
                                        if(savingData){
                                            world.saveImage();/**/
                                            world.saveData();
                                        }
                                        world.incrementTheta();
                                        
					long endTime = System.currentTimeMillis();
					try {
						Thread.sleep( TICK - endTime + time );
					} catch ( Exception e ) {
						System.out.println("cannot sleep: " + (TICK - (endTime - time)) );
					}
				}
			}
		});

		runThread.start();

	}
}