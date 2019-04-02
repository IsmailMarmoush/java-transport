package com.marmoush.transport.adapter.repo

import com.github.tototoshi.csv._
import com.marmoush.transport.domain.repo.DelaysRepo
import com.marmoush.transport.domain.value.Line

import scala.io.Source

case class DelaysCSVRepo(csvFile: Source) extends DelaysRepo {
  val reader = CSVReader.open(csvFile)

  override def isDelayed(line: Line): Boolean = reader.toStream.exists(l => l.head == line.name)
}
