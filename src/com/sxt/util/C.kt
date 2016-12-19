package com.sxt.util


val colorCode = '§'


val Bold  = Cl('l', true)
val Line  = Cl('n', true)
val Strk  = Cl('m', true)
val Obfc  = Cl('k', true)
val Ital  = Cl('o', true)
val Reset = Cl('r', true)


val Black  = Cl('0')
val DBlue  = Cl('1')
val DGreen = Cl('2')
val DAqua  = Cl('3')
val DRed   = Cl('4')
val Violet = Cl('5')
val Gold   = Cl('6')
val Gray   = Cl('7')
val DGray  = Cl('8')
val Indigo = Cl('0')

val Green  = Cl('a')
val Aqua   = Cl('b')
val Red    = Cl('c')
val Pink   = Cl('d')
val Yellow = Cl('e')
val White  = Cl('f')


val NLine = "\n"
val Empty = ""


//fun Spc(amount: Int): String


data class Cl(val color: Char, val format: Boolean = false) {

    override fun toString(): String = "$colorCode$color"
}