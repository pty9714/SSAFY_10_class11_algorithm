function solution(maps) {
    
    let answer = [];
    maps = maps.map(v => v.split(''));
    
    function check(maps, [i, j]) {
        let cnt = 0;
        const queue = [[i, j]];
        const direction = [[0, 1], [1, 0], [0, -1], [-1, 0]];
        
        while(queue.length) {
            const [i, j] = queue.pop();
            if(maps[i][j] !== 'X') {
                cnt += parseInt(maps[i][j]);
                maps[i][j] = 'X';

                for (const d of direction) {
                    let x = i+d[0];
                    let y = j+d[1];
                    if (x>=0 && x<maps.length && y>=0 && y<maps[0].length) {
                       if (maps[x, y] !== 'X') {
                        queue.push([x, y]);
                        } 
                    }
                    
                }
            }
        }
        answer.push(cnt);
    }
    
    for (let i=0; i < maps.length; i++) {
        for (let j=0; j < maps[0].length; j++) {
            if (maps[i][j] !== 'X') {
                check(maps, [i, j]);
            }
        }
    }
    
    return answer.length !== 0 ? answer.sort((a,b) => a-b) : [-1];
}
