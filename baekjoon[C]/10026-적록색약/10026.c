#include <stdio.h>
#include <stdlib.h>

void dfs(int, int);

char **painting;
int n;

int main() {
    scanf("%d", &n);

    painting = (char**)malloc(sizeof(char*)*n);
    for (int i = 0; i < n; i++)
        painting[i] = (char*)malloc(sizeof(char)*n);
    
    getchar();
    for (int i = 0; i < n; i++){
        for (int k = 0; k < n; k++)
            scanf("%c", &painting[i][k]);        
        getchar();
    }    

    int answer1=0, answer2=0;

    for (int i = 0; i < n; i++) { // 적록색약이 아닐 때.
        for (int k = 0; k < n; k++) {
            if(painting[i][k] != 'b' && painting[i][k] != 'r') { // 방문하지 않았다면 DFS
                answer1++;
                dfs(i, k);
            }
        }
    }
    for (int i = 0; i < n; i++) { // 적록색약일 때
        for (int k = 0; k < n; k++) {
            if(painting[i][k] != 'V') { // 방문하지 않았다면 DFS
                answer2++;
                dfs(i, k);
            }
        }
    }
    
    printf("%d %d", answer1, answer2);

    for (int i = 0; i < n; i++)
        free(painting[i]);
    free(painting);
    
    return 0;
}

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void dfs(int x, int y) {
    char color = painting[x][y];

    if(color == 'B') 
        painting[x][y] = 'b';
    else if(color == 'R' || color == 'G') 
        painting[x][y] = 'r';
    else
        painting[x][y] = 'V';
    
    for(int i=0; i<4; i++) {
        if(x + dx[i] < 0 || x + dx[i] >= n || y + dy[i] < 0 || y + dy[i] >= n)
            continue;
        
        if(painting[x + dx[i]][y + dy[i]] == color){
            dfs(x + dx[i], y + dy[i]);
        }
    }
}