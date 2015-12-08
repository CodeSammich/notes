####SOTD: The General - Dispatch

#Aim: How do we flag down a resource?

###Semaphores (created by Edsger Dijkstra)

IPC construct used to control access to a shared resource (like a file or shared memory).
Essentially, a semaphore is a counter that represents how many processes can access a resource at any given time.
If a semaphore has a calue of 3, then it can have 3 active "users".
If a semaphore has a value of 0, then it is unavailable.

Most semaphore operations are "atomic", meaning they will not be split up into multiple processor instructions.

####Semaphore operations:
- Create a semaphore
- Set an initial value
- Up(S) / V(S)
- Release the semaphore to signal you are done with its associated resource.
 - pseudocode:

         S++
         Down(S) / P(S)

- Attempt to take the semaphore

- If the semaphore is 0, wait for it to be available

 - pseudocode:

		while (S==0)
		block
		S--

- Removing a semaphore

####Semaphore code
- `semget - <sys/types.h> <sys/ipc.h> <sys/sem.h>`

 - Create/Get access to a semaphore

  - This is not the same as Up(S), the semaphore is not modified by semget.
  - Returns a semaphore descriptor or -1 (errno)

	    semget( <KEY>, <AMOUNT>, <FLAGS> )

- *KEY*
 - Unique semaphore identifier (use ftok)
- *AMOUNT*
 - Semaphores are actually stored as sets with possibly many semaphores stored together. This parameter sets the numbers of semaphores to create/get.
- *FLAGS*
 - Includes permissions for the semaphore.
 - Combine with bitwise or

  -	`IPC_CREAT`: create the semaphore, will set the value to 0.
  - `IPC_EXECL`: Fail if the semaphore already exists and IPC_CREAT is on.

		example
		int semd;
		semd=semget( ftok("file/dir", 2), 1, 0664 | IPC_CREAT);
