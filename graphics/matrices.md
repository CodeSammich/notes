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

#Matrix Math

###Scalar Multiplication
S * [a b c d] = [Sa Sb Sc Sd]

###Matrix Multiplication
M0 * M1 != M1 * M0

The # of rows in M0 must = # of cols in M1.. vice versa.

Example: [a b c] : [ 1 
	                 2    = [1a + 2b + 3c]
					 3 ]
					 
A x B * B x C = A x C

`x`: dimensions
`*`: multiply

[ a b c     [ 1 4       [ (1a + 2b + 3c) (4a + 5b + 6c)
  d e f   *   2 5    =    (1d + 2e + 3f) (4d + 5e + 6f)
  g h i ]     3 6 ]       (1g + 2h + 3i) (4g + 5h + 6i)]

###Matrix Multiplicative Identity


#Scaling

(x, y, z) ==> ( ax, by, cz)
	   S(a, b, c)

[x    [ a 0 0 0       [ ax
 y  *   0 b 0 0    =    by
 z      0 0 c 0         cz
 1]     0 0 0 1 ]        1]

Single multiplication routine scales the whole matrix (coordinates of the shape, for example)

###Translating

( x, y, z ) ======> ( x + a, y + b, z + c ) 
           ( a , b )
[ x      [ 1 0 0 a     [ x + a
  y   *    0 1 0 b   =   y + b
  z        0 0 1 c       z + c
  1 ]      0 0 0 1         1    ]

###Rotating
( x, y, z ) ==============> ( ?, ?, z )
            R( axis, angle)
			R( z, angle )

 Point (x, y) rotates, say, to ( xr, yr )

Angle to x-axis is phi
 Angle between is beta
 
 xr = rcos( phi + beta ) = rcos(phi) * cos(beta) - rsin(phi) * sin(beta) = xcos(beta) - ysin(beta) 
 yr = rsin( phi + beta ) = rsin(phi) * cos(beta) + rcos(phi) * sin(beta) = ycos(beta) + xsin(beta)
 
 [ x     [ cos(beta)  -sin(beta)  0  0        [ x        [  xcos(beta - ysin(beta))
   y   *   sin(beta)   cos(beta)  0  0    =     y     =     xcos(beta) + xsin(beta) 
   z          0           0       1  0          z                      z
   1 ]]       0           0       0  1 ]        1 ]                    1            ]

