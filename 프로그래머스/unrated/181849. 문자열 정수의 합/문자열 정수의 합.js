function solution(num_str) {
    let array = [...num_str];
    let result = 0;
    
    array.forEach((item ) => {
        result += parseInt(item);
    })
    
    return result;
}