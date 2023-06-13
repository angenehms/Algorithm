function solution(myString, pat) {
    let array = [...myString];
    let resultArray = [];
    
    array.forEach((item) => {
        if ( item === "A" ) {
            resultArray.push("B");
        } else if ( item === "B" ) {
            resultArray.push("A");
        }
    })
    
    let resultString = resultArray.join("");
    
    if ( resultString.includes(pat) ) {
        return 1;
    } else {
        return 0;
    }
    
}