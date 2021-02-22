import java.awt.Color;
import java.awt.Graphics2D;


public class TreeMyFractalPanel extends FractalPanel{
	//INHERITED THIS FROM DAD: don't uncomment these!
	//protected Graphics2D myGraphics;	<<--- Your crayon
	//protected int totalLevels; <<---how many levels you need to draw
	//protected Color bgColor = Color.WHITE;
	private Color[] rainbow =  {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA};
	public static void main(String[] args) {
		new FractalFrame( new TreeMyFractalPanel());
	}
	
	public void getStarted(int numLevels){
		//the image is cleared (set to blank & white)
		super.getStarted(numLevels);
		/********************************************************
		 * 	Place the FIRST call to recursive drawing function here!!
		/********************************************************/
		Coordinate a = new Coordinate(500,450);
		Coordinate b = new Coordinate(500,500);
		a.lineTo(b, myGraphics,Color.GREEN,3,false);
		
		Coordinate y = new Coordinate(500,550);
		Coordinate x = new Coordinate(500,500);
		y.lineTo(x, myGraphics,Color.GREEN,3,false);
		recur(0,b,a);
		recur(0,x,y);
	}//end getStarted
	
	/*Preconditions:
	 * 	g is the graphics object for the bufferedImage to which the fractal will be drawn
	 * 
	 *Postconditions: Part of the current level is drawn, and recurvsive calls are executed
	 *      that will draw the next level of the fractal 
	 */
	//private void recursiveDraw(Graphics2D g, Color c, int num, int x, int y, int sz){
	private void recur(int levelsDrawn, Coordinate b, Coordinate t){
		//pause(30.0/totalLevels, levelsDrawn);
		Color theColor = rainbow[levelsDrawn%rainbow.length];
		if(levelsDrawn>=totalLevels)
		return;
		//Draw right ear
		Coordinate right= new Coordinate(b);
		right.rotateAndScale(t, 6*Math.PI/5, 0.8);
		t.lineTo(right, myGraphics,theColor,3,false);
		
		//draw left
		Coordinate left= new Coordinate(b);
		left.rotateAndScale(t, -6*Math.PI/5 , 0.8);
		t.lineTo(left, myGraphics,theColor,3,false);
		
		levelsDrawn++;
		recur(levelsDrawn,t,right);
		recur(levelsDrawn,t,left);
	}//end recur function

}
