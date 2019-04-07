package com.marmoush.transport.domain.services

import java.time.LocalTime

import com.marmoush.transport.domain.repo.{DelaysRepo, LinesRepo, StopsRepo, TimesRepo}
import com.marmoush.transport.domain.value.{Line, Stop}

case class VehicleService(delaysRepo: DelaysRepo, linesRepo: LinesRepo, stopsRepo: StopsRepo, timesRepo: TimesRepo) {

  def isVehicleAvailable(time: LocalTime, x: Int, y: Int): Boolean = {
    false
  }

  def nextVehicle(stop: Stop): Option[(Line, LocalTime)] = {
    val sId = stopsRepo.getStopId(stop.x, stop.y)

    None
  }

  def isLineDelayed(line: Line): Boolean = delaysRepo.isDelayed(line)

}
