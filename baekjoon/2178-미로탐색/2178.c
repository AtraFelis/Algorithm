#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, m;
    int **map;

    scanf("%d %d", &n, &m);
    map = (int**)malloc(sizeof(int*)*(n+2));
    for (int i = 0; i < n+2; i++)
        map[i] = (int*)malloc(sizeof(int)*(m+2));
    //미로의 끝 부분을 모두 0으로 처리하여 계산하기 편하도록 (n+2)*(m+2)의 배열 할당.
    
    for (int i = 0; i < n+2; i++)
    {
        for (int j = 0; j < m+2; j++)
        {
            if(i==0 || i==n+1 || j==0 || j==m+1)
                map[i][j] = 0;
            else{
                char tmp = getchar();
                map[i][j] = (tmp == '1' ? 1 : 0);
            }
        }
        if(i != n) getchar();
    }
    

    
    //너비 우선 탐색
    int (*queue)[2] = (int (*)[2])malloc(n * m * sizeof(int[2]));
    // 최악의 경우에도 n*m 개 이상의 좌표가 queue에 들어갈 일은 없으므로, n*m의 크기로 배열 동적할당.
    queue[0][0] = 1; queue[0][1] = 1; 

    int front = 0, rear = 1;

    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    
    while(front != rear){
        int x = queue[front][0], y = queue[front++][1];

        for (int i = 0; i < 4; i++){
            if(map[x + dx[i]][y+dy[i]] != 0)
            {                   
                if(map[x + dx[i]][y+dy[i]] == 1){
                    queue[rear][0] = x + dx[i];
                    queue[rear++][1] = y+dy[i];
                } // 방문하지 않은 곳이면 queue에 추가

                if(map[x][y] < map[x + dx[i]][y+dy[i]] || map[x + dx[i]][y+dy[i]] == 1)
                    map[x + dx[i]][y+dy[i]] = map[x][y] + 1;
            }
        }
    }

    printf("%d", map[n][m]);

    return 0;
}

