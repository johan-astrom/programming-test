import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.johanastrom.StringUtilities;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Johan Åström 26/3 2021
 */

public class StringUtilitiesTest {

    private StringUtilities stringUtils;

    @BeforeAll
    static void printMessage(){
        System.out.println("========== Performing StringUtils tests ==========");
    }

    @BeforeEach
    void instantiate(){
        this.stringUtils = new StringUtilities();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "anagrams.csv", numLinesToSkip = 1)
    void callingIsAnagramWithAnagramsShouldReturnTrueRegardlessOfCase(String s1, String s2){
        assertTrue(this.stringUtils.isAnagram(s1, s2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "erroneous-anagrams.csv", numLinesToSkip = 1)
    void callingIsAnagramWithNonAnagramsShouldReturnFalse(String s1, String s2){
        assertFalse(this.stringUtils.isAnagram(s1, s2));
    }

    @AfterAll
    static void printAfterMessage(){
        System.out.println("=========== StringUtils tests finished ===========");
    }


}
