#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main() {
  int from_client;
  int e;
  char line[100];
  
  e = mkfifo( "mario", 0644 );
  printf("<server> pipe created: %d\n", e);

  from_client = open( "mario", O_RDONLY );
  printf("<server> pipe open\n");

  remove("mario");
  
  read( from_client, line, sizeof(line));
  printf("<server> read: [%s]\n", line);

  close(from_client);
  
  return 0;
}
