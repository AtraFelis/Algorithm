#include <stdio.h>
#include <stdlib.h>

void backtracking(int, int);
int dist;

int n;
char mbti[100000][4];

int main() {
    int t;
    scanf("%d", &t);
    

    for (int i = 0; i < t; i++) {
        scanf("%d", &n);        
        getchar();

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < 4; j++)
                mbti[k][j] = getchar();
            getchar();
        }

        if(n >= 33){
            printf("0\n");
            continue;
        }

        dist = __INT_MAX__;
        backtracking(0, 0);
        printf("%d\n", dist);
    }

    return 0;    
}

int tmp[3];
void backtracking(int cnt, int start) {
    if(cnt == 3){
        int sum = 0;
        for (int  i = 0; i < 4; i++) {
            if (mbti[tmp[0]][i] != mbti[tmp[1]][i])
                sum++;
            if (mbti[tmp[1]][i] != mbti[tmp[2]][i])
                sum++;
            if (mbti[tmp[0]][i] != mbti[tmp[2]][i])
                sum++;
        }        

        dist = dist < sum ? dist : sum;
        return;
    }

    for (int i = 0; i < n; i++) {
        if(start <= i){
            tmp[cnt] = i;
            backtracking(cnt + 1, i+1);
       }
    }
}