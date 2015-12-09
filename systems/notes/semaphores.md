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

#Aim: What's a semaphore? - To control resources!

###Semaphore Code

- semctl - `<sys/types.h` `sys/ipc.h>` `<sys/sem.h>`
  - Control the semaphore, including:
	- Set the semaphore value
	- Remove the semaphore
	- Get the current value
	- Get information about the semaphore

	`semctl( <DESCRIPTOR>, <INDEX>, <OPERATION> )`

	- *DESCRIPTOR*
	  - The return value of semget
	- *INDEX*
	  - The index of the semaphore you want to control in the semaphore set identified by the descriptor.
	  - For a simple semaphore, set 0.
	- *OPERATION*
	  - One of the following constants (there are others as well)
	  - `IPC_RMID`: remove the semaphore
	  - `SETVAL`: Set the value (requires data)
	  - `SETALL`: Set the value of every semaphore in the set. (requires data)
	  - `GETVAL`: Returns the value
	  - `IPC_STAT`: Populate buffer with information about the semaphore. (requires data)
	- *DATA*
	  - Variable for setting/storing information about the semaphore. (data type: union semun)

	> Unions are meant to store one of their associated types at any given time.

- You have to declare this union in your main c file on linux machines.

#Aim: Turn down or up?

###Semaphore code

- `semop`
  - Perform seamphore operations (like Up/Down)
  - All operations performed via semop are atomic (not broken up by any other processor instruction)
  - `semop( <DESCRIPTOR>, <OPERATION>, <AMOUNT> )`
	- *DESCRIPTOR*
	  - See above
	- *AMOUNT*
	  - The amount of semaphores you want to operate on in the semaphore set.
	  - For a single semaphore set, 1.
	- *OPERATION*
	  - A pointer to a struct sembuf

			struct sembuf {
				short sem_op;
				short sem_num;
				short sem_flg;
			}
				
	   - `sem_num`
		 - The index of the semaphore you want to work on.
	   - `sem_op`
		 - -1: Down(S)
		 - 1: Up(S)
		   - Any -/+ number will work, you will be requesting/releasing that value from the semaphore
		 - 0: Block until the semaphore reaches 0
	   - `sem_flg`
		 - Provide further options
		 - `SEM_UNDO`: Allow the OS to undo the given operation. Useful in the event that a program exists before it could release a semaphore.
		 - `IPC_NOWAIT`: Instead of waiting for the semaphore to be available, return an error.
		 
