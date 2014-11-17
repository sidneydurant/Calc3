
// Panel
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

// The class that sets up the primitives, and that draws the image on the JPanel
// currently this just sets up a demo scene that shows off the capabilities
public class Screen extends JPanel{

	private static BufferedImage screenImage;
	private static int[] screenRaster;
	
	private Rasterizer renderer;
	private OrthographicModel scene;
	
	private OrthographicModel cube, letterL, letterT, letterO;
        private int runNumber = 0;
        private String sceneToString = "";
	
	public Screen( int width, int height ){
		
		screenImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		screenRaster = ((DataBufferInt) screenImage.getRaster().getDataBuffer()).getData();

		renderer = new Rasterizer( width, height, screenRaster);
		
		renderer.clear();
		
                CubeFactory factory = new CubeFactory( renderer );
                
                letterL = new OrthographicModel( renderer );
                letterL.add( factory.createCube(), 0, 0, 0);
                letterL.add( factory.createCube(), 0, 100, 0);
                letterL.add( factory.createCube(), 0, -100, 0);
                letterL.add( factory.createCube(), 100, 100, 0);
                
                letterO = new OrthographicModel( renderer );
                letterO.add( factory.createCube(), 0, 100, 0);
                letterO.add( factory.createCube(), 0, -100, 0);
                letterO.add( factory.createCube(), 100, 100, 0);
                letterO.add( factory.createCube(), 100, 0, 0);
                letterO.add( factory.createCube(), 100, -100, 0);
                letterO.add( factory.createCube(), -100, 100, 0);
                letterO.add( factory.createCube(), -100, 0, 0);
                letterO.add( factory.createCube(), -100, -100, 0);
                
                letterT = new OrthographicModel( renderer );
                letterT.add( factory.createCube(), 0, 0, 0);
                letterT.add( factory.createCube(), 0, 100, 0);
                letterT.add( factory.createCube(), 0, -100, 0);
                letterT.add( factory.createCube(), 100, -100, 0);
                letterT.add( factory.createCube(), -100, -100, 0);
                
                runNumber = (int)System.currentTimeMillis();
                runNumber = runNumber>0?runNumber:-runNumber;//Always have a positive run number
                File outputDir = new File( "Run_" + runNumber + "\\Images" );
                outputDir.mkdirs();
                outputDir = new File( "Run_" + runNumber + "\\Data" );
                outputDir.mkdirs();
                
	}
        
	// is called every frame through repaint(), from Frame
        // Is also called during the construction of the Frame and JPanel 
	public void paint( Graphics g ){
		
		renderer.clear();
		sceneToString = "";
                
		OrthographicModel m;
                
                m = letterL;
                m.setRotation( 0, 0, (float)theta*3);
                m.setTranslation( 200, 200, 0 );
                m.setScaling( .5f, .5f, .5f);
                m.draw();
                sceneToString += m.toString();
		
                m = letterO;
                m.setRotation( 0, (float)theta*2, 0);
                m.setTranslation( 400, 200, 0 );
                m.setScaling( .5f, .5f, .5f);
                m.draw();
                sceneToString += m.toString();
                
                m = letterT;
                m.setRotation( (float)theta*5, 0, 0);
                m.setTranslation( 600, 200, 0 );
                m.setScaling( .5f, .5f, .5f);
                m.draw();
                sceneToString += m.toString();

		g.drawImage( screenImage, 0, 0, screenImage.getWidth(), screenImage.getHeight(), null );
                
	}
        
        public void saveImage(){
            //TODO
            try{
                File outputFile = new File( "Run_" + runNumber + "\\Images\\Frame_"+count+".png");
                ImageIO.write(screenImage, "png", outputFile);
                
            }catch (IOException e ){
                e.printStackTrace();
            }
        }
        
        public void saveData(){
            try{
                PrintWriter out = new PrintWriter("Run_" + runNumber + "\\Data\\Frame_"+count+".txt");
                out.println( sceneToString );
                out.close();
            }catch (Exception e ){
                e.printStackTrace();
            }
        }
        
        private double theta = 0;
        int count = 0;
	
        /**
         * method that increments theta, because we only want theta to be incremented
         * when repaint is explicitly called somewhere in the code. incrementTheta()
         * should always be called after a repaint.
         */
        public void incrementTheta(){
                count++;
		theta = count*2*Math.PI/120;
        }
	
}
