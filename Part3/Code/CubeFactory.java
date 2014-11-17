/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sidney Durant
 */
public class CubeFactory {
    
    Rasterizer r;
    
    public CubeFactory( Rasterizer r ){
        this.r = r;
    }
    
    public OrthographicModel createCube(){

        // the points on a hexahedron
        /*Point p0 = new Point( -50, -50, -50, new Color(0xffffffff) );
        Point p1 = new Point( -50, -50, 50, new Color(0xff0000ff) );
        Point p2 = new Point( -50, 50, -50, new Color(0xff00ff00) );
        Point p3 = new Point( -50, 50, 50, new Color(0xff00ffff) );
        Point p4 = new Point( 50, -50, -50, new Color(0xffff0000) );
        Point p5 = new Point( 50, -50, 50, new Color(0xffff00ff) );
        Point p6 = new Point( 50, 50, -50, new Color(0xffffff00) );
        Point p7 = new Point( 50, 50, 50, new Color(0xff000000) );*/

        // construct hexahedron model
        /*OrthographicModel cube = new OrthographicModel( r );
        cube.add( new Triangle( new Point( -50, -50, -50, new Color(0xffffffff) ), new Point( -50, -50, 50, new Color(0xff0000ff) ), new Point( -50, 50, -50, new Color(0xff00ff00) ) ) );
        cube.add( new Triangle( new Point( -50, -50, 50, new Color(0xff0000ff) ), new Point( -50, 50, -50, new Color(0xff00ff00) ), new Point( -50, 50, 50, new Color(0xff00ffff) ) ) );
        cube.add( new Triangle( new Point( -50, -50, -50, new Color(0xffffffff) ), new Point( -50, -50, 50, new Color(0xff0000ff) ), new Point( 50, -50, 50, new Color(0xffff00ff) ) ) );
        cube.add( new Triangle( new Point( -50, -50, -50, new Color(0xffffffff) ), new Point( 50, -50, -50, new Color(0xffff0000) ), new Point( 50, -50, 50, new Color(0xffff00ff) ) ) );
        cube.add( new Triangle( new Point( -50, -50, -50, new Color(0xffffffff) ), new Point( 50, 50, -50, new Color(0xffffff00) ), new Point( -50, 50, -50, new Color(0xff00ff00) ) ) );
        cube.add( new Triangle( new Point( -50, -50, -50, new Color(0xffffffff) ), new Point( 50, 50, -50, new Color(0xffffff00) ), new Point( 50, -50, -50, new Color(0xffff0000) ) ) );
        cube.add( new Triangle( new Point( -50, 50, 50, new Color(0xff00ffff) ), new Point( -50, -50, 50, new Color(0xff0000ff) ), new Point( 50, 50, 50, new Color(0xff000000) ) ) );
        cube.add( new Triangle( new Point( 50, 50, 50, new Color(0xff000000) ), new Point( -50, -50, 50, new Color(0xff0000ff) ), new Point( 50, -50, 50, new Color(0xffff00ff) ) ) );
        cube.add( new Triangle( new Point( -50, 50, 50, new Color(0xff00ffff) ), new Point( 50, 50, -50, new Color(0xffffff00) ), new Point( -50, 50, -50, new Color(0xff00ff00) ) ) );
        cube.add( new Triangle( new Point( 50, 50, -50, new Color(0xffffff00) ), new Point( 50, 50, 50, new Color(0xff000000) ), new Point( -50, 50, 50, new Color(0xff00ffff) ) ) );
        cube.add( new Triangle( new Point( 50, -50, -50, new Color(0xffff0000) ), new Point( 50, -50, 50, new Color(0xffff00ff) ), new Point( 50, 50, -50, new Color(0xffffff00) ) ) );
        cube.add( new Triangle( new Point( 50, -50, 50, new Color(0xffff00ff) ), new Point( 50, 50, -50, new Color(0xffffff00) ), new Point( 50, 50, 50, new Color(0xff000000) ) ) );
        /**/
        
        OrthographicModel cube = new OrthographicModel( r );
        cube.add( new Triangle( new Point( -50, -50, 0, new Color(0xffff0000) ), new Point( 50, -50, 0, new Color(0xff00ff00) ), new Point( -50, 50, 0, new Color(0xff0000ff) ) ) );
        cube.add( new Triangle( new Point( 50, 50, 0, new Color(0xff00ffff) ), new Point( 50, -50, 0, new Color(0xff00ff00) ), new Point( -50, 50, 0, new Color(0xff0000ff) ) ) );
        
        return cube;
    }
    
}
