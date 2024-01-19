function solution(a, b) {
    const gap = Math.abs(a-b) + 1;
    let result = 0;
    
    for ( let i=0; i<gap; i++ ) {
        if ( a >= b) {
            result += b
            b++
        } else {
            result += a
            a++
        }
    }

    return result
}
