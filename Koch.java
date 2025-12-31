/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		/*curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
        //uncomment the lines inside the function to make the snowflake have no inside lines
        n--;
        if(n == -1) return;
        if(n == 0){
            StdDraw.line(x1, y1, x2, y2);
            return;
        }
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.setPenColor(StdDraw.WHITE);
        //StdDraw.setPenRadius(0.005);
		StdDraw.line((2 * x1 + x2)/3, (2 * y1 + y2)/3, (x1 + 2 * x2)/3, (y1 + 2 * y2)/3);
        StdDraw.setPenColor(StdDraw.BLACK);
        //StdDraw.setPenRadius(0.002);
        StdDraw.line((2 * x1 + x2)/3, (2 * y1 + y2)/3, (Math.cbrt(3)/6) * (y1 - y2) + 0.5 * (x1 + x2), (Math.cbrt(3)/6) * (x2 - x1) + 0.5 * (y1 + y2));
        StdDraw.line((x1 + 2 * x2)/3, (y1 + 2 * y2)/3, (Math.cbrt(3)/6) * (y1 - y2) + 0.5 * (x1 + x2), (Math.cbrt(3)/6) * (x2 - x1) + 0.5 * (y1 + y2));
        curve(n, x1, y1, (2 * x1 + x2)/3, (2 * y1 + y2)/3);
        curve(n, (2 * x1 + x2)/3, (2 * y1 + y2)/3, (Math.cbrt(3)/6) * (y1 - y2) + 0.5 * (x1 + x2), (Math.cbrt(3)/6) * (x2 - x1) + 0.5 * (y1 + y2));
        curve(n, (Math.cbrt(3)/6) * (y1 - y2) + 0.5 * (x1 + x2), (Math.cbrt(3)/6) * (x2 - x1) + 0.5 * (y1 + y2),(x1 + 2 * x2)/3, (y1 + 2 * y2)/3);
        curve(n, (x1 + 2 * x2)/3, (y1 + 2 * y2)/3 , x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
        double x1 = 0.15 + 0.8*0.5, y1 = 0.8*(1 - 0.866), x2 =  0.15 + 0, y2 = 0.8*1, x3 = 0.15 + 0.8*1, y3 = 0.8*1;
		curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
	}
}
