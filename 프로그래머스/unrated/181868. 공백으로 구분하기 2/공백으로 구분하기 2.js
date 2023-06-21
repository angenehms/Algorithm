function solution(my_string) {
    const split = my_string.split(" ");
    const result = [];
    
    split.forEach((item) => {
        if ( item !== "" ) {
            result.push(item)
        }
    })
    
    
    return result;
}