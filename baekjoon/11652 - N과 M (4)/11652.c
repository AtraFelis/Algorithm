#include <stdio.h>
#include <stdbool.h>

void backtracking(int, int);

int n, m;
int main() {
    scanf("%d %d", &n, &m);

    backtracking(0, 0);

    return 0;
}

int arr[9];
void backtracking(int cnt, int start) {
    if(cnt == m) {
        for (int i = 0; i < m; i++)
            printf("%d ", arr[i]);
        printf("\n");
    } else {
        for (int i = 1; i <= n; i++) {
            if(start <= i) {                
                arr[cnt] = i;
                backtracking(cnt+1, i);
            }
        }
    }
}