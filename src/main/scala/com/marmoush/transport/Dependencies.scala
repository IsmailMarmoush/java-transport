package com.marmoush.transport

import com.marmoush.transport.adapter.repo._
import com.marmoush.transport.domain.repo._
import com.marmoush.transport.domain.services.VehicleService

import scala.io.Source

object Dependencies {
  val delaysRepo: DelaysRepo = DelaysCSVRepo("data/delays.csv")
  val linesRepo: LinesRepo   = LinesCSVRepo("data/lines.csv")
  val stopsRepo: StopsRepo   = StopsCSVRepo("data/stops.csv")
  val timesRepo: TimesRepo   = TimesCSVRepo("data/times.csv")

  val vehicleService = VehicleService(delaysRepo, linesRepo, stopsRepo, timesRepo)

}
