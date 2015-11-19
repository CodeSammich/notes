#Aim: Introduction to Redirection

###File Redirection

- Changing the usual input/output behavior of a program

- Command line redirection
- `>`
  - Redirects stdout to a file
  - Overwrites the contents of the file
  - `<COMMAND> > <FILE>`
  - `ls > file_list`
  
- `>>`
  - Redirects stdout to a file
  - Appends instead of overwrites
  
- `2>`
  - Redirects strerror to a file
  - Overwrites the file (2>> appends)
  
- `&>`
  - Redirects stdout and stderr
  - Can be used to make log files
  
- `<`
  - Redirects stdin from a file

- | (pipe)
  - Redirect stdout from one command to stdin of the next
  - Goes from left to right

###Redirection in C Programs

#### `dup2 - <unistd.h>`
- Redirect one file descriptor to another

		dup2( fd1, fd2 )

 - Redirects fd2 to fd1
 - You will lose any reference to the original fd2, that file is closed.

#### `dup - <unistd.h>`
- Duplicates an existing entry in the file table.
- Returns a new file descriptor for the duplicate entry.

		dup( fd )
 - returns the new file descriptor 
