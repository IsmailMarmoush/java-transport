package com.marmoush.transport

import com.marmoush.transport.adapter.repo._
import com.marmoush.transport.domain.repo._
import com.marmoush.transport.domain.services.VehicleService

object Dependencies {
  val delaysRepo: DelaysRepo = DelaysCSVRepo()
  val linesRepo: LinesRepo = LinesCSVRepo()
  val stopsRepo: StopsRepo = StopsCSVRepo()
  val timesRepo: TimesRepo = TimesCSVRepo()

  val vehicleService = VehicleService(delaysRepo, linesRepo, stopsRepo, timesRepo)
  

}
