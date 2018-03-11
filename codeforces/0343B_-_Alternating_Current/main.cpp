#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main() {
  string ss;
  cin >> ss;

  stack<char> st;

  for (int i = 0; i < ss.length(); i++) {
    if (st.size() == 0 || st.top() != ss[i]) {
      st.push(ss[i]);
    } else {
      st.pop();
    }
  }

  if (st.size() == 0)
    cout << "Yes" << endl;
  else
    cout << "No" << endl;
  return 0;
}
