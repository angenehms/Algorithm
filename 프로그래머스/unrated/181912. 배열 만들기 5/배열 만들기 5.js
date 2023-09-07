function solution(intStrs, k, s, l) {
    
    const array = [];
    
    for ( let i=0; i<intStrs.length; i++ ) {
        
        let sliceNumber = parseInt(intStrs[i].substr(s,l));
        
        if ( sliceNumber > k) {
            
            array.push(sliceNumber);
            
        }
        
    }
    
    return array;
    
}