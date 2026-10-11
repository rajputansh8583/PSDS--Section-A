#include <iostream>
#include <stack>
#include <string>
using namespace std;

// Function to evaluate Postfix expression
int evaluatePostfix(string exp) {
    stack<int> st;

    for (char c : exp) {
        // If operand (digit), push to stack
        if (isdigit(c)) {
            st.push(c - '0'); // convert char to int
        }
        // If operator, pop two operands
        else {
            int val2 = st.top(); st.pop();
            int val1 = st.top(); st.pop();

            switch (c) {
                case '+': st.push(val1 + val2); break;
                case '-': st.push(val1 - val2); break;
                case '*': st.push(val1 * val2); break;
                case '/': st.push(val1 / val2); break;
            }
        }
    }

    return st.top(); // final result
}

int main() {
    string exp;
    cout << "Enter a Postfix expression (digits only, no spaces): ";
    cin >> exp;
    cout << "Postfix: " << exp << endl;
    cout << "Result: " << evaluatePostfix(exp) << endl;
    return 0;
}
