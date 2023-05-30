function solution(my_string, index_list) {
    let resultArray = [];
    index_list.forEach((item) => {
        resultArray.push([...my_string][item]);
    })
    return resultArray.join("");
}