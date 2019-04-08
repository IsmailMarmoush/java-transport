package com.marmoush.transport.adapter.repo

import com.github.tototoshi.csv._
import com.marmoush.transport.domain.repo.DelaysRepo
import com.marmoush.transport.domain.value.Line

import scala.io.Source

case class DelaysCSVRepo(csvFile: String) extends DelaysRepo {

  override def isDelayed(line: Line): Boolean = {
    val reader = CSVReader.open(Source.fromResource(csvFile))
    val result = reader.toStream.exists(l => l.head == line.name)
    reader.close()
    result
  }
}
