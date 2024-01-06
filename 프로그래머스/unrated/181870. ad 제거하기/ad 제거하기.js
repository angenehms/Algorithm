function solution(strArr) {
    
    const result = [];
    
    strArr.forEach((item) => {
        if ( !item.includes("ad") ) {
            result.push(item);
        }
    })
    
    return result;
    
}