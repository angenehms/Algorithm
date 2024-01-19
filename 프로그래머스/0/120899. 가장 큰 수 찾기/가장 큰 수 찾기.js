function solution(array) {
    const copy = [...array];
    copy.sort((a,b)=>b-a)
    return [copy[0], array.indexOf(copy[0])]
}