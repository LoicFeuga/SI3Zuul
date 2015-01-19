package zuul;
import java.lang.reflect.Method;
import java.util.HashMap;


public class Language {
    private static final HashMap<String, Language> languages = new HashMap<>();
    public static Language selected = null;

    // PARAMETRES OBJET	//

    private final HashMap<String, String> translateTable;

    private Language() {
        translateTable = new HashMap<String, String>();
    }
    private void addWord(String key, String translate) {
        translateTable.put(key.toLowerCase(), translate);
    }


    /**
     * @param s word to translate
     * @return the translated  (in selected language) word corresponding to the word in parameter
     */
    public static String translate(String s) {
        if(selected == null) {
            System.err.println("No Language Selected");
            return s;
        }

        return selected.p_translate(s);
    }
    private String p_translate(String s) {
        String s2 = s.toLowerCase();
        if(translateTable.containsKey(s2))
            return translateTable.get(s2);
        return s; // no translations found, returning the whole word
    }

    /**
     * @param s word to 'untranslate'
     * @return the english word corresponding to the word in parameter (witch is in selected language)
     */
    public static String retrotranslate(String s) {
        if(selected == null) {
            System.err.println("No Language Selected");
            return s;
        }

        return selected.p_retrotranslate(s);
    }
    private String p_retrotranslate(String s) {
        String s2 = s.toLowerCase();
        if(translateTable.containsValue(s2))
            for(String index : translateTable.keySet())
                if(translateTable.get(index).equals(s))
                    return index;
        return s; // no translations found, returning the whole word
    }

    /**
     * Load all languages in memory
     */
    public static void loadAll() {
        for(Method m : Language.class.getMethods())
            if(m.getReturnType().equals(Language.class))
                try{ m.invoke(null); }
        catch(Exception e) { e.printStackTrace(); }
    }

    /**
     * Print a list of all available languages
     */
    public static void listAll() {
        if(languages.isEmpty())
            loadAll();
        for(String s : languages.keySet())
            System.out.println("- "+s+" ("+languages.get(s).p_translate("English (USA)")+")");
    }

    /**
     * @param languageCode the 3char code of language you want to set ('USA', 'FRA', 'POO'...)
     * @return 'true' if selectedLanguage changed, 'false' if languageCode was wrong
     */
    public static boolean selectLanguage(String languageCode) {
        if(languages.isEmpty())
            loadAll();
        if(!languages.containsKey(languageCode))
            return false;
        // else
        selected = languages.get(languageCode);
        return true;
    }

    //		DEFINITION LANGUES		//
    // To add a new Language, just add a new method like the following, changing translations (l.addWord("englishWord", "translatedWord"))
    //
    // /!\ FORMAT:      public static Language xxx() { ... }        /!\

    public static Language getFRA() {
        Language l = new Language();
        languages.put("FRA", l);

        l.addWord("English (USA)", "Français (France)");

        // ROOMS
        l.addWord("outdoor", "exterieur");
        l.addWord("parking", "parking");

        // ITEMS
        l.addWord("normal coffe", "caffé normal");
        l.addWord("watch", "montre");

        // MISC
        l.addWord("Corridor", "Couloir");
        l.addWord("Day", "Jour");
        l.addWord("Language", "Langue");
        l.addWord("selected", "sélectionné(e)");
        l.addWord("Choose", "Choisissez");
        l.addWord("a game seed", "une clé de génération");
        l.addWord("seed", "la clé");
        l.addWord("Choice", "choix");
        l.addWord("Are you a retard ?", "T'es débile ou quoi ?");
        l.addWord("to randomize", "pour générer aléatoirement");
        l.addWord("number", "nombre");
        l.addWord("between", "entre");
        l.addWord("is", "est");
        l.addWord("on", "allumer");
        l.addWord("off", "éteindre");
        l.addWord("and", "et");
        l.addWord("or", "ou");
        l.addWord("You can", "Vous pouvez");
        l.addWord("You are", "Vous êtes");
        l.addWord("go", "aller");
        l.addWord("use", "utiliser");
        l.addWord("get", "récupérer");
        l.addWord("infos", "infos");
        l.addWord("quit", "quitter");
        l.addWord("help", "aide");
        l.addWord("Cannot", "Impossible de");
        l.addWord("this", "ceci");
        l.addWord("do something", "Que faites-vous");
        l.addWord("here", "ici");
        l.addWord("light", "lumière");
        l.addWord("Go where ?", "Où aller ?");
        l.addWord("Get what ?", "Que récupérer ?");
        l.addWord("Use what ?", "Qu'utiliser ?");
        l.addWord("Turn light what ? On ? Off ??", "Que faire avec la lumière ? Allumer ? Éteindre ??");
        l.addWord("Let there be light !", "Et la lumière fut !");
        l.addWord("It's getting all dark !", "Ça va être tout noir !");
        l.addWord("energy", "energie");
        l.addWord("your", "votre");

        // Player.java
        l.addWord("You have too much played so", "Vous avez trop joué, de ce fait,");
        l.addWord("you have forgot", "vous avez oublié");
        l.addWord("the meaning of Life, the Universe and Everything !", "les réponses aux question sur la vie, l'univers et tout le reste.");
        l.addWord("inventory", "inventaire");
        l.addWord("knowlege", "savoir");

        // OOPBOOK.java
        l.addWord("You have learn all","vous avez tout appris sur");
        l.addWord("lecture", "cours magistraux");
        l.addWord("Super Book of OOP", "Encyclopédie complète de POO");
        l.addWord("This can give you all knowledge about OOP.", "Ceci peut vous apporter toutes les connaissances apropos de POO");
        
        // TABLET.java
        l.addWord("tablet", "tablette");
        l.addWord("You can play with it or go to the internet.", "Vous pouvez jouer avec, ou bien aller sur internet.");
        l.addWord("You try to learn", "Vous essayer d'apprendre");
        l.addWord("It is a success !", "C'est une réussite !");
        l.addWord(" a new lesson !", "un nouveau cours !");
        l.addWord("But you cannot learn anymore.", "Mais vous ne pouvez plus rien apprendre.");
        
        System.out.println("Paramètres de langue française (FRA) chargée.");
        return l;
    }

    public static Language getPOO() {
        Language l = new Language();
        languages.put("POO", l);

        l.addWord("English (USA)", "POO.language ("+Language.class.getCanonicalName()+")");

        // ROOMS
        l.addWord("outdoor", "desktop");
        l.addWord("parking", "system32");

        // ITEMS
        l.addWord("normal coffe", "defrag");
        l.addWord("watch", "time");

        l.addWord("Corridor", "path");
        l.addWord("Day", "Cycle");
        //l.addWord("Language", "Langue");
        //l.addWord("selected", "sélectionné(e)");
        //l.addWord("Choose", "Choisissez");
        //l.addWord("a game seed", "une clé de génération");
        //l.addWord("seed", "la clé");
        l.addWord("Choice", "$");
        l.addWord("Are you a retard ?", "throw Exception ?");
        l.addWord("to randomize", "= Math.random()");
        l.addWord("number", "long");
        l.addWord("between", "in");
        l.addWord("is", "==");
        l.addWord("on", "true");
        l.addWord("off", "false");
        l.addWord("and", "&&");
        l.addWord("or", "||");
        l.addWord("You can", "if(true)");
        l.addWord("You are", "C:\\\\");
        l.addWord("go", "cd");
        l.addWord("use", "./");
        l.addWord("get", "mov");
        l.addWord("infos", "-v");
        l.addWord("quit", "-q");
        l.addWord("help", "-h");
        l.addWord("Cannot", "if(false)");
        //l.addWord("this", "ceci");
        l.addWord("here", "$CURDIR");
        l.addWord("light", "chmod");
        l.addWord("do something", "$");
        l.addWord("Go where ?", "directory not found.");
        l.addWord("Get what ?", "file not found.");
        l.addWord("Use what ?", "file not found.");
        l.addWord("Turn light what ? On ? Off ??", "chmod true ? false ??");
        l.addWord("Let there be light !", "All access permited.");
        l.addWord("It's getting all dark !", "All access restricted.");
        l.addWord("energy", "battery");
        l.addWord("your", "user");

        // World.java
        l.addWord("Parking desc.", "Administration folder");

        // Player.java
        l.addWord("You have too much played so", "System update has");
        l.addWord("you have forgot", "remove");
        l.addWord("the meaning of Life, the Universe and Everything !", "all memory.");
        l.addWord("inventory", "ROM");
        l.addWord("knowlege", "RAM");

        // Coffe.java
        l.addWord("You drunk your", "Executing");
        l.addWord("and regain some energy.", "performances increased.");


        System.out.println(Language.class.getCanonicalName()+".getPOO() executed");
        return l;
    }

    public static Language getUSA() {
        Language l = new Language();
        languages.put("USA", l);

        l.addWord("Parking desc.", "Cheating room");

        System.out.println("Language parameters English (USA) loaded.");
        return l;
    }

}