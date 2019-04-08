package com.marmoush.domain.services

import java.time.LocalTime

import com.marmoush.transport.Dependencies.vehicleService._
import com.marmoush.transport.domain.value._
import org.scalatest.{FlatSpec, Matchers}

class VehicleServiceTest extends FlatSpec with Matchers {
  "Line200" should "not be equal to LineM4" in {
    Line200 eq LineM4
  }
  "Line M4" should "be delayed" in {
    isLineDelayed(LineM4) should be(true)
  }

  "Line U8" should "not be in delayed" in {
    isLineDelayed(AnonymousLine("U8")) should be(false)
  }

  // 1,3,10:08:00
  "Line200" should "be at stop 2,9 at time (10:08:00)" in {
    nextVehicle(Stop(2, 9), LocalTime.of(10, 5, 0)) == LineM4
  }
}
