package com.github.bassaer.chatmessageview.util


import com.github.bassaer.chatmessageview.models.Message
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

/**
 * <p>MessageDateComparator Test</p>
 * Created by nakayama on 2017/11/11.
 */
internal class MessageDateComparatorTest {
    private val newMessage = Message()
    private val oldMessage = Message()

    private val newCalendar = Calendar.getInstance()
    private val oldCalendar = Calendar.getInstance()

    private val messageDateComparator = MessageDateComparator()

    @Test
    fun compareDifferentDays() {
        newCalendar.set(2017, 10, 11)
        oldCalendar.set(2017, 10, 12)
        newMessage.createdAt = newCalendar
        oldMessage.createdAt = oldCalendar
        assertEquals(messageDateComparator.compare(newMessage, oldMessage), -1)
        newCalendar.set(2017, 10, 11)
        oldCalendar.set(2017, 9, 12)
        newMessage.createdAt = newCalendar
        oldMessage.createdAt = oldCalendar
        assertEquals(messageDateComparator.compare(newMessage, oldMessage), 1)
    }

    @Test
    fun compareSameDaysDifferentHour() {
        newCalendar.set(2017, 10, 11, 10,1)
        oldCalendar.set(2017, 10, 11, 22,1)
        newMessage.createdAt = newCalendar
        oldMessage.createdAt = oldCalendar
        assertEquals(messageDateComparator.compare(newMessage, oldMessage), -1)
        newCalendar.set(2017, 10, 11, 23,2)
        oldCalendar.set(2017, 10, 11, 23,1)
        newMessage.createdAt = newCalendar
        oldMessage.createdAt = oldCalendar
        assertEquals(messageDateComparator.compare(newMessage, oldMessage), 1)
    }


    @Test
    fun compareSameDaySameHour() {
        newCalendar.set(2017, 10, 10, 20,45)
        oldCalendar.set(2017, 10, 10,20,45)
        newMessage.createdAt = newCalendar
        oldMessage.createdAt = oldCalendar
        assertEquals(messageDateComparator.compare(newMessage, oldMessage), 0)
    }

}