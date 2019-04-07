package com.marmoush.transport.domain.repo
import java.time.LocalTime

import com.marmoush.transport.domain.value.Line

trait TimesRepo {
  def getNextLine(stopId: Int, localTime: LocalTime):Int
}
