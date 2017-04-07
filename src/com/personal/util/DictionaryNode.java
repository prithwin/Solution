package com.personal.util;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by pr250155 on 4/7/17.
 */
public class DictionaryNode {
    boolean wordEnd;
    Map<Character,DictionaryNode> chars = new HashMap<>();
    int count;
}
