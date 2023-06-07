function solution(myString, pat) {
    let lowerString = myString.toLowerCase();
    let lowerPat = pat.toLowerCase();
    
    if ( lowerString.includes(lowerPat) ) {
        return 1;
    } else {
        return 0;
    }
}