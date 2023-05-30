function solution(my_string) {
    const arr = [...my_string];
    let answerArray = [];
    
    arr.forEach((item) => {
        answerArray.unshift(item);
    });
    
    return answerArray.join("");
}