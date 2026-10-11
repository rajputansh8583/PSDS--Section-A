#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
    string s;

    cout << "Enter a string: ";
    cin >> s;

    unordered_map<char, int> lastSeen;

    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {

        // If character was already seen inside the current window
        if (lastSeen.find(s[right]) != lastSeen.end() &&
            lastSeen[s[right]] >= left) {
            left = lastSeen[s[right]] + 1;
        }

        // Store the latest position of the character
        lastSeen[s[right]] = right;

        // Calculate current window length
        int currentLength = right - left + 1;

        // Update maximum length
        maxLength = max(maxLength, currentLength);
    }

    cout << "Length of longest substring without repeating characters: "
         << maxLength << endl;

    return 0;
}