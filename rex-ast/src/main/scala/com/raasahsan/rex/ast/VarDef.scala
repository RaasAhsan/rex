package com.raasahsan.rex.ast

final case class VarDef(name: String, rhs: Expression) extends Statement
