package com.marmoush.transport.adapter.repo

import java.time.LocalTime
import java.time.format.DateTimeFormatter

import com.github.tototoshi.csv.CSVReader
import com.marmoush.transport.domain.repo.TimesRepo
import com.marmoush.transport.domain.value.Line

import scala.io.Source

case class TimesCSVRepo(csvFile: String) extends TimesRepo {
  override def getNextLines(stopId: Int, currentTime: LocalTime): List[(Int, LocalTime)] = {
    val reader = CSVReader.open(Source.fromResource(csvFile))
    val result = reader.toStream
      .drop(1)
      .filter {
        case (_ :: stopIdx :: time :: _) =>
          stopId == stopIdx.toInt && currentTime.isBefore(LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME))
        case _ => false
      }
      .map {
        case (lineId :: _ :: time :: _) => (lineId.toInt, LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME))
      }
      .toList
    reader.close()
    result
  }
}
