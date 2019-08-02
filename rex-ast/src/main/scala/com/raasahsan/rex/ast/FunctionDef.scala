package com.raasahsan.rex.ast

final case class FunctionDef(name: String, args: List[String], body: Block) extends Statement
