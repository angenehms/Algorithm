function solution(n) {
    let array = [];
    
    for (let i=0; i<Math.ceil(n/2); i++) {
        array.push(2*i+1);
    }
    
    return array;
}