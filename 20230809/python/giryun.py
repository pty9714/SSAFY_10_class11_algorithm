def change(t):
    return int(t[:2]) * 60 + int(t[3:])


def solution(book_time):
    rooms = []
    for s, e in sorted([[change(s), change(e)+10] for s, e in book_time]):
        if not rooms:
            rooms.append(e)
            continue
        for i, end in enumerate(rooms):
            if end <= s:
                rooms[i] = e
                break
        else:
            rooms.append(e)
    return len(rooms)

# 테스트 19 〉	통과 (23.34ms, 10.7MB)