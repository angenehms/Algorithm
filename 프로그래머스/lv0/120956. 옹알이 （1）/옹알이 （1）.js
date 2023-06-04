function solution(babbling) {
    
    let result = 0;
    
    for ( i=0; i<babbling.length; i++) {
        
        let copyIndex = babbling[i];
        console.log("포문", i, copyIndex);
        
        for (j=0; j<7; j++) {
            console.log("j순회번째", j);
            if ( copyIndex.substr(0,3) === "aya" || copyIndex.substr(0,3) === "woo" ) {
                copyIndex = copyIndex.substr(3);
                console.log(3, copyIndex);
            } else if ( copyIndex.substr(0,2) === "ye" || copyIndex.substr(0,2) === "ma" ) {
                copyIndex = copyIndex.substr(2);
                console.log(2, copyIndex);
            } else if ( copyIndex === "" ) {
                result += 1;
                console.log("result + 하는곳", 0);
                break;
            } else {
                break;
            }
        }
    }
    
    return result;
}