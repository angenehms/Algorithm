function solution(arr, delete_list) {
    const result = arr.filter(i => !delete_list.includes(i) )
    return result
}