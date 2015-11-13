#####SOTD: Shine - Collective Soul

#Aim: Are your processes running? - Then you should go out and catch them!

####Do Now: Run the command ps in a terminal. What do you see?

###Processes
 - Every running program is a process. A proess can create subprocesses, but these are no different from regular processes.

 - A procesor can handle 1 process per cycle (per core). "Multitasking" appears to happen because the processor switches between all the activate processes quickly.

  - _**pid**_
    - Every process has a unique identifier called the pid.

	 - pid 1 is the init process

	 - Each entry in the `/proc directory` is a current pid

  - `getpid() - <unistd.h>`
    - returns the current process' pid

  - `getppid() - <unistd.h>`
    - returns the current process' parent pid

  - `fork() - <unistd.h>`
	 - Creates a separate process based on the current one, the new process is called the child, the original is the parent.

	The child process is a duplicate of the parent process.  
	All parts of the parent process are copied, including stack and heap memory, and the file table.

	>		  A quick note on threads: A thread is a separate
			  executable entity similar to a child process,
			  except a thread is not a standalone process.
			  It does not have its own memory space, instead
			  it shares its parent's memory.

    - returns 0 to the child and the child's pid to the parent or -1 (errno).x

  - `sleep( <Number of seconds> ) - <unistd.h>`

    - C will wait for number of seconds

  - `wait - <unistd.h>`
    - Stops a parent process from running until any child has provided status information to the parent (usually the child has exited).

    - returns the pid of the child that exited, or -1 (errno)

#Aim: Time to bring out the exectioner.

`exit` - stops the main code during runtime

------------------------------
#####SOTD: Burden in my Hand - Soundgarden  
#Aim: Invasion of the process snatchers.

- `waitpid - <unistd.h>`

 - Waits for a specific child

  - `waitpid(pid, status, options)`
    - pid
      - The pid of the specific child to look for
      - If -1, will wait for any child

    - options
      - Can set other behavior for wait, if 0, will work normally.

###The exec family - `<unistd.h>`

 - There are a number of c functions that can be used to run other programs from within our own programs.

 - Replaces the current process with the new program, any code after a call to an exec function will be ignored.

    **WILL END** current program!

#####execl
	`execl( <PATH>, <COMMAND>, <ARGS>, NULL)`

 - _PATH_
  - The path to the program (ex: `"/bin/ls"`)

 - _COMMAND_
  - The name of the program (ex: `"ls"`)

 - ARGS
  - Each command line argument you wish to give the program. (ex `"-a"`, `"-l"`)

#####execlp
	`execlp( <PATH>, <COMMAND>, <ARGS>, NULL )`

 - Works like execl, except it uses the PATH environment variable for commands, so you can use `"ls"` as the PATH instead of `"/bin/ls"`

	`execlp( "ls", "ls", "-a", "-l", NULL`

#####execvp
	`execvp( <PATH>, <ARGUMENT ARRAY> );`

 - _ARGUMENT ARRAY_
  - Array of strings, with element 0 must be the name of the program to be executed and the last element must be NULL.

 - _PATH_
  -	Like execlp, the PATH argument will take the PATH Environment into account.

### AIM: Let's take this to delimit!

###**strsep** - `<string.h>`
used for parsing a string with a common delimeter

```c
strsep( <SOURCE>, <DELIMETER> )
```

locates first occurrence of delimeter in string, replaces with NULL
returns beginning of original string
sets source string to string starting at 1 index past location of new NULL
since source variable's value is changed, must be pointer to a string

```c
char line[100] = "wow-this-is-so-cool";
*s1 = line;
```


)
