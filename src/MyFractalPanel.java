import java.awt.Color;
import java.awt.Graphics2D;


public class MyFractalPanel extends FractalPanel{
	//INHERITED THIS FROM DAD: don't uncomment these!
	//protected Graphics2D myGraphics;	<<--- Your crayon
	//protected int totalLevels; <<---how many levels you need to draw
	//protected Color bgColor = Color.WHITE;
	
	public static void main(String[] args) {
		new FractalFrame( new MyFractalPanel());
	}
	
	public void getStarted(int numLevels){
		//the image is cleared (set to blank & white)
		super.getStarted(numLevels);
		/********************************************************
		 * 	Place the FIRST call to recursive drawing function here!!
		/********************************************************/
		Coordinate x =new Coordinate(500,500);
		Coordinate y =new Coordinate(0,0);
		
		Star a = new Star(x,200);
		EZPolygon b = new EZPolygon(a.getPoints());
		b.draw(myGraphics, Color.GREEN);
		a.draw(myGraphics);
		recur(0,a);
	}//end getStarted
	
	/*Preconditions:
	 * 	g is the graphics object for the bufferedImage to which the fractal will be drawn
	 * 
	 *Postconditions: Part of the current level is drawn, and recurvsive calls are executed
	 *      that will draw the next level of the fractal 
	 */
	//private void recursiveDraw(Graphics2D g, Color c, int num, int x, int y, int sz){
	private void recur(int levelsDrawn, Star c){
		pause(30.0/totalLevels, levelsDrawn);
		Coordinate[] centers = new Coordinate[5];
		for(int i=0;i<5;i++){
			Coordinate temp = new Coordinate(c.getPoint(i));
			temp.translate(0,0);
			centers[i]=temp;
		}
		Star[] newStars = new Star[5];
		for(int i=0;i<5;i++){
			Star temp = new Star(centers[i],c.getSize()/2);
			newStars[i]=temp;
		}
		for(int i=0;i<5;i++){
			EZPolygon b = new EZPolygon(newStars[i].getPoints());
			b.draw(myGraphics, Color.GREEN);
		}
		
	}//end recur function

}
