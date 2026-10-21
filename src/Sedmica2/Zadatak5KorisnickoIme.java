package Sedmica2;
/*
 * ZADATAK 5 – Generator korisničkog imena
 * Programiranje u Javi – Auditorne vježbe, Sedmica 2
 *
 * Od imena, prezimena i godine rođenja napravite korisničko ime:
 *   prvo slovo imena + prezime + zadnje dvije cifre godine, sve MALIM slovima
 *
 *   "Amila", "Tabak", 2006   ->   atabak06
 *
 * Koraci:
 *   1) prvo slovo imena:           ime.substring(0, 1)     (indeksi kreću od 0!)
 *   2) godinu pretvorite u tekst:  String godinaTekst = "" + godinaRodjenja;
 *      zadnje dvije cifre:         godinaTekst.substring(2)    -> "06"
 *      (zašto ne godinaRodjenja % 100?  probajte – dobit ćete 6, a ne 06)
 *   3) spojite dijelove i pretvorite u mala slova:  toLowerCase()
 *   4) ispišite korisničko ime i njegovu dužinu:    length()
 *
 * Očekivani ispis:
 *   Korisničko ime: atabak06
 *   Dužina: 8
 *
 * BONUS 1: ispišite inicijale u obliku  A.T.
 * BONUS 2 ("Tajni kod"): u riječi "JAVA" zamijenite prvo i zadnje slovo -> "AAVJ"
 *          (pomoć: charAt(0), charAt(3) i substring(1, 3))
 * BONUS 3: za prezime "Hodžić" napravite korisničko ime bez č, ć, š, ž, đ -> ahodzic06
 *          (pomoć: replace("ž", "z") ...)
 */
public class Zadatak5KorisnickoIme {

    public static void main(String[] args) {

        String ime = "Amila";
        String prezime = "Tabak";
        int godinaRodjenja = 2006;
        String godinaTekst= "" + godinaRodjenja;

        // TODO: napravite korisničko ime

        String korisnickoIme = ime.substring(0, 1) +prezime + godinaTekst.substring(2);
        System.out.println("Korisničko ime: " + korisnickoIme.toLowerCase());

        // TODO: ispišite dužinu korisničkog imena

        System.out.println("Duzina: " + korisnickoIme.length());

        // TODO: BONUS 1

        String inicijali = ime.substring(0,1)+"."+ prezime.substring(0,1);
        System.out.println(inicijali);

        // TODO: BONUS 2

        String rijec = "JAVA";
        String kod = rijec.charAt(3) + rijec.substring(1,3) + rijec.charAt(0);
        System.out.println(kod);

        // TODO: BONUS 3

        prezime = "Hodžić";
        prezime=prezime.replace('ž','z');
        prezime=prezime.replace('ć','c');
        korisnickoIme = ime.substring(0, 1) +prezime + godinaTekst.substring(2);
        System.out.println(korisnickoIme.toLowerCase());

    }
}
