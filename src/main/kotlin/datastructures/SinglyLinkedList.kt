package datastructures

import interfaces.LinkedList

class SinglyLinkedList<T> : LinkedList<T> {

    private var size = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    inner class Node<T>(val data: T, var next: Node<T>? = null)

    override fun isEmpty() = (head == null)
    override fun size() = size
    override fun getFirst() = head?.data
    override fun getLast() = tail?.data

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun addFirst(data: T) {
        val newNode = Node(data)
        if (isEmpty()) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        size++
    }

    override fun addLast(data: T) {
        val newNode = Node(data)
        if (isEmpty()) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        size++
    }

    override fun removeFirst() {
        if (!isEmpty()) {
            if (size == 1) {
                head = null
                tail = null
            } else {
                head = head?.next
            }
            size--
        }
    }

    override fun removeLast() {
        if (!isEmpty()) {
            if (size == 1) {
                head = null
                tail = null
            } else {
                var current = head
                var prev: Node<T>? = null
                while (current?.next != null) {
                    prev = current
                    current = current.next
                }
                prev?.next = null
                tail = prev
            }
            size--
        }
    }

    override fun toString(): String {
        var string = ""
        var current = head
        while (current != null) {
            string += "${current.data}\n"
            current = current.next
        }
        return string
    }
}