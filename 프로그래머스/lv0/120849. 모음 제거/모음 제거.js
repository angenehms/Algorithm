function solution(my_string) {
    let arr = [...my_string];
    let answerArray = [];
    const vowelArray = ["a", "e", "i", "o", "u"];
    arr.forEach((item) => {
        if ( !vowelArray.includes(item) ) {
            answerArray.push(item);
        }
    })
    return answerArray.join("");
}