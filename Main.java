package zuul;

import java.util.Scanner;

import zuul.world.World;

/**
 * 
 * @author Nathaël Noguès
 *
 */
public abstract class Main {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        selectLanguage();
        System.out.println();

        System.out.print(Language.translate("Choose")+" "+Language.translate("a game Seed")+" ("+
                Language.translate("number")+" "+Language.translate("between")+" "+Integer.MIN_VALUE+" "+Language.translate("and")
                +" "+Integer.MAX_VALUE+")\n"
                +Language.translate("Choose")+" '0' "+Language.translate("to randomize")+" "+Language.translate("seed")+".\n"+
                Language.translate("Choice")+": ");

        long l = 0;

        do {
            String s = input.nextLine();
            // Something wrong with Scanner 'input' TODO

            try {
                l = Long.parseLong(s);
                break; // User is cool and typed a Long value
            } catch(Exception e) {
                System.err.println(Language.translate("Are you a retard ?"));
                System.out.print(Language.translate("Choose")+" "+Language.translate("a game Seed")+" "
                        +Language.translate("between")+" "+Integer.MIN_VALUE+" "+Language.translate("and")
                        +" "+Integer.MAX_VALUE+", "+Language.translate("or")+" '0' "+Language.translate("to randomize")+" "+Language.translate("seed")+".\n"+
                        Language.translate("Choice")+": ");
            }
        } while(true);

        if(l == 0) {
            l =  (long)(Math.random()*(Long.MAX_VALUE-Long.MIN_VALUE)+Long.MIN_VALUE);
            System.out.println(Language.translate("Seed")+" "+Language.translate("is")+": "+l);
        }

        new World(l); // Let's begin the game !

        try { Thread.sleep(1000); } catch(Exception e) {} // Wait for all finish to be printed
        input.close();
        System.err.println("\n\t--- EXECUTION END ---");
    }
    public static void selectLanguage() {
        System.out.println("\nChoose a language:");
        Language.listAll();
        System.out.print("Your choice (3 letters) : ");

        while(!Language.selectLanguage(input.nextLine().toUpperCase())) {
            input.nextLine();
            System.err.println("No language found, try again.");
            try { Thread.sleep(100); } catch(Exception e){}
            System.out.print("Your choice (3 letters) : ");
        }

        System.out.println(Language.translate("Language")+" '"+Language.translate("English (USA)")+"' "+Language.translate("selected")+".");

        try { Thread.sleep(100); } catch(Exception e){} // Sleep some times to let user to see what did he select
    }

    public static String getStrTime(double time) {
        long day = (long)time;
        time = (time-day)*24;
        int hour = (int)time;
        time = (time-hour)*60;
        int min = (int)time;
        time = (time-min)*60;
        int sec = (int)time;

        return Language.translate("Day")+" "+(day+1)+", "+String.format("%02d", hour)+":"+String.format("%02d", min)+":"+String.format("%02d", sec);
    }


}
