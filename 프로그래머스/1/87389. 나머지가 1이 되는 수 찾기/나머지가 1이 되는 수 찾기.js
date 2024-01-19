function solution(n) {
    let i = 1;
    let result = 0;
    
    while ( true ) {
        if ( n%i === 1 ) {
              result = i  
            break
        }
        i++

    }
    return result
}