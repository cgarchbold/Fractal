import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;


public class Star{
	private Coordinate[] vertices;
	private int size;
	
	public Star(Coordinate center, int scale){
		scale*=-1;
		size=scale;
		Coordinate[] pts= new Coordinate[5];
		Coordinate a= new Coordinate(center);
		a.translate(0,scale);
		pts[0]=a;
		Coordinate b= new Coordinate(center);
		b.translate(0,scale);
		b.rotateAround(center,2*Math.PI/5);
		pts[3]=b;
		Coordinate c= new Coordinate(center);
		c.translate(0,scale);
		c.rotateAround(center,4*Math.PI/5);
		pts[1]=c;
		Coordinate d= new Coordinate(center);
		d.translate(0,scale);
		d.rotateAround(center,2*3*Math.PI/5);
		pts[4]=d;
		Coordinate e= new Coordinate(center);
		e.translate(0,scale);
		e.rotateAround(center,2*4*Math.PI/5);
		pts[2]=e;

		vertices = pts;
	}
	public void draw(Graphics2D g){
		vertices[0].lineTo(vertices[1], g);
		vertices[1].lineTo(vertices[2], g);
		vertices[2].lineTo(vertices[3], g);
		vertices[3].lineTo(vertices[4], g);
		vertices[4].lineTo(vertices[0], g);
	}
	public Coordinate[] getPoints(){
		return vertices;
	}
	public Coordinate getPoint(int x){
		return vertices[x];
	}
	public int getSize(){
		return size;
	}
	
	
}
