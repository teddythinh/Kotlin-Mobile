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

open class DocGia(_maDocGia: Int, _hoTen: String) {
    var maDocGia: Int = _maDocGia
    var hoTen: String = _hoTen

    open fun NhapThongTin() {
        print("Nhập mã độc giả: ")
        maDocGia = readLine()!!.toInt()
        print("Nhập họ tên: ")
        hoTen = readLine()!!
    }

    open fun xuatThongTin() {
        println("Ma doc gia: $maDocGia")
        println("Ho ten: $hoTen")
    }
}

class DocGiaThuong(_maDocGia: Int, _hoTen: String, _ngayHetHan: String, _gioiTinh: String, _soSachMuon: Int) : DocGia(_maDocGia, _hoTen) {
    var ngayHetHan: String = _ngayHetHan
    var gioiTinh: String = _gioiTinh
    var soSachMuon: Int = _soSachMuon

    constructor() : this(0, "", "", "", 0)
    constructor(_maDocGia: Int, _hoTen: String) : this(_maDocGia, _hoTen, "", "", 0)
    constructor(_maDocGia: Int, _hoTen: String, _ngayHetHan: String, _gioiTinh: String) : this(_maDocGia, _hoTen, _ngayHetHan, _gioiTinh, 0)
    constructor(_maDocGia: Int, _hoTen: String, _soSachMuon: Int) : this(_maDocGia, _hoTen, "", "", _soSachMuon)

    fun nhapThongTin() {
        super.NhapThongTin()
        print("Nhập ngày hết hạn: ")
        ngayHetHan = readLine()!!
        print("Nhập giới tính: ")
        gioiTinh = readLine()!!
        print("Nhập số sách mượn: ")
        soSachMuon = readLine()!!.toInt()
    }

    fun lePhi() {
        println("Lệ phí: ${soSachMuon * 5000}")
    }

    override fun xuatThongTin() {
        super.xuatThongTin()
        println("Ngày hết hạn: $ngayHetHan")
        println("Giới tính: $gioiTinh")
        println("Số sách mượn: $soSachMuon")
    }
}

class DocGiaVip(_maDocGia: Int, _hoTen: String, _ngayHetHan: String, _gioiTinh: String) : DocGia(_maDocGia, _hoTen) {
    var ngayHetHan: String = _ngayHetHan
    var gioiTinh: String = _gioiTinh

    constructor() : this(0, "", "", "")
    constructor(_maDocGia: Int, _hoTen: String) : this(_maDocGia, _hoTen, "", "")
    constructor(_maDocGia: Int, _hoTen: String, _gioiTinh: String) : this(_maDocGia, _hoTen, "", _gioiTinh)

    fun nhapThongTin() {
        super.NhapThongTin()
        print("Nhập ngày hết hạn: ")
        ngayHetHan = readLine()!!
        print("Nhập giới tính: ")
        gioiTinh = readLine()!!
    }

    fun lePhi() {
        println("Lệ phí: 50000")
    }

    override fun xuatThongTin() {
        super.xuatThongTin()
        println("Ngày hết hạn: $ngayHetHan")
        println("Giới tính: $gioiTinh")
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

    var docgia1: DocGiaThuong = DocGiaThuong(1, "Nguyen Van A", "01/01/2021", "Nam", 3)
    var docgia2: DocGiaVip = DocGiaVip(2, "Nguyen Van B", "01/01/2021", "Nam")
    var docgia3 = DocGiaThuong()
    var docgia4 = DocGiaVip()

    docgia1.xuatThongTin()
    docgia1.lePhi()
    docgia2.xuatThongTin()
    docgia2.lePhi()
    docgia3.nhapThongTin()
    docgia3.xuatThongTin()
    docgia3.lePhi()
    docgia4.nhapThongTin()
    docgia4.xuatThongTin()
    docgia4.lePhi()
    


}
