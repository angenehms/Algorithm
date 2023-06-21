function solution(a, b) {
    const aString = a.toString();
    const bString = b.toString();
    
    const aFirst = parseInt(aString + bString);
    const bFirst = parseInt(bString + aString);
    
    if ( aFirst >= bFirst) {
        return aFirst; 
    } else {
        return bFirst;
    }
}