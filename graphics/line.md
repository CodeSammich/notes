###Bresenham's Line Algorithm

*NOTE: 0 < m < 1*

	y = mx + b
	y = (dy / dx) + b //note: d == delta
	(dx)y = (dy)x + (dx)b
	0 = (dy)x - (dx)y + (dx)b
	A = dx
	B = -dx
	C = (dx)b
	
	0 = Ax + By + C
	f(x,y) = Ax + By + c
	
	0: (x, y) is on the line
	
	Midpoint ( x + 1, y + .5 )
		
	f(x+1, y + .5 ) = 0 :mp on the line, draw either pixel
	< 0: mp is above the line, draw bottom pixel
	> 0: mp is below the line, draw top pixel

###First Draft Algorithm

	(x0, y0) -> (x1, y1)

	x = x0, y = y0

	while( x <= x1 ) {
		plot( x, y )
		d = f( x + 1, y + .5 ) //delta
		if( d > 0)
			y += 1
		x += 1
	}

*Effiency*: initial value of delta

_NOTE:_ f( x , y) is used to find if midpoint is above or below line, to color specific pixel: if f > 0, color below, f < 0 color above

d = f( x0 + 1, y0 + .5 )
d = A( x0 + 1) + B( y + .5) + C
d = Ax0 + A + By0 + .5B + C + A + .5(B)
   (f (x0, y0) ) //by definition already on the line, constant of 0
d = 0 + A + .5B
d = A + .5B

###Second Draft Algorithm

	(x0, y0) -> (x1, y1)

	x = x0, y = y0
	d = A + .5B
	
	while( x <= x1 ) {
		plot( x, y )
		if( d > 0)
			y += 1
		x += 1
		d = f( x + 1, y + .5 )
	}

#####Cases of d

| if d < 0  |  if d > 0  |
|:---------:|:----------:|
| x -> x + 1, y -> y  |  x -> x + 1, y -> y + 1  | 
| f( x + 1, y ) |  f( x + 1, y + 1 )  |
| d = A(x + 1) + By + C | d = A(x + 1) + B( y + 1 ) + C   |
| d = Ax + By + C + A |  d = Ax + A + By + B + C    |
|     f( x, y ) |  f( x, y) + A + B |
| d = d + A |  d + A + B   |

###Third Draft

	(x0, y0) -> (x1, y1)

	x = x0, y = y0
	d = A + .5B
	
	while( x <= x1 ) {
		plot( x, y )
		if( d > 0)
			y += 1
			d += B
		x += 1
		d += A 
	}
	
### First Octant Algorithm

	(x0, y0) -> (x1, y1)

	x = x0, y = y0
	d = 2A + B
	
	while( x <= x1 ) {
		plot( x, y )
		if( d > 0)
			y += 1
			d += 2B
		x += 1
		d += A 
	}
 
### Second Octant

	m > 1
	
	( x, y + 1 )
	( x + 1, y + 1 )
	:( x + .5, y + 1 )
	
### Second Quadrant Algorithm Included

	(x0, y0) -> (x1, y1)

	x = x0, y = y0
	d = A + 2B
	
	while( y <= y1 ) {
		plot( x, y )
		if( d < 0)
			x += 1
			d += 2BA
		y += 1
		d += B 
	}

*initial d*
f( x0 + .5, y0 + 1 )
Ax0 + By0 + C + .5A + B
.5A + B ==> A + 2B

	<midpoint>
		if d = 0: on the line
		if d < 0: to the left
		if d > 0: to the right
		
	
