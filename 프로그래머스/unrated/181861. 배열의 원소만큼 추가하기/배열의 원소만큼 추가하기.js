function solution(arr) {
    const result = [];
    for (i=0; i<arr.length; i++) {
        for (j=0; j<arr[i]; j++) {
            result.push(arr[i]);
        }
    }
    
    return result;
}