#include <stdio.h>

int n;
int A[1001];
int dp[1001];

void f();

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
        scanf("%d", &A[i]);

    f();

    int answer = 0;
    for (int i = 1; i <= n; i++)
        answer = dp[i] > answer ? dp[i] : answer;
    
    printf("%d", answer);

    return 0;
}

void f() {
    for (int i = 1; i <= n; i++)
    {
        dp[i] = 1;
        for (int k = 1; k < i; k++)
        {
            if(A[i] > A[k])
                dp[i] = dp[i] > dp[k] ? dp[i] : dp[k] + 1;
        }
    }
}
