class Profile extends StatelessWidget {
  final String name;
  final int age;

  const Profile(required this.name, required this.age);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text(name),
        Text("Age: $age"),
      ],
    );
  }
}