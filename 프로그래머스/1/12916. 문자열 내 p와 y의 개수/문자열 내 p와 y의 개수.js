function solution(s){
    const arrayP = [];
    const arrayY = [];
    const toArray = [...s];
    toArray.forEach(i => {
        if ( i === "p" || i === "P" ) {
            arrayP.push(i)
        } else if ( i === "y" || i === "Y" ) {
            arrayY.push(i)
        }
    })
    
    return arrayP.length === arrayY.length ? true : false

}