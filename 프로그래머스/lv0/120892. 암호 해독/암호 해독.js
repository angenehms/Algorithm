function solution(cipher, code) {
    let array = [...cipher];
    let empty = [];
    
    let countNumber = Math.floor(array.length/code);
    
    for ( i=1; i<=countNumber; i++) {
        empty.push(array[(code*i)-1]);
    }
    
    return empty.join("");
}