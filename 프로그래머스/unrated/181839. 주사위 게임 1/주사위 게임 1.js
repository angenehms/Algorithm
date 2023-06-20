function solution(a, b) {
    const bothOdd = a%2 === 1 && b%2 === 1;
    const oneOdd = ( a%2 === 1 && b%2 === 0 ) || ( a%2 === 0 && b%2 === 1 );
    const bothEven = a%2 === 0 && b%2 === 0;
    
    if ( bothOdd ) {
        return (a**2) + (b**2);
    } else if ( oneOdd ) {
        return 2*(a+b);
    } else if ( bothEven ) {
        return Math.abs(a-b);
    }
}