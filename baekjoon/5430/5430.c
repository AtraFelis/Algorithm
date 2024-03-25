#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

void reverse(int *arr, int *len);
bool delete(int *arr, int *len);

int main() {
    int t;

    scanf("%d", &t);
    getchar(); // 엔터 제거

    int *arr;

    for (int i = 0; i < t; i++)
    {
        bool error_check = false;
        char command[100000];
        
        gets(command);

        int n;
        scanf("%d", &n);
        getchar(); // 엔터 제거
        arr = (int*)malloc(sizeof(int)*n);
        
        getchar(); // '[' 제거
        for (int k = 0; k < n; k++)
        {
            scanf("%d", &arr[k]);
            getchar(); // 컴마 제거
        }
        getchar(); // ']' 제거

        for (int k = 0; k < strlen(command); k++)
        {
            switch (command[k])
            //RR : 변화 없음
            //RD : 맨 마지막 없애고 R -> 연산 더 빠름
            {
            case 'R':                
                reverse(arr, &n);
                break;
            
            case 'D':
                error_check = !(delete(arr, &n));
                break;
            }

            if(error_check) break;
        }

        if(error_check)
            printf("error\n");
        else {
            printf("[");
            for (int i = 0; i < n-1; i++)
                printf("%d,", arr[i]);
            printf("%d]\n", arr[n-1]);
        }

        free(arr);
    }
    
    return 0;
}

void reverse(int *arr, int *len) {
    int tmp;
    int idx = *len-1;
    for (int i = 0; i < *len / 2; i++) {
        tmp = arr[i];
        arr[i] = arr[idx];
        arr[idx--] = tmp;
    }
}

bool delete(int *arr, int *len) {
    if(*len != 0) {
        for (int i = 1; i < *len; i++)
            arr[i-1] = arr[i];
        (*len)--;

        return true;
    }

    return false;
}