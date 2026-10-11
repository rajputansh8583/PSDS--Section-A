#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> arr = {1, 2, -1, 0, -2, 1};
    int target = 2;

    sort(arr.begin(), arr.end());

    int n = arr.size();

    for (int i = 0; i < n - 2; i++) {
        if (i > 0 && arr[i] == arr[i - 1])
            continue;

        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            int sum = arr[i] + arr[left] + arr[right];

            if (sum == target) {
                cout << arr[i] << " "
                     << arr[left] << " "
                     << arr[right] << endl;

                while (left < right && arr[left] == arr[left + 1])
                    left++;

                while (left < right && arr[right] == arr[right - 1])
                    right--;

                left++;
                right--;
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
    }

    return 0;
}