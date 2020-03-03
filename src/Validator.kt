class Validator {
    fun checkForNotAllowedCharecters(string: String): Boolean {
        if (string.contains(Regex("[a-zA-Zа-яА-Я]"))) {
            println("Введен недопустимый символ")
            return true
        } else {
            return false
        }
    }

    fun checkForForbiddenSymbols(string: String): Boolean {
        val forbiddenSymbols = charArrayOf(
            '!',
            '#',
            '%',
            '&',
            ':',
            ';',
            '<',
            '>',
            '=',
            '?',
            '@',
            '[',
            ']',
            'ˆ',
            '_',
            '`',
            '{',
            '}',
            '|',
            '~',
            '"',
            ',',
            '$'
        )
        if (string.indexOfAny(forbiddenSymbols) >= 0) {
            println("Были введены недопустимые символы")
            return true
        } else {
            return false
        }
    }
}