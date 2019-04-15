/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesztkrevenkaantal_20181005;

/**
 *
 * @author User
 */
public class TesztKrevenkaAntal_20181005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] numbers = {
            
            {-1,2,3},
            {4,-7,6},
            {10,8,-1},
        };
        
        
        int[] testNum1 = {2,4,5,9,11,13,4,5,6,6,7,9,17};
        int[] testNum2 = {2,0,0,0,0,0,0,0};
        // System.out.println(getLastNumber(testNum) + " a tömb utolsó eleme");
        // System.out.println(countEvenNumbers(testNum) + " db páros szám van a kérdéses tömbben");
        // System.out.println(findNumber101(testNum));
        // System.out.println(countSameNumbers(testNum1, testNum2));
        // System.out.println(matrixDiagonalDifference(numbers));
        // stairs(10);
        // System.out.println(kangaroosMeet(0, 2, 5, 3));
        // System.out.println(kangarooMeetO1(0, 5, 4, 3));
        
        
// TODO code application logic here
    }
    
/* 1. Valósítsd meg az alábbi getLastNumber metódust! A metódus adja vissza a paraméterként  
kapott tömb utolsó elemét! (2p)
public static int getLastNumber(int[] numbers) {}  */
    public static int getLastNumber(int[] numbers) {
        int lastNumber;

        // üres tömb vizsgálata
        if (numbers.length != 0) {
            lastNumber = numbers[numbers.length - 1];
        } else {
            System.out.println("Üres tömböt adtál meg!! Nincs utolsó elem, a legkisebb int érték egyébként a következő... ");
            System.out.println(Integer.MIN_VALUE);
            lastNumber = Integer.MIN_VALUE;

        }
        return lastNumber;
    }
    
    
/* 2. Valósítsd meg az alábbi countEvenNumbers metódust! A metódus adja vissza, 
hogy a paraméterként kapott tömbben hány páros szám szerepel! (2p)
public static int countEvenNumbers(int[] numbers) {} */
    public static int countEvenNumbers(int[] numbers) {
        int counterEven = 0;
        if (numbers.length == 0) {
            System.out.println("Üres tömböt adtál meg!! Így nincs páros szám sem, a legkisebb int érték egyébként a következő...");
            counterEven = Integer.MIN_VALUE;
            return counterEven;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                counterEven++;
            }
        }

        return counterEven;

    }
    
/* 3. Szerepel-e a 101-es szám a tömbben? Valósítsd meg az alábbi findNumber101 metódust! 
A metódus visszatérési értéke legyen az az index, ahol a tömbben először szerepel a 101-es szám! 
Ha a tömbben ez a szám nem szerepel, akkor a visszatérési érték legyen -1. (2p)
public static int findNumber101(int[] numbers) {} */
    public static int findNumber101(int[] numbers) {
        int idxFirst101 = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 101) {
                idxFirst101 = i;
                return idxFirst101;
            }
        }

        return idxFirst101;
    }
    
    
/* 4. Valósítsd meg a countSameNumbers metódust! A metódus két egészeket tartalmazó tömb paramétert kap, 
és azt kell megszámolnia, hogy hány elem szerepel az első tömbből a második tömbben! 
(Ügyelj arra, hogy ha egy szám többször szerepel a második tömbben, 
akkor azt csak egynek számold! Feltételezheted, hogy az első tömbben minden szám csak egyszer fordul elő.) (3p)
public static int countSameNumbers(int[] numbers, int[] otherNumbers) {}
Példa: {0, 1, 2, 3, 4} és {5, 6, 5, 4, 4, 4, 3} bemenetek esetén a kimenet 2 legyen, 
mert az első tömbből csak a 3-as és 4-es szám szerepel a második tömbben. */
    public static int countSameNumbers(int[] numbers, int[] otherNumbers) {
        int counterSameNum = 0;
        if (numbers.length < 1 || otherNumbers.length < 1) {
            System.out.println("Üres tömb is szerepel a bemenő paraméterek között");
            return counterSameNum;
        }
        // az első tömbből kiszedem az azonosakat egy metódussal
        int[] tempNumbers = removeDuplicates(numbers);

        //  ennek a tömbnek az elemeinek az egyezését nézem meg a másodikban
        for (int i = 0; i < tempNumbers.length; i++) {
            for (int j = 0; j < otherNumbers.length; j++) {
                if (tempNumbers[i] == otherNumbers[j]) {
                    counterSameNum++;
                    break;  // ha már van találat ne fusson végig az otherNumbers tömb-ön
                }

            }
        }

        return counterSameNum;
    }
    
    public static int[] removeDuplicates(int[] array) {
        int[] tempArray = new int[array.length];
        int tempIdx = 1;
        tempArray[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            boolean containsUpToIdx = false;
            //TODO iterate on tempArray until tempIdx, and if ti contains array[i] set containsUpToIdx to false
            for(int j=0; j<tempIdx; j++){
                if(array[i]==tempArray[j]){
                    containsUpToIdx=true;
                    break;
                }
            }
            if (!containsUpToIdx) {
                tempArray[tempIdx]=array[i];
                tempIdx++;

            }
        }
        // olyan tömb létrahozása ami annyi elemű ahány különböző elem van az eredetiben (tempIdx)        
        int[] removeArray = new int[tempIdx];
        for (int i = 0; i < tempIdx; i++) {
            removeArray[i] = tempArray[i];
        }
        return removeArray;
    }
     
/* 5. Valósítsd meg a matrixTopLeftNumber metódust! A metódus egy kétdimenziós tömböt kap paraméterül, 
és adja vissza ennek a mátrixnak a bal felső (első) elemét! (2p)
public static int matrixTopLeftNumber(int[][] numbers) {} */
    public static int matrixTopLeftNumber(int[][] numbers) {
        return numbers[0][0];
        
    }
    
/* 6. Mennyi a különbség a mátrix két átlójában szereplő elemek összege között? 
Valósítsd meg a matrixDiagonalDifference metódust! A metódus egy kétdimenziós tömböt kap paraméterül, 
és visszatérési értéke a mátrix átlóiban szereplő számok összegei közötti eltérés. 
(Ügyelj arra, hogy a metódusod visszatérési értéke a kérdésnek megfelelően 
mindig nemnegatív szám legyen!) (3p) Írd meg a metódus szignatúráját saját magad!
A metódus neve matrixDiagonalDifference legyen. */
    
    public static int matrixDiagonalDifference(int[][] numbers) {
        int diff = 0;
        if (numbers.length != numbers[0].length) {
            System.out.println("nem négyzetes mátrixot adtál meg !!");
            System.out.println("a legkisebb int szám egyébként: " + Integer.MIN_VALUE);
            return Integer.MIN_VALUE;
        }
        int sumRightDiagonal = 0;
        int sumLeftDiagonal = 0;

        for (int i = 0; i < numbers.length; i++) {
            sumRightDiagonal += numbers[i][i];
            sumLeftDiagonal += numbers[i][numbers.length - 1 - i];
        }
        // System.out.println(sumRightDiagonal + " - " + sumLeftDiagonal);
        
        diff = Math.min(sumRightDiagonal, sumLeftDiagonal) - Math.max(sumRightDiagonal, sumLeftDiagonal);

        return Math.abs(diff);
    }
    
/* 7. Valósítsd meg a stairs metódust! A metódus egy egész számot vár bemenetként, 
és rajzoljon ki a kimenetre az alább látható módon egy ilyen magas lépcsőt # 
és szóköz karakterekből! (A metódusnak a bemenetet nem kell ellenőriznie.) (3p)
public static void stairs(int height) {}

Példa kimenet height=5 bemenet esetén:
    #
   ##
  ###
 ####
#####     */
    public static void stairs(int height) {

        /* szintek száma */
        for (int i = 1; i < height + 1; i++) {

            /* üres karakterek rajzolása */
            for (int spaces = 1; spaces < height + 1 - i; spaces++) {
                System.out.print(" ");
            }
            /* csillagok rajzolása */
            for (int hashmark = 1; hashmark < i + 1; hashmark++) {
                System.out.print("#");
            }

            System.out.println();
        }

    }
    
/* 8. Adott két kenguru, akik a számegyenesen ugrálnak. Az első kenguru az x1 helyről indul, 
és v1 egységet ugrik (a pozitív irányba), a második kenguru pedig x2 helyről indul 
és egy ugrással v2 egységet ugrik. Döntsük el, hogy a két kenguru fog-e egy időben 
egy helyen tartózkodni a számegyenesen! Valósítsd meg a kangaroosMeet metódust, 
amely az x1, v1, x2 és v2 értékét bemeneti paraméterül kapja! (A bemeneti számok nemnegatív 
egészek lehetnek. A metódusnak a bemenetet nem kell ellenőriznie.) 
A metódus visszatérési értéke a döntésnek megfelelő boolean érték legyen. (5p) */  
    
    public static boolean kangaroosMeet(int x1, int v1, int x2, int v2) {
        boolean answer = false;
        int lowPos = -1;
        int jmpLowPos = -1;
        int highPos = -1;
        int jmpHighPos = -1;

        // azonos helyről indulnak vizsgálat
        if (x1 == x2 && v1 == v2) {
            answer = true;          // minden lépésben ugyanoda ugranak
        } else {
            answer = false;         // amelyik nagyobbat ugrik az egyre távolabb kerül
        }

        // beállítani, hogy ki van hátrébb >> firstPos  ekkor az eredileg hozzá tartozó ugrás lesz jmpFirstPos
        if (x1 > x2) {
            lowPos = x2;
            jmpLowPos = v2;
            highPos = x1;
            jmpHighPos = v1;
        } else {
            lowPos = x1;
            jmpLowPos = v1;
            highPos = x2;
            jmpHighPos = v2;

        }

        // lowPos hátrébb van mint highPos
        if (jmpLowPos > jmpHighPos) {       // ekkor biztos utoléri, és lehetséges, hogy egy helyen is lesznek
            for (int i = 1;; i++) {
                if ((lowPos + i * jmpLowPos) == (highPos + i * jmpHighPos)) {   // ha van olyan lépés amikor egy helyen vannak
                    answer = true;
                    return true;
                }
                if ((lowPos + i * jmpLowPos) > (highPos + i * jmpHighPos)) {      // ha már túlugrotta a hátsó kenguru az elsőt 
                    answer = false;
                    return answer;
                }
            }
        } else {                        // ekkor vagy mindig ugyanakkora a távolság közöttük 
            answer = false;             // vagy az előbbről induló  egyre távolabb kerül
        }

        return answer;
    }
    
    
    
    /* Bónusz kérdés (+2 pont): Megvalósítható-e ez a kangaroosMeet metódus O(1) 
    futásidővel? Ha igen, akkor implementáld le, ha nem, akkor indokold, hogy miért nem! */
    
    /* szerintem lehetséges: ha a hátrébbról induló nagyobbat ugrik + 
     és a sebesség különbség maradék nélkül osztója két indulási hely különbségének
    */
    
    public static boolean kangarooMeetO1(int x1, int v1, int x2, int v2) {
        boolean answer = false;
        int lowPos = -1;
        int jmpLowPos = -1;
        int highPos = -1;
        int jmpHighPos = -1;

        // azonos helyről indulnak vizsgálat
        if (x1 == x2 && v1 == v2) {
            answer = true;          // minden lépésben ugyanoda ugranak
        } else {
            answer = false;         // amelyik nagyobbat ugrik az egyre távolabb kerül
        }

        // beállítani, hogy ki van hátrébb >> firstPos  ekkor az eredileg hozzá tartozó ugrás lesz jmpFirstPos
        if (x1 > x2) {
            lowPos = x2;
            jmpLowPos = v2;
            highPos = x1;
            jmpHighPos = v1;
        } else {
            lowPos = x1;
            jmpLowPos = v1;
            highPos = x2;
            jmpHighPos = v2;
        }
        
        // lowPos hátrébb van mint highPos
        if (jmpLowPos > jmpHighPos && ( (highPos - lowPos) % (jmpLowPos - jmpHighPos) == 0) ) {       // ekkor biztos utoléri, és lehetséges, hogy egy helyen is lesznek
           answer = true;
           
        } else {                        // ekkor vagy mindig ugyanakkora a távolság közöttük 
            answer = false;             // vagy az előbbről induló  egyre távolabb kerül
        }
        
        
        return answer;
    }
    
    
}
