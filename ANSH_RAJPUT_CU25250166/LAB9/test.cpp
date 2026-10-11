#include <bits/stdc++.h>
using namespace std;
void solve() {
    int N;
    cout << "Enter size of array: ";
    cin >> N;
    long long ans = 0;
    cout << "Enter " << N << " elements: ";
    for (int i = 0; i < N; i++) {
        long long x;
        cin >> x;
        ans += abs(x);
    }
    cout << "Minimum operations: " << ans << endl;
}

int main() {
    int T;

    cout << "Enter number of test cases: ";
    cin >> T;
    while (T--) {
        solve();
    }
    return 0;
}