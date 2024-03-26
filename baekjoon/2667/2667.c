#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void dfs(int x, int y);

int **map;
int n;
int cnt = 0;

int main(int x, int y) {
    scanf("%d", &n);

    map = (int**)malloc(sizeof(int*)*n);
    for (int i = 0; i < n; i++)
        map[i] = (int*)malloc(sizeof(int)*n);

    getchar();
    for (int i = 0; i < n; i++){
        for (int k = 0; k < n; k++)
            map[i][k] = getchar() - 48;
        getchar(); // '\n' 제거
    }

    int *counting_sort = (int*)calloc((n*n + 1), sizeof(int));
    // 모든 원소를 0으로 초기화하면서 할당
    // counting sort를 위한 1차원 배열

    int complex = 0; // 아파트 단지수
    for (int i = 0; i < n; i++){
        for (int k = 0; k < n; k++){
            cnt = 0;
            if( map[i][k] == 1){
                dfs(i ,k);
                counting_sort[cnt]++;
                complex++;
            }
        } 
    }

    printf("%d\n", complex);
    for (int i = 0; i < n*n+1; i++)
        while(counting_sort[i]-- > 0)
            printf("%d\n", i);


    free(counting_sort);    
    for (int i = 0; i < n; i++)
        free(map[i]);
    free(map);    
    
    return 0;    
}

void dfs(int x, int y) {
    map[x][y] = 0; // 방문했다는 의미
    cnt++;

    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    for(int i=0; i<4; i++) {
        if(x + dx[i] < 0 || x + dx[i] >= n || y + dy[i] < 0 || y + dy[i] >= n)
            continue;

        if(map[x + dx[i]][y + dy[i]] == 1){
            dfs(x + dx[i], y + dy[i]);            
        }
    }
}