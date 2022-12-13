package com.aor.DK.model.menu

import spock.lang.Specification

class MenuTest extends Specification{

    def 'Testing menu start'(){
        when:
        def menu = new Menu("Start")
        then:
        menu.getNumberEntries() == 4
        menu.getMessage() == "Donkey Kong"
    }


    def 'Testing menu instructions'(){
        when:
        def menu = new Menu("Instructions")
        then:
        menu.getNumberEntries() == 2
        menu.getMessage() == "Instructions"
    }

    def 'Testing next entry'() {
        given:
        def menu = new Menu("Instructions")
        when:
        menu.nextEntry()
        then:
        menu.isSelected_Number(1)
    }

        def 'Testing next entry to 0'(){
            given:
            def menu = new Menu("Instructions")
            when:
            menu.nextEntry()
            menu.nextEntry()
            then:
            menu.isSelected_Number(0)
    }

    def 'Testing previous entry'(){
        given:
        def menu = new Menu("Instructions")
        when:
        menu.previousEntry()
        then:
        menu.isSelected_Number(1)
    }

    def 'Testing previous entry to 0'(){
        given:
        def menu = new Menu("Instructions")
        when:
        menu.previousEntry()
        menu.previousEntry()
        then:
        menu.isSelected_Number(0)
    }

    def 'Testing get entry'(){
        given:
        def menu = new Menu("Instructions")
        when:
        def entry = menu.getEntry(0)
        then:
        entry == "Start"
    }

    def 'Testing is selected String'(){
        given:
        def menu = new Menu("Instructions")
        expect:
        menu.isSelected_String("Start")
    }

    def 'Testing get message / get Mod'(){
        given:
        def menu = new Menu("Instructions")
        expect:
        menu.getMessage() == "Instructions"
        menu.getMod() == "Instructions"
    }




}
