#include <stdio.h>
#include <stdbool.h>

int arr[8];
int seq[8];
bool visit[8];
void backtracking(int n, int m, int cnt) {
    if(cnt == m) {
        for (int i = 0; i < m; i++)
            printf("%d ", seq[i]);
        printf("\n");
    } else {
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                seq[cnt] = arr[i];
                backtracking(n, m, cnt+1);
                visit[i] = false;
            }
        }        
    }
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    //삽입 정렬
    int k, key;
    for (int i = 1; i < n; i++) {
        k, key = arr[i];
        for (k = i; k > 0 && key < arr[k-1]; k--)
            arr[k] = arr[k-1];
        arr[k] = key;
    }

    backtracking(n, m, 0);

    return 0;
}