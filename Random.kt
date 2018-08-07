package MiscellaneousProjects

import java.util.Scanner

fun main(args: Array<String>) {

    println("Please type in any word and I will put it in reverse order")
    val string:String = readLine()!!
    println("Now please enter a number")
    val reader: Scanner = Scanner(System.`in`) // This whole block of code is for user input
    val number: Long = reader.nextLong()


    val right: String = string.reversed()
    if (right == string){
        println("Your word is a palindrome") // This block of code tells you whether or not your world is a palindrome
    } else{
        println("Your word is not a palindrome")
    }

    val reversedNumber: String = number.toString()
    var realReversed: String = reversedNumber.reversed() // This block of code is for reversing number
    val other: Long = realReversed.toLong()

    if (other == number){
        println("Congratulations! Your number is a palindrome")
    } else{                                                      // This block of code tells you if your number is a palindrome
        println("Your number is not a palindrome")
    }

    println("$other is your number in reversed order!") // This tells you your number in reversed order

   

}

