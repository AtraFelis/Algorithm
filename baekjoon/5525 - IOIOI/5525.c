#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    char *str = (char*)malloc(sizeof(char)*m);
    scanf("%s", str);

    int cnt = 0;
    int answer = 0;
    for (int i = 0; i < m; i++) {
        cnt++;
        if(str[i] == 'I'){
            int p = 0;
            for (int k = 1; ; k+=2) {
                cnt++;
                if(!(str[i+k]=='O' && str[i+k+1]=='I')){
                    i += k-1;
                    break;
                }
                p++;
            }
            if(p >= n) // 조건 없으면 p-n+1이 음수가 되어버리는 경우가 발생함.
                answer += p-n+1;
        }
    }
    
    printf("%d", cnt);

    free(str);
    return 0;
}