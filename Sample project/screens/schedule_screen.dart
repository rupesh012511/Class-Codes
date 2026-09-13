import 'package:flutter/material.dart';

class ScheduleScreen extends StatelessWidget {
  final List<Map<String, String>> schedule = [
    {"subject": "Math", "time": "10 AM"},
    {"subject": "OS", "time": "12 PM"},
    {"subject": "DBMS", "time": "2 PM"},
  ];

  @override
  Widget build(BuildContext context) {
    return GridView.builder(
      padding: EdgeInsets.all(10),
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 2, crossAxisSpacing: 10, mainAxisSpacing: 10),
      itemCount: schedule.length,
      itemBuilder: (context, index) {
        return GestureDetector(
          onTap: () {
            showDialog(
              context: context,
              builder: (_) => AlertDialog(
                title: Text(schedule[index]['subject']!),
                content: Text("Time: ${schedule[index]['time']}"),
              ),
            );
          },
          child: Card(
            child: Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(schedule[index]['subject']!),
                  Text(schedule[index]['time']!),
                ],
              ),
            ),
          ),
        );
      },
    );
  }
}