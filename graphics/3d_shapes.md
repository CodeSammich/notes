# 3D Shapes

Box, Sphere, Torus

### Box --------------------

Input: 
	width, height, depth
	(x, y, z) reference point (upper front left point as standard)

### Sphere --------------------

theta: angle of circle creation
phi: angle of circle rotation

theta: 0 -> 2Pi
phi: 0 -> Pi (does both sides at once)

[ 1  0         0       0       [ rcos(theta)       x = rcos(beta)
  0 cos(phi) sin(phi)  0    *    rsin(theta)    =  y = rsin(theta) * cos(phi)
  0 sin(phi) cos(phi)  0              0            z = rsin(theta) * sin(phi)
  0  0         0       1 ]            1     ]

if theta: 0 -> 2pi
	phi: 0 -> pi
	
if theta: 0 -> pi
	phi: 0 -> 2pi
	
##### Psuedocode

	for p: 0 -> 1
		for t: 0 -> 1
			x = rcos(pi * t) + cx
			y = rsin(pi * t) * cos( 2pi * p) + cy
		  	z = rcos(pi * t) * sin( 2pi * p) + cz
		
### Torus
[ 1   0          0          0       [  rcos(theta)           x = rcos(theta)
  0  cos(phi)  -sin(phi)    0    *     rsin(theta)     =     y = cos(phi) * ( rsin(theta) + R )
  0  sin(phi)  cos(phi)     0              0                 z = sin(phi) * ( rsin(theta) + R )
  0   0          0          1 ]            1        ]


# WireFrame/Polygon Meshes
Wireframe Mesh
- 3D Objects are defined as the edges that connect the vertices/points
- Works well with the existing matrix framework

### Polygon
- 3D Ojbects are defined as the surfaces (triangles or quadrilateral) that covers the object
- Moves from edge matrix to polygon matrix

P0 --------- P2
|            |
|            |
|            |
|            |
P1 --------- P4

Edge Matrix = [ P0P1 P1P2 P2P3 ]

But now: Triangle Matrix = [ P0P1P2 P2P3P0 ... ] and ten more to define a box
*(split each square into two triangles diagonally)*

For each polygon (triangle), we will draw lines to connet them
	P0P1
	P1P2
	P2P0
	
### Edge Matrix vs. Polygon Matrix
plot ---> plot
draw-line --> draw-line
draw-lines --> draw-polygon
add-point --> add-point
add-edge --> add-polygon
	
*points must be in counterclockwise order*

### Polygon Meshes
//First --> front two triangles of a box
P0, P1, P2
P2, P3, P0 

//Back  --> back two triangles of a box
P7, P5, P4
P7, P6, P5

### Sphere
P0 to P9 clockwise circle
Then you can rotate to create P10 - P19 respectively

In order to go counterclockwise, zoom in on latitude 
Triangles from P1, P2, P12 and P1, P12, P11

Generalized form:
	i, i + 1, i + n + 1
	i, i + n + 1, i + n

### Backface Culling
The process of rendering only the surfaces that are facing forward
The surface normal (N^) shows the direction a surface is "facing"

*^ is a vector*

The view vector/camera (V^) shows the direction of the observer

If 90 < theta < 270
Then draw the surface ("front-face sifting")

##### Algorithm Normal Vector
 1. Calculate ^N
 - Cross product of 2 vectors that share a common endpoint and go in different directions, must be ccw points

 2. Find theta between N^ and V^ (viewer line)
 3. If 90 < theta < 270, draw the polygon (_visible range_)

A^ = P1 - P0
	< x1 - x0, y1 - y0, z1 - z0 >
	
B^ = P2 - P0
	< x2 - x0, y2 - y0, z2 - z0 >
	
A^ x B^ = < AyBz - AzBy,
	        AzBx - AxBz,
			AxBy - AyBx >
N^ = < Nx, Ny, Nz > ##Points out from the surface


##### Algorithm View Vector
V^ = < 0, 0, -1 >
N^ * V^ =  (|N||V|) * cos(theta)
	         ^Always > 0
cos(theta) < 0 *IF* 90 < theta < 270

N^*V^ = NxVx + NyVy + NzVz
cos(theta) < 0 -> 90 < theta < 270
