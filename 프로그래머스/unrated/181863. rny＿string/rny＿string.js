function solution(rny_string) {
    let array = [...rny_string];
    
    for (i=0; i<array.length; i++) {
        if ( array[i] === "m" ) {
            array[i] = "rn";
        }
    }
    
    return array.join("");
}