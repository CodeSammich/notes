#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main() {

  int to_server;
  char line[100];

  to_server = open( "mario", O_WRONLY );
  printf( "<client> pipe open\n" );

  printf("<client> enter stuff: " );
  fgets( line, sizeof(line), stdin);
  write( to_server, line, sizeof(line));

  close(to_server);
  
  return 0;
}
