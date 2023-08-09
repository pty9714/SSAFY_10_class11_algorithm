function solution(book_time) {
    
    function compareTimes(time1, time2) {
        const [hour1, minute1] = time1.split(":").map(Number);
        const [hour2, minute2] = time2.split(":").map(Number);
        return hour1 * 60 + minute1 - (hour2 * 60 + minute2);
    }

    book_time.sort((a, b) => compareTimes(a[0], b[0]));
    let rooms = [];
    
    for (const book of book_time) {
        let reserved = false;
        
        // 퇴실 시간 + 청소 시간 계산
        let [hour, minute] = book[1].split(":").map(Number);
        if (minute >= 50) {
            minute -= 50;
            if (hour >= 23) {
                hour = 0;
            } else {
                hour += 1;
            }
        }
        else {
            minute += 10;
        }
        let time = [hour.toString().padStart(2, "0"), minute.toString().padStart(2, "0")].join(":");
        
        // 방 중에 쓸 수 있는 방이 있으면 예약 가능한 시간 업데이트
        for (let i=0; i<rooms.length; i++) {
            if (book[0] >= rooms[i]) {
                rooms[i] = time;
                reserved = true;
                break;
            }
        }
        // 없으면 새로운 방에 추가
        if (!reserved) {
            rooms.push(time);
        }
    }
    return rooms.length;
}
