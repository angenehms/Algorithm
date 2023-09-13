function solution(myString) {
    
    const slicedArray = myString.split("x");
    const result = [];
    
    slicedArray.forEach((item) => {
        result.push(item.length)
    })
    
    return result;
}