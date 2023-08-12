function toTime(time) {
    const [hour, minute] = time.split(":");
    return Number(hour) * 60 + Number(minute);
}

function solution(book_time) {

    // 시작 시간 기준으로 정렬
    book_time.sort((a, b) => toTime(a[0]) - toTime(b[0]));
    
    let rooms = [];
    for (const time of book_time) {
        let reserved = false;
        
        // 퇴실 시간 + 청소 시간 계산
        let [start, end] = [toTime(time[0]), toTime(time[1])+10];
        
        // 방 중에 쓸 수 있는 방이 있으면 예약 가능한 시간 업데이트
        for (let i=0; i<rooms.length; i++) {
            if (start >= rooms[i]) {
                rooms[i] = end;
                reserved = true;
                break;
            }
        }
        // 없으면 새로운 방에 추가
        if (!reserved) {
            rooms.push(end);
        }
    }
    return rooms.length;
}
// 테스트 11 〉	통과 (15.58ms, 37.8MB)
