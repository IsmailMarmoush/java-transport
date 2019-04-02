package com.marmoush.transport.domain.value


sealed abstract class Line(val name: String)

case object LineM4 extends Line("M4")

case object Line200 extends Line("200")

case object LineS75 extends Line("S75")
