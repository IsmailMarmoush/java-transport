package com.marmoush.domain.services

import org.scalatest.{FlatSpec, Matchers}
import com.marmoush.transport.Dependencies.vehicleService._
import com.marmoush.transport.domain.value.{AnonymousLine, Line, LineM4}

class VehicleServiceTest extends FlatSpec with Matchers {
  "Line M4" should "be delayed" in {
    isLineDelayed(LineM4) should be(true)
  }

  "Line U8" should "not be in delayed" in {
    isLineDelayed(AnonymousLine("U8")) should be(false)
  }

}
