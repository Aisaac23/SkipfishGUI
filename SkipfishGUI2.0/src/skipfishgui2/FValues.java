package skipfishgui2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public final class FValues {
    
    protected static final String o = "-o";
    protected static final String W = "-W";
    protected static final String S = "-S";
    protected static final String N = "-N";
    protected static final String C = "-C";
    protected static final String H = "-H";
    protected static final String Y = "-Y";
    protected static final String l = "-l";
    protected static final String g = "-g";
    protected static final String m = "-m";
    protected static final String f = "-f";
    protected static final String t = "-t";
    protected static final String w = "-w";
    protected static final String i = "-i";
    protected static final String s = "-s";
    protected static final String e = "-e";
    protected static final String O = "-O";
    protected static final String P = "-p";
    
    protected static final String RESULTS = "/Results";
    protected static final String LEARNED = "/LearnedWords";
    
    protected static final String outputfile = "newWords.wl";
    protected static final String mkdir = "mkdir";
    protected static final String touch = "touch";
    protected static final String skipfish = "skipfish";
    protected static final String bash = "bash";
    protected static final String bash_c = "-c";
    protected static final String output_ext = ".wl";
    protected static final String bash_p = "-p";
    
    protected static final String os = System.getProperty("os.name");

    protected static final String flush = "--flush-to-disk";
    protected static final String indexHTML = "/index.html";
    
    protected static final long ONE_K = 1000;
    protected static final String baseZeros = "0000";
    
    protected static final String start_message = "Skipfish has started, it'll start scanning in 60 seconds.\n"
                                           + "Press the \"Stop\" button to interrupt at any moment.";
    protected static final String confirm_interrupt = "Are you sure you want to interrupt Skipfish?";
    
    protected static final String generic_file_message1 = "Please doble check the file: ";
    protected static final String generic_file_message2 = "There's something wrong with the file: ";
    
    protected static final String invalid_input_dictionary = "Please, either provide a valid Input Dictionary or disable the option.";
    
    protected static final String empty_required_field = "Please fill all the required fields.";
    
    protected static final String wrong_url = "Please doble check the URL";
    
    protected static final String duplicate_report = "There is a report with this name and ID already! Do you want to change the ID?";

    protected static final String manual_duplicate_change = "OK, then change the path manually before pressing the \"Run\" button.";
    
    protected static final String wrong_cookies_format = "Please follow the format for all your cookies.";
}
