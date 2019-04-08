package com.marmoush.transport.domain.services

import java.time.LocalTime

import com.marmoush.transport.Dependencies.vehicleService._
import com.marmoush.transport.domain.value._
import org.scalatest.{FlatSpec, Matchers}

class VehicleServiceTest extends FlatSpec with Matchers {
  "Line200" should "not be equal to LineM4" in {
    Line200 should not be (LineM4)
  }

  "Line M4" should "be delayed" in {
    isLineDelayed(LineM4) should be(true)
  }

  "Line U8" should "not be in delayed" in {
    isLineDelayed(Line("U8")) should be(false)
  }

  // 1,3,10:08:00
  "Line200" should "be at stop 2,9 at time (10:08:00)" in {
    nextVehicles(Stop(2, 9), LocalTime.of(10, 5, 0)) should be(
      List((LineM4, LocalTime.of(10, 7, 0)), (Line200, LocalTime.of(10, 8)), (LineS75, LocalTime.of(10, 8))))
  }
}
