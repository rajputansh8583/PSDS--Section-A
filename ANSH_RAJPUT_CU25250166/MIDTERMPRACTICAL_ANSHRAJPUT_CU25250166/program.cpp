#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    void solve() {
        int N, K;
        cout << "enter N and K: ";
        cin >> N >> K;
        vector<int> A(N);
        cout << "enter array elements: ";
        for (int i = 0; i < N; i++) {
            cin >> A[i];
        }
       sort(A.begin(), A.end(), [K](int a, int b) {
            int d1 = __builtin_popcount(a ^ K);
            int d2 = __builtin_popcount(b ^ K);
            if (d1 == d2)
                return a < b;

            return d1 < d2;
        });
        cout << "Sorted array: ";
        for (int i = 0; i < N; i++) {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};
int main() {
    int T;
    cout << "Enter number of test cases: ";
    cin >> T;
    Solution obj;
    while (T--) {
        obj.solve();
    }
    return 0;
}