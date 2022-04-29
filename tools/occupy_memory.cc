#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main() {
  size_t msize = (size_t)6 * 1024 * 1024 * 1024;
  char *buffer = new char[msize];
  memset(buffer, 0, msize);
  while (true) {
    sleep(1000);
  }
}
