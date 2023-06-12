function solution(my_string, alp) {
    let array = [...my_string];
    let resultArray = array.map((item) => {
        if ( item === alp ) {
            return item.toUpperCase();
        } else {
            return item
        }
    })
    
    return resultArray.join("");
}