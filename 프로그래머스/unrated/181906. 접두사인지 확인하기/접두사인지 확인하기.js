function solution(my_string, is_prefix) {
    let lengthOfPrefix = is_prefix.length;
    let array = [...my_string];
    if ( array.splice(0,lengthOfPrefix).join("") === is_prefix ) {
        return 1;
    } else {
        return 0;
    }
}