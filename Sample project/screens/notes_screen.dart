import 'package:flutter/material.dart';

class NotesScreen extends StatefulWidget {
  @override
  _NotesScreenState createState() => _NotesScreenState();
}

class _NotesScreenState extends State<NotesScreen> {
  List<String> notes = [];
  final controller = TextEditingController();

  void addNote() {
    setState(() {
      notes.add(controller.text);
      controller.clear();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.all(10),
          child: Row(
            children: [
              Expanded(child: TextField(controller: controller)),
              IconButton(icon: Icon(Icons.add), onPressed: addNote),
            ],
          ),
        ),

        Expanded(
          child: ListView.builder(
            itemCount: notes.length,
            itemBuilder: (context, index) {
              return Card(
                child: ListTile(title: Text(notes[index])),
              );
            },
          ),
        ),
      ],
    );
  }
}