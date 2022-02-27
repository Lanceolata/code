#include "config.h"

#ifdef USE_SUB
  #include "test.h"
#else
  #include <iostream>
#endif

int main() {
#ifdef USE_SUB
  test();
#else
  std::cout << "server" << std::endl;
#endif
}
