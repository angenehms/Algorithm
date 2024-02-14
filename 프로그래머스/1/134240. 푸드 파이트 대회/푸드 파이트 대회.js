function solution(food) {
    
    let former = "";
    let latter = "";
    
    for (let i=1; i<=food.length; i++ ) {
        if ( food[i]%2 === 0 ) { // 원소가 짝수
            for (let j=0; j<food[i]/2; j++) {
                former = former + String(i);
            }
        } else if ( food[i]%2 !== 0 && food[i]-1 !== 0) { // 원소가 홀수
            for (let j=0; j<(food[i]-1)/2; j++) {
                former = former + String(i);
            }
        }
        
    }
    
    latter = former.split('').reverse().join('');
    return former + "0" + latter
}