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

#Aim: A pipe by any other name...

###Named Pipes
- `mkfifo - <sys/types.h> <sys/stat.h>`
  - C function to create a FIFO
  - Returns 0 on success and -1 on failure
  - Once created, the FIFO acts like a regular file, and we can use open, read, write, and close on it
  - `mkfifo( <name>, <permissions> )`

#Aim: Always remember to tip your servers

###Server/Client Program Paradigms

######Handshake
- A procedure to ensure that a connection has been established
- Both ends of the connection must verify that they can send and receive data to and from each other

*Basic Handshake Procedure*:
1. Server creates a named pipe (Well Known Pipe)
2. Server waits for a connection
3. Client creates a "private" named pipe
4. Client connects to server and sends the private pipe name
5. Client waits for private pipe connection
6. Server receives client's message and removes the WKP
7. Server connects to client pipe, sending an initial acknowledgement message.
8. Client receives server's message, removes its private pipe.

#Aim: Sometimes you have to ask your server for another fork

###Basic Server
1. Basic Handshake
2. Server gets data from client, "processes" it and sends back a response
3. Once the client exists, the server recreates a new WKP, removes the old client connections and the steps restart.

