//11279 최대 힙

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> // Boolean 자료형이 정의된 헤더파일

#define MAX 100001

typedef struct max_heap {
    int size;
    int arr[MAX];
} max_heap;

void init(max_heap *h);
bool isEmpty(max_heap *h);
void push(max_heap *h,int value);
int pop(max_heap *h);

int main() {
    max_heap* heap = (max_heap*)malloc(sizeof(max_heap));
    init(heap);

    int answer[MAX], size = 0;

    int n;
    scanf("%d",&n);

    int input;
    for (int i = 0; i < n; i++)
    {
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

void init(max_heap *h){
    h->size = 0;
}

bool isEmpty(max_heap *h){
    if(h->size == 0)
        return true;
    return false;
}

void push(max_heap *h, int value) {
    int i = ++h->size;

    while( (i!=1) && value > h->arr[i/2] ){
        h->arr[i] = h->arr[i/2];
        i /= 2;
    }

    h->arr[i] = value;
}

int pop(max_heap *h) {
    int value = h->arr[1];
    h->arr[1] = h->arr[h->size--];
    
    int parent = 1, child = 2;

    while(true){
        if(child > h->size)
            break;
        if((h->arr[child] < h->arr[child+1]) && child < h->size)
        // child가 size와 크기가 같으면 오른쪽 자식 노드가 존재하지 않는 것이므로 무시해야 함.
            child++;
        
        if(h->arr[parent] >= h->arr[child]) break;

        int tmp = h->arr[child];
        h->arr[child] = h->arr[parent];
        h->arr[parent] = tmp;

        parent = child;
        child *= 2;
    }

    return value;
}