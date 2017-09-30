package com.functional.util

/**
  * Created by prajeeva on 9/22/17.
  */
class EntrySet[K,V](key:K,value:V,next:EntrySet[K,V]) {
  def apply(key: K, value: V): EntrySet[K,V] = new EntrySet(key, value, null)
}