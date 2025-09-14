package me.vividcode.java21to25.classfile;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.MethodModel;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ParseClass {

  void parse() throws IOException {
    var classModel = ClassFile.of().parse(
        Path.of("target", "classes", "me", "vividcode",
            "java21to25", "classfile", "ParseClass.class"));
    var methods = classModel.methods().stream().map(MethodModel::methodName)
        .collect(
            Collectors.joining(", "));
    System.out.println(methods);
  }

  static void main() throws IOException {
    new ParseClass().parse();
  }
}
