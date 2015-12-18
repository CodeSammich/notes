#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int server_handshake( int *from_client ) {

  int to_server;
  char buffer[100];

  sprintf( buffer, "%d", getpid() );
  mkfifo( buffer, 0644);

  to_server = open( "mario", O_WRONLY );
  write( to_server, buffer, sizeof(buffer) );

  *from_client = open( buffer, O_RDONLY );
  remove( buffer );

  read( *from_client, buffer, sizeof(buffer) );
  printf("<client> connection established:[%s]\n", buffer );

  return to_server;
}

int main() {

  int to_client;
  int from_client;
  char buffer[100];

  while (1) {

    printf("<server> waiting for connection");
    to_client = server_handshake( &from_client );

    while( read( from_client, buffer, sizeof(buffer))) {

      printf("<server> received [%s]\n", buffer );
      write( to_client, buffer, sizeof(buffer) );

      strncpy( buffer, "", sizeof(buffer));
    }
  }

  close( to_client );

  return 0;
}
