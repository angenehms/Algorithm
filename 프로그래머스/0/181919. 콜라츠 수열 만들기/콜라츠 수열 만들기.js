function solution(n) {
    const result = [];
    
    while ( n !== 1 ) {
        result.push(n)
        n%2 === 0 ? n = n/2 : n = 3*n +1
    }
    
    result.push(1)
    
    return result
}