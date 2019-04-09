package com.marmoush.transport.domain.services

import java.time.LocalTime

import com.marmoush.transport.domain.repo.{DelaysRepo, LinesRepo, StopsRepo, TimesRepo}
import com.marmoush.transport.domain.value.{Line, Stop}

case class VehicleService(delaysRepo: DelaysRepo, linesRepo: LinesRepo, stopsRepo: StopsRepo, timesRepo: TimesRepo) {
// Find a vehicle for a given time and X & Y coordinates ??

//  def getVehicle(time: LocalTime, x: Int, y: Int): Option[Line] = {
//    false
//  }

  def nextVehicles(stopId: Int, time: LocalTime): List[(Line, LocalTime)] =
    timesRepo
      .getNextLines(stopId, time)
      .map {
        case (lineId, time) => (linesRepo.getLine(lineId), time)
      }
      .flatMap {
        case (Some(x), t) => Some((x, t))
        case (None, _)    => None
      }

  def isLineDelayed(line: Line): Boolean = delaysRepo.isDelayed(line)

}
