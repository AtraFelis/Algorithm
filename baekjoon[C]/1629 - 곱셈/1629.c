#include <stdio.h>

int main() {

    long long a, b, c;
    scanf("%lld %lld %lld", &a, &b, &c);

    a %= c;
    long long answer = 1;    
    for (b; b > 1; b /= 2){
        if(b % 2 == 1)
            answer = (answer * a) % c;
        a = (a * a) % c;
    }
    
    answer = (answer * a) % c;
    printf("%lld", answer);

    return 0;    
}