package com.raasahsan.rex

import java.io.FileOutputStream

import com.raasahsan.rex.compiler.RexCompiler

object Main {

  def main(args: Array[String]): Unit = {
    println("rex")

//    val program = Program(Block(List()))

    val compiler = new RexCompiler
    val classBytes = compiler.compile()

    val fos = new FileOutputStream("out/MainJs.class")
    fos.write(classBytes)
    fos.close()
  }

}
