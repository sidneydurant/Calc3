
public class Line implements GeometricPrimitive{

	private Point[] p = new Point[3];
	
	public Line( Point p0, Point p1 ){
		this.p[0] = p0;
		this.p[1] = p1;
	}
	
	public void draw( Rasterizer r ){
		r.drawLine( this );
	}
	
        public void translate( int xShift, int yShift, int zShift ){
            this.p[0].translate( xShift, yShift, zShift );
            this.p[1].translate( xShift, yShift, zShift );
        }
	
	public Point[] getPoints(){
		return p;
	}
	
	public Point getP0(){
		return p[0];
	}
	
	public Point getP1(){
		return p[1];
	}
	
}
