#include <stdio.h>
#include <stdlib.h>

void makestar(int x, int y, int n);
char star[6561][6561];

int main() {
    int n;
    scanf("%d", &n);
    
    for (int i = 0; i < n; i++)
        for (int k = 0; k < n; k++)
            star[i][k] = ' ';

    makestar(0, 0, n);

    for (int i = 0; i < n; i++)
    {
        for (int k = 0; k < n; k++)
        {
            printf("%c", star[i][k]);
        }

        printf("\n");
    }    
    
    return 0;
}

void makestar(int x, int y, int n) {

    if(n == 1) {
        star[x][y] = '*';
        return;
    }
    
    int check = 1;
    for (int i = x; i < x+n; i += n/3)
    {
        for (int k = y; k < y+n; k += n/3)
        {
            if(check++ == 5){
                continue;
            }
            
            makestar(i, k, n/3);
        }
        
    }
}