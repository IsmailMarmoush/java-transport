package com.marmoush.transport.domain.repo
import com.marmoush.transport.domain.entities.StopEntity

trait StopsRepo {
  def stopId(x: Int, y: Int): Option[Int]
  def stop(id: Int): Option[StopEntity]
}
