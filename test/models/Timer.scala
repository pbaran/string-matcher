package models

import System.currentTimeMillis

class Timer {

  var timestamp = currentTimeMillis

  def timeDiff() = {
    val oldTimestamp = timestamp
    timestamp = currentTimeMillis
    timestamp - oldTimestamp
  }
}
