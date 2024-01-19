function solution(n_str) {
    const toArray = [...n_str];
    let indexInfo = 0
    
    for ( let i=0; i<toArray.length; i++ ) {
        if ( parseInt(toArray[i]) !== 0 ) {
            indexInfo = i;
            break
        }
    }
    
    return n_str.slice(indexInfo, n_str.length)
    
}