import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    println("Введите выражение:")
    val string = reader.nextLine()
    if (Validator().checkForNotAllowedCharecters(string) || Validator().checkForForbiddenSymbols(string)) {
        main()
    } else {
        val result = Calculator().calculate(string)
        print("Ответ: ${result}")
    }
}