package com.raasahsan.rex.ast

final case class ConstDef(name: String, rhs: Expression) extends Statement
