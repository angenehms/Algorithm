function solution(my_string) {
    const resultArray = []
    const toArray = [...my_string]
    toArray.forEach((i) => {
        if ( i === i.toUpperCase() ) {
            resultArray.push(i.toLowerCase())
        } else {
            resultArray.push(i.toUpperCase())
        }
    })
    
    return resultArray.join("")
}