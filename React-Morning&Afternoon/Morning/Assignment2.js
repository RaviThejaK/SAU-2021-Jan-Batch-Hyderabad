
var arr = { a: 1, b: 2 };
console.log(arr);
const clonearr = { ...arr };
console.log(clonearr);

clonearr.c = 3;

console.log(arr);
console.log(clonearr);


