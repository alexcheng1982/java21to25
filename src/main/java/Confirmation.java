void main() {
  String confirmation = IO.readln("Do you wish to continue? y/n");
  if ("y".equalsIgnoreCase(confirmation)) {
    IO.println("Files deleted");
  } else {
    IO.println("Operation cancelled");
  }
}