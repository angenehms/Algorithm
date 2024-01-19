function solution(A,B){
    // 하나는 오름차순 정렬, 하나는 내림차순 정렬
    const a = A.sort((a,b) => b-a);
    const b = B.sort((a,b) => a-b);
    let result = 0;
    
    for ( let i=0; i<A.length; i++ ) {
        result += a[i]*b[i]
    }
    
    return result
}