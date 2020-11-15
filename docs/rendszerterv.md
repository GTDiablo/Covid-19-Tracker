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

### 5.0 Funkcionális terv
- Rendszer szereplők:
  - Felhasználó
- Menü-hierarchiák:
  - Dashboard
    - Keresés -> Ország kiválasztása.
    - Details:
      - Részletezett adatok szolgáltatása
  - Map:
    - Covid térkép súlyozott megjelenítése, fertőzöttek alapján.
  - Covid-Test:
    - Result:
      - Start-State
      - Test
      - Result State

### 6.0 Fizikai környezet
- Operációs rendszer:
    - Windows 10
    - Ubuntu 20.04.1         
- Fejlesztő eszközök:
    - Android Studio
- Programozási nyelv:
    - Kotlin    
- Keretrendszer:
    - Gradle
    - Retrofit
    - Moshi
    - Retrofit-Moshi adapter
 - Felhasznált API-k:
    - [Coronavirus COVID19 API](https://documenter.getpostman.com/view/10808728/SzS8rjbc)
 - Cél platform:
    - Android 10 és újabb verziók


### Absztrak domain modell
Alkalmazásunk a MVC architekturális modell-t fogja használni. Ami nem más mint a Modell-nézet-vezérlő programtervezési minta.

Jelenlegi fellálás:
- Backend szerverünk, egy kiszervezett, külön karbantartott és frissített különállú alkalmazás. Innen kapjuk a működéshez szükséges modelleket és adatokat.
- Java / Kotlin alkalmazásunk a controller, hisz ez dolgozza fel a kapott modelleket és kezeli a logikát.
- Az android beépített UI könyvtára segítségével jelenítünk meg dolgokat vagy éppen animálunk és a nézetek közt váltunk.

### Architekturális terv
Az alkalmazásunk az MVC architekturális, tervezési mintát használja. Emiatt az alkalmazásunk könnyen bővíthető változtatható, mivel az alkalmazás különböző rétegei jól el vannak különítve.


### Implementációs terv
- **DashboardFragment.kt** - Ez a UI vezérlő felelős a dashboard logikáért, az azon megjelenített view kezelésért és irányításárért.
- **MapFragment.kt** - A map nézet eloszlását és view irányításáért szolgál. Ez egy nagy processt ellátó fragment.
- **DetailFragment.kt** - A Dashboard után ide jutunk el a felkeresett ország adataival és itt dolgozódik fel minden.
- **CountryResponseApi.kt** - A fő backend endpoint API kérésével foglalkozó processzor.
- **CountryResponse.kt** - Adat model.

### Tesztterv
- A backend API végpontjai ki vannak szervezve ezért ezt nem kell nekünk külön tesztelni.
- A modell és API response classok a java beépített teszt könyvtárával lehet ellenőrizni.
- Minden UI elemet és navigációs proceszt kézzel, emberi forrással kell tesztelni.
- Keresési view beírásnál helyesen adja e vissza az ertékeket.
- A dashboard megkapja és feldolgozza e az initial adatokat.
- A lekért modellek megfelelnek e a backend modellekkel.
- Detail view megkapja e a lekért és kijelölt adatokat.
- A detail view feldogozza rendesen e a gráf adatokat.
- A detail view megjelenít e mindent fragmentet amit megkapott.
  
### Telepítési terv
A telepítéshez a következőknek kell meglennie:
- Android operációs rendszerrel rendelkező készülék.
- Android verziónak 7.0 vagy újabbnak kell lennie.
- Internet elérés
- Google Play store hozzáférés.
- Elegendő tárhely a készüléken.
- Minimum 256mb memória megléte.

### Karbantartási terv
Mivel nekünk csak a controller és view részével kell foglalkoznunk ezért logikai és kinézeti komponenseket könnyen lehet frissíteni, és akár többet hozzáadni. Az android ui framework-je elegendő forrást tár elénk, hogy minden új dolgot létre tudjunk hozni.