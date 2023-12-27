class Solution {
    class Degree {
        double hDegree;
        double mDegree;
        double sDegree;
        Degree(double hDegree, double mDegree, double sDegree) {
            this.hDegree = hDegree;
            this.mDegree = mDegree;
            this.sDegree = sDegree;
        }
    }
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int c1 = toSeconds(h1, m1, s1);
        int c2 = toSeconds(h2, m2, s2);
        if(c1 == 0 || c1 == 43200) answer++;
        for(int i = c1; i < c2; i++) {
            Degree cur = toDegree(i / 3600, (i % 3600) / 60, (i % 3600) %  60);
            Degree next = toDegree((i + 1) / 3600, ((i + 1) % 3600) / 60, ((i + 1) % 3600) %  60);
            boolean hOverlap = isOverlap(cur.hDegree, cur.sDegree, next.hDegree, next.sDegree);
            boolean mOverlap = isOverlap(cur.mDegree, cur.sDegree, next.mDegree, next.sDegree);
            if(hOverlap && mOverlap) {
                if(next.hDegree == next.mDegree) {
                    answer++;
                }
                else {
                    answer += 2;
                }
            }
            else if(hOverlap || mOverlap) {
                answer++;
            }
        }
    
        return answer;
    }
    
    public int toSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }
    
    public Degree toDegree(int h, int m, int s) {
        double hDegree = 30 * (h % 12) + 0.5 * m + (1/120) * s;
        double mDegree = 6 * m + 0.1 * s;
        double sDegree = 6 * s;
        return new Degree(hDegree, mDegree, sDegree);
    }
    
    public boolean isOverlap(double curDegree1, double curDegree2, double nextDegree1, double nextDegree2) {
        if(curDegree1 > curDegree2 && nextDegree1 <= nextDegree2) {
            return true;
        }
        if(curDegree2 == 354d && curDegree1 > 354d) {
            return true;
        }
        return false;
    }
}
/*
[1초당]
초침 360/60/60 = 6
분침 360/60/60/6 = 0.1
시침 360/12/60/60 = 1/120

[각도]
초침 6s
분침 6m + 0.1s
초침 30*(h % 12) + 0.5m + (1/120)s
*/