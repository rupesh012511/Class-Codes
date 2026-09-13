import 'package:flutter/material.dart';

class AddTaskScreen extends StatefulWidget {
  @override
  _AddTaskScreenState createState() => _AddTaskScreenState();
}

class _AddTaskScreenState extends State<AddTaskScreen> {
  final titleController = TextEditingController();
  final descController = TextEditingController();
  DateTime? selectedDate;

  void pickDate() async {
    DateTime? picked = await showDatePicker(
      context: context,
      initialDate: DateTime.now(),
      firstDate: DateTime(2024),
      lastDate: DateTime(2030),
    );

    setState(() {
      selectedDate = picked;
    });
  }

  void saveTask() {
    Navigator.pop(context); // simple for demo
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Add Task")),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(controller: titleController, decoration: InputDecoration(labelText: "Title")),
            TextField(controller: descController, decoration: InputDecoration(labelText: "Description")),

            SizedBox(height: 10),
            ElevatedButton(onPressed: pickDate, child: Text("Pick Date")),

            SizedBox(height: 20),
            ElevatedButton(onPressed: saveTask, child: Text("Save Task")),
          ],
        ),
      ),
    );
  }
}