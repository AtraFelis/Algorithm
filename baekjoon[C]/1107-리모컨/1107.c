#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main() {
    int n;
    scanf("%d", &n);

    char num[10];
    sprintf(num, "%d", n);

    int m;
    scanf("%d", &m);

    bool channel[10];
    for (int i = 0; i < 10; i++)
        channel[i] = true;
    
    for (int i = 0; i < m; i++) {
        int tmp;
        scanf("%d", &tmp);
        channel[tmp] = false;
    }

    // case 1 : -, +로만 채널을 움직일 경우
    int answer = n > 100 ? n-100 : 100-n;

    //case 2: 번호로 이동한 후, -+로 움직일 경우
    int len = strlen(num);
    for (int i = 0; i <= 1000000; i++) {
        char tmp[10] = {};
        sprintf(tmp, "%d", i);
        
        int tmplen = strlen(tmp);
        bool can_change = true;
        for (int i = 0; i < tmplen; i++) {
            if(channel[tmp[i] - 48] == false){
            // 옮기고자 하는 채널에 고장난 번호가 있다면
                can_change = false;
                break;
            }
        }

        if(can_change){
            int res = n-i > 0 ? n-i + tmplen : i - n + tmplen;
            answer = answer < res ? answer : res;
        }
    }

    printf("%d", answer);
    
    return 0;
}