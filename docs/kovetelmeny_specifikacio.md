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

# 3. Rendszerre vonatkozó pályázat/törvények/rendeletek/szabványok és ajánlások
- **3.1** Törvények és Rendeletek:
  - Felhasználói adatokra vonatkozó törvények:
    - [https://europa.eu/youreurope/citizens/consumers/internet-telecoms/data-protection-online-privacy/index_hu.htm](https://europa.eu/youreurope/citizens/consumers/internet-telecoms/data-protection-online-privacy/index_hu.htm)
  - Appunkra egy meghatározó európai vagy más országbeli törvény sem érvényes. Általában egyes országok megszabják, hogy az oldal, valamint az azt üzemeltető cég mit csinálhat és mit nem csinálhat a felhasználóktól gyűjtött adatokkal. Szolgáltatásunk felsoroltak közül egy módszert sem alkalmaz:
    - *Nem tárolunk adatokat a felhasználóink oldalán (legyen az böngésző vagy gép).*
    - *Nem használunk sütiket vagy más felhasználókövető eszközt.*
    - *Nem naplózunk semmit az oldalon történő tevékenységek közül.*
- **3.2** Szabványok:
  - HTTP (protocol) - A HTTP (HyperText Transfer Protocol) egy információátviteli protokoll elosztott, kollaboratív, hipermédiás, információs rendszerekhez. A HTTP fejlesztését a World Wide Web Consortium és az Internet Engineering Task Force koordinálta RFC-k formájában. Az 1999-ben kiadott RFC 2616 definiálja a HTTP/1.1-et, amit 2015 végére leváltott a HTTP/2.0-ás verzió, amit az RFC 7540 definiál. Hivatalosan ez a legújabb protokoll. A HTTP egy kérés-válasz alapú protokoll kliens és szerver között. A HTTP-klienseket a „user agent” gyűjtőnévvel is szokták illetni. A user agent jellemzően, de nem feltétlenül webböngésző.A HTTP a TCP/IP réteg felett helyezkedik el. A HTTP implementálható más megbízható szállítási réteg felett is, akár az interneten, akár más hálózaton. Kizárólagosan TCP protokollt használ, mivel az adatveszteség nem megengedhető.
  - [SSL](https://developer.android.com/training/articles/security-ssl) - Az SSL tanúsítványok arra szolgálnak, hogy létrejöhessen egy biztonságos, titkosított csatorna a kliens és a szerver között. Bizonyos információknak, mint a hitelkártya adatok, fiókbelépéshez szükséges adatok és egyéb kényes információk átvitelének titkosítás alatt kell történnie, hogy kizárjuk az adatok kiszivárgását.

    SSL tanúsítvánnyal adataink titkosításon esnek át, mielőtt azok Interneten keresztül átvitelre kerülnének. A titkosított adatot csak a célszerver képes lefordítani. Ez biztosítja, hogy a weboldalon megadott adatainkat nem tulajdoníthatják el.

    2014. augusztus 6-tól kezdve a Google bejelentette: az SSL tanúsítvánnyal rendelkező weboldalak előkelőbb helyre kerülnek a keresőmotorjukban. Ez is egy előny, amiért megéri SSL-t használni.

    A tanúsítvány maga base64-es módon kódolt adatokat tartalmaz a kiállításról, ezen kívül tartalmazza a titkosításhoz szükséges publikus kulcsot, a digitális aláírás hitelesítését és a privát kulccsal létrehozott digitális aláírást is.

    Az SSL tanúsítványt szerveroldalon kell elhelyezni. Az olyan weboldalak esetében, amelyek biztonságát egy SSL tanúsítvány garantálja, https:// előtaggal fog kezdődni az URL. A hitelesítés fajtájától függően a böngésző lakat ikonnal, illetve a szervezet nevével is jelezheti a biztonságos kapcsolat meglétét.




# 4. Jelenlegi üzleti folyamatok modellje
- A jelenlegi pandémiás helyzet alatt, a 
    [COVID SARS-2](https://hu.wikipedia.org/wiki/SARS-CoV-2) emberek ezreit fertőzi meg naponta. Fontos, a vírus elkerülése érdekében, hogy mindenki naprakész és tájékozott
    legyen az aktuális megfertőződések, halálesetek, kigyógyulások, napi-, heti- vagy akár összes előfordulások számaival. __*Honnan szerezhetünk ezekről az információkról tudomást?*__
    A híradóból, a rádióból, vagy ha az interneten utánakeresünk. Ezek a módszerek, hírfolyamok nem elég gyorsak, nem elég FRISSEK.

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

# 7. Irányított és szabad szöveges riportok szövege
A megválaszolatlan kérdéseket majd élőben feltesszük.
