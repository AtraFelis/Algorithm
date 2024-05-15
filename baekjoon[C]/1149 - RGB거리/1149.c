#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int rgb[1000][3];
    int dp[1000][3];

    for (int i = 0; i < n; i++)
        scanf("%d %d %d", &rgb[i][0], &rgb[i][1], &rgb[i][2]);
    
    dp[0][0] = rgb[0][0];
    dp[0][1] = rgb[0][1];
    dp[0][2] = rgb[0][2];

    for (int i = 1; i < n; i++) {
        for (int k = 0; k < 3; k++)
        {
            int tmp = dp[i-1][(k+1)%3] < dp[i-1][(k+2)%3] ? dp[i-1][(k+1)%3] : dp[i-1][(k+2)%3];
            dp[i][k] = tmp + rgb[i][k];
        }        
    }

    int answer = dp[n-1][0] < dp[n-1][1] ? dp[n-1][0] : dp[n-1][1];
    answer = answer < dp[n-1][2] ? answer : dp[n-1][2];

    printf("%d", answer);        

    return 0; 
}