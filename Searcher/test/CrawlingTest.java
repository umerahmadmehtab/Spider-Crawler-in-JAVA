/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
import Searcher.Searcher;

public class CrawlingTest {

    private static void sm(File f, String indent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CrawlingTest() 
    {
    }
     
    @Test
    public void testsearchMap() throws Exception 
    {
       Searcher sm = new Searcher();
        System.out.println("Crawling");
        File f = new File("ReadMe.txt");
        String indent = "";
        CrawlingTest.sm(f, indent);
    }
    
}
