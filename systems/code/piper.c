#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define READ 0
#define WRITE 1

int main() {

  int fds[2];
  int f;
  char line[100];

  pipe( fds );
  printf("fds[0]: %d\n", fds[0]);
  printf("fds[1]: %d\n", fds[1]);

  f = fork();
  if(f == 0 ) { //child
    close( fds[READ] );
    fgets(line, sizeof(line), stdin );
    write( fds[WRITE], &line, sizeof(line) );
    close( fds[WRITE] );
  }
  else {
    close( fds[WRITE] );
    read( fds[READ], &line, sizeof(line) );
    printf( "parent read: %s\n", line);
    close( fds[READ]);
  }
  return 0;
}
