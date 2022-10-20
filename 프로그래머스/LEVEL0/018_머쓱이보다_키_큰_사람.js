// 문제 설명
// 머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다. 머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.

// 제한사항
// 1 ≤ array의 길이 ≤ 100
// 1 ≤ height ≤ 200
// 1 ≤ array의 원소 ≤ 200

function solution(array, height) {
    let insert = [...array, height];
    // console.log(insert);
    let toLower = insert.sort(function(a, b)  {
    return b - a; // 내림차순 sort 공식 외워서 쓴 것 입니다.
    });
    // console.log(toLower);
    return toLower.indexOf(height);
}

// 다른풀이 인튜이션 (1)
// 순회를 돌면서 height 값과 array 의 요소들의 크기비교를 위한 if 구문 활용해도 될 것 같습니다.