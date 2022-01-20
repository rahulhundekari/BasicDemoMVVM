package com.example.demoapp.network

import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlType

//@XmlType(propOrder = ["ItemCount", "Item"])
//data class ListOfItems(@XmlElement val Item: List<Item>?, @XmlElement val ItemCount: Int?)

@Root(name = "Item", strict = false)
@Path("ListOfItems")
data class Item @JvmOverloads constructor(
    @param:Element(name = "HasPod", required = false)
    @get:Element(name = "HasPod", required = false)
    val HasPod: String?,

    @param:Element(name = "StationMime", required = false)
    @get:Element(name = "StationMime", required = false)
    val StationMime: String?,

    @param:Element(name = "ItemType", required = false)
    @get:Element(name = "ItemType", required = false)
    val ItemType: String?,

    @param:Element(name = "StationUrl", required = false)
    @get:Element(name = "StationUrl", required = false)
    val StationUrl: String?,

    @param:Element(name = "SimF", required = false)
    @get:Element(name = "SimF", required = false)
    val SimF: String?,

    @param:Element(name = "Band", required = false)
    @get:Element(name = "Band", required = false)
    val Band: String?,

    @param:Element(name = "SocialTw", required = false)
    @get:Element(name = "SocialTw", required = false)
    val SocialTw: String?,

    @param:Element(name = "IconFormat", required = false)
    @get:Element(name = "IconFormat", required = false)
    val IconFormat: String?,

    @param:Element(name = "O", required = false)
    @get:Element(name = "O", required = false)
    val O: String?,

    @param:Element(name = "StationName", required = false)
    @get:Element(name = "StationName", required = false)
    val StationName: String?,

    @param:Element(name = "SocialFb", required = false)
    @get:Element(name = "SocialFb", required = false)
    val SocialFb: String?,

    @param:Element(name = "HasSchedule", required = false)
    @get:Element(name = "HasSchedule", required = false)
    val HasSchedule: String?,

    @param:Element(name = "StationLocation", required = false)
    @get:Element(name = "StationLocation", required = false)
    val StationLocation: String?,

    @param:Element(name = "Lcov", required = false)
    @get:Element(name = "Lcov", required = false)
    val Lcov: String?,

    @param:Element(name = "LogoPl", required = false)
    @get:Element(name = "LogoPl", required = false)
    val LogoPl: String?,

    @param:Element(name = "Relia", required = false)
    @get:Element(name = "Relia", required = false)
    val Relia: String?,

    @param:Element(name = "StationFormat", required = false)
    @get:Element(name = "StationFormat", required = false)
    val StationFormat: String?,

    @param:Element(name = "StationBandWidth", required = false)
    @get:Element(name = "StationBandWidth", required = false)
    val StationBandWidth: String?,

    @param:Element(name = "HURL", required = false)
    @get:Element(name = "HURL", required = false)
    val HURL: String?,

    @param:Element(name = "Lang", required = false)
    @get:Element(name = "Lang", required = false)
    val Lang: String?,

    @param:Element(name = "Sound", required = false)
    @get:Element(name = "Sound", required = false)
    val Sound: String?,

    @param:Element(name = "HasNet", required = false)
    @get:Element(name = "HasNet", required = false)
    val HasNet: String?,

    @param:Element(name = "StationId", required = false)
    @get:Element(name = "StationId", required = false)
    val StationId: String?,

    @param:Element(name = "IconLocation", required = false)
    @get:Element(name = "IconLocation", required = false)
    val IconLocation: String?,

    @param:Element(name = "StationDesc", required = false)
    @get:Element(name = "StationDesc", required = false)
    val StationDesc: String?,

    @param:Element(name = "Logo", required = false)
    @get:Element(name = "Logo", required = false)
    val Logo: String?,

    @param:Element(name = "Bookmark", required = false)
    @get:Element(name = "Bookmark", required = false)
    val Bookmark: String?,

    @param:Element(name = "Freq", required = false)
    @get:Element(name = "Freq", required = false)
    val Freq: String?,

    @param:Element(name = "IconLang", required = false)
    @get:Element(name = "IconLang", required = false)
    val IconLang: String?
)

