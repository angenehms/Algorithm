function solution(str_list, ex) {
    
    let array = [];
    
    for ( i=0; i<str_list.length; i++ ) {
        
        if ( !str_list[i].includes(ex) ) {
            
            array.push(str_list[i]);
            
        }
        
    }
    
    return array.join("");
    
}