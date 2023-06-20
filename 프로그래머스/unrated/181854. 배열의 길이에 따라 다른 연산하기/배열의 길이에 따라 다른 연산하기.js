function solution(arr, n) {
    
    const result = [];
    const oddLength = ( arr.length%2 === 1 );
    const evenLength = ( arr.length%2 === 0 );
    
    if ( oddLength ) {
        
        for ( i = 0; i < Math.ceil(arr.length/2); i++ ) {
            
            arr[2*i] += n;
            
        }
        
        return arr 
        
    } else if ( evenLength ) {
        
        for ( i=0; i < arr.length/2; i++ ) {
            
            arr[2*i + 1] += n;
            
        }
        
        return arr
        
    }   
    
}