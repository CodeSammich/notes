####SOTD: For What It's Worth - Buffalo Springfield

#Aim: I need information, stat!

###Do Now:
   1. Make a directory
   2. Put a few files in that directory and maybe even a directory or two

###stat - `<sys/stat.h>`

- Get information about a file (metadata)

 - stat( PATH, STAT BUFFER )
  - struct stat sb;
  - stat("foo", &sb);

###STAT BUFFER

* Must be a pointer to a struct stat

* All the file information gets put into the stat buffer.

 * **Some of the fields in struct stat:**
  * st_size
   * file size in bytes

  * st_uid, st_gid
  * user id, group id

  * st_mode
   * file permissions

  * st_atime, st_mtime
   * last access, last modification

   * These are struct time_t variables. We can use functions in time.h to make sense of them

  * ctime( `<struct time_t *>` )
   * returns the time as a string

  * time( `<struct time_t *>` )
   * sets the parameter to the current time


