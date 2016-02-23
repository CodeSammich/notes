#Using Matrices

Could keep track of all the points in my image, and at the end connect the dots

###Points Matrix
> [P0 P1 P2 P3 P4 P5 P6]

while( i < points.length - 1 ) {
	draw_line( points.i, points.i + 1 );
	i++;
}

###Shape Matrix
> [ [P0, P1, P2] [P3, P4, P5, P6] ]

> [ P0P1P2P0 \0 P3P4P5P6P3 \0 ]

###Edge Matrix
> [P0P1 P1P2 P2P3 ... ]

###Connections Matrix

