#include <string>

using namespace std;

class Solution {
 public:
  string numberToWords(int num) {
    if (num <= 0) {
        return "Zero";
    }
    return help(num);
  }

 private:
  static const string const below_10[];
  static const string const below_20[];
  static const string const below_100[];

  string help(int n) {
    string res;
    if (n < 10) {
      res = below_10[n];
    } else if (n < 20) {
      res = below_20[n - 10];
    } else if (n < 100) {
      res = below_100[n / 10] + " " + help(n % 10);
    } else if (n < 1000) {
      res = help(n/100) + " Hundred " +  help(n % 100);
    } else if (n < 1000000) {
      res = help(n/1000) + " Thousand " +  help(n % 1000);
    } else if (n < 1000000000) {
      res = help(n/1000000) + " Million " +  help(n % 1000000);
    } else {
      res = help(n/1000000000) + " Billion " + help(n % 1000000000);
    }
    trim(res);
    return res;
  }

  void trim(string &s) {
    if (s.empty()) {
        return;
    }
    s.erase(0,s.find_first_not_of(" "));
    s.erase(s.find_last_not_of(" ") + 1);
  }
};

const string const Solution::below_10[] =  {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
const string const Solution::below_20[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
const string const Solution::below_100[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
