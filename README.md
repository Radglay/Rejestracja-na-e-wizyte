### Rejestracja-na-e-wizyte

Projekt powstał w ramach zaliczenia przedmiotu #Inżynieria oprogramowania. Do stworzenia projektu postanowiłem użyć języka Java oraz frameworku **Spring Boot** oraz **Hibernate**, dzięki temu miałem idealną okazję by nauczyć się nowych technologii. Moją rolą w projekcie była obsługa bazy danych oraz serwera.

## Użyte technologie
- Spring Boot 2.4.1
- Java 13
- Hibernate
- React.js

## Budowanie projektu
Aby zbudować program należy otworzyć pobrany folder w IntelliJ IDEA, wybrać SDK Java 13 oraz zbudować projekt, zaimportowane zostaną wszystkie podane w pliku konfiguracyjnym **build.gradle** zależności. Następnie należy zainstalować **nodeJS**, pobierając go ze strony https://nodejs.org/en/download/. Aby uruchomić aplikacje należy uruchomić serwer w IntelliJ **Shift + F10** lub wciskając **Run**(zielony trójką w prawym górnym rogu). Dodatkowo należy uruchomić front-end, w katalogu z projektem otwieramy konsole CMD, wpisujemy **install npm** i uruchamiamy za pomocą **npm start**.      

Po pomyślnym wykonaniu komend dotyczących React.js, w konsoli powinien zostać wyświetlony taki komunikat:  
![image](https://user-images.githubusercontent.com/32621646/114459336-afd6c680-9be0-11eb-9350-7da737ddb9b0.png)  
Widzimy również adres strony startowej naszej aplikacji http://localhost:3000

## Wygląd aplikacji
Strona główna
![image](https://user-images.githubusercontent.com/32621646/114461637-4061d680-9be2-11eb-8cf9-75627ddc69a9.png)  
  
Panel logowania, do którego możemy wejść ze strony głównej klikając przycisk **Zaloguj się** w prawym górnym rogu lub pod adresem http://localhost:3000/zaloguj  
![image](https://user-images.githubusercontent.com/32621646/114461825-85860880-9be2-11eb-9787-785fc3d1a0ca.png)  
  
Panel rejetracji klikając **Załóż konto** w panelu logowania lub pod adresem http://localhost:3000/rejestracja  
![image](https://user-images.githubusercontent.com/32621646/114464232-c6335100-9be5-11eb-9403-be6baac5366f.png)  

Wybranie Listy dostępnych lekarzy z menu **Lista lekarzy**  
![image](https://user-images.githubusercontent.com/32621646/114546233-33ce9400-9c5d-11eb-9eaf-b959d78574b8.png)  



Po utworzeniu konta i zalogowaniu się, użytkownik będzie miał dostępne 3 pozycje w menu  
![image](https://user-images.githubusercontent.com/32621646/114549150-f23fe800-9c60-11eb-9551-2517332c51da.png)  

  Po wybraniu **Lista lekarzy** użytkownik będzie mógł po kliknięciu na lekarza zobaczyć jego wizyty i umówić się na wizytę  
  ![image](https://user-images.githubusercontent.com/32621646/114548178-b22c3580-9c5f-11eb-9fcd-383fee326804.png)  
![image](https://user-images.githubusercontent.com/32621646/114548750-75147300-9c60-11eb-94b5-14406549ee40.png)  

W przypadku gdy jesteśmy zapisani na wizytę, w kalendarzu lekarza zobaczymy informację o naszej wizycie  
![image](https://user-images.githubusercontent.com/32621646/114547915-56fa4300-9c5f-11eb-805c-29c71438918c.png)  
Po wybraniu opcji **Karta pacjenta** użytkownik widzi swoje dane oraz zbilżające się wizyty. W przypadku gdy nie ma jeszcze odpowiedniej godziny a klikniemy dołącz pojawi się alert  
![image](https://user-images.githubusercontent.com/32621646/114549326-274c3a80-9c61-11eb-8741-9d0d828c4999.png)  
![image](https://user-images.githubusercontent.com/32621646/114549457-55317f00-9c61-11eb-8505-209f0845e2b2.png)  
Lekarz po zalogowaniu się będzie miał takie 3 opzycje w menu  
![image](https://user-images.githubusercontent.com/32621646/114547102-4d241000-9c5e-11eb-8598-b9fb388482e0.png)  
Lekarz po wejściu w zakładke **Wizyty** może sprawdzić swoje przyszłe wizyty, edytować termin i usunąć.
![image](https://user-images.githubusercontent.com/32621646/114551254-6e3b2f80-9c63-11eb-93e3-84f85fcffbc7.png)
  





  


