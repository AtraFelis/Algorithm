//[백준] 5430 - AC
// Gold V

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
    int t;

    scanf("%d", &t);

    for (int i = 0; i < t; i++)
    {
        bool error_check = false;
        char command[100001];
        
        while(getchar() != '\n'); // 버퍼 제거
        gets(command);

        int n;
        scanf("%d", &n);
        getchar(); // 엔터 제거

        int arr[100001];

        int k=0;
        while(getchar() != ']' && n != 0)
            scanf("%d", &arr[k++]);
        
        if(k != n) error_check = true;

        bool reverse = false;
        int front = 0, rear = n;

        int len = strlen(command);
        for (int k = 0; k < len; k++)
        {
            if(command[k] == 'R')
                reverse = !reverse;
            else { // command[i] == 'D'
                if(front == rear) {
                    error_check = true;
                    break;
                }                
                if(reverse) {    
                    rear--;
                } else {
                    front++;
                }
            }
        }

        if(error_check)
            printf("error\n");
        else {
            if(reverse){
                printf("[");
                for (int j = rear-1; j > front; j--)
                    printf("%d,", arr[j]);
                if(front < rear)
                    printf("%d", arr[front]);
                printf("]\n");
            }
            else {
                printf("[");
                for (int j = front; j < rear-1; j++)
                    printf("%d,", arr[j]);
                if(front < rear)
                    printf("%d", arr[rear-1]);
                printf("]\n");
            }
        }
    }
    
    return 0;
}