package com.assurance.boggle.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DictionaryTrie {

    private TrieNode root;

    public DictionaryTrie() throws IOException {
        root = new TrieNode();
        final InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = br.readLine();
        int i = 0;
        while (line != null) {
            if (i == 90000) {
                break;
            }
            root.add(line.toLowerCase());
            line = br.readLine();
            i++;
        }
    }

    public TrieNode getRoot() {
        return root;
    }

    //    public static void main(String[] args) {
//        try {
//            DictionaryTrie dt = new DictionaryTrie(new File("src/main/java/dictionary.txt"));
//            System.out.println(dt.root.exists("ballerina"));
//            System.out.println(dt.root.getNumPrefixesOf("bnt"));
//            System.out.println(dt.root.getNumPrefixesOf("bna"));
//            System.out.println(dt.root.getNumPrefixesOf("bng"));
//            System.out.println(dt.root.getNumPrefixesOf("bne"));
//            System.out.println(dt.root.getNumPrefixesOf("bnr"));
//            System.out.println(dt.root.getNumPrefixesOf("bno"));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
