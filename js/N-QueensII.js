/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function(n) {
    let ans = 0;
    const count = (n, cur, col, diag1, diag2) => {
        if (cur == n) {
            ans++;
            return;
        }
        for(let i = 0; i < n; i++) {
            let d1 = cur + i;
            let d2 = cur + n - i - 1;
            let col1 = col.slice();
            let diag11 = diag1.slice();
            let diag21 = diag2.slice();
            if (!col[i] && !diag1[d1] && !diag2[d2]) {
                col1[i] = true;
                diag11[d1] = true;
                diag21[d2] = true;
                count(n, cur + 1, col1, diag11, diag21);
            } 
        }
    }
    count(n, 0, Array(n).fill(false), Array(2*n - 1).fill(false), Array(2*n - 1).fill(false));
    return ans;
};

console.log(totalNQueens(8))