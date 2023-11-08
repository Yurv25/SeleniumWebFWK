package Utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    FileReader fr;
    Properties p;
    public ReadPropertyFile() throws IOException {
        try {
            fr =  new FileReader("/Users/yurimac/IdeaProjects/WebFramework/src/test/resources/configfiles/config.properties");
            p =  new Properties();
            p.load(fr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
