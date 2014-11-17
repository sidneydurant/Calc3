
public interface GeometricPrimitive {
    public void draw( Rasterizer r );
    public Point[] getPoints();
    public void translate(int xShift, int yShift, int zShift);
}
