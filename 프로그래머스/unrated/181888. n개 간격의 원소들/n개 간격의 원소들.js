function solution(num_list, n) {
    let countNumber = Math.ceil(num_list.length/n);
    let result = [];
    for ( i=0; i<countNumber; i++) {
        result.push(num_list[n*i]);
    }
    
    return result;
}