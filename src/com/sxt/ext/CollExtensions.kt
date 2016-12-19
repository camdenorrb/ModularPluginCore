package com.sxt.ext

fun <E> MutableCollection<E>.add(vararg elements: E) {
    elements.forEach { this.add(it) }
}