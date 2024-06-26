/**
 * [백준] 14500 - 테트로미노
 * GOlD IV
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    int tetromino[19][2][4] =    
    {
        { {0, 1, 2, 3}, {0, 0, 0, 0} }, // 1
        { {0, 0, 0, 0}, {0, -1, -2, -3} }, // 2
        { {0, 1, 0, 1}, {0, 0, -1, -1} }, // 3
        { {0, 0, 0, 1}, {0, -1, -2, -2} }, // 4
        { {0, 1, 2, 0}, {0, 0, 0, -1} }, // 5
        { {0, 1, 1, 1}, {0, 0, -1, -2} }, // 6
        { {0, 1, 2, 2}, {-1, -1, -1, 0} }, // 7
        { {1, 1, 0, 1}, {0, -1, -2, -2} }, // 8
        { {0, 0, 1, 2}, {0, -1, -1, -1} }, // 9
        { {0, 1, 0, 0}, {0, 0, -1, -2} }, // 10
        { {0, 1, 2, 2}, {0, 0, 0, -1} }, // 11
        { {0, 0, 1, 1}, {0, -1, -1, -2} }, // 12
        { {1, 2, 0, 1}, {0, 0, -1, -1} }, // 13
        { {1, 0, 1, 0}, {0, -1, -1, -2} }, // 14
        { {0, 1, 1, 2}, {0, 0, -1, -1} }, // 15
        { {0, 1, 2, 1}, {0, 0, 0, -1} }, // 16
        { {1, 0, 1, 1}, {0, -1, -1, -2} }, // 17
        { {1, 0, 1, 2}, {0, -1, -1, -1} }, // 18
        { {0, 0, 1, 0}, {0, -1, -1, -2} }, // 19
    };

    int **block = (int**)malloc(sizeof(int*)*(n+2));
    for (int k = 0; k < n+2; k++)
        block[k] = (int*)malloc(sizeof(int)*(m+2)); 

    for (int i = 0; i < n+2; i++) {
        for (int k = 0; k < m+2; k++) {
            if(i==0 || k==0 || i==n+1 || k==m+1) {
                block[i][k] = -1;
            }
            else scanf("%d", &block[i][k]);
        }
    }
    
    int answer = 0;
    for (int i = 1; i < n+1; i++){
        for (int k = 1; k < m+1; k++) {
            for (int j = 0; j < 19; j++) {
                int tmp = 0;
                for (int t = 0; t < 4; t++) {
                    if (block[i+tetromino[j][0][t]][k+tetromino[j][1][t]] == -1){
                        tmp = 0;
                        break;
                    }
                    tmp += block[i+tetromino[j][0][t]][k+tetromino[j][1][t]];
                }
                if(answer < tmp)
                    answer = tmp;
            }
        }
    }
    
    printf("%d", answer);

    return 0;
}