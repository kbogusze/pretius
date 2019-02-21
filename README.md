# pretius
Zadanie rekrutacyjne dla firmy Pretius 02.21.2019

# Aby uruchomić program i przetestować należy:
1. Skopiować repozytorium Git do środowiska, zalecane Intellij lub NetBens, Eclipse
2. Zbudować projekt 
3. Uruchomić projekt
4. Otworzyć przeglądarke np Google Chrome 
5. Aby odpytać aplikacje należy w pasek adresu wkleić:

```
http://localhost:8080/api/currencyrates/PLN/1.0/USD
```
gdzie PLN oznacza kod waluty która wymieniamy, 1.0 ilość waluty jaką posiadamy, USD kod docelowej waluty zgodnie ze standardem ISO

lub 

```
http://localhost:8080/api/currencyrates/USD/30.0/PLN
```

Oczekiwna forma odpowiedzi:
```
{
  "code":"PLN",
  "amount":114.741
}
```
