#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

void DSLR();
int D(int);
int S(int);
int L(int);
int R(int);

int num_q[10000];
char *str_q[10000];

int main() {
    int t;
    scanf("%d", &t);

    for (int i = 0; i < 10000; i++)
        str_q[i] = malloc(sizeof(char)*10001);

    for (int i = 0; i < t; i++)
        DSLR();

    for (int i = 0; i < 10000; i++)
        free(str_q[i]);

    return 0;
}

void DSLR() {
    int A, B;
    scanf("%d %d", &A, &B);

    int front = 0, rear = 0;
    bool visit[10000];

    for (int i = 0; i < 10000; i++)
        visit[i] = false;  

    num_q[rear] = A;
    str_q[rear++][0] = '\0';

    visit[A] = true;
    while(front != rear) {
        int num = num_q[front];

        if(num == B) {
            printf("%s\n", str_q[front]);
            break;
        }     

        int next_num[4] = {D(num), S(num), L(num), R(num)}; 
        char dslr[4] = { 'D', 'S', 'L', 'R' };

        int len = strlen(str_q[front]);

        for (int i = 0; i < 4; i++)
        {
            if(!visit[next_num[i]]){
                visit[next_num[i]] = true;

                num_q[rear] = next_num[i];

                str_q[front][len] = dslr[i];
                str_q[front][len+1] = '\0';
                strcpy(str_q[rear++], str_q[front]);
            }
        }
        front++;
    }
}

int D(int n) {
    return (n * 2) % 10000;
}

int S(int n) {
    return n-1 < 0 ? 9999 : n-1;
}

int L(int n) {
    return (n % 1000) * 10 + (n / 1000);
}

int R(int n) {
    return n / 10 + (n % 10) * 1000;
}