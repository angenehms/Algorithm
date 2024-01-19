function solution(num_list, n) {
    const toString = num_list.join("");
    const fommer = toString.substr(0,n)
    const latter = toString.substr(n, num_list.length);
    console.log(fommer)
    console.log(latter)
    return [...(latter+fommer)].map(i => parseInt(i))
    

}