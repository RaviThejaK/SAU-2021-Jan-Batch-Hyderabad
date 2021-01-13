const intArray = [1, 2, 3, 4, 5, 6];

function CustomReduce(arr, fun, initialValue) {

    var acc = 0;
    for (var i = initialValue; i < arr.length; i++) {
        result = fun(acc, arr[i]);
        acc += arr[i];
    }
    return result;
}

var answer = CustomReduce(intArray, (acc, val) => {
    console.log(acc);
    console.log(val);
    return acc + val
}, 0);

console.log(answer);

//const intArray = [1, 2, 3, 4, 5, 6];

var checkans = intArray.reduce((acc1, val1) => {
    console.log(acc1);
    console.log(val1);
    return acc1 + val1;

}, 0);

console.log(checkans);
