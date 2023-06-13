function solution(num_list) {
    let odd = [];
    let even = [];
    
    num_list.forEach((item) => {
        if ( item%2 === 0 ) {
            even.push(item);
        } else {
            odd.push(item);
        }
    })
    
    let oddJoin = odd.join("");
    let evenJoin = even.join("");
    
    return parseInt(oddJoin) + parseInt(evenJoin);
}