import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.johanastrom.StringUtilities;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilitiesTest {

    private StringUtilities stringUtils;

    @BeforeEach
    public void instantiate(){
        stringUtils = new StringUtilities();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "anagrams.csv", numLinesToSkip = 1)
    void callingIsAnagramWithAnagramsShouldReturnTrueRegardlessOfCase(String s1, String s2){
        assertTrue(stringUtils.isAnagram(s1, s2));
    }



}
