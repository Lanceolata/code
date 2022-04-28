#include "Sort.h"

template<class T>
class QuickSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size() - 1;
    sort(vec, 0, n);
  }

 private:
  void quickSort(vector<int>& nums, int l, int r){
        if(l >= r) return;
        int i = l; // cursor for final pivot location 
        for(int j = l; j <= r - 1; j++){ // nums[r] is chosen as the pivot
            if(nums[j] <= nums[r]){
                swap(nums[i], nums[j]);
                i++; // smaller or equal elements go to the left of i 
            }
        }
        swap(nums[i], nums[r]); // after swap, the pivot is nums[i]
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
  }
  void sort(vector<T>& vec, int l, int h) {
    if (l >= h) {
      return;
    }
    int m = partition(vec, l, h);
    sort(vec, l, m);
    sort(vec, m + 1, h);
  }

  int partition(vector<T>& vec, int l, int h) {
    int i = l, j = h;
    T v = vec[l];
    while (i < j) {
      while (i < j && vec[j] >= v) {
        j--;
      }
      while (i < j && vec[i] <= v) {
        i++;
      }
      if (i < j) {
        swap(vec[i++], vec[j--]);
      }
    }
    swap(vec[l], vec[i]);
    return i;
  }
};
