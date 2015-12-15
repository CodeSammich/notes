#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/sem.h>

int main() {

  int key = ftok("makefile", 'a');
  int semid;

  semid = semget( key, 1, 0644);
  printf("Before access...\n");

  struct sembuf sb;
  sb.sem_num = 0;
  sb.sem_flg = SEM_UNDO;
  sb.sem_op = -1;

  semop( semid, &sb, 1);
  int i = 10;
  while ( i-- ) {
    printf("I'm in!");
    sleep(1);
  }

  sb.sem_op = 1;
  semop( semid, &sb, 1);
  
  printf("I'm done!\n");
  return 0;
}
