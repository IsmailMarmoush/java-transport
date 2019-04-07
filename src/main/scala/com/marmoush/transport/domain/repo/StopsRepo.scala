package com.marmoush.transport.domain.repo
import com.marmoush.transport.domain.entities.StopEntity

trait StopsRepo {
  def getStopId(x: Int, y: Int): Option[Int]
  def getStopEntity(id: Int): Option[StopEntity]
}
