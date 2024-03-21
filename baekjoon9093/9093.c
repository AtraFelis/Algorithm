//백준 9093 단어 뒤집기
// Bronze 1

#include <stdio.h>
#include <string.h>

int main() {
    int t;
    scanf("%d", &t);
    getchar();

    char line[1000];

    for (int i = 0; i < t; i++)
    {
        gets(line);
        int idx = 0;

        for (int k = 0; k < strlen(line) + 1; k++)
        {
            if(line[k] == ' ' || k == strlen(line)){
                for (int j = k-1; j >= idx; j--)
                    printf("%c", line[j]);
                printf(" ");               
                idx = k+1;
            }     
        }

        printf("\n");
    }
    

    return 0;    
}
