package me.vividcode.java21to25.classfile;

import static java.lang.classfile.ClassFile.ACC_PUBLIC;
import static java.lang.classfile.ClassFile.ACC_STATIC;
import static java.lang.constant.ConstantDescs.CD_Object;
import static java.lang.constant.ConstantDescs.CD_void;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.Opcode;
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.nio.file.Path;

public class GenerateClass {

  void generate() throws IOException {
    var classDesc = ClassDesc.of("HelloWorld");
    ClassFile.of()
        .buildTo(Path.of("target", "classes", "HelloWorld.class"),
            classDesc,
            classBuilder -> {
              classBuilder.withMethod("greet",
                  MethodTypeDesc.of(CD_void),
                  ACC_STATIC,
                  methodBuilder -> {
                    methodBuilder.withCode(codeBuilder -> {
                      codeBuilder.loadConstant("Hello world");
                      codeBuilder.invoke(Opcode.INVOKESTATIC,
                          ClassDesc.of("java.lang.IO"),
                          "println",
                          MethodTypeDesc.of(CD_void, CD_Object),
                          false);
                      codeBuilder.return_();
                    });
                  });
              classBuilder.withMethod("main",
                  MethodTypeDesc.of(CD_void),
                  ACC_PUBLIC | ACC_STATIC,
                  methodBuilder -> {
                    methodBuilder.withCode(codeBuilder -> {
                      codeBuilder.invoke(Opcode.INVOKESTATIC,
                          classDesc,
                          "greet",
                          MethodTypeDesc.of(CD_void),
                          false);
                      codeBuilder.return_();
                    });
                  });
            });
  }

  static void main() throws IOException {
    new GenerateClass().generate();
  }
}
