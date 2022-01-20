package com.example.demoapp.network

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name = "ListOfItems", strict = false)
data class ApiResponse @JvmOverloads constructor(
    @param:Element(name = "ItemCount")
    @get:Element(name = "ItemCount")
    val ItemCount: Int?,
    @param:ElementList(name = "Item", inline = true)
    @get:ElementList(name = "Item", inline = true)
    val Item: List<Item>?
)
