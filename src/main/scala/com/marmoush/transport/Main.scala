package com.marmoush.transport

import cats.effect._
import fs2.StreamApp.ExitCode
import fs2.{Stream, StreamApp}
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global
import Dependencies.vehicleService
import com.marmoush.transport.domain.value.Line

object Main extends StreamApp[IO] {

  val vService = HttpService[IO] {
    case GET -> Root / "isLineDelayed" / line => Ok(s"${vehicleService.isLineDelayed(Line(line))}")
  }

  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO].bindHttp(8080, "localhost").mountService(vService, "/").serve

}
