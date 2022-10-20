// 문제 설명
// 정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// 0 < n ≤ 1000

// 풀이 (1)
function solution(n) {
    let array = [];
    let answer = 0;
    for (i=1; i<n+1; i++) {
        array.push(i);
    }
    for (i=0; i<=Math.floor((n-2)/2); i++) {
        answer = answer + array[2*i+1];
    }
    return answer
}

// 풀이 (2)
function solution(n) {
    let sum = 0;
    while(n) {
        if (n % 2 == 0) {
            sum += n;
        }
        n--;
    }
    
    return sum;
}

// 풀이 (3)
function solution(n) {
    return Math.floor(n/2)*(Math.floor(n/2)+1);
} // 시그마 공식활용

