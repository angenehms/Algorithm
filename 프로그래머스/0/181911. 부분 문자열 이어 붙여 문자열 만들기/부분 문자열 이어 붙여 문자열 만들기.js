function solution(my_strings, parts) {
    
    const resultArray = my_strings.map((v, i) => 
        v.slice(parts[i][0], parts[i][1] + 1)
    )
    
    return resultArray.join("")
}