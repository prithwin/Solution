package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by prith on 02-06-2017.
 */
public class NormalizePathTest {
    @Test public void testNormalization() {
        System.out.println("Original Path was: " + "/a/b/c/d/.././.././e");
        System.out.println(new NormalizePath().normazlie("/a/b/c/d/.././.././e"));
        System.out.println("Original Path was: " + "/usr/etc/hkc/.././dir1/dir2/./../file");
        System.out.println(new NormalizePath().normazlie("/usr/etc/hkc/.././dir1/dir2/./../file"));
    }
}
