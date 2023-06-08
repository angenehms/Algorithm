function solution(my_string, is_suffix) {
    
    const array = [...my_string];
    
    const lengthOfSuffix = is_suffix.length;
    const lengthOfArray = array.length;
    
    const width = lengthOfArray - lengthOfSuffix;
    const suffix = array.splice(width, lengthOfSuffix).join("")
    
    if ( suffix === is_suffix ) {
        return 1;
    } else {
        return 0;
    }
}