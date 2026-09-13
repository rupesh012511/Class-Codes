import 'dart:io';

void main() {
  List<String> tasks = [];

  while (true) {
    print('\nTodo List Menu:');
    print('1. Add Task');
    print('2. Remove Task');
    print('3. View Tasks');
    print('4. Exit');
    print('Enter your choice:');

    String? choice = stdin.readLineSync();

    switch (choice) {
      case '1':
        addTask(tasks);
        break;
      case '2':
        removeTask(tasks);
        break;
      case '3':
        viewTasks(tasks);
        break;
      case '4':
        print('Exiting...');
        return;
      default:
        print('Invalid choice. Please try again.');
    }
  }
}

void addTask(List<String> tasks) {
  print('Enter the task to add:');
  String? task = stdin.readLineSync();
  if (task != null && task.isNotEmpty) {
    tasks.add(task);
    print('Task added successfully.');
  } else {
    print('Task cannot be empty.');
  }
}

void removeTask(List<String> tasks) {
  if (tasks.isEmpty) {
    print('No tasks to remove.');
    return;
  }

  viewTasks(tasks);
  print('Enter the task number to remove:');
  String? input = stdin.readLineSync();
  int? index = int.tryParse(input ?? '');

  if (index != null && index > 0 && index <= tasks.length) {
    String removedTask = tasks.removeAt(index - 1);
    print('Removed task: $removedTask');
  } else {
    print('Invalid task number.');
  }
}

void viewTasks(List<String> tasks) {
  if (tasks.isEmpty) {
    print('No tasks in the list.');
    return;
  }

  print('Your Tasks:');
  for (int i = 0; i < tasks.length; i++) {
    print('${i + 1}. ${tasks[i]}');
  }
}
