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
    
    protected static final String o = "-o"; // write output to specified directory (required)
    protected static final String W = "-W"; // use a specified read\-write wordlist (required)
    protected static final String S = "-S"; // load a supplemental read\-only wordlist
    protected static final String N = "-N"; // do not accept any new cookies
    protected static final String C = "-C"; // append a custom cookie to all requests
    protected static final String H = "-H"; // append a custom HTTP header to all requests
    protected static final String Y = "-Y"; // do not fuzz extensions in directory brute\-force
    protected static final String l = "-l"; // max requests per second (0\..000000)
    protected static final String g = "-g"; // max simultaneous TCP connections, global (40)
    protected static final String m = "-m"; // max simultaneous connections, per target IP (10)
    protected static final String f = "-f"; // max number of consecutive HTTP errors (100)
    protected static final String t = "-t"; // total request response timeout (20 s)
    protected static final String w = "-w"; // individual network I/O timeout (10 s)
    protected static final String i = "-i"; // timeout on idle HTTP connections (10 s)
    protected static final String s = "-s"; // response size limit (200000 B)
    protected static final String e = "-e"; // do not keep binary responses for reporting
    protected static final String O = "-O"; // do not submit any forms
    
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

    protected static final String flush = "--flush-to-disk"; /*This causes request / response data to be flushed to disk instead of being kept in memory. As a result, the memory usage for large scans will be significant lower.*/
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
