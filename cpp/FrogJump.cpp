#include <iostream>
#include <vector>
#include <sstream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    bool canCross(vector<int>& stones) {
        int n = stones.size();
        bool ans = false;
        unordered_map<int, int> indexes;
        for (int i = 0; i < n; i++) {
            indexes.insert({stones[i], i});
        }
        bool** dp = new bool*[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new bool[2001];
            for (int j = 0; j < 2001; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][1] = true;

        for (int i = 0; i < n ; i++) {
            for (int j = 1; j <= 2000; j++) {
                if (dp[i][j]) {
                    // cout << "dp true " << i << " " << j << endl;
                    int cur = stones[i];
                    int next = cur + j;
                    if (indexes.find(next) != indexes.end()) {
                        int next_index = indexes[next];
                        dp[next_index][j] = true;
                        if(next_index == n-1) {
                            ans = true;
                            // cout << "next one " << next_index << " " << j << "\n";
                            break;
                        }
                    }
                    next = cur + j - 1;
                    if (indexes.find(next) != indexes.end()) {
                        int next_index = indexes[next];
                        dp[next_index][j-1] = true;
                        if(next_index == n-1) {
                            ans = true;
                            // cout << "next one " << next_index << " " << j-1 << "\n";
                            break;
                        }
                    }
                    next = cur + j + 1;
                    if (indexes.find(next) != indexes.end() && i!=0) {
                        int next_index = indexes[next];
                        dp[next_index][j+1] = true;
                        if(next_index == n-1) {
                            ans = true;
                            // cout << "next one " << next_index << " " << j+1 << "\n";
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
};

int main() {
    
    // Accepting space-separated numbers from user input
    int n;
    cin >> n;

    // Converting the input string into a vector of integers
    vector<int> stones_list(n);
    for (int i = 0; i < n; i++) {
        cin >> stones_list[i];
    }

    // Creating a Solution instance and calling canCross
    Solution solution;
    cout << solution.canCross(stones_list) << endl;
}