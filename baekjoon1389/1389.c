#include <stdio.h>
#include <stdlib.h>

#define INF 100 // 사람의 수(n)의 최대가 100이므로, 100 이상의 값이 나올 수 없음.

int min(int a, int b) {
    return a < b ? a : b;
}

int main(){
    int n, m;
    scanf("%d %d", &n, &m);

    int **graph;
    graph = (int**)malloc(sizeof(int*)*(n+1));
    for (int i = 0; i < n+1; i++)
        graph[i] = (int*)malloc(sizeof(int)*(n+1));
    //n*n 인접행렬 그래프 생성

    for (int i = 1; i < n+1; i++){
        for (int j = 1; j < n+1; j++)
            graph[i][j] = INF;
        graph[i][i] = 0;
        graph[0][i] = 0; // 0번 요소는 모든 가중치를 합하여 답을 구하기 용도로 활용하기 위해 0으로 초기화.
    }

    for (int i = 0; i < m; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a][b] = graph[b][a] = 1;
    } // 간선의 가중치가 모두 1인 가중치 그래프

    //Floyd-Warshall
    for (int node = 1; node < n+1; node++){
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < n+1; j++){
                graph[i][j] = min(graph[i][j], graph[i][node] + graph[node][j]);
                if (node == n && graph[i][j] < INF)
                    graph[0][i] += graph[i][j];
            }        
        }
    }
    
    int answer = 1;
    for (int i = 2; i < n+1; i++) {
        if(graph[0][answer] > graph[0][i])
            answer = i;
    }

    printf("%d", answer);

    return 0;
}

