function solution(my_string, n) {
    let array = [...my_string];
    let lastIndex = array.length - n
    return array.splice(lastIndex).join("");
}