#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int client_handshake( int *from_server ) {

  int to_server;
  char buffer[100];

  sprintf( buffer, "%d", getpid() );
  mkfifo( buffer, 0644);

  to_server = open( "mario", O_WRONLY );
  write( to_server, buffer, sizeof(buffer) );

  *from_server = open( buffer, O_RDONLY );
  remove( buffer );

  read( *from_server, buffer, sizeof(buffer) );
  printf("<client> connection established:[%s]\n", buffer );

  return to_server;
}

int main() {
  int to_server;
  int from_server;
  char buffer[100];

  to_server = client_handshake( &from_server);

  while (1) {

    printf("<client> enter stuff: ");
    fgets( buffer, sizeof(buffer), stdin);
    write( to_server, buffer, sizeof(buffer) );
    read( from_server, buffer, sizeof(buffer) );
    printf( "<client> received: %s\n", buffer);

  }

  close( to_server );
  close( from_server );

  return 0;
}
