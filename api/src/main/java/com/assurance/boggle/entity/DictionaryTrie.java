package com.assurance.boggle.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryTrie {

    private TrieNode root;

    public DictionaryTrie(File dict) throws IOException {
        root = new TrieNode();
        final BufferedReader br = new BufferedReader(new FileReader(dict));
        String line = br.readLine();
        while (line != null) {
            line.toLowerCase();
            root.add(line);
            line = br.readLine();
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
