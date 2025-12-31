/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		sierpinski(n ,0.0, 1.0, 0.5, 0.0, 0.0, 0.866);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if(n == 0){
            return;
        }
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
        
        sierpinski(n - 1, x1, (x1 + x2)/2, (x3 + x1)/2, y1, (y1 + y2)/2, (y3 + y1)/2);
        sierpinski(n - 1, (x1 + x2)/2, x2, (x2 + x3)/2, (y1 + y2)/2, y2, (y2 + y3)/2);
        sierpinski(n - 1, (x3 + x1)/2, (x2 + x3)/2, x3, (y3 + y1)/2, (y2 + y3)/2, y3);
	}
}
