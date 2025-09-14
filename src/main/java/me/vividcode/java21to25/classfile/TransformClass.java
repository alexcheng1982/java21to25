package me.vividcode.java21to25.classfile;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassTransform;
import java.lang.classfile.CodeTransform;
import java.lang.classfile.MethodTransform;
import java.lang.classfile.instruction.InvokeInstruction;
import java.lang.constant.ClassDesc;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TransformClass {

  void transform() throws IOException {
    CodeTransform codeTransform = (codeBuilder, e) -> {
      switch (e) {
        case InvokeInstruction i when i.owner().asInternalName()
            .contains("OldService") -> codeBuilder.invoke(i.opcode(),
            ClassDesc.of(
                "me.vividcode.java21to25.classfile.totransform.NewService"),
            i.name().stringValue(),
            i.typeSymbol(), i.isInterface());
        default -> codeBuilder.accept(e);
      }
    };
    var methodTransform = MethodTransform.transformingCode(codeTransform);
    var classTransform = ClassTransform.transformingMethods(
        methodTransform);
    var packagePath = Path.of("target", "classes", "me", "vividcode",
        "java21to25",
        "classfile", "totransform");
    var classModel = ClassFile.of().parse(
        packagePath.resolve("ServiceCaller.class"));
    var bytes = ClassFile.of()
        .transformClass(classModel,
            classTransform);
    Files.write(packagePath.resolve("ServiceCaller.class"), bytes,
        StandardOpenOption.TRUNCATE_EXISTING);
  }

  static void main() throws IOException {
    new TransformClass().transform();
  }
}
