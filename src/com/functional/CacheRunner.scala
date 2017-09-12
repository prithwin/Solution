import com.functional.util.LRUCache

/**
  * Created by prajeeva on 9/11/17.
  */


object CacheRunner {
  def main(args: Array[String]): Unit = {
    val cache = LRUCache(5)
    cache.put(1,5)
    cache.put(2,67)
    cache.put(3,8)
    cache.put(4,34)
    cache.put(5,223)
    println
    cache.get(3)
    println()
  }
}
