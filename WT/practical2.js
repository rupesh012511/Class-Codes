// e. Create a Promise that resolves after 2 seconds with a success message.
// f. Rejects if a condition fails.
// g. Consume the Promise using then() and catch().
// h. Display appropriate success or error messages.

// Function to create a Promise that checks a condition and resolves/rejects after 2 seconds
function checkCondition(condition) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (condition) {
                resolve("Success: The condition is true!");
            } else {
                reject(new Error("Error: The condition failed!"));
            }
        }, 2000); // Resolves after 2 seconds
    });
}

// Example usage:
// g. Consume the Promise using then() and catch().
// h. Display appropriate success or error messages.
checkCondition(true)
    .then((message) => {
        console.log(message); // Success message
    })
    .catch((error) => {
        console.error(error.message); // Error message
    });

// Another example with false condition
checkCondition(false)
    .then((message) => {
        console.log(message);
    })
    .catch((error) => {
        console.error(error.message);
    });
