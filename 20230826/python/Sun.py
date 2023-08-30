def convert(time):
    h,m,s = time.split(":")
    return int(h)*60*60 + int(m) * 60 + int(s)

def solution(play_time, adv_time, logs):
    playSec = convert(play_time)
    advSec = convert(adv_time)

    totalSec = [0 for _ in range(playSec+1)]
    for log in logs:
        slog, elog = log.split("-")
        start = convert(slog)
        end = convert(elog)
        totalSec[start] += 1
        totalSec[end] -= 1

    for i in range(1,playSec):
        totalSec[i] += totalSec[i-1]
    
    currSum = sum(totalSec[:advSec])

    maxSum = currSum
    maxIdx = 0
    for i in range(advSec,playSec):
        currSum = currSum + totalSec[i] - totalSec[i-advSec]
        if currSum>maxSum:
            maxSum = currSum
            maxIdx = i - advSec + 1

    answer = '%02d:%02d:%02d' %(maxIdx/3600, maxIdx/60%60, maxIdx %60)
    return answer

p = "02:03:55"
a = "00:14:15"
l = ["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]
print(solution(p,a,l))
