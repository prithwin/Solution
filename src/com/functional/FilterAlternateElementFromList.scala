package com.functional


object FilterAlternateElementFromList {

  def f(coefficients:List[Int],powers:List[Int],x:Double):Double =
  {
    var sum = 0.0
    for(i <- powers.indices) {
      sum += coefficients(i) * scala.math.pow(x , powers(i))
    }
    sum
  }

  def area(coefficients:List[Int],powers:List[Int],x:Double):Double =
  {var sum = 0.0
    for(i <- powers.indices) {
      sum += coefficients(i) * scala.math.pow(x , powers(i))
    }
    scala.math.Pi * scala.math.pow(sum , 2)
  }


  def summation(func:(List[Int],List[Int],Double)=>Double,upperLimit:Int,lowerLimit:Int,coefficients:List[Int],powers:List[Int]):Double =
  {
    var area = 0.0
    for(x <- lowerLimit.toDouble to upperLimit.toDouble by 0.2) {
      area += func(coefficients , powers ,x)
    }
    area
  }


}