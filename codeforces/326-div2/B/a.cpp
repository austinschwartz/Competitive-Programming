#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>
#include <queue>
#include <cmath>
#include <map>
#define fi first
#define se second
#define ll o<<1
#define rr o<<1|1
#define CLR(a, b) memset(a, (b), sizeof(a))
using namespace std;
typedef long long LL;
typedef pair<int, int> pii;
const int MOD = 1e4 + 7;
const int MAXN = 1e5 + 10;
void add(LL &x, LL y) { x += y; x %= MOD; }
LL p[100]; int k;
void getp(LL n) {
    k = 0;
    for(LL i = 2; i * i <= n; i++) {
        if(n % i == 0) {
            p[k++] = i;
            while(n % i == 0) {
                n /= i;
            }
        }
    }
    if(n > 1) p[k++] = n;
}
int main() {
    LL n;
    while(scanf("%lld", &n) != EOF) {
        getp(n); LL ans = 1LL;
        for(int i = 0; i < k; i++) {
            ans = ans * p[i];
        }
        printf("%lld\n", ans);
    }
    return 0;
}
