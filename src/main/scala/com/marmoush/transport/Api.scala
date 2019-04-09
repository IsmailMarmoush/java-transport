package com.marmoush.transport

import java.time.LocalTime

import cats.effect._
import fs2.StreamApp.ExitCode
import fs2.{Stream, StreamApp}
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global
import Dependencies.vehicleService
import com.marmoush.transport.domain.value.Line
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

object Api extends StreamApp[IO] {

  val transportService = HttpService[IO] {
    case GET -> Root / "isLineDelayed" / line => Ok(s"${vehicleService.isLineDelayed(Line(line)).asJson.noSpaces}")
    case GET -> Root / "nextVehicles" / stopId =>
      Ok(s"${vehicleService.nextVehicles(stopId.toInt, LocalTime.now).asJson.noSpaces}")
    case GET -> Root / "nextVehicles" / stopId / time =>
      Ok(s"${vehicleService.nextVehicles(stopId.toInt, LocalTime.parse(time)).asJson.noSpaces}")

  }

  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO].bindHttp(8080, "localhost").mountService(transportService, "/").serve

}
