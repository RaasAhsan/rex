package com.raasahsan.rex.compiler

import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes._

class RexCompiler {

  def compile(): Array[Byte] = {
    val cw = new ClassWriter(0)
    cw.visit(V1_8, ACC_PUBLIC, "MainJs", null, "java/lang/Object", null)

    val mv = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null)
    mv.visitCode()
    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
    mv.visitInsn(ICONST_5)
    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false)
    mv.visitInsn(RETURN)
    mv.visitMaxs(2, 1)
    mv.visitEnd()

    cw.visitEnd()

    cw.toByteArray
  }

}
