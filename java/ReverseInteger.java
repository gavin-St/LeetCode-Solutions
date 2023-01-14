public class ReverseInteger {
    public static void main (String args[]){
        System.out.println(reverse(-1563847412));
    }
    public static int reverse(int x) {
        int ans = 0, d = x%10; 
        if (x > 0){
            while (ans < 100000000 && x > 0){
                ans *= 10;
                ans += (x%10);
                x /= 10;
            }
            if(x > 0){
                if(d>2) 
                    ans = 0;
                else if (d==2){
                    if(ans > 214748364) ans = 0;
                    else if (ans == 214748364 && x > 7) ans = 0;
                    else ans  = ans *10 + (x%10);
                }
                else 
                    ans  = ans *10 + (x%10);
            }
        }
        else{
            if (x == Integer.MIN_VALUE) return 0;
            x *= -1; d *= -1;
            while (ans < 100000000 && x > 0){
                ans *= 10;
                ans += (x%10);
                x /= 10;
            }
            if(x > 0){
                if(d>2) 
                    ans = 0;
                else if (d==2){
                    if(ans > 214748364) ans = 0;
                    else if (ans == 214748364 && x > 7) ans = 0;
                    else ans  = ans *10 + (x%10);
                }
                else 
                    ans  = ans *10 + (x%10);
            }
            ans *= -1;
        }
        return ans;
    }
}
