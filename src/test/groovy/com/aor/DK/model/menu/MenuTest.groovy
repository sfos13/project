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

    def 'Testing menu win'(){
        when:
        def menu = new Menu("Win")
        then:
        menu.getNumberEntries() == 2
        menu.getMessage() == "Congratulations! You won the game!"
    }

    def 'Testing menu lost'(){
        when:
        def menu = new Menu("Lost")
        then:
        menu.getNumberEntries() == 3
        menu.getMessage() == "Try again! Its just a Donkey Kong"
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
        def menu = new Menu("Win")
        when:
        menu.nextEntry()
        then:
        menu.isSelected_Number(1)
    }

        def 'Testing next entry to 0'(){
            given:
            def menu = new Menu("Win")
            when:
            menu.nextEntry()
            menu.nextEntry()
            then:
            menu.isSelected_Number(0)
    }

    def 'Testing previous entry'(){
        given:
        def menu = new Menu("Win")
        when:
        menu.previousEntry()
        then:
        menu.isSelected_Number(1)
    }

    def 'Testing previous entry to 0'(){
        given:
        def menu = new Menu("Win")
        when:
        menu.previousEntry()
        menu.previousEntry()
        then:
        menu.isSelected_Number(0)
    }

    def 'Testing get entry'(){
        given:
        def menu = new Menu("Win")
        when:
        def entry = menu.getEntry(0)
        then:
        entry == "Play again?"
    }

    def 'Testing is selected String'(){
        given:
        def menu = new Menu("Win")
        expect:
        menu.isSelected_String("Play again?")
    }

    def 'Testing get message / get Mod'(){
        given:
        def menu = new Menu("Win")
        expect:
        menu.getMessage() == "Congratulations! You won the game!"
        menu.getMod() == "Win"
    }




}
