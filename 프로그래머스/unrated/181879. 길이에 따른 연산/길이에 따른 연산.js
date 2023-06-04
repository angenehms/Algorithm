function solution(num_list) {
    let plus = 0;
    let multi = 1;

    if ( num_list.length >= 11 ) {
        num_list.forEach((item) => {
            plus += item;
        })
        return plus;
    } else if ( num_list.length <= 10 ) {
        num_list.forEach((item) => {
            multi *= item;
        })
        return multi;
    }
    
    
}