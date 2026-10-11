#include <bits/stdc++.h>
using namespace std;
int digitSum(int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}
void solve() {
    int N;
    cout << "Enter size of array: ";
    cin >> N;
    vector<int> nums(N);
    cout << "Enter " << N << " elements: ";
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }
    long long ans = 0;
    // Check every pair
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {

            if (digitSum(nums[i]) == digitSum(nums[j])) {
                ans++;
            }
        }
    }
    cout << "Number of special pairs: " << ans << endl;
}
int main() {
    solve();

    return 0;
}