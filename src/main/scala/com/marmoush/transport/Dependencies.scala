package com.marmoush.transport

import com.marmoush.transport.adapter.repo._
import com.marmoush.transport.domain.repo._
import com.marmoush.transport.domain.services.VehicleService

import scala.io.Source

object Dependencies {
  private val delaysRepo: DelaysRepo = DelaysCSVRepo(Source.fromResource("data/delays.csv"))
  private val linesRepo: LinesRepo = LinesCSVRepo()
  private val stopsRepo: StopsRepo = StopsCSVRepo(Source.fromResource("data/stops.csv"))
  private val timesRepo: TimesRepo = TimesCSVRepo(Source.fromResource("data/times.csv"))

  val vehicleService = VehicleService(delaysRepo, linesRepo, stopsRepo, timesRepo)


}
