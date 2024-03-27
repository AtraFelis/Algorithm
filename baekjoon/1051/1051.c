/**
 * [백준] 1051 - 숫자 정사각형
 * Silver III
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    int **square = (int**)malloc(sizeof(int*)*n);
    for (int i = 0; i < n; i++)
        square[i] = (int*)malloc(sizeof(int)*m);

    getchar();
    for (int i = 0; i < n; i++){
        for (int k = 0; k < m; k++)
            square[i][k] = getchar() - 48;
        getchar(); // '\n' 제거.
    }

    int side = n < m ? n+1 : m+1; // 정사각형의 최대 길이, while문 들어가면서 -1 하고 시작하므로 1 길게 설정.
    bool find = false;
    while(!find && side-- != 1) {
        for (int i = 0; i <= n-side && !find; i++)
        {
            for (int k = 0; k <= m - side && !find; k++)
            {
                int width[3] = {i+side-1, i, i+side-1};
                int length[3] = {k, k+side-1, k+side-1};

                if(square[i][k] == square[i+side-1][k] && square[i][k] == square[i][k+side-1] && square[i][k] == square[i+side-1][k+side-1])
                    find = true;
            }
        }
    }

    printf("%d", side * side);

    for (int i = 0; i < n; i++)
        free(square[i]);
    free(square);

    return 0;
}