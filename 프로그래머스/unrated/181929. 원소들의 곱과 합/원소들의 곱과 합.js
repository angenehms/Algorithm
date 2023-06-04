function solution(num_list) {
    let mul = 1;
    let squ = 0;
    
    num_list.forEach((item) => {
        mul *= item;
    });
    
    num_list.forEach((item) => {
        squ += item;
    })
    
    if ( mul < squ**2 ) {
        return 1;
    } else {
        return 0;
    }
}