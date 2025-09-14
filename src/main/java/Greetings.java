String getMessage() {
  return "Current time is: " + LocalDateTime.now();
}

void main() {
  IO.println(getMessage());
}