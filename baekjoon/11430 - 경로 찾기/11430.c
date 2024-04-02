#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    scanf("%d", &n);

    int **graph = (int**)malloc(sizeof(int*)*n);
    for (int i = 0; i < n; i++)
        graph[i] = (int*)malloc(sizeof(int)*n);
    
    for (int i = 0; i < n; i++)
        for (int k = 0; k < n; k++)
            scanf("%d", &graph[i][k]);

    for (int i = 0; i < n; i++) // 경유하는 노드
        for (int k = 0; k < n; k++) // 출발 노드
            for (int j = 0; j < n; j++) // 도착 노드 
                if(graph[k][j] == 1 || graph[k][i] + graph[i][j] == 2)
                    graph[k][j] = 1;

    for (int i = 0; i < n; i++){
        for (int k = 0; k < n; k++)
            printf("%d ", graph[i][k]);
        printf("\n");
    }

    for (int i = 0; i < n; i++)
        free(graph[i]);
    free(graph);

    return 0;
}