package com.marmoush.transport.domain.repo
import java.time.LocalTime

trait TimesRepo {
  def getNextLines(stopId: Int, localTime: LocalTime): List[(Int, LocalTime)]
}
