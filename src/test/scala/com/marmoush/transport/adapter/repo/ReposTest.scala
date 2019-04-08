package com.marmoush.transport.adapter.repo
import java.time.LocalTime

import org.scalatest.{FlatSpec, Matchers}
import com.marmoush.transport.Dependencies._

class ReposTest extends FlatSpec with Matchers {

  "getStopId(2,9)" should "return 3" in {
    stopsRepo.getStopId(2, 9) should be(Some(3))
    stopsRepo.getStopId(2, 9) should be(Some(3))
  }

  "getNextLine(3,10:08:00)" should "return 2" in {
    println(timesRepo.getNextLines(3, LocalTime.of(10, 6, 0)))
  }
}
