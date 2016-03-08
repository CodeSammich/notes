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
