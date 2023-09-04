function solution(prices) {
    
    const result = [];
    // let count = 0;
    
    for ( let i=0; i<prices.length; i++ ) {
        
        let count = 0;
        
        for ( let j = i+1; j<prices.length; j++ ) {
            
            // let count = 0;
            
            if ( prices[i] <= prices[j] ) {
                count++;
            } else {
                count++;
                break;
            }
            
            // console.log(result, count, i)
            
        }   
        
        result.push(count);

    }
    
    return result;
    
}