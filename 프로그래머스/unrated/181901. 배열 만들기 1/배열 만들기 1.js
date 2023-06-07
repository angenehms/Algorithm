function solution(n, k) {
    let result = [];
    
    for ( i=1; i<=Math.floor(n/k); i++ ) {
        result.push(k*i);
    } 
    
    return result;
}