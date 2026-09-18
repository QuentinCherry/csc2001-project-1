# Journal
## Initial Steps (Monday/Wed)
Started by implementing [Session](src/main/java/Session.java) and [SessionList](src/main/java/SessionList.java)
## Session
Was a very simple record class, containing all required fields and a custom toString.
## SessionList
This one was slightly harder, but started by writing out functions I thought i'd need and making helpers for them
These included:
- getSession(index)
- len()
- append(Session) <- this was the reason I used a standard class instead of a record

Helpers included:
- idIndex(id) <- linear search algorythm to find the index of a given id

## MainGUI
Implemented most simple TODOs in MainGUI

## Friday's work
Reformatted several methods I caught as O(n^2) to be O(n)
Implemented session Removal
Implemented participant addition, also changed session class to include current participants because i didnt realize it needed it

Fixed several critical logic bugs in SessionList methods
Existing code works as expected now!

Is the journal supposed to emulate commit messages?

Now implemented searching functions, They already existed as helpers I just needed to call them

Implemented searchByMentor in SessionList

Added a checkInputs method that verifys all information entered is valid, called in append()
