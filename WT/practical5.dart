class Person {
  String _name;
  int _id;

  Person(this._name, this._id);

  // Getters
  String get name => _name;
  int get id => _id;

  // Setters
  set name(String name) => _name = name;
  set id(int id) => _id = id;

  void displayInfo() {
    print('Name: $_name, ID: $_id');
  }
}

class Student extends Person {
  String _grade;

  Student(String name, int id, this._grade) : super(name, id);

  // Getter and setter for grade
  String get grade => _grade;
  set grade(String grade) => _grade = _grade;

  @override
  void displayInfo() {
    super.displayInfo();
    print('Grade: $_grade');
  }
}

class Professor extends Person {
  String _department;

  Professor(String name, int id, this._department) : super(name, id);

  // Getter and setter for department
  String get department => _department;
  set department(String department) => _department = department;

  @override
  void displayInfo() {
    super.displayInfo();
    print('Department: $_department');
  }
}

class Course {
  String _name;
  String _code;
  Professor _professor;

  Course(this._name, this._code, this._professor);

  // Getters
  String get name => _name;
  String get code => _code;
  Professor get professor => _professor;

  // Setters
  set name(String name) => _name = name;
  set code(String code) => _code = code;
  set professor(Professor professor) => _professor = professor;

  void displayInfo() {
    print('Course: $_name ($_code)');
    print('Professor:');
    _professor.displayInfo();
  }
}

// Async function to simulate fetching data from a web source
Future<List<Student>> fetchStudents() async {
  print('Fetching student data...');
  await Future.delayed(Duration(seconds: 2)); // Simulate delay
  // Simulate fetched data
  return [
    Student('Alice', 1, 'A'),
    Student('Bob', 2, 'B'),
    Student('Charlie', 3, 'A'),
  ];
}

void main() async {
  // Create instances
  Professor prof = Professor('Dr. Smith', 101, 'Computer Science');
  Course course = Course('Dart Programming', 'CS101', prof);
  Student student = Student('John', 201, 'A');

  // Display info
  print('Professor Info:');
  prof.displayInfo();
  print('\nCourse Info:');
  course.displayInfo();
  print('\nStudent Info:');
  student.displayInfo();

  // Simulate async data fetching
  print('\n--- Simulating Data Fetch ---');
  List<Student> students = await fetchStudents();
  print('Fetched Students:');
  for (var s in students) {
    s.displayInfo();
    print('---');
  }
}
