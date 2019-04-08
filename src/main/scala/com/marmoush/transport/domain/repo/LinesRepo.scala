package com.marmoush.transport.domain.repo
import com.marmoush.transport.domain.entities.StopEntity
import com.marmoush.transport.domain.value.Line

trait LinesRepo {
   def getLine(id:Int):Option[Line]
}
