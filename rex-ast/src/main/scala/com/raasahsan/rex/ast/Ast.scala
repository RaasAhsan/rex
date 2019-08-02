package com.raasahsan.rex.ast

final case class Program(block: Block)

final case class Block(statements: List[Statement])

sealed abstract class Statement

final case class VarDef(name: String, rhs: Expression) extends Statement

final case class LetDef(name: String, rhs: Expression) extends Statement

final case class ConstDef(name: String, rhs: Expression) extends Statement

final case class FunctionDef(name: String, args: List[String], body: Block) extends Statement

sealed abstract class Expression extends Statement

final case class Lambda(args: List[String], body: Block) extends Expression

// TODO: Lambda apply?
final case class FunctionApply(name: String, args: List[Expression]) extends Expression

final case class GetField(term: String, field: String) extends Expression

final case class SetField(term: String, rhs: Expression) extends Expression

final case class JsObject(pairs: (String, Expression)*) extends Expression

final case class JsString(value: String) extends Expression

final case class JsInt(value: Int) extends Expression

final case class JsBoolean(value: Boolean) extends Expression

final case class JsArray(value: List[Expression]) extends Expression

final case class JsDouble(value: Double) extends Expression
