import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {       
        long answer;
        
        Arrays.sort(times);
        
        long lo = times[0];
        long hi = (long)times[times.length-1]*n;
        answer = hi;

        while(lo <= hi) {            
            long mid = (hi + lo) / 2;
        
            long cnt = 0;
            for(int time : times) {
                cnt += (mid / time);
            }
            
            if(cnt >= n) {
                answer = Math.min(answer, mid);
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        
        return answer;
    }
}