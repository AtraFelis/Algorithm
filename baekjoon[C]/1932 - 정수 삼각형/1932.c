#include <stdio.h>

int main() {
    int tri[500][500];
    int dp[500][500];

    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        for (int k = 0; k <= i; k++)
            scanf("%d", &tri[i][k]);

    dp[0][0] = tri[0][0];

    for (int i = 1; i < n; i++) {
        for (int k = 0; k <= i; k++) {            
            dp[i][k] = dp[i-1][k] + tri[i][k];
            
            if(k != 0 && dp[i-1][k] < dp[i-1][k-1])
                dp[i][k] = dp[i-1][k-1] + tri[i][k];
        }        
    }

    int answer = 0;
    for (int i = 0; i < n; i++)
        answer = answer > dp[n-1][i] ? answer : dp[n-1][i];
    
    printf("%d", answer);        

    return 0;
}