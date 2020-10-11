# 1. Jelenlegi helyzet leírása
2019 decemberének végén a kínai Vuhanban megmagyarázhatatlan vírusos tüdőgyulladásos megbetegedések történtek. Ez a 2019 végén megjelent koronavírusos betegség később COVID–19 néven vált ismertté, és egy új világjárvány kezdetét jelentette, amelyet egy új ismeretlen kórokozó okozott, az új humán koronavírus (SARS-CoV-2). 

A WHO célja az volt, hogy a kínai Vuhan város, ahol az első megbetegedés történt, a stigmát elkerülje, ezért 2020. február 11-én az NCP-nek (Novel Coronavirus Pneumonia) nevezett betegség új nevet kapott COVID-19 (Corona Virus Disease), és az ideiglenes 2019-nCoV koronavírus nevet SARS-CoV-2 (Severe Acute Respiratory Syndrome coronavirus 2) névre változtatta. 

Ugyanakkor dr. Tedrosz Adamon Gebrejeszusz, az Egészségügyi Világszervezet (WHO) elnöke felszólította a világot, hogy a lehető leginkább agresszív módon küzdjön meg az új vírussal, mert még mindig reális esély van a COVID–19 betegség visszaszorítására, ha elegendő forrást fordítanak a harcra.[40] Február 24-én a főigazgató már „nagyon aggasztónak” nevezte az új megbetegedések számának növekedését Olaszországban, Dél-Koreában és Iránban,[41] de kijelentette, hogy nincs még pandémiának nevezhető helyzet.

Nancy Messonnier, a CDC igazgatója azt közölte február 25-én, hogy a 2019-es koronavírus-betegség (COVID–19) széles körű terjedése az Egyesült Államokban még nem történt meg, de csak idő kérdése, hogy megvalósul. A COVID–19 járvány már két olyan kritériumnak is megfelel, ami alapján pandémiának kell besorolni.

2020. március 11-én a WHO világjárvánnyá, pandémiává nyilvánította a COVID–19 koronavírus-járványt. Március 25-én a WHO vezetője, Tedrosz Adamon Gebrejeszusz kijelentette, hogy „egy hónappal, két hónappal ezelőtt lett volna itt a cselekvés ideje”.

Jelenleg a fertőzöttek száma megközelíti a 38 milliót, több, mint 1 millióan vesztették életüket, 28 millióan pedig már meggyógyultak.

A fertőzés a világ minden országában megjelent már. A helyzet súlyossága, az új fertőzések száma jelen pillanatban a világszerte növekszik. Ebből az okból kifolyólag szeretnénk létrehozni egy olyan applikációt, amivel nyomon lehet követni a járvány terjedését. Az applikáció rendelkezni fog majd adattal a világ minden országáról, így segítségével naprakészek lehetünk.

# 2. Vágyálomrendszer leírása
Célunk egy olyan mobilos applikáció létrehozása, amivel nyomon tudjuk követni a Covid-19 adatokat világszerte, így naprakészek tudunk lenni az aktuális helyzettel kapcsolatban. Az applikáció adatot fog majd szolgáltatni az új fertőzöttek számáról, az eddig azonosított esetek számáról, a halálesetek számáról, a meggyógyultak számáról napi felosztásban és összesen is. Minden adathoz nagyon könnyen férhetünk majd hozzá egy egyszerű és átlátható UI-n keresztül.

# 3. Használati esetek
- __3.1__ Day One: Egy adott országban az első naptól eltelt *MINDEN NAP* napi adatai.
- __3.2__ By Country: Egy adott országban az eddigi összes adat két dátum között.
- __3.3__ Summary: Az összes adat a COVID elterjedése óta, összes ország összegezve.
- __3.4__ Countries: Az összes ország kilistázása, mely szerepel az adatbázisban.

# 4. Jelenlegi üzleti folyamatok modellje
- A jelenlegi pandémiás helyzet alatt, a 
    [COVID SARS-2](https://hu.wikipedia.org/wiki/SARS-CoV-2) emberek ezreit fertőzi meg naponta. Fontos, a vírus elkerülése érdekében, hogy mindenki naprakész és tájékozott
    legyen az aktuális megfertőződések, halálesetek, kigyógyulások, napi-, heti- vagy akár összes előfordulások számaival. __*Honnan szerezhetünk ezekről az információkról tudomást?*__
    A híradóból, a rádióból, vagy ha az interneten utánakeresünk. Ezek a módszerek, hírfolyamok nem elég gyorsak, nem elég FRISSEK és nem elég közvetlenek.

# 5. Igényelt üzleti folyamatok modellje
- Ezeket az információs csatornákat váltja le az applikációnk, mely __*gyorsabb*__ és __*állandóan frissülő*__ információval látja el felhasználóit.
- Az időhöz kötött információszerzést (TV,rádió), felváltja az azonnali információ.
- Mivel a telefon manapság már munka és tanulóeszköz ezért sokkal közvetlenebb és gyorsabb
  módja az adatszerzésnek.
- Egy keresőmező segítségével bármely ország részletes adatait le tudjuk kérdezni.
- A TV-ben, rádióban halott információ nem elég részletes. Appunk erről is gondoskodik, hiszen, ha a feljegyzett információk mindegyikével nem is de a legnagyobb részéről tartalmaz információt.


# 6. Követelménylista
- __6.1__ Egyszerű felület
  - __6.1.1__ RecyclerView adapter adaptálja a RecyclerViewban a HTTP válaszban érkező adatokat,
  a keresési mezőbe beírt országhoz megfelelően.
  - __6.1.2__ Csak egy keresőmező a kezdőképernyőn megjelenő UI -> átláthatóság.
- __6.2__ Könnyed keresés:
  - __6.2.3__ Keresés előtt a jelenlegi tartózkodási helyhez kapcsolódó adatok mutatása,
ha be van kapcsolva a helymeghatározás.
  - __6.2.2__ Kereső mezőbe való gépelés közben debouncing alkalmazása -> 0.5s.
  

- __6.3__ Verziófüggetlenség
  - __6.3.1__ Android 21 API-ig bármilyen androidos telefonon futtatható.
- __6.4__ Valós idejű adatok szolgáltatása HTTP protokollon keresztül
  - __6.4.1__ Retrofit és a Moshi gondoskodik a HTTP lekérdezéseinkről, valamin az abből kapott JSON adatformátumú adatok appunkba való adaptálásáról.

- __6.5__ Az alapvető biztonsági protokollok.
  - __6.5.1__ API kulcs elrejtése a buildconfig-ban

# 8. Képernyőtervek
- __8.1__ 0. Fragment : https://www.figma.com/file/U9TEmGe0kFJ0tU4DvgLXtq/Covid-19-Tracker?node-id=11%3A18
- __8.2__ 1. Fragment : https://www.figma.com/file/U9TEmGe0kFJ0tU4DvgLXtq/Covid-19-Tracker?node-id=11%3A22
- __8.3__ 2. Fragment : https://www.figma.com/file/U9TEmGe0kFJ0tU4DvgLXtq/Covid-19-Tracker?node-id=11%3A25

