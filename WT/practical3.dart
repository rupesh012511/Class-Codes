import 'dart:io';

void main() {
  print('Hello User');

  print('Simple Calculator');
  print('Enter first number:');
  double? num1 = double.tryParse(stdin.readLineSync() ?? '');

  print('Enter second number:');
  double? num2 = double.tryParse(stdin.readLineSync() ?? '');

  print('Enter operation (+, -, *, /):');
  String? operation = stdin.readLineSync();

  if (num1 == null || num2 == null || operation == null) {
    print('Invalid input');
    return;
  }

  double result;
  switch (operation) {
    case '+':
      result = add(num1, num2);
      break;
    case '-':
      result = subtract(num1, num2);
      break;
    case '*':
      result = multiply(num1, num2);
      break;
    case '/':
      if (num2 == 0) {
        print('Cannot divide by zero');
        return;
      }
      result = divide(num1, num2);
      break;
    default:
      print('Invalid operation');
      return;
  }

  print('Result: $result');
}

double add(double a, double b) => a + b;
double subtract(double a, double b) => a - b;
double multiply(double a, double b) => a * b;
double divide(double a, double b) => a / b;
