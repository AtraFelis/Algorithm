public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cmd = {"next","prev"};

        System.out.println(solution.solution(
                "34:33","13:00","00:55","02:55", cmd));
    }
}

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        String[] tmp = op_start.split(":");
        int start = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);

        tmp = op_end.split(":");
        int end = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);

        tmp = video_len.split(":");
        int len = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);

        tmp = pos.split(":");
        int int_pos = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);


        for (String command : commands) {
            if (int_pos >= start && int_pos <= end) int_pos = end;

            switch (command) {
                case "next":
                    int_pos += 10;
                    if (int_pos >= len) int_pos = len;
                    break;
                case "prev":
                    int_pos -= 10;
                    if (int_pos <= 0) int_pos = 0;
                    break;
            }
        }

        if (int_pos >= start && int_pos <= end) int_pos = end;

        return String.format("%02d:%02d", int_pos / 60, int_pos % 60);
    }
}