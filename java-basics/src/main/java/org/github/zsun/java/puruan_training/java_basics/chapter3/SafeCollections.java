package org.github.zsun.java.puruan_training.java_basics.chapter3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SafeCollections {
    public static void main(String[] args) {
        List<String> strs = Collections.synchronizedList(new ArrayList<>());

        Set<String> sets = Collections.synchronizedSet(new HashSet<>());

        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
    }
}
