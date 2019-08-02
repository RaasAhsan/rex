package com.raasahsan.rex.ast

final case class LetDef(name: String, rhs: Expression) extends Statement
