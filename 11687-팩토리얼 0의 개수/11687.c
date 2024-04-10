#include <stdio.h>

int main() {
    /*
    1. 팩토리얼의 해에 포함된 0의 개수는 곱셈식에 포함된 5의 개수와 같다.
    2. 25, 50 등등 5가 두 개 이상 포함된 수를 잘 처리해야한다.
    3. 만약 27! 이라면, 27/5 = 5, 5/5 = 1 따라서 5 + 1 = 6개가 된다.
        27/5의 해 -> 5의 배수의 개수
        27/25의 해 -> 25의 배수의 개수, 즉 27//5//5 의 해 -> 25의 배수의 개수     
    4. 주어지는 0의 개수는 최대 10억이므로, 그냥 반복문을 이용하면 반드시 시간 초과가 일어난다. 따라서, 이진 탐색을 이용한다.
    */

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