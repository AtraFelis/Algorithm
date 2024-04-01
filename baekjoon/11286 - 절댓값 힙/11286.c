//11286 절댓값 힙

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> // Boolean 자료형이 정의된 헤더파일

#define MAX 100001

typedef struct minAbsHeap {
    int size;
    int arr[MAX];
} minAbsHeap;

void init(minAbsHeap *h);
bool isEmpty(minAbsHeap *h);
void push(minAbsHeap *h,int value);
int pop(minAbsHeap *h);

int main() {
    minAbsHeap* heap = (minAbsHeap*)malloc(sizeof(minAbsHeap));
    init(heap);

    int answer[MAX], size = 0;

    int n;
    scanf("%d",&n);

    int input;
    for (int i = 0; i < n; i++) {
        scanf("%d", &input);
        if(input == 0){
            if(isEmpty(heap))
                answer[size++] = 0;
            else
                answer[size++] = pop(heap);
        }
        else
            push(heap, input);
    }

    for (int i = 0; i < size; i++)
        printf("%d\n", answer[i]);
    
    free(heap);
    return 0;
}

void init(minAbsHeap *h){
    h->size = 0;
}

bool isEmpty(minAbsHeap *h){
    if(h->size == 0)
        return true;
    return false;
}

void push(minAbsHeap *h, int value) {
    int i = ++h->size;
    
    int tmp = value < 0 ? value * -1 : value;
    int tmp2 =  h->arr[i/2] < 0 ? h->arr[i/2] * -1 : h->arr[i/2];

    while( i != 1 && tmp <= tmp2 ) {
        if(tmp == tmp2 && value > h->arr[i/2])
            break;
        h->arr[i] = h->arr[i/2];
        i /= 2;
        tmp2 =  h->arr[i/2] < 0 ? h->arr[i/2] * -1 : h->arr[i/2];
    }

    h->arr[i] = value;
}

int pop(minAbsHeap *h) {
    int value = h->arr[1];
    h->arr[1] = h->arr[h->size--];
    
    int parent = 1, child = 2;

    while(true){
        if(child > h->size)
            break;

        
        if(child < h->size){
            int left_child = h->arr[child] < 0 ? h->arr[child]  * -1 : h->arr[child] ;
            int right_chid = h->arr[child+1] < 0 ? h->arr[child+1] * -1 : h->arr[child+1];

            if(left_child > right_chid)
                child++;
            else if(left_child == right_chid && h->arr[child] > h->arr[child+1])
                child++;
        }
        // 왼쪽과 오른쪽 자식 노드 중 작은 것 찾는 조건문
        // child가 size와 크기가 같으면 오른쪽 자식 노드가 존재하지 않는 것이므로 무시해야 함.

        
        int parent_value = h->arr[parent] < 0 ? h->arr[parent] * -1 : h->arr[parent];
        int child_value = h->arr[child] < 0 ? h->arr[child] * -1 : h->arr[child];
        
        if(parent_value < child_value) 
            break;
        // ex) abs(-1) == 1이면 
        else if(parent_value == child_value && h->arr[parent] <= h->arr[child])
                break;     
            
        int tmp = h->arr[child];
        h->arr[child] = h->arr[parent];
        h->arr[parent] = tmp;

        parent = child;
        child *= 2;
    }

    return value;
}