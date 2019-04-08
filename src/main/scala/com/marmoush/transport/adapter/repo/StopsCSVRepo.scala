package com.marmoush.transport.adapter.repo

import com.github.tototoshi.csv.CSVReader
import com.marmoush.transport.domain.entities.StopEntity
import com.marmoush.transport.domain.repo.StopsRepo
import com.marmoush.transport.domain.value.Stop

import scala.io.Source

case class StopsCSVRepo(csvFile: String) extends StopsRepo {

  override def getStopId(x: Int, y: Int): Option[Int] = {
    val reader = CSVReader.open(Source.fromResource(csvFile))
    val result =
      reader.toStream.drop(1).find { case (id :: x1 :: y1 :: nil) => x == x1.toInt && y == y1.toInt }.map(_.head.toInt)
    reader.close()
    result
  }
  override def getStopEntity(id: Int): Option[StopEntity] = {
    val reader = CSVReader.open(csvFile)
    val result = reader.toStream.drop(1).find { case (id :: _) => id == id.toInt }.map {
      case (idx :: x :: y :: _) => StopEntity(idx.toInt, Stop(x.toInt, y.toInt))
    }
    reader.close()
    result
  }
}
