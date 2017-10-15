# **RentACar**
Alkalmazások fejlesztése 1. c kurzus csoportos beadandó feladat

## **1. Követelmény feltárás**

### **1.1. Célkitűző dokumentum**
A 2017-es Alk.fejl kurzus féléves beadandó feladatául, egy autó kölcsönző projekt gyakorlati megvalósítását hozzuk létre.
A projekt egy webes alkalmazás, melyen vendég felhasználók ingyenesen regisztrálhatják magukat, valamint már regisztrált felhasználók pedig authentikációt követően bérbe vehetnek személygépjárműveket, amennyiben van szabadon bérelhető (nem foglalt vagy használatban levő) gépjármű.

### **1.2. Szakterületi fogalom jegyzék**

### **1.3. Használati eset model (Use-Case Model)**

A használati eseteket (belépés / regisztráció / bérlés) az alábbi használati eset diagramm ábrázolja.

**Regisztráció (UseCase 1)**

![use case 1](https://github.com/csokistej/RentACar/blob/master/usecase1.png)

**Belépés (UseCase 2)**

![use case 2](https://github.com/csokistej/RentACar/blob/master/usecase2.png)

**Bérlés (UseCase 3)**

![use case 3](https://github.com/csokistej/RentACar/blob/master/usecase3.png)

### **1.4 Non-Funkciónális követelmények**
**Hardver igény:** cpu:Pentium 4, RAM: 2 GB, video: 1280x1024
**Szoftver igény:**
  - OS:független
  - CASE eszköz: Enterprise Architect 8
  - IDE: Neatbeans 6.9.1
  - Egyéb követelmények: felhasználó barát kezelhetősége, valamint finom, letisztult egyszerű külső 
  - A futtatáshoz bármely OS plattform megfelel, mely JRE 6 implementációt tartalmaz.
  

## **2. Tervezés**

### **2.1. Arcihtektúra**
A szoftver megfelel a MVC architeltúrának. A projektet Spring keretrendszer segítségével kivitelezzük. 
**Importált J2EE csomagok:**
  - JPA
  - Themyleaf
  - lombok
  - Web services
  - DevTools
  - Web

### **2.2. Osztálymodell**
A projektben megvalósított entitásokat az alábbi osztály diagramm ábrázolja: 

![UML Class Diagram](https://github.com/csokistej/RentACar/blob/master/UMLClassDiagram.png)

### **2.3. Adatbázisterv**
![database_ek_diagram](https://github.com/csokistej/RentACar/blob/master/db_er_diagram.PNG)

## Szerepkörök:
  - **User Role**: felhasználói szerepkör, autóbérlésre jogosult

## **3. Implementáció**

## **4.Tesztelés**

### **Regisztráció (UseCase 1)**
  #### **Test 1**
    Input: "testUser", "supers3cret", "test@test.com", "LastName", "FisrtName", "123456789", "Test Town, Test Street 42."
    Output: Send feedback message.
  #### **Test 2**
    Input: "testUser", null, "test@test.com", "LastName", "FisrtName", "123456789", "Test Town, Test Street 42."
    Output: Error message.

### **Belépés (UseCase 2)**
  #### **Test 1**
    Input: "testUser", "supers3cret"
    Output: Go to rent site.
  #### **Test 2**
    Input: "testUser", null
    Output: Error message.

## 5. **Felhasználói dokumentáció**
