function solution(num_list) {
    
    let oddSum = 0;
    let evenSum = 0;
    
    for ( i=0; i<num_list.length; i++ ) {
        if ( i%2 === 0 ) {
            oddSum += num_list[i];
        } else if ( i%2 === 1 ) {
            evenSum += num_list[i];
        }
    }
    
    if ( oddSum > evenSum ) {
        return oddSum;
    } else if ( oddSum < evenSum ) {
        return evenSum;
    } else if ( oddSum === evenSum ) {
        return oddSum
    }
        
}