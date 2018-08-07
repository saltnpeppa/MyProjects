package MiscellaneousProjects

import java.util.*

fun main(args: Array<String>) {

    println("Please enter a number")
    var firstNumber: Scanner= Scanner(System.`in`)
    var realfirstNumber: Double = firstNumber.nextDouble()



    println("Now please enter an operator (+, -, /, *)")
    val firstOperator: Scanner = Scanner(System.`in`)
    var realfirstOperator: String = firstOperator.next()

    println("Now please enter your other number")
    val secondNumber: Scanner = Scanner(System.`in`)
    val realsecondNumber: Double = secondNumber.nextDouble()

    when(realfirstOperator){
        "+" -> println(realfirstNumber + realsecondNumber)
        "-" -> println(realfirstNumber - realsecondNumber)
        "/" -> println(realfirstNumber / realsecondNumber)
        "*" -> println(realfirstNumber * realsecondNumber)
        else -> {println("You entered an unidentifiable operator.")}
    }
}