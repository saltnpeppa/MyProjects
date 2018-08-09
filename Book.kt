package OO

import java.util.*
import kotlin.system.exitProcess

class Books(val title: String, val author: String, val publicationYear: Int?, var borrowed: Boolean, var youHaveTheBook: Boolean){
    fun isBorrowed(): Boolean{
        if(borrowed == false){
            if (youHaveTheBook == false) {
                println("Do you want to borrow this book? [Y/N]")
                val reader: Scanner = Scanner(System.`in`)
                val answer: String = reader.next()
                if (answer == "Y") {
                    println("You have successfully borrowed the book!")
                    youHaveTheBook = true
                    borrowed = true
                    return true
                } else {
                    println("We'll try another time.")
                    exitProcess(1)
                    return false
                }
            }
            else if(youHaveTheBook == true){
                println("You can't checkout a book you already have!")
                exitProcess(1)
            }
            return true
        } else {
            println("The book is borrowed so you cannot check it out.")
            exitProcess(1)
            return false
        }
    }

    fun youAreInPossessionReturn(): Boolean {
        if(youHaveTheBook) {
            println("You are currently in possession of the book. Do you wish to return it? [Y/N]")
            val reader: Scanner = Scanner(System.`in`)
            val answer: String = reader.next()
            if(answer == "Y"){
                println("You have successfully returned the book")
                return true
            } else {
                println("How much longer would you like to hold on to the book since there are others who want to read it as well? If you have a any other reason that isn't a number, please contact the front desk.")
                val otherReader: Scanner = Scanner(System.`in`)
                val otherAnswer: Int = otherReader.nextInt()
                if(otherAnswer <= 3){
                    println("That should be fine!")
                } else if (otherAnswer <= 7){
                    println("It's a bit risky, but that should be fine")
                } else if (otherAnswer > 7) {
                    println("I'm sorry, but that won't work. Please return it sooner.")
                } else {
                    println("I couldn't understand you request. Please contact the front desk.")
                    exitProcess(1)
                }
            }
            return true
        } else {
            println("You can't a return a book that hasn't been borrowed")
            exitProcess(1)
            return false
        }
    }

    fun read(): Boolean {
        if (borrowed and youHaveTheBook){
            println("Do you want to read the book? [Y/N]")
            val reader: Scanner = Scanner(System.`in`)
            val answer: String = reader.next()
            if(answer == "Y"){
                println("You read the book!")
            } else {
                println("That's fine")
                return false
            }
            return true
        } else {
            println("You can't read a book that you haven't borrowed!")
            exitProcess(1)
            return false
        }
    }

    fun print() {
        println("Book Details [Title: $title, Author: $author, PublicationYear: $publicationYear, StatusBorrowed: $borrowed, Do you have it: $youHaveTheBook]")
    }
}

fun main(args: Array<String>) {
    var borrowed: Boolean = true
    println("Do you want to checkout or return a book? [checkout/return]")
    val realReader = Scanner(System.`in`)
    val answer: String = realReader.next()
    if(answer == "checkout"){
        println("Please enter the title of your book.")
        val reader: Scanner = Scanner(System.`in`)
        val title: String = reader.next()


        println("Please enter the author of this book.")
        val reader2: Scanner = Scanner(System.`in`)
        val author: String = reader2.next()

        println("Please enter the publication year of this book. If you don't know, type in 0.")
        val reader3: Scanner = Scanner(System.`in`)
        val publicationYear: Int = reader3.nextInt()

        var borrowed: Boolean = false
        var youHaveTheBook: Boolean = false

        val book = Books(title, author, publicationYear, borrowed, youHaveTheBook)
        book.isBorrowed()
        book.read()

    } else if(answer == "return"){
        println("Please enter the title of your book.")
        val reader: Scanner = Scanner(System.`in`)
        val title: String = reader.next()


        println("Please enter the author of this book.")
        val reader2: Scanner = Scanner(System.`in`)
        val author: String = reader2.next()

        println("Please enter the publication year of this book. If you don't know, type in 0.")
        val reader3: Scanner = Scanner(System.`in`)
        val publicationYear: Int = reader3.nextInt()

        var borrowed: Boolean = true
        var youHaveTheBook: Boolean = true

        val book = Books(title, author, publicationYear, borrowed, youHaveTheBook)
        book.youAreInPossessionReturn()
        book.print()

    }




}


