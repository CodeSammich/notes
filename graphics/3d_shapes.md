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
