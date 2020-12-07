# Tesztjegyzőkönyv

Tesztelendő program
-------------------
**com.null.covid19_tracker** nevű android alkalmazás

Tesztelési környezet
--------------------

Mivel android alkalmazásról van szó ezért unit és integration tesztek kevesebbek, mint a manuális tesztek száma. Mivel java / kotlin / android környezetre nincs automatizált screen propagation / gesture propagation alkalmazás / könyvtár ezért a további teszteket saját kezüleg kell elvégezni.


Tesztelés tárgya
----------------

Alkalmazás megfeleől működése, backend és 'frontend' meglefelő szinkronizációja és kapott adatok, rendses feldolgozása és megjelenítése.

Tesztelés célja
---------------

Rossz funkcionalitás, esetleges rossz kalkuláció, route és logic hiba kiszűrése.

Backend postman-es tesztelése
-----------------------------
Postman API request tesztelőt a következő linken lehet letölteni: [Postman](https://www.postman.com/)


![Backend Test](img/Screenshot-20201207090156-1637x401.png)
![Backend Test](img/2.png)
![Backend Test](img/3.png)
![Backend Test](img/4.png)
![Backend Test](img/5.png)



Tesztelők
---------

#### Raska Gergely
**Unit és integration tesztek**

- Teszt 1: MainActivity.kt renszeresen frissít-e a megfelelő adatokkal.
- Teszt 2: MapActivity.kt körök nagysága megfelelő-e
- Teszt 3: Api Response tesztek
- Teszt 4: Data classok helyes működése
- Teszt 5: Response seriazizer tesztelése
- Teszt 6: Data processor helyes működése
- Teszt 7: Activity Logic működése
- Teszt 8: Fragmentek követiek e a megadott ligkát
- Teszt 9: Android verzió támogatási teszt

#### Mester Ákos
**Unit és integration tesztek**

- Teszt 1: MainActivity.kt renszeresen frissít-e a megfelelő adatokkal.
- Teszt 2: MapActivity.kt körök nagysága megfelelő-e
- Teszt 3: Api Response tesztek
- Teszt 4: Data classok helyes működése
- Teszt 5: Response seriazizer tesztelése
- Teszt 6: Data processor helyes működése
- Teszt 7: Activity Logic működése
- Teszt 8: Fragment view működése
- Teszt 9: Fragmentek követiek e a megadott ligkát

#### Boda Zsolt
**Unit és Manuális tesztek**

- Teszt 1: MainActivity.kt renszeresen frissít-e a megfelelő adatokkal.
- Teszt 2: MapActivity.kt körök nagysága megfelelő-e
- Teszt 3: Gesture libarray helyes működése
- Teszt 4: Networking helyes működése
- Teszt 5: Permisson managger helyes működése
- Teszt 6: Reszponzivitási tesztek
- Teszt 7: Manuális platform tesztek
- Teszt 8: Android verzió támogatási teszt
- Teszt 9: Kpernyő nagyság szerinti manuálist tesztelés

Összefoglalás
-------------
Az alkalmazás a felsorolt teszteken átment gond nélkül, kivéve a következőn, ami a mi oldalunkról nem javítható: Android v.11 Queen Cake verzión az alkalmazás összeomlik view / activity váltásnál. Ez az ahozz kiadott android API hibája, ami nem a mi oldalunkon törik el, így nem tudunk ezzel mit tenni és nem is tudunk rajta körbemenni. A kotlin jvm pluginok miatt, a különböző android verziókra való build manuálisan szükséges.