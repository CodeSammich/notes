#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int server_handshake( int *from_client ) {
  /* Relies on buffer being a properly null-terminated string that is the name of the downstream pipe */
  int to_client;
  char buffer[100];

  mkfifo( "mario", 0644 ); //make pipe
  *from_client = open( "mario", O_RDONLY ); //wait for a connection

  remove( "mario" );
  read( *from_client, buffer, sizeof(buffer));

  to_client = open( buffer, O_WRONLY );

  strncpy( buffer, "its-a-me, mario!", sizeof(buffer) );

  write( to_client, buffer, sizeof(buffer));

  return to_client;
}

int main() {
  int to_client;
  int from_client;
  char buffer[100];

  to_client = server_handshake( &from_client );

  while( 1 ) {
    read( from_client, buffer, sizeof(buffer));
    /* do stuff to buffer */
    write( to_client, buffer, sizeof(buffer));
  }
  
  return 0;
}
