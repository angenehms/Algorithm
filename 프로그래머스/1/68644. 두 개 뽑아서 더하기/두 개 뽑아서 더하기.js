function solution(numbers) {
    
    // const set = new Set(numbers);
    // const setArray =Array.from(set)
    const result = [];
    console.log(numbers)
    
    for (let i=0; i<numbers.length-1; i++) {
        for (let j=i+1; j<numbers.length; j++) {
            console.log(numbers[i], numbers[j])
            result.push(numbers[i]+numbers[j]);  
        }
    }
    
    const set = new Set(result);
    const setArray =Array.from(set);

    return setArray.sort((a,b) => a-b)
  
}