#####SOTD: "rearviewmirror" - Pearl Jam

#Aim: Make it so

	char *s1 = "Hello";
	char *s2 = "Hello";
	char s3[] = "Hello";

Literal strings are immutable (not s1, s2, s3, but the actual "Hello", right hand side)

     'H' 'e' 'l' 'l' 'o' \0

`s3` IS mutable in that it is an array ==> runs strcpy into an array, which IS mutable

###Separate compilation

 - You can combine multiple c files into a c program by including them all in one gcc command.
 
		gcc test.c string.c foo.c woohoo.c

- You cannot have duplicate function or global variable names across these files.
 - This includes the `main()` function

 - `gcc -c`
  - Will compile a `.c` file into a `.o` file, it is not a fully functional program, but it is compiled code.
  - Do this to compile a `.c` file that does not contain a `main()` function

  - `gcc` can link `.o` files together with `.c` files
