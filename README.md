# pretius
Zadanie rekrutacyjen dla firmy Pretius 02.21.2019

# Aby uruchomić program i przetestować należy
1. Skopiować repozytorium Git do środowiska, zalenace Intellij lub NetBens, Eclipse
2. Zbudować projekt 
3. Uruchomić projekt
4. Otworzyć przegladarke np Google Chrome 
5. Odpytać aplikacje o swoją funkcjonlaność za pomocą requesta np:

```
http://localhost:8080/api/currencyrates/PLN/1.0/USD
```

lub 

```
http://localhost:8080/api/currencyrates/USD/30.0/PLN
```

Oczekiwna forma odpowiedzi
```
{
  "code":"PLN",
  "amount":114.741
}
```
