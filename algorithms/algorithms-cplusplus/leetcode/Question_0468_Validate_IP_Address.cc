#include <string>
#include <regex>

using namespace std;

class Solution {
 public:
  string validIPAddress(string IP) {
    regex ipv4("^([1-9]\\d{0,2}|0)(?:\\.([1-9]\\d{0,2}|0)){3}$");
    regex ipv6("^([0-9a-fA-F]{1,4})(\\:[0-9a-fA-F]{1,4}){7}$");

    smatch m;
    if (regex_match(IP, m, ipv4)) {
      for (auto& e: m) {
        if (stoi(e) > 255) {
          return "Neither";
        }
      }
      return "IPv4";
    } else if (regex_match(IP, m, ipv6)) {
      return "IPv6";
    }
    return "Neither";
  }
};
