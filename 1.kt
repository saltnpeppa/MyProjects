package ProjectEuler

fun main(args: Array<String>) {

    val values = arrayListOf<Int>()
    for (i in 1..999){
        if (i % 3 == 0 || i % 5 == 0){
            values.add(i)
        }
    }
    println(values.sum())


}