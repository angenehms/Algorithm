function solution(numbers) {
    
    const positive = [];
    const negative = [];
    
    // 양수는 양수끼리, 음수는 음수끼리 분리
    numbers.forEach(i => {
        if ( i >= 0 ) {
            positive.push(i)
        } else {
            negative.push(i)
        }
    })
    
    // 절대값이 큰 순서대로 내림차순 정렬
    positive.sort((a,b) => b-a);
    negative.sort((a,b) => a-b);
    
    const positCan = positive[0] !== undefined && positive[1] !== undefined
    const negatCan = negative[0] !== undefined && negative[1] !== undefined
    
    if ( positCan && negatCan ) {
        return Math.max(positive[0]*positive[1], negative[0]*negative[1])
    } else if ( !positCan && negatCan ) {
        return negative[0]*negative[1]
    } else if ( !negatCan && positCan) {
        return positive[0]*positive[1]
    } else {
        return positive[0]*negative[0]
    }
}