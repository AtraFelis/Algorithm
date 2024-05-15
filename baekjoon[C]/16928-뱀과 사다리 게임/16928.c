#include <stdio.h>
#include <stdbool.h>

void BFS();

int map[101];
int ladder_snake[101];

int main() {   
    int n, m;
    scanf("%d %d", &n, &m);

    for (int i = 1; i < 101; i++)
        ladder_snake[i] = i;

    for (int i = 0; i < n + m; i++)
    {
        int depart, dest; // 출발 노드, 도착 노드
        scanf("%d %d", &depart, &dest);

        ladder_snake[depart] = dest;
        //1차원 배열을 자바의 map, 파이썬의 딕셔너리처럼 사용  
    }
    
    BFS();

    return 0;
}

void BFS() {
    int queue[100000];
    int front = 0, rear = 0;
    
    bool visit[101];

    queue[rear++] = 1;

    while(front != rear) {
        int current_pos = queue[front++];

        if(current_pos == 100){
            printf("%d", map[100]);
            return;
        }

        for(int i=1; i<7; i++) { // 주사위
            int next_pos = current_pos + i;
            if(next_pos > 100)
                continue;
    
            if(visit[ladder_snake[next_pos]] || visit[next_pos])
                continue;

            visit[next_pos] = visit[ladder_snake[next_pos]] = true;
            
            map[ladder_snake[next_pos]] = map[current_pos] + 1;
            queue[rear++] = ladder_snake[next_pos];
        }
    }
}