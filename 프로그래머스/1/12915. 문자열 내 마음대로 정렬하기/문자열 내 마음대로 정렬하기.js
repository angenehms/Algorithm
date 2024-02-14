function solution(strings, n) {
    
    const result = strings.map(i => i[n] + i).sort();
    return result.map(i => i.substr(1))
}