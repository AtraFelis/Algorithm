// [백준] 6054 - 카잉 달력 
// Silver I

#include <stdio.h>

int main() {
    int t;
    scanf("%d", &t);

    int m, n, x, y;
    for (int i = 0; i < t; i++)
    {
        scanf("%d %d %d %d", &m, &n, &x, &y);
        
        int tmp = x%n;
        if(tmp == 0)
            tmp = n;

        int answer = x;
        int check = tmp;

        while(answer <= m*n) {
            if(tmp == y){
                printf("%d\n", answer);
                break;
            }

            tmp = (tmp + m) % n;
            if(tmp == 0)
                tmp = n;

            answer += m;
            
            if(tmp == check) {
                //첫 번째 경우로 돌아온다면 존재하지 않는다는 뜻.
                printf("-1\n");
                break;
            }
        }    
    }

    return 0;
}
