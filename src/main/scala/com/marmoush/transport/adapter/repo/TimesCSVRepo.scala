package com.marmoush.transport.adapter.repo

import java.time.LocalTime
import java.time.format.DateTimeFormatter

import com.github.tototoshi.csv.CSVReader
import com.marmoush.transport.domain.repo.TimesRepo

import scala.io.Source

case class TimesCSVRepo(csvFile: Source) extends TimesRepo {
  val reader = CSVReader.open(csvFile)
  override def getNextLine(stopId: Int, currentTime: LocalTime): Int =
    reader.toStream
      .filter {
        case (line :: stopIdx :: time :: nil) =>
          stopId == stopIdx && currentTime.isBefore(LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME))
      }
      .sortBy { case (_ :: _ :: time :: nil) => LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME) }(
        Ordering[LocalTime])
      .head
      .head
      .toInt
}
