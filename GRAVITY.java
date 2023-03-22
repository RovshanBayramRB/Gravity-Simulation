
public class abc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				StdDraw.enableDoubleBuffering();
				
				double  deltaT = 100000;
				int n = 4;
				double radius = 2.50e+11;

				StdDraw.setXscale(-radius, radius);
				StdDraw.setYscale(-radius, radius);

				double x = 1.4960e+11;
				double y = 0;
				double vx = 0;
				double vy = 2.9800e+04;
				double[] m = {5.9740e+24, 1.9890e+30};
				String[] fn = {"earth.gif","sun.gif"};
				
				double x1 = 2.2790e+11;
				double y1 = 0;
				double vx1 = 0;
				double vy1 = 2.4100e+04;
				double[] m1 = {6.4190e+23, 1.9890e+30};
				String[] fn1 = {"mars.gif", "sun.gif"};
				
				double x2 = 5.7900e+10;
				double y2 = 0;
				double vx2 = 0;
				double vy2 = 4.7900e+04;
				double[] m2 = {3.3020e+23, 1.9890e+30};
				String[] fn2 = {"mercury.gif", "sun.gif"};
				
				double x3 = 1.0820e+11;
				double y3 = 0;
				double vx3 = 0;
				double vy3 = 3.5000e+04;
				double[] m3 = {4.8690e+24, 1.9890e+30};
				String[] fn3 = {"venus.gif", "sun.gif"};
				
				double G = 6.67 * Math.pow(10,-11);
//				StdOut.print(G);
				double R = Math.sqrt(x*x + y*y);
				double R1 = Math.sqrt(x1*x1 + y1*y1); //mars
				double R2 = Math.sqrt(x2*x2 + y2*y2); //mercury
				double R3 = Math.sqrt(x3*x3 + y3*y3); //venus
			 	
				double F = (G * m[0] *m[1]) / (R * R);
				double F1 = (G * m1[0] *m1[1]) / (R1 * R1); //mars
				double F2 = (G * m2[0] *m2[1]) / (R2 * R2); //mercury
				double F3 = (G * m3[0] *m3[1]) / (R3 * R3); //venus
				
				double cosO;
				double sinO;
				
				double cosO1;
				double sinO1;
				
				double cosO2;
				double sinO2;
				
				double cosO3;
				double sinO3;
				
				double Fx = 0;
				double Fx1 = 0;
				double Fx2 = 0;
				double Fx3 = 0;
				
				double Fy = 0;
				double Fy1 = 0; //mars
				double Fy2 = 0;
				double Fy3 = 0;
				
				double Ax;
				double Ay;
				
				double Ax1;  //mars
				double Ay1;
				
				double Ax2;  //mercury
				double Ay2;
				
				double Ax3;  //venus
				double Ay3;
				
				double Px = x;
				double Py = y;
				double Px1 = x1; //mars
				double Py1 = y1;
				double Px2 = x2; //mercury
				double Py2 = y2;
				double Px3 = x3; //venus
				double Py3 = y3;
				
				double Vx = vx;
				double Vy = vy;
				double Vx1 = vx1; //mars
				double Vy1 = vy1;
				double Vx2 = vx2; //mercury
				double Vy2 = vy2;
				double Vx3 = vx3; //venus
				double Vy3 = vy3;
				
				
				

				while(true)
				{
					
					// Step 1
					StdDraw.clear();
					
					
					// Step 2 calculator
					StdDraw.picture(0 , 0, "stars.jpg", 2 * radius, 2 * radius);
					
					cosO = -Px / R;
					sinO = -Py / R;
					 
					cosO1 = -Px1 / R1;
					sinO1 = -Py1 / R1;   //mars
					
					cosO2 = -Px2 / R2;  //mercury
					sinO2 = -Py2 / R2;
					
					cosO3 = -Px3 / R3;  //venus
					sinO3 = -Py3 / R3;
					
					Fx =  F * cosO;
					Fy =  F * sinO;
					
					Fx1 =  F1 * cosO1;
					Fy1 =  F1 * sinO1;  //mars
					
					Fx2 =  F2 * cosO2;
					Fy2 =  F2 * sinO2;
					
					Fx3 =  F3 * cosO3;
					Fy3 =  F3 * sinO3;
				
					
					Ax = Fx / m[0];
					Ay = Fy / m[0];
					
					Ax1 = Fx1 / m1[0];
					Ay1 = Fy1 / m1[0];
					Ax2 = Fx2 / m2[0];
					Ay2 = Fy2 / m2[0];
					Ax3 = Fx3 / m3[0];
					Ay3 = Fy3 / m3[0];
					
					Vx += deltaT * Ax ;
					Vy += deltaT * Ay ;
					Vx1 += deltaT * Ax1 ;
					Vy1 += deltaT * Ay1 ;
					Vx2 += deltaT * Ax2 ;
					Vy2 += deltaT * Ay2 ;
					Vx3 += deltaT * Ax3 ;
					Vy3 += deltaT * Ay3 ;
					
					
					Px +=  deltaT * Vx;
					Py += deltaT * Vy;
					Px1 +=  deltaT * Vx1;
					Py1 += deltaT * Vy1;
					Px2 +=  deltaT * Vx2;
					Py2 += deltaT * Vy2;
					Px3 +=  deltaT * Vx3;
					Py3 += deltaT * Vy3;
					
					
					// Step 3 Draw
					
					StdDraw.picture(Px, Py, fn[0]);
					StdDraw.picture(0, 0, fn[1]);
					
					StdDraw.picture(Px1, Py1, fn1[0]);
					StdDraw.picture(0, 0, fn1[1]);
					StdDraw.picture(Px2, Py2, fn2[0]);
					StdDraw.picture(0, 0, fn2[1]);
					StdDraw.picture(Px3, Py3, fn3[0]);
					StdDraw.picture(0, 0, fn3[1]);
					
					StdOut.println(Px);
					StdOut.println(Py);
					
					StdOut.println(Px1);
					StdOut.println(Py1);
					StdOut.println(Px2);
					StdOut.println(Py2);
					StdOut.println(Px3);
					StdOut.println(Py3);
					
							
					// Step 4
					StdDraw.show();
					StdDraw.pause(40);
					
				
			}
			}
					
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	


