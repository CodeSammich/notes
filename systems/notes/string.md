#####SOTD: In The Meantime - Spacehog

#Aim: Time to stop stringing you along.

Array variable = memory address of first index

      float fray[5];
      float fp = fray
      fp[2] <==> *(fp + 2)

      	    	   	^Will move over 2 "slots" in the memory chunk

C strings (ctrings)
  	  Strings are character arrays that end with a null character (either '' or 0 or '\0').

	  The terminating null character is a convention, string functions will not work correctly without it.

	  The following are valid ways to declare strings:

	      char s[256];
	      	   Normal array declaration, allocates 256 bytes, nothing is set automatically

	      char s[256] = "Imagine";
	      	   Allocates 256 bytes, puts "Imagine" in the first 7 bytes AND adds a null at the 8th byte

	      char s[] = "Tuesday";
	      	   Allocates 8 bytes, puts "Tuesday" in the first 7 bytes AND adds a null at the 8th byte

	      char *s = "Tuesday";
	      	   Allocates 8 bytes, puts "Mankind" in the first 7 bytes AND adds a null at the 8th byte,
		   s is a pointer variable instead of the array.

If you set a pointer = to another pointer, because pointers hold an integer that is a memory address, they WILL point to the same memory

------------------------------------
#Aim: How to write functioning code

####Functions: A brief interlude

	   All c functions are "pass by value"
	       A parameter is a copy of the variable passed into the function. The original variable is not touched.

	   function headers
	       <return type> <name> (<parameters>)

	   You must declare a function before you use it. This can be used in a few ways:

	       1) Write entire functino at the top of your code, making sure to keep the order correct.

	       2) Write the function headers at the top of your code, and then provide the full definition later
