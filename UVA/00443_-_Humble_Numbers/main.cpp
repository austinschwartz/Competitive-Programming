#include <bits/stdc++.h>

using namespace std;

#define ll long long

#define MAX 5843

int main() {
  priority_queue<ll, vector<ll>, greater<ll> > pq;
  ll ans[MAX] = {1};
  pq.push(1);
  for (int i = 1; i < MAX; i++) {
    ll num = pq.top();
    pq.pop();
    ans[i] = num;

    while (!pq.empty() && pq.top() == num)
      pq.pop();

    pq.push(num * 2);
    pq.push(num * 3);
    pq.push(num * 5);
    pq.push(num * 7);
  }

  while (1) {
    int n;
    scanf("%d", &n);
    if (n == 0)
      break;
    if (n % 10 == 1 && n % 100 != 11)
      printf("The %dst humble number is %lld.\n", n, ans[n]);
    else if (n % 10 == 2 && n % 100 != 12)
      printf("The %dnd humble number is %lld.\n", n, ans[n]);
    else if (n % 10 == 3 && n % 100 != 13)
      printf("The %drd humble number is %lld.\n", n, ans[n]);
    else
      printf("The %dth humble number is %lld.\n", n, ans[n]);
  }
  return 0;
}
