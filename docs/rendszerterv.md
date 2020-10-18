# Rendszerterv
### 1.0 A rendszer célja
Célunk egy olyan mobilos applikáció létrehozása, aminek segítségével nyomon tudjuk követni a Covid-19 terjedését a világ minden országában. Az applikáció naprakész adatokat szolgáltat a kialakult vírushelyzettel kapcsolatban. Könnyedén nyomonkövethetjük, az új esetek számát, halálesetek számát, összesen igazolt fertőzöttek számát. Mindezt gráfok és térkép nézet segítségével tesszük még szemléletesebbé.

### 2.0 Projekt terv
**2.1** Projekt szerepkörök felelősségek:
    + **2.1.1** Látványtervek kifejlesztése és létrehozása.
    + **2.1.2** Backend rendszer megtervezése és létrehozása.
    + **2.1.3** Frontend rendszer megtervezése és létrehozása.
    + **2.1.4** Unit és integrálási tesztek létrehozása és végrehajtása.
    + **2.1.4** DevOps feladatok kivitelezése és oldal szolgáltatás publikációja.

+ **2.2** Projekt munkások és felelősségeik:

+ **2.3** Mérföldkövek és ütemterv:
    - ***2.3.1** Rendszerhez tartozó látványtervek létrehozása. →*
    - ***2.3.2** Látványtervek lefejlesztése statikus erőforrásokra. →*
    - ***2.3.3** Frontend komponensek megtervezése. →*
    - ***2.3.4** Frontend komponensek lefejlesztése.→*
    - ***2.3.5** Backend logika létrehozása. →*
    - ***2.3.6** Unittestek létrehozása és tesztek végrehajtása. →*
    - ***2.3.7** Bug keresése és kód refaktoriálása, ha szükséges. →*
    - ***2.3.8** Applikáció konténer létrehozása és locálist tesztelése. →*
    - ***2.3.9** Szolgáltatás publikációja. →*
    
### 3.0 Üzleti folyamatok modellje
- A jelenlegi pandémiás helyzet alatt, a 
    [COVID SARS-2](https://hu.wikipedia.org/wiki/SARS-CoV-2) emberek ezreit fertőzi meg naponta. Fontos, a vírus elkerülése érdekében, hogy mindenki naprakész és tájékozott
    legyen az aktuális megfertőződések, halálesetek, kigyógyulások, napi-, heti- vagy akár összes előfordulások számaival. __*Honnan szerezhetünk ezekről az információkról tudomást?*__
    A híradóból, a rádióból, vagy ha az interneten utánakeresünk. Ezek a módszerek, hírfolyamok nem elég gyorsak, nem elég FRISSEK.
    
### 4.0 Követelmények
- __4.1__ Egyszerű felület
  - __4.1.1__ RecyclerView adapter adaptálja a RecyclerViewban a HTTP válaszban érkező adatokat,
  a keresési mezőbe beírt országhoz megfelelően.
  - __4.1.2__ Csak egy keresőmező a kezdőképernyőn megjelenő UI -> átláthatóság.
- __4.2__ Könnyed keresés:
  - __4.2.3__ Keresés előtt a jelenlegi tartózkodási helyhez kapcsolódó adatok mutatása,
ha be van kapcsolva a helymeghatározás.
  - __4.2.2__ Kereső mezőbe való gépelés közben debouncing alkalmazása -> 0.5s.
  

- __4.3__ Verziófüggetlenség
  - __4.3.1__ Android 21 API-ig bármilyen androidos telefonon futtatható.
- __4.4__ Valós idejű adatok szolgáltatása HTTP protokollon keresztül
  - __4.4.1__ Retrofit és a Moshi gondoskodik a HTTP lekérdezéseinkről, valamin az abből kapott JSON adatformátumú adatok appunkba való adaptálásáról.

- __4.5__ Az alapvető biztonsági protokollok.
  - __4.5.1__ API kulcs elrejtése a buildconfig-ban
