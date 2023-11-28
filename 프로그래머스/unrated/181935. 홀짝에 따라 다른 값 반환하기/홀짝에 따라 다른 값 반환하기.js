function solution(n) {
    
    if (n%2 === 1) {
        const times = n/2;
        let result = 0;
        for ( let i=0; i < times; i++ ) {
            result = result + ( 2*i + 1 );
        }
        return result;
        
    } else {
        const times = n/2;
        let result = 0;
        for ( let i=1; i <= times; i++ ) {
            result = result + ( 2*i ) ** 2;
        }
        return result;
    }
}