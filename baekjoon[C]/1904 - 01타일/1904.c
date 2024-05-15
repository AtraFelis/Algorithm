#include <stdio.h>

int dp[1000001];
int main() {
    int n;
    scanf("%d", &n);

    // dp[n] = dp[n-2] + dp[n-1]
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++)
        dp[i] = (dp[i-2] % 15746  + dp[i-1] % 15746) % 15746;
    
    printf("%d", dp[n]);
    
    return 0;
}