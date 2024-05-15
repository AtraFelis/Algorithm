#include <stdio.h>

int main() {

    int m;
    scanf("%d", &m);

    //binary search
    int min, mid, max;

    min = 5 / 5;
    max = 400000015 / 5; // '400000015' : '0' 이 100,000,000이 나오는 값. 즉, 이 문제의 최댓값.
    mid = (min + max) / 2;
    // 탐색을 편하게 하기 위해서 미리 5로 나눈 값을 기준으로 이분 탐색 시작함.

    int zero_cnt = 0;
    while (zero_cnt != -1)
    {

        zero_cnt = mid;
        int tmp = mid;
        for ( ; tmp >= 5; tmp /= 5)
            zero_cnt += tmp / 5;

        if(zero_cnt > m)
        {
            max = mid - 1;
            mid = (min + max) / 2;
        }
        else if ( zero_cnt < m )
        {
            min = mid + 1;
            mid = (min + max) / 2;
        }
        else { // zero_cnt == m
            mid *= 5;
            break;
        }

        if(min > max){
            mid = -1;
            break;
        }
    }

    printf("%d", mid);
    
    return 0;
}