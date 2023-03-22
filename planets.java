public class planets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdDraw.enableDoubleBuffering();
		double totalT = Double.parseDouble(args[0]);
		double dT = Double.parseDouble(args[1]);

		int n = StdIn.readInt();
		double radius = StdIn.readDouble();

		StdDraw.setXscale(-radius, radius);
		StdDraw.setYscale(-radius, radius);
double[] positionx = new double[n];
		double[] positiony = new double[n];
		double[] speedx = new double[n];
		double[] speedy = new double[n];
		double[] m = new double[n];
		String[] namefile = new String[n];
		for (int i = 0; i < n; i++) {

			positionx[i] = StdIn.readDouble();
			positiony[i] = StdIn.readDouble();
			speedx[i] = StdIn.readDouble();
		    speedy[i] = StdIn.readDouble();
			m[i] = StdIn.readDouble();
			namefile[i] = StdIn.readString();

		}

		double GravitationalConstant = 6.67 * Math.pow(10, -11);
		for (double t = 0.0; t < totalT; t = t + dT) {

			
			StdDraw.clear();
			
			StdDraw.picture(0, 0, "stars.jpg", radius * 2, radius * 2);
			for (int i = 0; i < n; i++) {
				double ax = 0.0;
				double ay = 0.0;
				double dx ;
			    double dy ;
				double r ;
				double cosA;
				double sinA;
				double f ;
				double fx;
				double fy;
					
				
				for (int j = 0; j < n; j++) {
					if (i != j) {
						
						 dx = positionx[j] - positionx[i];
					     dy = positiony[j] - positiony[i];
						 r = Math.sqrt(dx * dx + dy * dy);
						 cosA = dx / r;
						 sinA = dy / r;
						 f = (GravitationalConstant * m[i] * m[j]) / (r * r);
						 fx = f * cosA;
						 fy = f * sinA;
						ax += fx / m[i];
						ay += fy / m[i];
					}
				}
				
				speedx[i] = speedx[i] + (ax * dT);
				
				speedy[i] = speedy[i] + (ay * dT);
				positionx[i] = positionx[i] + (speedx[i] * dT);
				positiony[i] = positiony[i] + (speedy[i] * dT);

			}
			
			for (int i = 0; i < n; i++) {
		StdDraw.picture(positionx[i], positiony[i], namefile[i]);

			}

			
		StdDraw.show();
			StdDraw.pause(40);

		}

		for (int i = 0; i < n; i++) {
			StdOut.print(positionx[i]+" ");
			StdOut.println(positiony[i]);
			
		}
	}
}