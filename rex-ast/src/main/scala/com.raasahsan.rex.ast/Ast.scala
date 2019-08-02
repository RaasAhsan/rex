package com.raasahsan.rex.ast

final case class Program(block: Block)

final case class Block(statements: Statement)

sealed abstract class Statement

final case class VarDef(name: String, rhs: Expression) extends Statement

final case class ConstDef(name: String, rhs: Expression) extends Statement

final case class LetDef(name: String, rhs: Expression) extends Statement

final case class FunctionDef(name: String, args: List[String], body: Block) extends Statement

sealed abstract class Expression extends Statement

final case class FunctionCall(name: String, args: List[Expression])
