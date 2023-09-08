function solution(names) {
    
    let times = Math.ceil(names.length/5); // 뽑아야 하는 갯수
    let array = [];
    
    for ( let i=1; i<=times; i++ ) {
        
        let index = 5*(i-1);
        array.push(names[index]); 
        
    }
    
    return array
}