function solution(s) {
    const length = s.length;
    if ( length%2 === 0 ) { // 짝수면
        return s.substr((length/2)-1, 2)
    } else { // 홀수면
        return s[Math.floor(length/2)]
    }
}