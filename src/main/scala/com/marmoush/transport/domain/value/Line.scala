package com.marmoush.transport.domain.value

sealed case class Line(name: String)

object LineM4  extends Line("M4")
object Line200 extends Line("200")
object LineS75 extends Line("S75")
