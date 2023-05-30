function solution(num_list) {
    const resultArray = num_list.sort((a,b) => a-b);
    const length = resultArray.length
    const result = resultArray.splice(0, 5)
    return resultArray;
}