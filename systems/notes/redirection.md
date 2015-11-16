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
  - Overwrites the file (2>> apends)
  
- `&>`
  - Redirects stdout and stderr
  - Can be used to make log files
  
- `<`
  - Redirects stdin from a file

- | (pipe)
  - Redirect stdout from one command to stdin of the next
  - Goes from left to right


