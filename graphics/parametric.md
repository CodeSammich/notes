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
