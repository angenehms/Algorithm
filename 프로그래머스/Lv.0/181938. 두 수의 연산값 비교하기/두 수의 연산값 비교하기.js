function solution(a, b) {
    
    const cal = parseInt(a.toString() + b.toString());
    const cal2 = 2*a*b
    
    if ( cal >= cal2) {
        return cal
    } else {
        return cal2
    }
        
}