#Aim: Ceci n'est pas une pipe

###Pipe
- A conduit between 2 separate processes
- Pipes have 2 ends, a read end and a write end
- Pipes are unidirectional (a single pipe must be either read or write only in a process).
- Pipes act just like files.
- You can transfer any data you like through a pipe using read/write.
- Unamed pipes have no external idntification (like a descriptor or name).

- `pipe - <unistd.h>`
  - Create an unamed pipe
  - Returns 0 if the pipe was created, -1 if not.
  - Opens both ends of the pipe as files.
  - `pipe( int descriptors[2] )`
	- _descriptors_
	  - Array that will contain the descriptors for each end of the pipe

###Named Pipes
- Also known as FIFOs
- Same as unnamed pipes except FIFOs have a name that can be used to identify them via different programs
- Keep in mind that like unnamed pipes, FIFOs are unidirectional
- `mkfifo`
  - Shell command to make a FIFO
  - `$ mkfifo <pipe name>`


