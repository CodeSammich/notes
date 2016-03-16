#Parametric Equations

x = f(t)
y = g(t)

t: 0 -> 1

	double param_x( double t ) {
		return 100 * cos( 2 * M_PI * t ) + 250;
	}
	
	double param_y( double t ) {
		return t * 100 * sin( 2 * M_PI * t) + 250;
	}
	
	int main() {
		double x0, y0, x, y, t, step;
		x0 = param_x(0);
		y0 = param_y(0);
		step = .25 //square, cause 1 / .25 = 4
		for(t = step; t < 1; t += step) { //regular polygon maker
			x = param_x( t );
			y = param_y( t );
			
			add_edges( edges, x0, y0, 0, x, y, 0);
			
			x0 = x;
			y0 = y;
		}
	}

###Herite Inputs

P0, P1: Endpoints
R0, R1: Rates of chance at each endpoint

####Hermite Curves
f(t) = at^3 + bt^2 + ct + d `Points on the curve`
f'(t) = 3at^2 + 2bt + c `Rates of change`

When t = 0
f(t) = d `Initial point`
f'(t) = c `Initial slope r0`

When t = 1
f(t) = d `End point`
f'(t) = c `End slope r1`

[ 0 0 0 1     [a	  [ d                  [ P0 
  1 1 1 1   *  b	    a + b + c + d    =   P1
  0 0 1 0      c    =  	c                    R0
  3 2 1 0 ]    d ]      3a 2b c ]            R1  ]
	                      G

 H * C = G
 H ^ -1  * H * C = H ^ -1 * G
	           C = H ^ -1 * G
			   
[ 2 -2 1 1     [ P0       [ a
  -3 3 -2 1  *   P1   =     b
  0 0 1 0        R0         c
  1 0 0 0  ]     R1 ]       d ]

###Bezier Curves

Inputs: P0 P3 : endpoints
        P1, P2
		
*Linear B.C.*

`P(t) = (1 - t)P0 + tP1`

*Quadratic B.C.*
P(t) = ( 1 - t )R0 + tR1
R0(t) = (1-t)P0 + tP1
 ... //algebra, proof available online
`R(t) = (1-t)^2 P0 +2t(1-t)P1 + t^2 P2`

*Cubic B.C.*
`Q(t) = ((1-t)^3)P0 + 3t((1-t)^2)P1 + ((3t^2)(1-t))P2 + (t^3)P3`

*_Inputs_*
P0, P1, P2, P3 -> at^3 + bt^2 + ct + d

R(t) = (1-t)Q0 + tQ1
     = (1-t)^2 P0 + 3t(1-t)^2 P1 + 3t^2(1-t) P2 + t^3 P3
	 
...

(-P0 + 3P1 - 3P2 + P3)*t^3      +   (3P0 - 6P1 + 3P2)t^2    +  ( -3P0 + 3P1 )t    + P0

--------*a*-----------------          ---------*b*----          ------*c*---      -*d*-

[ -1 3 -3 1          [ P0        [ a       [ -P0 + 3P1 - 3P2 + P3
  3 -6 3 0         *   P1    =     b     =   3P0 - 6P1 + 3P2
  -3 3 0 0             P2          c             -3P0 + 3P1
  1  0 0 0 ]           P3 ]        d ]                P0           ]
