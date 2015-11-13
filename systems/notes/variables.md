#Aim: Variables are the spice of life.

###Do Now: What is the smallest variable type that could be used to store the following values (using standard sizes).

   1. 5	     	    |	     byte
   2. -30,000		|     short (-2^15 => 2^15 - 1)
   3. 255		    |     short
   4. 5,000,000,000	|     long (-2^63 => 2^63 - 1)

###C Primitive Variable Types
 
  - All C primitives are numeric
       
  - The only difference is floating point vs. integer and size of variable    
   
  - Size can be platform dependent:

  - `sizeof(<TYPE>)` can be used to find the size in bytes

    - `sizeof(int)`

|Type	|		Standard Size (in bytes)|
|:-----:|:-----------------------------:|
|   int |				4 |
|   short|			2|
|   long|				8|
|   float|			4|
|   double|			8|
|   char|				1|

  - All booleans are numbers
    - 0 ==> false
    - anything else ==> true

    **YOU WILL ALL MAKE THIS MISTAKE**  

        if( x = 6) {...}
	   
	 - will return number if assigned, 6 == true
	 - will always be true!

