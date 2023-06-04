function solution(num_list) {
    let array = [];
    
    num_list.forEach((item) => {
        if ( item < 0 ) {
            array.push(item);
        }
    })
    
    return num_list.indexOf(array[0]);
}