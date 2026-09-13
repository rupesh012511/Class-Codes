// ES6 Script Demonstrating Rest and Spread Operators

// a. Function using rest operator to accept multiple numbers and return their sum
function sum(...numbers) {
    return numbers.reduce((acc, num) => acc + num, 0);
}

console.log("Sum of 1, 2, 3, 4:", sum(1, 2, 3, 4)); // Output: 10

// b. Merge two arrays using the spread operator
let array1 = [1, 2, 3];
let array2 = [4, 5, 6];
let mergedArray = [...array1, ...array2];

console.log("Merged array:", mergedArray); // Output: [1, 2, 3, 4, 5, 6]

// c. Copy and update an object using the spread operator
let originalObject = { name: "John", age: 30 };
let updatedObject = { ...originalObject, city: "New York" };

console.log("Updated object:", updatedObject); // Output: { name: "John", age: 30, city: "New York" }

// d. Demonstrate passing array elements as function arguments using spread
function multiply(a, b, c) {
    return a * b * c;
}

let values = [2, 3, 4];
let product = multiply(...values);

console.log("Product of array elements:", product); // Output: 24
