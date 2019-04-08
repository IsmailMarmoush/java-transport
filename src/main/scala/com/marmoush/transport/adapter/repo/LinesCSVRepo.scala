package com.marmoush.transport.adapter.repo

import com.github.tototoshi.csv.CSVReader
import com.marmoush.transport.domain.repo.LinesRepo
import com.marmoush.transport.domain.value.Line

import scala.io.Source

case class LinesCSVRepo(csvFile: String) extends LinesRepo {

  override def getLine(id: Int): Option[Line] = {
    val reader = CSVReader.open(Source.fromResource(csvFile))
    val result = reader.toStream.drop(1).find { case (idx :: name :: nil) => id == idx.toInt }.map {
      case (idx :: name :: nil) => Line(name)
    }
    reader.close()
    result
  }
}
