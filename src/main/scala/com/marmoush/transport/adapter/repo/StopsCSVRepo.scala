package com.marmoush.transport.adapter.repo

import com.github.tototoshi.csv.CSVReader
import com.marmoush.transport.domain.entities.StopEntity
import com.marmoush.transport.domain.repo.StopsRepo

import scala.io.Source

case class StopsCSVRepo(csvFile: Source) extends StopsRepo {
  val reader = CSVReader.open(csvFile)

  override def stopId(x: Int, y: Int): Option[Int] =
    reader.toStream.find { case (id :: x1 :: y1) => x == x1 && y == y1 }.map(_.head.toInt)
  override def stop(id: Int): Option[StopEntity] = ???
}
