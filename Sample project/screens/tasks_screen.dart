import 'package:flutter/material.dart';

class TasksScreen extends StatefulWidget {
  @override
  _TasksScreenState createState() => _TasksScreenState();
}

class _TasksScreenState extends State<TasksScreen> {
  List<Map<String, dynamic>> tasks = [
    {
      "title": "Study DSA",
      "desc": "Binary Search",
      "date": "20 Apr",
      "done": false
    }
  ];

  void toggleTask(int index) {
    setState(() {
      tasks[index]['done'] = !tasks[index]['done'];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.builder(
        itemCount: tasks.length,
        itemBuilder: (context, index) {
          return Card(
            child: ListTile(
              title: Text(tasks[index]['title']),
              subtitle: Text(tasks[index]['desc']),
              trailing: Icon(
                tasks[index]['done']
                    ? Icons.check_circle
                    : Icons.circle_outlined,
                color: tasks[index]['done'] ? Colors.green : null,
              ),
              onTap: () => toggleTask(index),
            ),
          );
        },
      ),

      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          Navigator.pushNamed(context, '/addTask');
        },
      ),
    );
  }
}