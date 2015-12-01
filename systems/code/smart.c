#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

static void sighandler( int signo ) {
  if (signo == SIGINT) {
    printf("Interrupted... how rude!\n");
    exit(0);
  }
}

int main() {
  
  signal( SIGINT, sighandler );
  
  int i = 0;
  while(1) {
    printf("G'day mate!\t%d\t%d\n", i++, getpid());
    sleep(1);
  }
  
  return 0;	
}

