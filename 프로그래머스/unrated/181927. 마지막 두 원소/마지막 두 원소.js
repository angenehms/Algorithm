function solution(num_list) {
    
    let indexOfLastElement = num_list[num_list.length - 1];
    let preLastElement = num_list[num_list.length - 2];
    
    if ( indexOfLastElement > preLastElement ) {
        num_list.push(indexOfLastElement-preLastElement);
    } else {
        num_list.push(indexOfLastElement*2);
    }
    
    return num_list;
}