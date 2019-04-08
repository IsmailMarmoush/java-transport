package com.marmoush.transport.adapter.repo

import com.github.tototoshi.csv.CSVReader
import com.marmoush.transport.domain.repo.LinesRepo
import com.marmoush.transport.domain.value.{AnonymousLine, Line}

import scala.io.Source

case class LinesCSVRepo(csvFile: Source)  extends LinesRepo{
  val reader = CSVReader.open(csvFile)

  override def getLine(id: Int): Option[Line] =reader.toStream.find{case (idx::name::nil)=>id==idx }.map{ case(idx::name::nil)=> new AnonymousLine(name)}
}
