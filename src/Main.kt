import java.io.File

fun main() {
    // Чтение данных из файла input.txt
    val inputFile = File("input.txt")
    val lines = inputFile.readLines()

    val n = lines[0].toInt()

    // Считываем координаты выпиленных клеток и сохраняем их в сет
    val cells = mutableSetOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (x, y) = lines[i].split(" ").map { it.toInt() }
        cells.add(x to y)
    }

    // Массив направлений для проверки соседей (влево, вправо, вверх, вниз)
    val directions = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0
    )

    var perimeter = 0

    // Для каждой клетки проверяем всех соседей
    for ((x, y) in cells) {
        for ((dx, dy) in directions) {
            val neighbor = x + dx to y + dy
            if (neighbor !in cells) {
                perimeter++
            }
        }
    }

    val outputFile = File("output.txt")
    outputFile.writeText(perimeter.toString())
}
