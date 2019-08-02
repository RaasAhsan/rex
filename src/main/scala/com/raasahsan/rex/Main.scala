package com.raasahsan.rex

import java.io.FileOutputStream

object Main {

  def main(args: Array[String]): Unit = {
    println("rex")

//    val program = com.raasahsan.rex.ast.Program(com.raasahsan.rex.ast.Block(List()))

    val compiler = new RexCompiler
    val classBytes = compiler.compile()

    val fos = new FileOutputStream("out/MainJs.class")
    fos.write(classBytes)
    fos.close()
  }

}
