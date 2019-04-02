package com.marmoush.transport.domain.repo

import com.marmoush.transport.domain.value.Line

trait DelaysRepo {
  def isDelayed(line: Line): Boolean
}
