#include <cstdio>
#include <cstdlib>
#include <map>
#include <iostream>
#include <cmath>

using namespace std;

int main() {
  int T;
  scanf("%d", &T);
  for (int i = 0; i < T; i++) {
    map<int, int> map;
    int M, N, val;
    scanf("%d %d", &N, &M);
    for (int j = 0; j < N; j++) {
      scanf("%d", &val);
      map[val]++;
    }
    for (int k = 0; k < M; k++) { 
      scanf("%d", &val);
      map[val]--;
    }
    int count = 0;
    std::map<int, int>::iterator iter;
    for (iter = map.begin(); iter != map.end(); iter++) {
      count += abs((*iter).second);
    }
    printf("%d\n", count);
  }

}
