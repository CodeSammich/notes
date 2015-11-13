####SOTD: Wheels - Cake

#Aim: File this under useful information.

###Do Now: What are the different kinds of file permissions?

- seed ==> input for random number generator, default random number

###File Permissions

 - 3 kinds of permissions:
  - read, write, execute

   - Permissions can be represented as 3-digit binary #s or 1-digit octal #s

 - `chmod <number number number> <file name>`

**Note: Don't compile .h files**

#Aim: Opening up a whole new world of possibilites

###File Table

- A list of all files used by a program while it is running.
  - Contains basic information like the file's location and size
  - The file table has a limited size, which is a power of 2 and commonly 256,
       `getdtablesize()` will return this value

- Standard File Table:

  |file descrip.|name(path) | location | ... |
   |:----------:|:---------:|:--------:|:---:|
   |0	   |stdin       |	| |
	|1   	   |stdout      | | |
	|2 	   |stderr      | | |
	   
     - Each file is given an integer index, starting at 0, this is referred to as the file descriptor
     - There are 3 files always open in the table:
	 
	    0 or **STDIN_FILENO**: stdin  
	    1 or **STDOUT_FILENO**: stdout  
	    2 or **STDERR_FILENO**: stderr  

###File Actions
-  `open - <fcntl.h>`
 - Add a file to the file table and returns its file descriptor

 - _If open fails, -1 is returned, extra error information can be found in errno (#include <errno.h>)_
 - _If you include <string.h>, can use strerror( errno ) to get error message_

  - _**errno is an int variable that can be found in <errno.h>, using strerror (in string.h)
     on errno will return a string description of the error**_

 - `open( <PATH>, <FLAGS>, <MODE> )`
  - returns file descriptor ==> often used in conjunction with read/write as the first parameter

   - mode
    - Only used when creating a file. Set the new file's permissions using a 3 digit octal #

	         Octal #s have a leading 0
			      0644, 0777 ...

			      (1-7) corresponds to binary: so 7 is 111 ==> read yes, write yes, exec yes

	- flags
	 - Determine what you plan to do with the file.

     - Use the following constants:

	 | Flag | Indication |
	 |:----:|:--------------:|
	 |`O_RDONLY` | read only |
	 |`O_WRONLY` | write only|
	 |`O_RDWR` | read + write|
	 |`O_APPEND` | append onto file|
	 |`O_TRUNC` | truncate file |
	 |`O_CREAT` | create a new file, if not existing. |
	 |`O_EXCL`  | when combined with O_CREAT, will return an error if the file exists |


####SOTD: Fly Me To The Moon - Frank Sinatra

#Aim: Read your writes!

######a brief interlude

###bitwise operators

| Operator | Definition |
|:--------:|:----------:|
|	`&` | bitwise and |
|	`|` | bitwise or  |
|	`~` | bitwise not |
|	`^` | bitwise xor |

- logical operators work on each bit of a value

		char c = 13; //00001101
		char x = ~c; //11110010

- flags
 > Each flag is a number, to combine flags we use bitwise or

		O_WRONLY = 1   	       00000001
		O_APPEND = 8	       00001000
		O_WRONLY | O_APPEND =  00001001

- `close - <unistd.h>`
 - Remove a file from the file table.

 - Returns 0 if successful. Returns -1 and an error if unsuccessful.

                   close( `<FILE DESCRIPTOR>` )

- `read - <unistd.h>`
 - Read in data from a file

		read( `<FILE DESCRIPTOR>, <BUFFER>, <AMOUNT>` )
		read( fd, buff, n )

  - Read n bytes from the fd's file and put that data into buff

  - returns the number of bytes actually read; return and sets errno if unsuccessful.

  - BUFFER must be a pointer. C is pass-by-copy, so you can't manage a value that is going to be deleted after the function ends anyways.

- ` write - <unistd.h>`
-  Writes in data to a file

		write( <FILE DESCRIPTOR>, <BUFFER>, <AMOUNT IN BYTES> )
		read( fd, buff, n)
		//fd is often, if not always, returned by `open(<file_name>);`

**BUFFER is generally the place you want to store the value/stored the value you're using**

####SOTD: Crazy - Gnarls Barkley

#Aim: Seek and ye shall find

###umask - `<sys/stat.h>`

- Set the file creation permission mask

- By default, created files are not given the exact permissions provided in the mode argument to open.

- A mask is applied that automatically shuts off certain permissions.

- Umask is applied by using bitwise negation on the mask, then bitwise anding it to the node

		new_permissions = ~mask & mode

- The default mask is 022, which shuts off write permissions for group and other.

		umask( <MASK> );
	- You can define the umask using a 3 digit octal #

			umask(0000);

###lseek - `<unistd.h>`

- Set the current position in an open file

		lseek( <FILE DESCRIPTOR>, <OFFSET>, <WHENCE> )

 - _**offset**_
  - Where to measure the offset from

  - **SEEK_SET**
   - offset is evaluated from the beginning of the file

  - **SEEK_CUR**
   - offset is relative to the current position in the file

  - **SEEK_END**
   - offset is evaluated from the end of the file
 
 - returns the number of bytes the current position is from the beginning of the file, or -1 (errno)

