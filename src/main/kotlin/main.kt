fun main () {

    val seconds = 150
    println(agoToText(seconds))
}

fun agoToText (seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) только что"
        in 60..60 * 60 -> "был(а) " + "${minutesToText(seconds)}" + " назад"
        in 60 * 60..24 * 60 * 60 -> "был(а) " + "${hoursToText(seconds)}" + " назад"
        in 24 * 60 * 60..24 * 60 * 60 * 2 -> "был(а) вчера"
        in 24 * 60 * 60 * 2..24 * 60 * 60 * 3 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun minutesToText (seconds: Int): String{
    val minutes = seconds / 60
    val lastNumber = minutes % 10
    return when {
        (minutes == 11) || (minutes == 12) || (minutes == 13) || (minutes == 14) -> "$minutes минуты"
        lastNumber == 1 -> "$minutes минуту"
        (lastNumber == 2) || (lastNumber == 3) || (lastNumber == 4) -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursToText (seconds: Int): String {
    val hours = seconds / (60 * 60)
    val lastNumber = hours % 10
    return when {
        (hours == 11) || (hours == 12) || (hours == 13) || (hours == 14) -> "$hours часов"
        lastNumber == 1 -> "$hours час"
        lastNumber == 2 || lastNumber == 3 || lastNumber == 4 -> "$hours часа"
        else -> "$hours часов"
    }
}
