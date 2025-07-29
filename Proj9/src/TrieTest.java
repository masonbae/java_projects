import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;

public class TrieTest {
    @Test
    public void testInsertAndIsWord() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.isWord("apple"));
        assertFalse(trie.isWord("app"));
    }

    @Test
    public void testIsPrefix() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.isPrefix("app"));
        assertFalse(trie.isPrefix("apl"));
    }


    @Test
    public void testClone() {
        Trie trie = new Trie();
        trie.insert("test");
        trie.insert("testing");
        Trie clone = trie.clone();
        assertEquals(trie.wordCount(), clone.wordCount());
        assertTrue(clone.isWord("test") && clone.isWord("testing"));
    }

    @Test
    public void testEquals() {
        Trie trie1 = new Trie();
        trie1.insert("hello");
        trie1.insert("world");

        Trie trie2 = new Trie();
        trie2.insert("hello");
        trie2.insert("world");

        Trie trie3 = new Trie();
        trie3.insert("hello");

        assertTrue(trie1.equals(trie2));
        assertFalse(trie1.equals(trie3));
    }


    @Test
    public void testInsertAndSearch() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        assertTrue(trie.isWord("cat"));
        assertTrue(trie.isWord("car"));
        assertFalse(trie.isWord("ca"));
        assertFalse(trie.isWord("cut"));
    }

    @Test
    public void testPrefix() {
        Trie trie = new Trie();
        trie.insert("hello");
        assertTrue(trie.isPrefix("he"));
        assertFalse(trie.isPrefix("hey"));
    }

    @Test
    public void testEmptyTrie() {
        Trie trie = new Trie();
        assertFalse(trie.isWord(""));
        assertFalse(trie.isPrefix("a"));
    }


    @Test
    public void testWordBoundaries() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("applepie");
        trie.insert("app");
        assertTrue(trie.isWord("app"));
        assertTrue(trie.isWord("apple"));
        assertFalse(trie.isWord("applep"));
        assertTrue(trie.isWord("applepie"));
    }

    @Test
    public void testWordCountNormal() {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("helicopter");
        trie.insert("helix");
        assertEquals(3, trie.wordCount());
    }

    @Test
    public void testWordCount() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        assertEquals(2, trie.wordCount());
        trie.insert("banana");
        trie.insert("bandana");
        assertEquals(4, trie.wordCount());
    }

    @Test
    public void testCloneAndEquality() {
        Trie trie1 = new Trie();
        trie1.insert("test");
        trie1.insert("testing");

        Trie clone = trie1.clone();
        assertTrue(trie1.equals(clone));

        Trie trie2 = new Trie();
        trie2.insert("test");
        assertFalse(trie1.equals(trie2));
    }

    @Test
    public void testInsertDuplicatedWords() {
        Trie trie = new Trie();
        trie.insert("test");
        trie.insert("test");
        assertEquals(1, trie.wordCount());
    }

    @Test
    public void testReverseOrderInsertions() {
        Trie trie = new Trie();
        trie.insert("z");
        trie.insert("y");
        trie.insert("x");
        assertTrue(trie.isWord("z"));
        assertTrue(trie.isWord("y"));
        assertTrue(trie.isWord("x"));
    }

    @Test
    public void testComplexToStringOutput() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");
        String expectedOutput = "app\napple\napricot\nbanana\n";
        assertEquals(expectedOutput, trie.toString());
    }

    @Test
    public void testEdgeCaseLetters() {
        Trie trie = new Trie();
        trie.insert("aaa");
        trie.insert("zzz");
        assertTrue(trie.isWord("aaa"));
        assertTrue(trie.isWord("zzz"));
    }

    @Test
    public void testAlphabeticalOrder() {
        Trie trie = new Trie();
        trie.insert("banana");
        trie.insert("apple");
        trie.insert("apricot");
        assertEquals("apple\napricot\nbanana\n", trie.toString());
    }

    @Test
    public void testWordOverlap() {
        Trie trie = new Trie();
        trie.insert("book");
        trie.insert("bookcase");
        trie.insert("bookshelf");
        assertTrue(trie.isWord("book"));
        assertTrue(trie.isWord("bookcase"));
        assertTrue(trie.isWord("bookshelf"));
        assertTrue(trie.isPrefix("book"));
        assertFalse(trie.isWord("books"));
    }

    @Test
    public void testLoadNonExistentFile() {
        Trie trie = new Trie();
        assertThrows(FileNotFoundException.class, () -> {
            trie.loadFromFile("DNE.txt");
        });
    }

    @Test
    public void testWordInsertion() {
        Trie trie = new Trie();
        trie.insert("example");
        assertTrue(trie.isWord("example"));
        assertFalse(trie.isWord("examp"));
    }

    @Test
    public void testEquality() {
        Trie trie1 = new Trie();
        Trie trie2 = new Trie();
        trie1.insert("same");
        trie2.insert("same");
        assertEquals(trie1, trie2);
    }

    @Test
    public void testLoadFromFile() {
        Trie trie = new Trie();
        try {
            trie.loadFromFile("test.txt");
        }
        catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        assertTrue(trie.isWord("tree"));
        assertTrue(trie.isWord("trie"));
        assertTrue(trie.isWord("data"));
        assertFalse(trie.isWord("word")); // Not in file
    }

    @Test
    public void testLoadFromFileMixedCase() {
        Trie trie = new Trie();
        try {
            trie.loadFromFile("test2.txt");
        } catch (FileNotFoundException e) {
            throw(new RuntimeException(e));
        }
        //words in file with mixed cases, ex: aPllE
        assertTrue(trie.isWord("apple"));
        assertTrue(trie.isWord("banana"));
        assertTrue(trie.isWord("carrot"));
    }

    @Test
    public void testAllSingleCharacters() {
        Trie trie = new Trie();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            trie.insert(String.valueOf(ch));
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            assertTrue(trie.isWord(String.valueOf(ch)));
        }
    }

    @Test
    public void testLoadFromFileWithDuplicates(){
        Trie trie = new Trie();
        try{
            trie.loadFromFile("testDuplicates.txt");
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        //made new file with all duplicate words
        assertEquals(1, trie.wordCount());
    }

    @Test
    public void testLoadFromFileWithDuplicatesFail(){
        Trie trie = new Trie();
        try{
            trie.loadFromFile("testDuplicates.txt");
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        //made new file with all duplicate words (3 times, same word)
        assertNotEquals(3, trie.wordCount());
    }



}
