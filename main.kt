fun exercise7(list: MutableList<Int>): MutableList<Int> {
    for (i in 0 until list.size - 1) {
        for (j in 0 until list.size - 1) {
            if (list[j] > list[j + 1]) {
                val number = list[j]
                list[j] = list[j + 1]
                list[j + 1] = number
            }
        }
    }
    return list
}

fun exercise8(list: MutableList<Int>): MutableList<Int> {
    for (i in 0 until list.size - 1) {
        for (j in 0 until list.size - 1) {
            if (list[j] < list[j + 1]) {
                val number = list[j]
                list[j] = list[j + 1]
                list[j + 1] = number
            }
        }
    }
    return list
}

fun exercise9(list: MutableList<Int>, k: Int): MutableList<Int>? {
    if (k == 1) {
        return exercise7(list)
    } else if (k == 0) {
        return exercise8(list)
    }
    return null
}

fun exercise10(n: Int): Boolean {
    var number = n
    var reverse = 0
    while (number != 0) {
        var lastDigit = number % 10
        reverse = reverse * 10 + lastDigit
        number /= 10
    }
    return n == reverse
}

fun exercise11(n: Int): Boolean {
    if (n <= 1) {
        return false
    }
    for (i in 2 until n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

fun exercise12(list: MutableList<Int>): List<Int> {
    var biggestNumber: Int = 0
    var biggestOddNumber: Int = 0
    var biggestEvenNumber: Int = 0
    var biggestPrimeNumber: Int = 0
    for (i in 0 until list.size) {
        if (list[i] > biggestNumber) {
            biggestNumber = list[i]
        }
        if (list[i] % 2 == 0) {
            if (list[i] > biggestEvenNumber) {
                biggestEvenNumber = list[i]
            }
        } else {
            if (list[i] > biggestOddNumber) {
                biggestOddNumber = list[i]
            }
        }
        if (exercise11(list[i])) {
            if (list[i] > biggestPrimeNumber) {
                biggestPrimeNumber = list[i]
            }
        }
    }
    var result: List<Int> =
            listOf(biggestNumber, biggestOddNumber, biggestEvenNumber, biggestPrimeNumber)
    return result
}

open class NhanVien constructor(id: Int, name: String, dob: String, address: String) {
    var id: Int = id
    var name: String = name
    var dob: String = dob
    var address: String = address

    fun NhapThongTin() {
        println("Nhập ID: ")
        id = readLine()!!.toInt()
        println("Nhập tên: ")
        name = readLine()!!.toString()
        println("Nhập ngày sinh: ")
        dob = readLine()!!.toString()
        println("Nhập địa chỉ: ")
        address = readLine()!!.toString()
    }

    open fun XuatThongTin() {
        println("ID: $id")
        println("Tên: $name")
        println("Ngày sinh: $dob")
        println("Địa chỉ: $address")
    }
}

class NhanVienSanXuat constructor(id: Int, name: String, dob: String, address: String, quantity: Int) :
        NhanVien(id, name, dob, address) {
    var quantity: Int = quantity

    override fun XuatThongTin() {
        super.XuatThongTin()
        println("Lương: $salary")
    }
}


fun main() {
    var list1: MutableList<Int> = mutableListOf(3, 5, 1, 2, 4)
    var list2: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("Exercise 7: " + exercise7(list1))

    println("Exercise 8: " + exercise8(list1))

    println("Exercise 9: " + exercise9(list1, 1))
    println("Exercise 9: " + exercise9(list1, 0))

    println("Exercise 10: " + exercise10(12321))
    println("Exercise 10: " + exercise10(12345))

    println("Exercise 11: " + exercise11(5))
    println("Exercise 11: " + exercise11(6))

    println("Exercise 12: " + exercise12(list2))
}
