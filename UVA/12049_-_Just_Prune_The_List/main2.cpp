#include <cstdio>
#include <cstdlib>
#include <map>
#include <iostream>
#include <cmath>

using namespace std;

int main() {
  map<int, int> map;
  int T;
  scanf("%d\n", &T);
  for (int i = 0; i < T; i++) {
    int M, N;
    scanf("%d %d\n", &N, &M);
    for (int j = 0; j < N; j++) {
      map[j]++;
    }
    for (int k = 0; k < M; k++) { 
      map[k]++;
    }
    int count = 0;
    std::map<int, int>::iterator iter;
    for (iter = map.begin(); iter != map.end(); iter++) {
      count += abs((*iter).second);
    }
    cout << count;
    return 0;
  }

}
