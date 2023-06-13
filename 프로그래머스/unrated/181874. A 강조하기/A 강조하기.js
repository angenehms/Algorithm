function solution(myString) {
    let array = [...myString];
    let result = [];
    
    array.forEach((item) => {
        if ( item === "a" || item === "A") {
            result.push("A");
        } else {
            result.push(item.toLowerCase());
        }
    })
    
    return result.join("");
}