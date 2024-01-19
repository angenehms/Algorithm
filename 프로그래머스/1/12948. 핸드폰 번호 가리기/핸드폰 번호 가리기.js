function solution(phone_number) {
    const latter = phone_number.slice(-4);
    const star = phone_number.length - 4;
    let result = ""
    for (let i =0; i<star; i++) {
        result += "*"
    }
    return result+latter
    
}