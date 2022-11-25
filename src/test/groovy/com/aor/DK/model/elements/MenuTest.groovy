package com.aor.DK.model.elements

import com.aor.DK.model.menu.Menu
import spock.lang.Specification

class MenuTest extends Specification{

    def 'get Menu message'(){
        given:
        def entries = new ArrayList<String>()
        def message = new String("Test")
        def menu = new Menu(entries,message)
        when:
        def a1 = menu.getMessage()
        then:
        a1 == "Test"
    }

    def 'get next entry'(){
        given:
        def entries = new ArrayList<String>()
        entries.add("Element")
        entries.add("Element2")
        def message = new String("Test")
        def menu = new Menu(entries,message)
        when:
        menu.nextEntry()
        then:
        menu.getCurrentEntry() == 1
        when:
        menu.nextEntry()
        then:
        menu.getCurrentEntry() == 0
    }

    def 'get prev entry'(){
        given:
        def entries = new ArrayList<String>()
        entries.add("Element")
        entries.add("Element2")
        def message = new String("Test")
        def menu = new Menu(entries,message)
        when:
        menu.previousEntry()
        then:
        menu.getCurrentEntry() == 1
        when:
        menu.previousEntry()
        then:
        menu.getCurrentEntry() == 0
    }

    def 'get entry' () {
        def entries = new ArrayList<String>()
        entries.add("Element")
        entries.add("Element2")
        def message = new String("Test")
        def menu = new Menu(entries,message)
        when:
        def a1 = menu.getEntry(0).toString()
        then:
        a1 == "Element"
    }

    def 'test isSelected method'() {
        given:
        def entries = new ArrayList<String>()
        entries.add("Element")
        entries.add("Element2")
        def message = new String("Test")
        def menu = new Menu(entries, message)
        when:
        def a1 = menu.isSelected(0)
        then:
        a1
    }

    def 'test isSelectedExit method'() {
        given:
        def entries = new ArrayList<String>()
        entries.add("Start")
        entries.add("Exit")
        def message = new String("Test")
        def menu = new Menu(entries, message)
        when:
        menu.nextEntry()
        def a1 = menu.isSelectedExit()
        then:
        a1
    }

    def 'test isSelectedStart method'() {
        given:
        def entries = new ArrayList<String>()
        entries.add("Start")
        entries.add("Exit")
        def message = new String("Test")
        def menu = new Menu(entries, message)
        when:
        def a1 = menu.isSelectedStart()
        then:
        a1
    }

    def 'test getNumber entries method'() {
        given:
        def entries = new ArrayList<String>()
        entries.add("Start")
        entries.add("Exit")
        def message = new String("Test")
        def menu = new Menu(entries, message)
        when:
        def a1 = menu.getNumberEntries()
        then:
        a1 == 2
    }





}
